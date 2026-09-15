package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.entity.ArticleEntity
import com.example.data.model.Newspaper
import com.example.data.model.NewspaperCategory
import com.example.data.model.NewspaperDataSource
import com.example.data.repository.NewsRepository
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
    SEARCH
}

enum class ThemeMode {
    SYSTEM, LIGHT, DARK
}

data class NewsSearchResult(
    val query: String = "",
    val matchingNewspapers: List<Newspaper> = emptyList(),
    val matchingArticles: List<ArticleEntity> = emptyList()
)

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = NewsRepository.getInstance(application)

    // Navigation state
    private val _currentScreen = MutableStateFlow(ScreenDestination.MAIN_TABS)
    val currentScreen: StateFlow<ScreenDestination> = _currentScreen.asStateFlow()

    private val _selectedTab = MutableStateFlow(BottomTab.HOME)
    val selectedTab: StateFlow<BottomTab> = _selectedTab.asStateFlow()

    private val _activeArticleId = MutableStateFlow<String?>(null)
    val activeArticleId: StateFlow<String?> = _activeArticleId.asStateFlow()

    private val _activeNewspaperId = MutableStateFlow<String?>(null)
    val activeNewspaperId: StateFlow<String?> = _activeNewspaperId.asStateFlow()

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

    private val _sourcesSearchQuery = MutableStateFlow("")
    val sourcesSearchQuery: StateFlow<String> = _sourcesSearchQuery.asStateFlow()

    val filteredNewspapers: StateFlow<List<Newspaper>> = combine(
        favoriteNewspaperIds,
        _sourcesCategoryFilter,
        _sourcesSearchQuery
    ) { favIds, category, query ->
        val baseList = if (category == NewspaperCategory.ALL) {
            NewspaperDataSource.allNewspapers
        } else {
            NewspaperDataSource.getByCategory(category)
        }

        val queried = if (query.isBlank()) {
            baseList
        } else {
            baseList.filter {
                it.name.contains(query, ignoreCase = true) ||
                it.banglaName.contains(query, ignoreCase = true) ||
                it.category.displayName.contains(query, ignoreCase = true)
            }
        }

        queried.map { newspaper ->
            newspaper.copy(isFavorite = favIds.contains(newspaper.id))
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Search Screen State
    private val _globalSearchQuery = MutableStateFlow("")
    val globalSearchQuery: StateFlow<String> = _globalSearchQuery.asStateFlow()

    val searchResults: StateFlow<NewsSearchResult> = _globalSearchQuery
        .debounce(200)
        .flatMapLatest { query ->
            if (query.isBlank()) {
                flowOf(NewsSearchResult())
            } else {
                combine(
                    repository.searchArticles(query),
                    favoriteNewspaperIds
                ) { articles, favIds ->
                    val matchingPapers = NewspaperDataSource.allNewspapers.filter {
                        it.name.contains(query, ignoreCase = true) ||
                        it.banglaName.contains(query, ignoreCase = true) ||
                        it.category.displayName.contains(query, ignoreCase = true)
                    }.map { it.copy(isFavorite = favIds.contains(it.id)) }

                    NewsSearchResult(
                        query = query,
                        matchingNewspapers = matchingPapers,
                        matchingArticles = articles
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

    // Settings
    val themeMode = MutableStateFlow(ThemeMode.SYSTEM)
    val selectedLanguage = MutableStateFlow("English")
    val notificationsEnabled = MutableStateFlow(true)
    val breakingAlertsEnabled = MutableStateFlow(true)

    init {
        viewModelScope.launch {
            repository.initializeData()
            // Immediately fetch real-time news from the internet on launch
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
            _isRefreshing.value = true
            repository.refreshRealtimeNews()
            _isRefreshing.value = false
        }
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

    fun openNewspaper(newspaperId: String) {
        _activeNewspaperId.value = newspaperId
        pushScreen(ScreenDestination.NEWSPAPER_DETAIL)
    }

    fun openCategory(category: NewspaperCategory) {
        _activeCategory.value = category
        pushScreen(ScreenDestination.CATEGORY_VIEW)
    }

    fun openSearch() {
        _globalSearchQuery.value = ""
        pushScreen(ScreenDestination.SEARCH)
    }

    private fun pushScreen(destination: ScreenDestination) {
        navBackStack.add(_currentScreen.value)
        _currentScreen.value = destination
    }

    fun handleBack(): Boolean {
        if (navBackStack.isNotEmpty()) {
            val previous = navBackStack.removeAt(navBackStack.size - 1)
            _currentScreen.value = previous
            return true
        } else if (_currentScreen.value != ScreenDestination.MAIN_TABS) {
            _currentScreen.value = ScreenDestination.MAIN_TABS
            return true
        } else if (_selectedTab.value != BottomTab.HOME) {
            _selectedTab.value = BottomTab.HOME
            return true
        }
        return false
    }

    fun setSourcesCategoryFilter(category: NewspaperCategory) {
        _sourcesCategoryFilter.value = category
    }

    fun setSourcesSearchQuery(query: String) {
        _sourcesSearchQuery.value = query
    }

    fun setGlobalSearchQuery(query: String) {
        _globalSearchQuery.value = query
    }

    fun toggleSaveArticle(article: ArticleEntity) {
        viewModelScope.launch {
            val newSaveState = !article.isSaved
            repository.toggleSaveArticle(article.id, newSaveState)
            _snackbarMessage.emit(
                if (newSaveState) "Article saved for offline reading 📥"
                else "Article removed from saved 🗑️"
            )
        }
    }

    fun toggleFavoriteNewspaper(newspaperId: String, isCurrentlyFavorite: Boolean) {
        viewModelScope.launch {
            repository.toggleFavoriteNewspaper(newspaperId, isCurrentlyFavorite)
            _snackbarMessage.emit(
                if (!isCurrentlyFavorite) "Added to favorite newspapers ❤️"
                else "Removed from favorite newspapers"
            )
        }
    }

    fun refreshNews() {
        viewModelScope.launch {
            _isRefreshing.value = true
            val result = repository.refreshRealtimeNews()
            _isRefreshing.value = false
            result.onSuccess { count ->
                _snackbarMessage.emit(
                    if (count > 0) "Refreshed: $count new articles collected!"
                    else "News feed is up to date!"
                )
            }.onFailure {
                _snackbarMessage.emit("Showing cached news (offline mode)")
            }
        }
    }

    fun submitRating() {
        ratingSubmitted.value = true
        viewModelScope.launch {
            _snackbarMessage.emit("Thank you for your rating! ⭐")
        }
    }

    fun clearCache() {
        viewModelScope.launch {
            repository.clearCache()
            _snackbarMessage.emit("Offline cache cleared and reset!")
        }
    }
}
