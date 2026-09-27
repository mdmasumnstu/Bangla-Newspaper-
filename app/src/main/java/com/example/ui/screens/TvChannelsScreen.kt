package com.example.ui.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SportsCricket
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.Newspaper
import com.example.data.model.NewspaperDataSource
import com.example.ui.NewsViewModel
import com.example.ui.theme.BreakingRed

/**
 * Categorization of Bangladesh TV Channels
 */
enum class TvChannelCategory(
    val id: String,
    val titleEn: String,
    val titleBn: String,
    val description: String,
    val icon: ImageVector,
    val badgeColor: Color,
    val channelIds: List<String>
) {
    NEWS(
        id = "news",
        titleEn = "News TV Channels",
        titleBn = "সংবাদ টিভি চ্যানেল",
        description = "24/7 Live News, Breaking Bulletins & Talk Shows",
        icon = Icons.Filled.LiveTv,
        badgeColor = Color(0xFFDC2626),
        channelIds = listOf(
            "somoy_tv",
            "jamuna_tv",
            "independent_tv",
            "channel_24",
            "ekattor_tv",
            "atn_news",
            "dbc_news",
            "news24_tv",
            "ekhon_tv",
            "btv_news"
        )
    ),
    ENTERTAINMENT(
        id = "entertainment",
        titleEn = "General Entertainment",
        titleBn = "সাধারণ বিনোদন টিভি চ্যানেল",
        description = "Dramas, Serials, Family Shows & Cultural Programs",
        icon = Icons.Filled.Movie,
        badgeColor = Color(0xFF7C3AED),
        channelIds = listOf(
            "channel_i",
            "atn_bangla",
            "ntv_bd",
            "rtv_online",
            "bangla_vision",
            "ekushey_tv",
            "boishakhi_tv",
            "maasranga_tv",
            "desh_tv",
            "my_tv",
            "satv_bd",
            "deepto_tv",
            "btv_national"
        )
    ),
    SPORTS_MUSIC(
        id = "sports_music",
        titleEn = "Sports & Music",
        titleBn = "খেলাধুলা ও সঙ্গীত চ্যানেল",
        description = "Live Cricket, Sports Broadcasts & Bengali Music",
        icon = Icons.Filled.SportsCricket,
        badgeColor = Color(0xFFEA580C),
        channelIds = listOf(
            "gazi_tv",
            "t_sports_tv",
            "gaan_bangla"
        )
    ),
    INTERNATIONAL(
        id = "international",
        titleEn = "International Bengali",
        titleBn = "আন্তর্জাতিক বাংলা টিভি",
        description = "Global Bengali Diaspora & UK Broadcasting",
        icon = Icons.Filled.Public,
        badgeColor = Color(0xFF0284C7),
        channelIds = listOf(
            "channel_s_uk"
        )
    );

    companion object {
        fun findCategory(channelId: String): TvChannelCategory {
            return entries.firstOrNull { it.channelIds.contains(channelId) } ?: NEWS
        }
    }
}

