package com.example.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.NewspaperCategory
import com.example.ui.NewsViewModel
import com.example.ui.components.ArticleCard
import com.example.ui.components.CategoryChipRow
import com.example.ui.components.NewspaperGridCard

data class CategoryItem(
    val category: NewspaperCategory,
    val icon: ImageVector,
    val iconBgColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    viewModel: NewsViewModel,
    onBack: () -> Unit,
    onOpenArticle: (String) -> Unit,
    onOpenNewspaper: (String) -> Unit,
    onOpenCategory: (NewspaperCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    val strings by viewModel.appStrings.collectAsStateWithLifecycle()
    val isBn = strings == com.example.util.AppStrings.Bangla
    val searchQuery by viewModel.globalSearchQuery.collectAsStateWithLifecycle()
    val searchResults by viewModel.searchResults.collectAsStateWithLifecycle()
    val searchCategoryFilter by viewModel.searchCategoryFilter.collectAsStateWithLifecycle()
    val recentSearches by viewModel.recentSearches.collectAsStateWithLifecycle()

    val popularCategories = listOf(
        CategoryItem(NewspaperCategory.BENGALI, Icons.Filled.Newspaper, Color(0xFF10B981)),
        CategoryItem(NewspaperCategory.JOBS, Icons.Filled.Business, Color(0xFF0D9488)),
        CategoryItem(NewspaperCategory.RADIO, Icons.Filled.Tv, Color(0xFFE11D48)),
        CategoryItem(NewspaperCategory.GOVERNMENT, Icons.Filled.Public, Color(0xFF059669)),
        CategoryItem(NewspaperCategory.STOCK_MARKET, Icons.Filled.Business, Color(0xFF2563EB)),
        CategoryItem(NewspaperCategory.MAGAZINE, Icons.Filled.Newspaper, Color(0xFF7C3AED)),
        CategoryItem(NewspaperCategory.TECH, Icons.Filled.Public, Color(0xFFD97706)),
        CategoryItem(NewspaperCategory.LOCAL, Icons.Filled.LocationOn, Color(0xFFF97316)),
        CategoryItem(NewspaperCategory.TV_NEWS, Icons.Filled.Tv, Color(0xFFEF4444)),
        CategoryItem(NewspaperCategory.SPORTS, Icons.Filled.SportsSoccer, Color(0xFFEAB308)),
        CategoryItem(NewspaperCategory.ENGLISH, Icons.Filled.Language, Color(0xFF8B5CF6))
    )

    Column(modifier = modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = {
                        viewModel.setGlobalSearchQuery(it)
                        if (it.trim().length >= 3) {
                            viewModel.addRecentSearch(it)
                        }
                    },
                    placeholder = { Text(strings.searchPlaceholder, fontSize = 14.sp) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { viewModel.setGlobalSearchQuery("") }) {
                                Icon(imageVector = Icons.Filled.Clear, contentDescription = strings.clear)
                            }
                        }
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .testTag("global_search_input")
                )
            },
            navigationIcon = {
                IconButton(onClick = onBack, modifier = Modifier.testTag("search_back_btn")) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        )

        // Instant Category Filter Chips in Search Screen
        CategoryChipRow(
            selectedCategory = searchCategoryFilter,
            onCategorySelect = { viewModel.setSearchCategoryFilter(it) },
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (searchQuery.isBlank() && searchCategoryFilter == NewspaperCategory.ALL) {
                // Recent Searches
                if (recentSearches.isNotEmpty()) {
                    item {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = if (isBn) "সাম্প্রতিক অনুসন্ধান" else "Recent Searches",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                androidx.compose.material3.TextButton(
                                    onClick = { viewModel.clearRecentSearches() }
                                ) {
                                    Text(
                                        text = if (isBn) "সব মুছুন" else "Clear All",
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                recentSearches.forEach { term ->
                                    AssistChip(
                                        onClick = {
                                            viewModel.setGlobalSearchQuery(term)
                                            viewModel.addRecentSearch(term)
                                        },
                                        label = { Text(term) },
                                        shape = RoundedCornerShape(16.dp),
                                        colors = AssistChipDefaults.assistChipColors(
                                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
                                        ),
                                        modifier = Modifier.testTag("recent_search_chip_$term")
                                    )
                                }
                            }
                        }
                    }
                }

                // Popular Categories List
                item {
                    Text(
                        text = if (isBn) "জনপ্রিয় ক্যাটাগরি" else "Popular Categories",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )
                }

                items(popularCategories, key = { it.category.name }) { item ->
                    val catName = if (isBn) item.category.banglaName else item.category.displayName
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onOpenCategory(item.category) }
                            .testTag("search_category_${item.category.name}"),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        border = CardDefaults.outlinedCardBorder().copy(
                            brush = androidx.compose.ui.graphics.SolidColor(MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Surface(
                                    shape = CircleShape,
                                    color = item.iconBgColor.copy(alpha = 0.15f),
                                    modifier = Modifier.size(36.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Icon(
                                            imageVector = item.icon,
                                            contentDescription = null,
                                            tint = item.iconBgColor,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.width(16.dp))
                                Text(
                                    text = "${item.category.emoji} $catName",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            } else {
                // Search Results for Newspapers (Grid 3 per row)
                if (searchResults.matchingNewspapers.isNotEmpty()) {
                    item {
                        Text(
                            text = "${strings.sources} (${searchResults.matchingNewspapers.size})",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    val chunkedNewspapers = searchResults.matchingNewspapers.chunked(3)
                    items(chunkedNewspapers) { rowNewspapers ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            rowNewspapers.forEach { newspaper ->
                                Box(modifier = Modifier.weight(1f)) {
                                    NewspaperGridCard(
                                        newspaper = newspaper,
                                        onClick = {
                                            viewModel.addRecentSearch(newspaper.name)
                                            onOpenNewspaper(newspaper.id)
                                        },
                                        onToggleFavorite = {
                                            viewModel.toggleFavoriteNewspaper(newspaper.id, newspaper.isFavorite)
                                        }
                                    )
                                }
                            }
                            repeat(3 - rowNewspapers.size) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }

                // Search Results for Articles
                if (searchResults.matchingArticles.isNotEmpty()) {
                    item {
                        Text(
                            text = "${strings.latestNews} (${searchResults.matchingArticles.size})",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }

                    items(searchResults.matchingArticles, key = { it.id }) { article ->
                        ArticleCard(
                            article = article,
                            onClick = {
                                viewModel.addRecentSearch(article.title.take(30))
                                onOpenArticle(article.id)
                            },
                            onToggleSave = { viewModel.toggleSaveArticle(article) }
                        )
                    }
                }

                if (searchResults.matchingNewspapers.isEmpty() && searchResults.matchingArticles.isEmpty()) {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = strings.noArticlesFound,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = if (isBn) "অনুসন্ধান পরামর্শ: প্রথম আলো, বিডি জবস, অর্থ মন্ত্রণালয়, রেডিও বা প্রযুক্তি"
                                else "Try searching for Prothom Alo, BD Jobs, Ministry of Finance, Radio, or Tech.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
