package com.example.ui.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.Newspaper
import com.example.data.model.NewspaperCategory
import com.example.ui.NewsViewModel
import com.example.ui.components.CategoryChipRow
import com.example.ui.components.NewspaperGridCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SourcesScreen(
    viewModel: NewsViewModel,
    onOpenNewspaper: (String) -> Unit,
    onOpenSearch: () -> Unit,
    onOpenMenu: () -> Unit,
    modifier: Modifier = Modifier
) {
    val strings by viewModel.appStrings.collectAsStateWithLifecycle()
    val filteredNewspapers by viewModel.filteredNewspapers.collectAsStateWithLifecycle()
    val categoryFilter by viewModel.sourcesCategoryFilter.collectAsStateWithLifecycle()
    val regionFilter by viewModel.sourcesRegionFilter.collectAsStateWithLifecycle()
    val searchQuery by viewModel.sourcesSearchQuery.collectAsStateWithLifecycle()

    val regions = listOf(
        "All Regions",
        "Barishal Division",
        "Rangpur Region",
        "Sylhet Division",
        "Chattogram Region",
        "Mymensingh Region",
        "Khulna Region",
        "Rajshahi Region",
        "Cumilla Region"
    )

    Column(modifier = modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "${strings.sources} (${filteredNewspapers.size})",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            },
            navigationIcon = {
                IconButton(onClick = onOpenMenu, modifier = Modifier.testTag("sources_menu_btn")) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = { viewModel.openTvChannels() },
                    modifier = Modifier.testTag("sources_tv_btn")
                ) {
                    Icon(
                        imageVector = Icons.Filled.LiveTv,
                        contentDescription = "Live TV Channels",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                IconButton(onClick = onOpenSearch, modifier = Modifier.testTag("sources_search_btn")) {
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

        // Search Input
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { viewModel.setSourcesSearchQuery(it) },
            placeholder = { Text(strings.searchSourcesPlaceholder) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { viewModel.setSourcesSearchQuery("") }) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = strings.clear)
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                focusedBorderColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 6.dp)
                .testTag("sources_search_input")
        )

        // Category Filter Chips
        CategoryChipRow(
            selectedCategory = categoryFilter,
            onCategorySelect = { viewModel.setSourcesCategoryFilter(it) },
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 2.dp)
        )

        // Region Filter Chips (When Local Newspapers category is active)
        if (categoryFilter == NewspaperCategory.LOCAL) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 14.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                regions.forEach { region ->
                    val isSelected = regionFilter == region
                    FilterChip(
                        selected = isSelected,
                        onClick = { viewModel.setSourcesRegionFilter(region) },
                        label = {
                            Text(
                                text = region,
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.secondary,
                            selectedLabelColor = Color.White
                        ),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.testTag("region_chip_${region.replace(" ", "_")}")
                    )
                }
            }
        }

        // Radio Type Filter Chips (When FM Radio category is active)
        if (categoryFilter == NewspaperCategory.RADIO) {
            val isBn = strings == com.example.util.AppStrings.Bangla
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 14.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                com.example.data.model.ExtraSourcesDataSource.radioTypes.forEach { type ->
                    val isSelected = regionFilter == type
                    val labelText = if (isBn) {
                        when (type) {
                            "All Radio" -> "সব রেডিও"
                            "Top 10 FM" -> "টপ ১০ এফএম"
                            "Private FM Online" -> "প্রাইভেট এফএম"
                            "Off Private FM" -> "অন্যান্য এফএম"
                            "State-owned Radio" -> "সরকারি বেতার"
                            else -> type
                        }
                    } else type
                    FilterChip(
                        selected = isSelected,
                        onClick = { viewModel.setSourcesRegionFilter(type) },
                        label = {
                            Text(
                                text = labelText,
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.tertiary,
                            selectedLabelColor = Color.White
                        ),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.testTag("radio_chip_${type.replace(" ", "_")}")
                    )
                }
            }
        }

        // Government Portal Filter Chips (When Government category is active)
        if (categoryFilter == NewspaperCategory.GOVERNMENT) {
            val isBn = strings == com.example.util.AppStrings.Bangla
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 14.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                com.example.data.model.ExtraSourcesDataSource.govtTypes.forEach { type ->
                    val isSelected = regionFilter == type
                    val labelText = if (isBn) {
                        when (type) {
                            "All Portals" -> "সকল বাতায়ন"
                            "Ministries & Divisions" -> "মন্ত্রণালয় ও বিভাগ"
                            "Citizen Services" -> "নাগরিক ই-সেবা"
                            "Constitutional & Apex" -> "সাংবিধানিক প্রতিষ্ঠান"
                            else -> type
                        }
                    } else type
                    FilterChip(
                        selected = isSelected,
                        onClick = { viewModel.setSourcesRegionFilter(type) },
                        label = {
                            Text(
                                text = labelText,
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color(0xFF006A4E),
                            selectedLabelColor = Color.White
                        ),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.testTag("govt_chip_${type.replace(" ", "_")}")
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // 3-Column Grid of Newspapers (Grid wise, 3 newspapers per row)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .testTag("sources_grid"),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            if (categoryFilter == NewspaperCategory.TV_NEWS) {
                item(span = { GridItemSpan(3) }) {
                    Card(
                        onClick = { viewModel.openTvChannels() },
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 6.dp)
                            .testTag("tv_channels_banner")
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.LiveTv,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(
                                        text = "Open Categorized TV View",
                                        fontWeight = FontWeight.Bold,
                                        style = MaterialTheme.typography.titleSmall,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                    Text(
                                        text = "News • Entertainment • Sports • International",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                                    )
                                }
                            }
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = "Open",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }
            }

            items(filteredNewspapers, key = { it.id }) { newspaper ->
                NewspaperGridCard(
                    newspaper = newspaper,
                    onClick = { onOpenNewspaper(newspaper.id) },
                    onToggleFavorite = {
                        viewModel.toggleFavoriteNewspaper(newspaper.id)
                    }
                )
            }

            if (filteredNewspapers.isEmpty()) {
                item(span = { GridItemSpan(3) }) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp, bottom = 40.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = strings.noNewspapersFound,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "অনুগ্রহ করে অনুসন্ধান বা ক্যাটাগরি ফিল্টার পরিবর্তন করুন।",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            item(span = { GridItemSpan(3) }) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