enum class TvViewMode {
    GRID, LIST
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvChannelsScreen(
    viewModel: NewsViewModel,
    onBack: () -> Unit,
    onOpenNewspaper: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current
    val favoriteIds by viewModel.favoriteNewspaperIds.collectAsStateWithLifecycle()

    var searchQuery by remember { mutableStateOf("") }
    var selectedCategoryFilter by remember { mutableStateOf<TvChannelCategory?>(null) }
    var viewMode by remember { mutableStateOf(TvViewMode.GRID) }

    // Resolve channel objects from data source
    val allChannels = remember(favoriteIds) {
        val allTvIds = TvChannelCategory.entries.flatMap { it.channelIds }
        allTvIds.mapNotNull { id ->
            NewspaperDataSource.getById(id)?.copy(
                isFavorite = favoriteIds.contains(id)
            )
        }
    }

    // Filtered channels based on search and category
    val filteredChannels = remember(searchQuery, selectedCategoryFilter, allChannels) {
        allChannels.filter { channel ->
            val matchesCategory = selectedCategoryFilter == null ||
                TvChannelCategory.findCategory(channel.id) == selectedCategoryFilter

            val matchesSearch = searchQuery.isBlank() ||
                channel.name.contains(searchQuery, ignoreCase = true) ||
                channel.banglaName.contains(searchQuery, ignoreCase = true) ||
                channel.websiteUrl.contains(searchQuery, ignoreCase = true) ||
                channel.tagline.contains(searchQuery, ignoreCase = true)

            matchesCategory && matchesSearch
        }
    }

    // Helper functions for clicking URLs
    val onLaunchUrl: (String) -> Unit = { url ->
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        } catch (_: Exception) {
            Toast.makeText(context, "Could not open browser", Toast.LENGTH_SHORT).show()
        }
    }

    val onCopyUrl: (String, String) -> Unit = { url, name ->
        clipboardManager.setText(AnnotatedString(url))
        Toast.makeText(context, "Copied $name link to clipboard", Toast.LENGTH_SHORT).show()
    }

