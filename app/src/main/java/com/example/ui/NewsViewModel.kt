package com.example.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.entity.ArticleEntity
import com.example.data.model.Newspaper
import com.example.data.model.NewspaperCategory
import com.example.data.model.NewspaperDataSource
import com.example.data.repository.NewsRepository
import com.example.util.AppStrings
import com.example.util.NotificationHelper
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

enum class BottomTab {
    HOME, SOURCES, FAVORITES, RATE_US, SETTINGS
}

enum class ScreenDestination {
    SPLASH,
    MAIN_TABS,
    ARTICLE_DETAIL,
    NEWSPAPER_DETAIL,
    CATEGORY_VIEW,
    SEARCH,
    TV_CHANNELS
}

enum class ThemeMode {
    SYSTEM, LIGHT, DARK
}

data class NewsSearchResult(
    val query: String = "",
    val categoryFilter: NewspaperCategory = NewspaperCategory.ALL,
    val matchingNewspapers: List<Newspaper> = emptyList(),
    val matchingArticles: List<ArticleEntity> = emptyList()
)

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = NewsRepository.getInstance(application)
    private val prefs = application.getSharedPreferences("newshub_bd_prefs", Context.MODE_PRIVATE)

    // Navigation state
    private val _currentScreen = MutableStateFlow(ScreenDestination.MAIN_TABS)
    val currentScreen: StateFlow<ScreenDestination> = _currentScreen.asStateFlow()

    private val _selectedTab = MutableStateFlow(BottomTab.HOME)
    val selectedTab: StateFlow<BottomTab> = _selectedTab.asStateFlow()

    private val _activeArticleId = MutableStateFlow<String?>(null)
    val activeArticleId: StateFlow<String?> = _activeArticleId.asStateFlow()

    private val _activeNewspaperId = MutableStateFlow<String?>(null)
    val activeNewspaperId: StateFlow<String?> = _activeNewspaperId.asStateFlow()

    private val _activeWebUrlOverride = MutableStateFlow<String?>(null)
    val activeWebUrlOverride: StateFlow<String?> = _activeWebUrlOverride.asStateFlow()

    private val _activeCategory = MutableStateFlow<NewspaperCategory?>(null)
    val activeCategory: StateFlow<NewspaperCategory?> = _activeCategory.asStateFlow()

    // Screen navigation history for Android back button
    private val navBackStack = mutableListOf<ScreenDestination>()

    // Data streams
    val breakingNews: StateFlow<List<ArticleEntity>> = repository.breakingNews
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val topNews: StateFlow<List<ArticleEntity>> = repository.topNews
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val allArticles: StateFlow<List<ArticleEntity>> = repository.allArticles
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val savedArticles: StateFlow<List<ArticleEntity>> = repository.savedArticles
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val favoriteNewspaperIds: StateFlow<List<String>> = repository.favoriteNewspaperIds
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Filter & Search
    private val _sourcesCategoryFilter = MutableStateFlow(NewspaperCategory.ALL)
    val sourcesCategoryFilter: StateFlow<NewspaperCategory> = _sourcesCategoryFilter.asStateFlow()

    private val _sourcesRegionFilter = MutableStateFlow("All Regions")
    val sourcesRegionFilter: StateFlow<String> = _sourcesRegionFilter.asStateFlow()

    private val _sourcesSearchQuery = MutableStateFlow("")
    val sourcesSearchQuery: StateFlow<String> = _sourcesSearchQuery.asStateFlow()

    val filteredNewspapers: StateFlow<List<Newspaper>> = combine(
        favoriteNewspaperIds,
        _sourcesCategoryFilter,
        _sourcesRegionFilter,
        _sourcesSearchQuery
    ) { favIds, category, region, query ->
        val baseList = if (category == NewspaperCategory.ALL) {
            NewspaperDataSource.allNewspapers
        } else {
            NewspaperDataSource.getByCategory(category)
        }

        val regionalList = if (category == NewspaperCategory.LOCAL && region != "All Regions") {
            baseList.filter { it.region == region }
        } else if (category == NewspaperCategory.RADIO && region != "All Radio" && region != "All Regions") {
            baseList.filter { it.region == region }
        } else if (category == NewspaperCategory.GOVERNMENT && region != "All Portals" && region != "All Regions") {
            baseList.filter { it.region == region }
        } else {
            baseList
        }

        val queried = if (query.isBlank()) {
            regionalList
        } else {
            val tokens = query.trim().lowercase().split("\\s+".toRegex()).filter { it.isNotEmpty() }
            regionalList.filter { item ->
                val searchable = "${item.name} ${item.banglaName} ${item.category.displayName} ${item.category.banglaName} ${item.tagline} ${item.region.orEmpty()}".lowercase()
                tokens.all { searchable.contains(it) }
            }
        }

        queried.map { newspaper ->
            newspaper.copy(isFavorite = favIds.contains(newspaper.id))
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Search Screen State
    private val _globalSearchQuery = MutableStateFlow("")
    val globalSearchQuery: StateFlow<String> = _globalSearchQuery.asStateFlow()

    private val _searchCategoryFilter = MutableStateFlow(NewspaperCategory.ALL)
    val searchCategoryFilter: StateFlow<NewspaperCategory> = _searchCategoryFilter.asStateFlow()

    // Persistent Recent Searches
    private val _recentSearches = MutableStateFlow<List<String>>(loadRecentSearches())
    val recentSearches: StateFlow<List<String>> = _recentSearches.asStateFlow()

    val searchResults: StateFlow<NewsSearchResult> = combine(
        _globalSearchQuery.debounce(100),
        _searchCategoryFilter
    ) { query, catFilter ->
        Pair(query.trim(), catFilter)
    }.flatMapLatest { (query, catFilter) ->
        if (query.isBlank() && catFilter == NewspaperCategory.ALL) {
            flowOf(NewsSearchResult(categoryFilter = catFilter))
        } else {
            combine(
                repository.searchArticles(query),
                favoriteNewspaperIds
            ) { articles, favIds ->
                val basePapers = if (catFilter == NewspaperCategory.ALL) {
                    NewspaperDataSource.allNewspapers
                } else {
                    NewspaperDataSource.getByCategory(catFilter)
                }

                val matchingPapers = if (query.isBlank()) {
                    basePapers
                } else {
                    val tokens = query.lowercase().split("\\s+".toRegex()).filter { it.isNotEmpty() }
                    basePapers.filter { item ->
                        val searchable = "${item.name} ${item.banglaName} ${item.category.displayName} ${item.category.banglaName} ${item.tagline} ${item.region.orEmpty()}".lowercase()
                        tokens.all { searchable.contains(it) }
                    }
                }.map { it.copy(isFavorite = favIds.contains(it.id)) }

                val matchingArticles = if (catFilter == NewspaperCategory.ALL) {
                    articles
                } else {
                    articles.filter { art ->
                        art.category.equals(catFilter.name, ignoreCase = true) ||
                        art.category.equals(catFilter.displayName, ignoreCase = true) ||
                        art.newspaperName.equals(catFilter.displayName, ignoreCase = true)
                    }
                }

                NewsSearchResult(
                    query = query,
                    categoryFilter = catFilter,
                    matchingNewspapers = matchingPapers,
                    matchingArticles = matchingArticles
                )
            }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NewsSearchResult())

    // Active Article Stream
    val currentArticle: StateFlow<ArticleEntity?> = _activeArticleId
        .flatMapLatest { id ->
            if (id != null) repository.getArticleById(id) else flowOf(null)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    // Active Newspaper Articles
    val activeNewspaperArticles: StateFlow<List<ArticleEntity>> = _activeNewspaperId
        .flatMapLatest { id ->
            if (id != null) repository.getArticlesByNewspaper(id) else flowOf(emptyList())
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Refresh & Status
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    private val _snackbarMessage = MutableSharedFlow<String>()
    val snackbarMessage = _snackbarMessage.asSharedFlow()

    // Rating & Feedback
    val userRating = MutableStateFlow(5)
    val feedbackText = MutableStateFlow("")
    val ratingSubmitted = MutableStateFlow(false)

    // Settings (persisted with SharedPreferences)
    val themeMode = MutableStateFlow(
        try {
            ThemeMode.valueOf(prefs.getString("theme_mode", ThemeMode.SYSTEM.name) ?: ThemeMode.SYSTEM.name)
        } catch (_: Exception) {
            ThemeMode.SYSTEM
        }
    )

    val selectedLanguage = MutableStateFlow(
        prefs.getString("selected_language", "English") ?: "English"
    )

    val appStrings: StateFlow<AppStrings> = selectedLanguage.map { lang ->
        AppStrings.forLanguage(lang)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, AppStrings.English)

    val notificationsEnabled = MutableStateFlow(
        prefs.getBoolean("notifications_enabled", true)
    )

    // Storage and Cache State
    private val _cacheSizeFormatted = MutableStateFlow("Calculating...")
    val cacheSizeFormatted: StateFlow<String> = _cacheSizeFormatted.asStateFlow()

    init {
        viewModelScope.launch {
            repository.initializeData(getApplication())
            // Calculate cache size & auto-trim if excessive
            refreshCacheSize()
            com.example.util.CacheManager.autoTrimIfNeeded(getApplication())
            refreshCacheSize()
            // Delay background network refresh slightly so initial app launch is instantaneous
            kotlinx.coroutines.delay(2500)
            refreshNewsSilent()
        }

        // Periodic background update every 5 minutes while connected
        viewModelScope.launch {
            while (true) {
                kotlinx.coroutines.delay(5 * 60 * 1000)
                refreshNewsSilent()
            }
        }
    }

    private fun refreshNewsSilent() {
        viewModelScope.launch {
            val result = repository.refreshRealtimeNews()
            if (result.isSuccess && (result.getOrNull() ?: 0) > 0 && notificationsEnabled.value) {
                val breaking = breakingNews.value.firstOrNull()
                if (breaking != null) {
                    NotificationHelper.sendBreakingNewsNotification(
                        context = getApplication(),
                        title = breaking.title,
                        body = breaking.description.take(120),
                        articleId = breaking.id
                    )
                }
            }
        }
    }

    fun setLanguage(lang: String) {
        selectedLanguage.value = lang
        prefs.edit().putString("selected_language", lang).apply()
    }

    fun setNotificationsEnabled(enabled: Boolean) {
        notificationsEnabled.value = enabled
        prefs.edit().putBoolean("notifications_enabled", enabled).apply()
    }

    fun setTheme(mode: ThemeMode) {
        themeMode.value = mode
        prefs.edit().putString("theme_mode", mode.name).apply()
    }

    fun sendTestNotification() {
        val isBn = selectedLanguage.value.contains("বাংলা") || selectedLanguage.value.equals("Bangla", ignoreCase = true)
        val breaking = breakingNews.value.firstOrNull()
        val totalCount = NewspaperDataSource.allNewspapers.size
        val title = if (isBn) {
            breaking?.title ?: "ব্রেকিং নিউজ: বাংলাদেশ তাজা খবর"
        } else {
            breaking?.title ?: "Breaking News: Bangladesh Live Update"
        }
        val body = if (isBn) {
            breaking?.description?.take(120) ?: "নিউজহাব বিডি তে যুক্ত হয়েছে $totalCount+ পত্রিকা, চাকরি, রেডিও ও মন্ত্রণালয়ের তথ্য।"
        } else {
            breaking?.description?.take(120) ?: "NewsHub BD now features $totalCount+ newspapers, jobs, radio & ministries."
        }
        NotificationHelper.sendBreakingNewsNotification(
            context = getApplication(),
            title = title,
            body = body,
            articleId = breaking?.id
        )
    }

    fun navigateToTab(tab: BottomTab) {
        _selectedTab.value = tab
        _currentScreen.value = ScreenDestination.MAIN_TABS
        navBackStack.clear()
    }

    fun openArticle(articleId: String) {
        _activeArticleId.value = articleId
        pushScreen(ScreenDestination.ARTICLE_DETAIL)
    }

    fun openNewspaper(newspaperId: String, customUrl: String? = null) {
        _activeNewspaperId.value = newspaperId
        _activeWebUrlOverride.value = customUrl
        pushScreen(ScreenDestination.NEWSPAPER_DETAIL)
    }

    fun openCategory(category: NewspaperCategory) {
        _activeCategory.value = category
        pushScreen(ScreenDestination.CATEGORY_VIEW)
    }

    fun openTvChannels() {
        pushScreen(ScreenDestination.TV_CHANNELS)
    }

    fun openSearch() {
        pushScreen(ScreenDestination.SEARCH)
    }

    fun pushScreen(destination: ScreenDestination) {
        if (_currentScreen.value != destination) {
            navBackStack.add(_currentScreen.value)
            _currentScreen.value = destination
        }
    }

    fun handleBack(): Boolean {
        if (navBackStack.isNotEmpty()) {
            _currentScreen.value = navBackStack.removeAt(navBackStack.size - 1)
            return true
        } else if (_selectedTab.value != BottomTab.HOME) {
            _selectedTab.value = BottomTab.HOME
            return true
        }
        return false
    }

    fun setSourcesCategoryFilter(category: NewspaperCategory) {
        _sourcesCategoryFilter.value = category
        if (category == NewspaperCategory.RADIO) {
            _sourcesRegionFilter.value = "All Radio"
        } else if (category == NewspaperCategory.GOVERNMENT) {
            _sourcesRegionFilter.value = "All Portals"
        } else if (category != NewspaperCategory.LOCAL) {
            _sourcesRegionFilter.value = "All Regions"
        }
    }

    fun setSourcesRegionFilter(region: String) {
        _sourcesRegionFilter.value = region
    }

    fun setSourcesSearchQuery(query: String) {
        _sourcesSearchQuery.value = query
    }

    fun setGlobalSearchQuery(query: String) {
        _globalSearchQuery.value = query
    }

    fun setSearchCategoryFilter(cat: NewspaperCategory) {
        _searchCategoryFilter.value = cat
    }

    fun toggleSaveArticle(article: ArticleEntity) {
        viewModelScope.launch {
            val newSaveState = !article.isSaved
            repository.toggleSaveArticle(article.id, newSaveState)
            val isBn = selectedLanguage.value.contains("বাংলা") || selectedLanguage.value.equals("Bangla", ignoreCase = true)
            _snackbarMessage.emit(
                if (newSaveState) {
                    if (isBn) "সংবাদটি অফলাইনে পড়ার জন্য সংরক্ষিত হয়েছে 📥"
                    else "Article saved for offline reading 📥"
                } else {
                    if (isBn) "সংরক্ষিত তালিকা থেকে সরানো হয়েছে 🗑️"
                    else "Article removed from saved 🗑️"
                }
            )
        }
    }

    fun toggleFavoriteNewspaper(
        newspaperId: String,
        isCurrentlyFavorite: Boolean? = null
    ) {
        val currentlyFav = isCurrentlyFavorite ?: favoriteNewspaperIds.value.contains(newspaperId)
        viewModelScope.launch {
            repository.toggleFavoriteNewspaper(newspaperId, currentlyFav)
            val isBn = selectedLanguage.value.contains("বাংলা") || selectedLanguage.value.equals("Bangla", ignoreCase = true)
            _snackbarMessage.emit(
                if (!currentlyFav) {
                    if (isBn) "প্রিয় তালিকায় যুক্ত হয়েছে ❤️"
                    else "Added to favorite newspapers ❤️"
                } else {
                    if (isBn) "প্রিয় তালিকা থেকে বাদ দেওয়া হয়েছে"
                    else "Removed from favorite newspapers"
                }
            )
        }
    }

    fun refreshNews() {
        viewModelScope.launch {
            _isRefreshing.value = true
            val result = repository.refreshRealtimeNews()
            _isRefreshing.value = false
            val isBn = selectedLanguage.value.contains("বাংলা") || selectedLanguage.value.equals("Bangla", ignoreCase = true)
            result.onSuccess { count ->
                _snackbarMessage.emit(
                    if (count > 0) {
                        if (isBn) "সফলভাবে রিফ্রেশ হয়েছে: $count নতুন সংবাদ পাওয়া গেছে!"
                        else "Refreshed: $count new articles collected!"
                    } else {
                        if (isBn) "সংবাদ ফিড সম্পূর্ণ আপডেট আছে!"
                        else "News feed is up to date!"
                    }
                )
            }.onFailure {
                _snackbarMessage.emit(
                    if (isBn) "অফলাইন ক্যাশ থেকে সংবাদ প্রদর্শিত হচ্ছে"
                    else "Showing cached news (offline mode)"
                )
            }
        }
    }

    fun submitRating() {
        ratingSubmitted.value = true
        viewModelScope.launch {
            val isBn = selectedLanguage.value.contains("বাংলা") || selectedLanguage.value.equals("Bangla", ignoreCase = true)
            _snackbarMessage.emit(
                if (isBn) "আপনার মূল্যবান মতামতের জন্য ধন্যবাদ! ⭐"
                else "Thank you for your rating! ⭐"
            )
        }
    }

    private fun loadRecentSearches(): List<String> {
        val saved = prefs.getString("recent_searches_list", null)
        return if (saved != null) {
            saved.split("|||").filter { it.isNotBlank() }
        } else {
            listOf("Prothom Alo", "চাকরি", "মন্ত্রণালয়", "রেডিও", "Sports", "Economy")
        }
    }

    fun addRecentSearch(query: String) {
        val trimmed = query.trim()
        if (trimmed.length < 2) return
        val current = _recentSearches.value.toMutableList()
        current.remove(trimmed)
        current.add(0, trimmed)
        val updated = current.take(10)
        _recentSearches.value = updated
        prefs.edit().putString("recent_searches_list", updated.joinToString("|||")).apply()
    }

    fun removeRecentSearch(term: String) {
        val updated = _recentSearches.value.filter { it != term }
        _recentSearches.value = updated
        prefs.edit().putString("recent_searches_list", updated.joinToString("|||")).apply()
    }

    fun clearRecentSearches() {
        _recentSearches.value = emptyList()
        prefs.edit().remove("recent_searches_list").apply()
    }

    fun refreshCacheSize() {
        viewModelScope.launch {
            val bytes = com.example.util.CacheManager.calculateCacheSizeBytes(getApplication())
            _cacheSizeFormatted.value = com.example.util.CacheManager.formatBytes(bytes)
        }
    }

    fun clearCache() {
        viewModelScope.launch {
            repository.clearCache()
            com.example.util.CacheManager.clearAllCache(getApplication())
            refreshCacheSize()
            val isBn = selectedLanguage.value.contains("বাংলা") || selectedLanguage.value.equals("Bangla", ignoreCase = true)
            _snackbarMessage.emit(
                if (isBn) "অ্যাপ ক্যাশ ও মেমরি সম্পূর্ণ খালি করা হয়েছে! (স্টোরেজ মুক্ত হয়েছে)"
                else "App cache & memory completely cleared! (Storage freed)"
            )
        }
    }
}
