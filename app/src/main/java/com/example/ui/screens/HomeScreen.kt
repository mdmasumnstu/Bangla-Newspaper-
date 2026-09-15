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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.local.entity.ArticleEntity
import com.example.data.model.NewspaperDataSource
import com.example.ui.NewsViewModel
import com.example.ui.components.ArticleCard
import com.example.ui.components.BreakingNewsBanner
import com.example.ui.components.NewspaperGridCard
import com.example.ui.components.TopNewsCarousel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: NewsViewModel,
    onOpenSearch: () -> Unit,
    onOpenArticle: (String) -> Unit,
    onOpenNewspaper: (String) -> Unit = {},
    onSeeAllNews: () -> Unit,
    onOpenMenu: () -> Unit,
    modifier: Modifier = Modifier
) {
    val breakingNews by viewModel.breakingNews.collectAsStateWithLifecycle()
    val topNews by viewModel.topNews.collectAsStateWithLifecycle()
    val allArticles by viewModel.allArticles.collectAsStateWithLifecycle()
    val isRefreshing by viewModel.isRefreshing.collectAsStateWithLifecycle()

    var showNotificationsDialog by remember { mutableStateOf(false) }

    // Filter out top news and breaking from latest feed to show diverse content
    val latestArticles = remember(allArticles, topNews, breakingNews) {
        val topIds = topNews.map { it.id }.toSet()
        val latestList = allArticles.filter { !topIds.contains(it.id) }
        if (latestList.isNotEmpty()) latestList else allArticles
    }

    Column(modifier = modifier.fillMaxSize()) {
        // Top App Bar
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "NewsHub BD",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            },
            navigationIcon = {
                IconButton(onClick = onOpenMenu, modifier = Modifier.testTag("home_menu_btn")) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            actions = {
                IconButton(onClick = { viewModel.refreshNews() }, modifier = Modifier.testTag("home_refresh_btn")) {
                    if (isRefreshing) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            strokeWidth = 2.dp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = "Refresh News",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                IconButton(onClick = onOpenSearch, modifier = Modifier.testTag("home_search_btn")) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
                IconButton(onClick = { showNotificationsDialog = true }, modifier = Modifier.testTag("home_notifications_btn")) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "Notifications",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        )

        // News Feed
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Breaking News Banner
            if (breakingNews.isNotEmpty()) {
                item {
                    BreakingNewsBanner(
                        breakingArticles = breakingNews,
                        onClick = onOpenArticle
                    )
                }
            }

            // Top News Header & Carousel
            if (topNews.isNotEmpty()) {
                item {
                    Column {
                        Text(
                            text = "Top News",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )

                        TopNewsCarousel(
                            articles = topNews,
                            onArticleClick = onOpenArticle
                        )
                    }
                }
            }

            // Popular Newspapers (3 per row)
            item {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Popular Newspapers",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        TextButton(onClick = onSeeAllNews) {
                            Text(
                                text = "All (120+)",
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 13.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    val topNewspapers = remember {
                        val ids = listOf("prothom_alo", "the_daily_star", "ittefaq", "bdnews24", "kaler_kantho", "somokal")
                        ids.mapNotNull { NewspaperDataSource.getById(it) }
                    }

                    // 2 rows of 3 columns
                    topNewspapers.chunked(3).forEach { rowPapers ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            rowPapers.forEach { newspaper ->
                                Box(modifier = Modifier.weight(1f)) {
                                    NewspaperGridCard(
                                        newspaper = newspaper,
                                        onClick = { onOpenNewspaper(newspaper.id) },
                                        onToggleFavorite = {
                                            viewModel.toggleFavoriteNewspaper(newspaper.id, newspaper.isFavorite)
                                        }
                                    )
                                }
                            }
                            repeat(3 - rowPapers.size) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }

            // Latest News Section Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Latest News",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    TextButton(onClick = onSeeAllNews, modifier = Modifier.testTag("see_all_news_btn")) {
                        Text(
                            text = "See All",
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            // Latest News Feed
            items(latestArticles, key = { it.id }) { article ->
                ArticleCard(
                    article = article,
                    onClick = { onOpenArticle(article.id) },
                    onToggleSave = { viewModel.toggleSaveArticle(article) }
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

    // Notifications Dialog
    if (showNotificationsDialog) {
        AlertDialog(
            onDismissRequest = { showNotificationsDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text("News Alerts")
                }
            },
            text = {
                Column {
                    Text(
                        text = "Real-time breaking updates enabled:",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    breakingNews.take(3).forEach { item ->
                        Text(
                            text = "• ${item.title}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                    if (breakingNews.isEmpty()) {
                        Text("No unread breaking alerts right now. You are all caught up!")
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showNotificationsDialog = false }) {
                    Text("Close")
                }
            }
        )
    }
}