    val onShareUrl: (String, String) -> Unit = { url, name ->
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, name)
            putExtra(Intent.EXTRA_TEXT, "$name: $url")
        }
        context.startActivity(Intent.createChooser(shareIntent, "Share $name link"))
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Top App Bar
        CenterAlignedTopAppBar(
            title = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Bangladesh TV Channels",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "বাংলাদেশ টিভি চ্যানেল (${filteredChannels.size})",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            },
            navigationIcon = {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier.testTag("tv_channels_back_btn")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            actions = {
                // Toggle Grid / List View
                IconButton(
                    onClick = {
                        viewMode = if (viewMode == TvViewMode.GRID) TvViewMode.LIST else TvViewMode.GRID
                    },
                    modifier = Modifier.testTag("tv_toggle_view_btn")
                ) {
                    Icon(
                        imageVector = if (viewMode == TvViewMode.GRID) Icons.Filled.ViewList else Icons.Filled.GridView,
                        contentDescription = if (viewMode == TvViewMode.GRID) "Switch to List View" else "Switch to Grid View",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        )

        // Search and Filter Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            // Search Input
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = {
                    Text(
                        "Search 27 TV channels (e.g. Somoy, NTV, Sports)...",
                        fontSize = 13.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotBlank()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = "Clear Search",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                    focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("tv_search_input")
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Category Chips Row
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 2.dp)
            ) {
                // "All" chip
                item {
                    FilterChip(
                        selected = selectedCategoryFilter == null,
                        onClick = { selectedCategoryFilter = null },
                        label = { Text("All (${allChannels.size})", fontWeight = FontWeight.SemiBold) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Tv,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                }

                items(TvChannelCategory.entries.toTypedArray()) { cat ->
                    val isSelected = selectedCategoryFilter == cat
                    val count = allChannels.count { TvChannelCategory.findCategory(it.id) == cat }
                    FilterChip(
                        selected = isSelected,
                        onClick = {
                            selectedCategoryFilter = if (isSelected) null else cat
                        },
                        label = {
                            Text(
                                text = "${cat.titleEn.substringBefore(" TV")} ($count)",
                                fontWeight = FontWeight.SemiBold
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = cat.icon,
                                contentDescription = null,
                                tint = if (isSelected) cat.badgeColor else MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(16.dp)
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = cat.badgeColor.copy(alpha = 0.15f),
                            selectedLabelColor = cat.badgeColor
                        )
                    )
                }
            }
        }

        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f))

        // Content Display
        if (filteredChannels.isEmpty()) {
            TvEmptyState(
                searchQuery = searchQuery,
                onClearSearch = {
                    searchQuery = ""
                    selectedCategoryFilter = null
                }
            )
        } else {
            when (viewMode) {
                TvViewMode.GRID -> {
                    TvChannelsGridView(
                        channels = filteredChannels,
                        selectedCategory = selectedCategoryFilter,
                        onOpenNewspaper = onOpenNewspaper,
                        onLaunchUrl = onLaunchUrl,
                        onCopyUrl = onCopyUrl,
                        onShareUrl = onShareUrl,
                        onToggleFavorite = { viewModel.toggleFavoriteNewspaper(it) }
                    )
                }
                TvViewMode.LIST -> {
                    TvChannelsListView(
                        channels = filteredChannels,
                        selectedCategory = selectedCategoryFilter,
                        onOpenNewspaper = onOpenNewspaper,
                        onLaunchUrl = onLaunchUrl,
                        onCopyUrl = onCopyUrl,
                        onShareUrl = onShareUrl,
                        onToggleFavorite = { viewModel.toggleFavoriteNewspaper(it) }
                    )
                }
            }
        }
    }
}

/**
 * Grid View with Categorized Sections
 */
@Composable
private fun TvChannelsGridView(
    channels: List<Newspaper>,
    selectedCategory: TvChannelCategory?,
    onOpenNewspaper: (String) -> Unit,
    onLaunchUrl: (String) -> Unit,
    onCopyUrl: (String, String) -> Unit,
    onShareUrl: (String, String) -> Unit,
    onToggleFavorite: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 165.dp),
        contentPadding = PaddingValues(start = 14.dp, end = 14.dp, top = 12.dp, bottom = 28.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .testTag("tv_channels_grid")
    ) {
        // If viewing all categories, group them with headers
        if (selectedCategory == null) {
            TvChannelCategory.entries.forEach { category ->
                val categoryChannels = channels.filter { TvChannelCategory.findCategory(it.id) == category }
                if (categoryChannels.isNotEmpty()) {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        TvCategoryHeader(category = category, count = categoryChannels.size)
                    }

                    items(categoryChannels, key = { it.id }) { channel ->
                        TvChannelGridCard(
                            channel = channel,
                            category = category,
                            onOpenNewspaper = { onOpenNewspaper(channel.id) },
                            onLaunchUrl = { onLaunchUrl(channel.websiteUrl) },
                            onCopyUrl = { onCopyUrl(channel.websiteUrl, channel.name) },
                            onShareUrl = { onShareUrl(channel.websiteUrl, channel.name) },
                            onToggleFavorite = { onToggleFavorite(channel.id) }
                        )
                    }
                }
            }
        } else {
            // Filtered to a single category
            item(span = { GridItemSpan(maxLineSpan) }) {
                TvCategoryHeader(category = selectedCategory, count = channels.size)
            }

            items(channels, key = { it.id }) { channel ->
                TvChannelGridCard(
                    channel = channel,
                    category = selectedCategory,
                    onOpenNewspaper = { onOpenNewspaper(channel.id) },
                    onLaunchUrl = { onLaunchUrl(channel.websiteUrl) },
                    onCopyUrl = { onCopyUrl(channel.websiteUrl, channel.name) },
                    onShareUrl = { onShareUrl(channel.websiteUrl, channel.name) },
                    onToggleFavorite = { onToggleFavorite(channel.id) }
                )
            }
        }
    }
}

/**
 * List View with Full Width Cards & Direct Clickable Links
 */
