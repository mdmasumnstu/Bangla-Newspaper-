package com.example.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.NewspaperCategory
import com.example.data.model.NewspaperDataSource
import com.example.ui.NewsViewModel
import com.example.ui.components.NewspaperGridCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryViewScreen(
    category: NewspaperCategory,
    viewModel: NewsViewModel,
    onBack: () -> Unit,
    onOpenNewspaper: (String) -> Unit,
    onOpenSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    val favoriteIds by viewModel.favoriteNewspaperIds.collectAsStateWithLifecycle()
    val newspapers = rememberNewspapersForCategory(category, favoriteIds)

    val title = when (category) {
        NewspaperCategory.BENGALI -> "Bengali Newspapers"
        NewspaperCategory.ONLINE -> "Online Portals"
        NewspaperCategory.BUSINESS -> "Business News"
        NewspaperCategory.SPORTS -> "Sports News"
        NewspaperCategory.EDUCATION -> "Education News"
        NewspaperCategory.ENGLISH -> "English Newspapers"
        NewspaperCategory.AGENCIES -> "News Agencies"
        NewspaperCategory.INTERNATIONAL -> "International News"
        NewspaperCategory.TV_NEWS -> "TV News Portals"
        NewspaperCategory.LOCAL -> "Local Newspapers"
        NewspaperCategory.ALL -> "All Newspapers"
    }

    Column(modifier = modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "$title (${newspapers.size})",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            },
            navigationIcon = {
                IconButton(onClick = onBack, modifier = Modifier.testTag("category_back_btn")) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            actions = {
                IconButton(onClick = onOpenSearch, modifier = Modifier.testTag("category_search_btn")) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        )

        // 3-Column Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .testTag("category_grid"),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(newspapers, key = { it.id }) { newspaper ->
                NewspaperGridCard(
                    newspaper = newspaper,
                    onClick = { onOpenNewspaper(newspaper.id) },
                    onToggleFavorite = {
                        viewModel.toggleFavoriteNewspaper(newspaper.id, newspaper.isFavorite)
                    }
                )
            }

            item(span = { GridItemSpan(3) }) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun rememberNewspapersForCategory(
    category: NewspaperCategory,
    favoriteIds: List<String>
): List<com.example.data.model.Newspaper> {
    return androidx.compose.runtime.remember(category, favoriteIds) {
        NewspaperDataSource.getByCategory(category).map {
            it.copy(isFavorite = favoriteIds.contains(it.id))
        }
    }
}
