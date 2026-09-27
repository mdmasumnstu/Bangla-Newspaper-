package com.example.ui.screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.NewspaperDataSource
import com.example.ui.NewsViewModel
import com.example.ui.components.ArticleCard
import com.example.ui.components.NewspaperCard
import com.example.ui.components.NewspaperGridCard
import com.example.ui.theme.EmeraldPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(
    viewModel: NewsViewModel,
    onOpenArticle: (String) -> Unit,
    onOpenNewspaper: (String) -> Unit,
    onExploreSources: () -> Unit,
    onOpenMenu: () -> Unit,
    modifier: Modifier = Modifier
) {
    val strings by viewModel.appStrings.collectAsStateWithLifecycle()
    val isBn = strings == com.example.util.AppStrings.Bangla
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val savedArticles by viewModel.savedArticles.collectAsStateWithLifecycle()
    val favoriteIds by viewModel.favoriteNewspaperIds.collectAsStateWithLifecycle()

    val favoriteNewspapers = remember(favoriteIds) {
        NewspaperDataSource.allNewspapers.filter { favoriteIds.contains(it.id) }
            .map { it.copy(isFavorite = true) }
    }

    Column(modifier = modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = strings.favorites,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            },
            navigationIcon = {
                IconButton(onClick = onOpenMenu, modifier = Modifier.testTag("favorites_menu_btn")) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        )

        // Custom Tab Switcher (Saved Newspapers | Saved Articles)
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = MaterialTheme.colorScheme.primary
                )
            },
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Tab(
                selected = selectedTabIndex == 0,
                onClick = { selectedTabIndex = 0 },
                text = {
                    val tabLabel = if (isBn) "প্রিয় পত্রিকা (${favoriteNewspapers.size})" else "Saved Newspapers (${favoriteNewspapers.size})"
                    Text(
                        text = tabLabel,
                        fontWeight = if (selectedTabIndex == 0) FontWeight.Bold else FontWeight.Medium,
                        fontSize = 13.sp
                    )
                },
                modifier = Modifier.testTag("tab_saved_newspapers")
            )
            Tab(
                selected = selectedTabIndex == 1,
                onClick = { selectedTabIndex = 1 },
                text = {
                    val tabLabel = if (isBn) "অফলাইন সংবাদ (${savedArticles.size})" else "Saved Articles (${savedArticles.size})"
                    Text(
                        text = tabLabel,
                        fontWeight = if (selectedTabIndex == 1) FontWeight.Bold else FontWeight.Medium,
                        fontSize = 13.sp
                    )
                },
                modifier = Modifier.testTag("tab_saved_articles")
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (selectedTabIndex == 0) {
            // Saved Newspapers Tab
            if (favoriteNewspapers.isEmpty()) {
                EmptyStateView(
                    title = if (isBn) "কোনো প্রিয় পত্রিকা যুক্ত করা হয়নি" else "No Favorite Newspapers Yet",
                    description = if (isBn) "পত্রিকা ও সাইট তালিকা থেকে আপনার পছন্দের পত্রিকার স্টার বাটনে ট্যাপ করে এখানে যুক্ত করুন।"
                    else "Star your preferred newspapers from the Sources tab to access them quickly here.",
                    buttonText = if (isBn) "পত্রিকা ব্রাউজ করুন" else "Explore Sources",
                    onButtonClick = onExploreSources
                )
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier.fillMaxSize().testTag("favorites_grid"),
                    contentPadding = PaddingValues(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(favoriteNewspapers, key = { it.id }) { newspaper ->
                        NewspaperGridCard(
                            newspaper = newspaper,
                            onClick = { onOpenNewspaper(newspaper.id) },
                            onToggleFavorite = {
                                viewModel.toggleFavoriteNewspaper(newspaper.id, isCurrentlyFavorite = true)
                            }
                        )
                    }

                    item(span = { GridItemSpan(3) }) {
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        } else {
            // Saved Articles Tab (Offline Reading)
            if (savedArticles.isEmpty()) {
                EmptyStateView(
                    title = if (isBn) "অফলাইনে পড়ার মতো কোনো সংরক্ষিত সংবাদ নেই" else "No Articles Saved for Offline Reading",
                    description = if (isBn) "ইন্টারনেট ছাড়া যেকোনো সময় পড়তে যেকোনো সংবাদের বুকমার্ক আইকনে ট্যাপ করে সংরক্ষণ করুন।"
                    else "Tap the bookmark icon on any news article to save it for reading anytime, even without an internet connection.",
                    buttonText = if (isBn) "সংবাদ ফিড দেখুন" else "Explore News",
                    onButtonClick = onExploreSources
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(savedArticles, key = { it.id }) { article ->
                        ArticleCard(
                            article = article,
                            onClick = { onOpenArticle(article.id) },
                            onToggleSave = { viewModel.toggleSaveArticle(article) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun EmptyStateView(
    title: String,
    description: String,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Filled.BookmarkBorder,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onButtonClick,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = EmeraldPrimary)
        ) {
            Text(text = buttonText, color = Color.White, fontWeight = FontWeight.SemiBold)
        }
    }
}