@Composable
private fun TvChannelsListView(
    channels: List<Newspaper>,
    selectedCategory: TvChannelCategory?,
    onOpenNewspaper: (String) -> Unit,
    onLaunchUrl: (String) -> Unit,
    onCopyUrl: (String, String) -> Unit,
    onShareUrl: (String, String) -> Unit,
    onToggleFavorite: (String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 28.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .testTag("tv_channels_list")
    ) {
        if (selectedCategory == null) {
            TvChannelCategory.entries.forEach { category ->
                val categoryChannels = channels.filter { TvChannelCategory.findCategory(it.id) == category }
                if (categoryChannels.isNotEmpty()) {
                    item {
                        TvCategoryHeader(category = category, count = categoryChannels.size)
                    }

                    items(categoryChannels, key = { it.id }) { channel ->
                        TvChannelListCard(
                            channel = channel,
                            category = category,
                            onOpenNewspaper = { onOpenNewspaper(channel.id) },
                            onLaunchUrl = { onLaunchUrl(channel.websiteUrl) },
                            onCopyUrl = { onCopyUrl(channel.websiteUrl, channel.name) },
                            onShareUrl = { onShareUrl(channel.websiteUrl, channel.name) },
                            onToggleFavorite = { onToggleFavorite(channel.id) }
                        )
                    }
                }
            }
        } else {
            item {
                TvCategoryHeader(category = selectedCategory, count = channels.size)
            }

            items(channels, key = { it.id }) { channel ->
                TvChannelListCard(
                    channel = channel,
                    category = selectedCategory,
                    onOpenNewspaper = { onOpenNewspaper(channel.id) },
                    onLaunchUrl = { onLaunchUrl(channel.websiteUrl) },
                    onCopyUrl = { onCopyUrl(channel.websiteUrl, channel.name) },
                    onShareUrl = { onShareUrl(channel.websiteUrl, channel.name) },
                    onToggleFavorite = { onToggleFavorite(channel.id) }
                )
            }
        }
    }
}

/**
 * Category Section Header
 */
