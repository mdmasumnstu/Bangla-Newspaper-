package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.model.NewspaperCategory
import com.example.data.model.NewspaperDataSource
import com.example.ui.BottomTab
import com.example.ui.theme.EmeraldPrimary

@Composable
fun AppDrawerContent(
    selectedTab: BottomTab,
    onSelectTab: (BottomTab) -> Unit,
    onSelectCategory: (NewspaperCategory) -> Unit,
    onCloseDrawer: () -> Unit,
    strings: com.example.util.AppStrings = com.example.util.AppStrings.English,
    onOpenTvChannels: (() -> Unit)? = null
) {
    val tvChannelsCount = remember { NewspaperDataSource.getByCategory(NewspaperCategory.TV_NEWS).size }

    ModalDrawerSheet(
        modifier = Modifier.width(300.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.linearGradient(
                            listOf(
                                EmeraldPrimary,
                                Color(0xFF0D5C3A)
                            )
                        )
                    )
                    .padding(20.dp)
            ) {
                // Cross Sign (Close Navigation Drawer)
                IconButton(
                    onClick = onCloseDrawer,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .background(Color.White.copy(alpha = 0.2f), CircleShape)
                        .testTag("nav_drawer_cross_btn")
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close Navigation",
                        tint = Color.White
                    )
                }

                Column(modifier = Modifier.padding(end = 36.dp)) {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color.White,
                        modifier = Modifier.size(52.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_app_logo),
                            contentDescription = "NewsHub Logo",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = strings.appName,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "সব খবর, এক অ্যাপে",
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Text(
                        text = if (strings == com.example.util.AppStrings.Bangla) "৪০০+ পত্রিকা, রেডিও ও সরকারি বাতায়ন" else "400+ Bangladeshi Media, Portals & Radio",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 11.sp,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Main Tabs
            NavigationDrawerItem(
                icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                label = { Text(strings.homeFeed, fontWeight = FontWeight.SemiBold) },
                selected = selectedTab == BottomTab.HOME,
                onClick = {
                    onSelectTab(BottomTab.HOME)
                    onCloseDrawer()
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )

            NavigationDrawerItem(
                icon = { Icon(Icons.Filled.Newspaper, contentDescription = null) },
                label = { Text(strings.sources, fontWeight = FontWeight.SemiBold) },
                selected = selectedTab == BottomTab.SOURCES,
                onClick = {
                    onSelectTab(BottomTab.SOURCES)
                    onCloseDrawer()
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )

            NavigationDrawerItem(
                icon = { Icon(Icons.Filled.LiveTv, contentDescription = null, tint = MaterialTheme.colorScheme.primary) },
                label = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(strings.tvNews, fontWeight = FontWeight.SemiBold)
                        Surface(
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primaryContainer
                        ) {
                            Text(
                                text = "$tvChannelsCount",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                },
                selected = false,
                onClick = {
                    if (onOpenTvChannels != null) {
                        onOpenTvChannels()
                    } else {
                        onSelectCategory(NewspaperCategory.TV_NEWS)
                    }
                    onCloseDrawer()
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )

            NavigationDrawerItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(strings.favorites, fontWeight = FontWeight.SemiBold) },
                selected = selectedTab == BottomTab.FAVORITES,
                onClick = {
                    onSelectTab(BottomTab.FAVORITES)
                    onCloseDrawer()
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )

            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(8.dp))

            // Category Headers
            Text(
                text = strings.browseCategories,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 6.dp)
            )

            val categories = listOf(
                NewspaperCategory.BENGALI to Icons.Filled.Newspaper,
                NewspaperCategory.ONLINE to Icons.Filled.Public,
                NewspaperCategory.TV_NEWS to Icons.Filled.Tv,
                NewspaperCategory.EDUCATION to Icons.Filled.Public,
                NewspaperCategory.SPORTS to Icons.Filled.SportsSoccer,
                NewspaperCategory.BUSINESS to Icons.Filled.Business,
                NewspaperCategory.ENGLISH to Icons.Filled.Language,
                NewspaperCategory.INTERNATIONAL to Icons.Filled.Public,
                NewspaperCategory.JOBS to Icons.Filled.Business,
                NewspaperCategory.GOVERNMENT to Icons.Filled.Public,
                NewspaperCategory.STOCK_MARKET to Icons.Filled.Business,
                NewspaperCategory.AGENCIES to Icons.Filled.Newspaper,
                NewspaperCategory.TECH to Icons.Filled.Public,
                NewspaperCategory.MAGAZINE to Icons.Filled.Newspaper,
                NewspaperCategory.RADIO to Icons.Filled.Tv,
                NewspaperCategory.LOCAL to Icons.Filled.LocationOn
            )

            categories.forEach { (cat, icon) ->
                val catName = if (strings == com.example.util.AppStrings.Bangla) cat.banglaName else cat.displayName
                NavigationDrawerItem(
                    icon = { Icon(icon, contentDescription = null, modifier = Modifier.size(20.dp)) },
                    label = { Text("${cat.emoji} $catName", fontSize = 14.sp) },
                    selected = false,
                    onClick = {
                        onSelectCategory(cat)
                        onCloseDrawer()
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(8.dp))

            // Other Actions
            NavigationDrawerItem(
                icon = { Icon(Icons.Filled.Star, contentDescription = null) },
                label = { Text(strings.rateUs) },
                selected = selectedTab == BottomTab.RATE_US,
                onClick = {
                    onSelectTab(BottomTab.RATE_US)
                    onCloseDrawer()
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )

            NavigationDrawerItem(
                icon = { Icon(Icons.Filled.Settings, contentDescription = null) },
                label = { Text(strings.settings) },
                selected = selectedTab == BottomTab.SETTINGS,
                onClick = {
                    onSelectTab(BottomTab.SETTINGS)
                    onCloseDrawer()
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