@Composable
private fun TvCategoryHeader(
    category: TvChannelCategory,
    count: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 6.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Surface(
                shape = CircleShape,
                color = category.badgeColor.copy(alpha = 0.15f),
                modifier = Modifier.size(28.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = category.icon,
                        contentDescription = null,
                        tint = category.badgeColor,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = category.titleEn,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = category.titleBn,
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Surface(
            shape = RoundedCornerShape(12.dp),
            color = category.badgeColor.copy(alpha = 0.12f)
        ) {
            Text(
                text = "$count Channels",
                style = MaterialTheme.typography.labelSmall,
                color = category.badgeColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
            )
        }
    }
}

/**
 * Grid Card Component with Clickable URL & Channel Info
 */
@Composable
fun TvChannelGridCard(
    channel: Newspaper,
    category: TvChannelCategory,
    onOpenNewspaper: () -> Unit,
    onLaunchUrl: () -> Unit,
    onCopyUrl: () -> Unit,
    onShareUrl: () -> Unit,
    onToggleFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    val brandColor = Color(channel.primaryColorHex)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onOpenNewspaper)
            .testTag("tv_grid_card_${channel.id}"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = BorderStroke(1.dp, brandColor.copy(alpha = 0.25f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar with Category Badge and Favorite Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = brandColor.copy(alpha = 0.12f)
                ) {
                    Text(
                        text = "LIVE TV",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = brandColor,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

                IconButton(
                    onClick = onToggleFavorite,
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        imageVector = if (channel.isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = if (channel.isFavorite) "Favorited" else "Add to Favorites",
                        tint = if (channel.isFavorite) BreakingRed else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                        modifier = Modifier.size(17.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Channel Icon / Monogram
            Surface(
                shape = CircleShape,
                color = brandColor.copy(alpha = 0.14f),
                border = BorderStroke(2.dp, brandColor.copy(alpha = 0.5f)),
                modifier = Modifier.size(54.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = channel.banglaName.take(2).ifBlank { channel.name.take(2) },
                        color = brandColor,
                        fontWeight = FontWeight.Black,
                        fontSize = 17.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Channel Bangla Name
            Text(
                text = channel.banglaName.ifBlank { channel.name },
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )

            // Channel English Name
            Text(
                text = channel.name,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Tagline
            Text(
                text = channel.tagline,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.outline,
                fontSize = 10.5.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Clickable URL Item (Highlighted with link styling)
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.25f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable(onClick = onLaunchUrl)
                    .testTag("tv_url_${channel.id}")
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Language,
                        contentDescription = "Website",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = channel.websiteUrl
                            .removePrefix("https://")
                            .removePrefix("http://")
                            .removePrefix("www.")
                            .trimEnd('/'),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold,
                        textDecoration = TextDecoration.Underline,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 11.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Action Row: Open In-App, External Browser, Copy
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onLaunchUrl,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.OpenInNew,
                        contentDescription = "Open in Browser",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(16.dp)
                    )
                }

                IconButton(
                    onClick = onCopyUrl,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ContentCopy,
                        contentDescription = "Copy Link",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(16.dp)
                    )
                }

                IconButton(
                    onClick = onShareUrl,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Share Channel",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

/**
 * List Card Component with Extended Details and Direct Clickable Link
 */
@Composable
fun TvChannelListCard(
    channel: Newspaper,
    category: TvChannelCategory,
    onOpenNewspaper: () -> Unit,
    onLaunchUrl: () -> Unit,
    onCopyUrl: () -> Unit,
    onShareUrl: () -> Unit,
    onToggleFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    val brandColor = Color(channel.primaryColorHex)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onOpenNewspaper)
            .testTag("tv_list_card_${channel.id}"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = BorderStroke(1.dp, brandColor.copy(alpha = 0.2f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Channel Circular Monogram
                Surface(
                    shape = CircleShape,
                    color = brandColor.copy(alpha = 0.15f),
                    border = BorderStroke(1.5.dp, brandColor.copy(alpha = 0.5f)),
                    modifier = Modifier.size(48.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = channel.banglaName.take(2).ifBlank { channel.name.take(2) },
                            color = brandColor,
                            fontWeight = FontWeight.Black,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Titles & Tagline
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = channel.banglaName.ifBlank { channel.name },
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = brandColor.copy(alpha = 0.12f)
                        ) {
                            Text(
                                text = category.titleEn.substringBefore(" TV"),
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = brandColor,
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Text(
                        text = channel.name,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 12.sp
                    )

                    Text(
                        text = channel.tagline,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.outline,
                        fontSize = 11.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Favorite Icon
                IconButton(
                    onClick = onToggleFavorite,
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = if (channel.isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = if (channel.isFavorite) "Favorited" else "Favorite",
                        tint = if (channel.isFavorite) BreakingRed else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Clickable URL Banner
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.25f),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .clickable(onClick = onLaunchUrl)
                    .testTag("tv_list_url_${channel.id}")
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Language,
                            contentDescription = "Website",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = channel.websiteUrl,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold,
                            textDecoration = TextDecoration.Underline,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 12.sp
                        )
                    }

                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.OpenInNew,
                        contentDescription = "Open Link",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onOpenNewspaper,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = brandColor
                    ),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                    modifier = Modifier.height(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.LiveTv,
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Watch Channel", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }

                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    OutlinedButton(
                        onClick = onLaunchUrl,
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                        modifier = Modifier.height(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.OpenInNew,
                            contentDescription = "Browser",
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Browser", fontSize = 11.5.sp)
                    }

                    IconButton(
                        onClick = onCopyUrl,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ContentCopy,
                            contentDescription = "Copy Link",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(17.dp)
                        )
                    }

                    IconButton(
                        onClick = onShareUrl,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Share",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(17.dp)
                        )
                    }
                }
            }
        }
    }
}

/**
 * Empty search state
 */
@Composable
private fun TvEmptyState(
    searchQuery: String,
    onClearSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.size(72.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Filled.Tv,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(36.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "No TV Channels Found",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = if (searchQuery.isNotBlank()) "No channels match \"$searchQuery\"" else "No channels in this category",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onClearSearch) {
            Text("Show All 27 Channels")
        }
    }
}
