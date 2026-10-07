package com.example.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.NewsViewModel
import com.example.ui.ThemeMode
import com.example.ui.theme.EmeraldPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: NewsViewModel,
    onOpenMenu: () -> Unit,
    onExitApp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val strings by viewModel.appStrings.collectAsStateWithLifecycle()
    val isBn = strings == com.example.util.AppStrings.Bangla
    val currentTheme by viewModel.themeMode.collectAsStateWithLifecycle()
    val language by viewModel.selectedLanguage.collectAsStateWithLifecycle()
    val notificationsEnabled by viewModel.notificationsEnabled.collectAsStateWithLifecycle()
    val cacheSize by viewModel.cacheSizeFormatted.collectAsStateWithLifecycle()

    var showThemeDialog by remember { mutableStateOf(false) }
    var showLanguageDialog by remember { mutableStateOf(false) }
    var showAboutDialog by remember { mutableStateOf(false) }
    var showPrivacyDialog by remember { mutableStateOf(false) }
    var showTermsDialog by remember { mutableStateOf(false) }
    var showCopyrightDialog by remember { mutableStateOf(false) }
    var showExitDialog by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = strings.settings,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            },
            navigationIcon = {
                IconButton(onClick = onOpenMenu, modifier = Modifier.testTag("settings_menu_btn")) {
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Theme Setting
            SettingsItemRow(
                icon = Icons.Filled.Brightness4,
                title = strings.theme,
                subtitle = when (currentTheme) {
                    ThemeMode.SYSTEM -> "System Default"
                    ThemeMode.LIGHT -> "Light Mode"
                    ThemeMode.DARK -> "Dark Mode"
                },
                onClick = { showThemeDialog = true },
                tag = "setting_theme"
            )

            // Notifications Setting
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("setting_notifications"),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
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
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(
                                text = strings.notifications,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = strings.notificationDesc,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Switch(
                        checked = notificationsEnabled,
                        onCheckedChange = { viewModel.setNotificationsEnabled(it) },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = EmeraldPrimary
                        )
                    )
                }
            }

            // Test Notification Action
            if (notificationsEnabled) {
                SettingsItemRow(
                    icon = Icons.Filled.Notifications,
                    title = strings.testAlert,
                    subtitle = "Trigger real-time notification preview",
                    onClick = { viewModel.sendTestNotification() },
                    tag = "setting_test_notification"
                )
            }

            // Language Setting
            SettingsItemRow(
                icon = Icons.Filled.Language,
                title = strings.language,
                subtitle = strings.languageDesc,
                onClick = { showLanguageDialog = true },
                tag = "setting_language"
            )

            // About Setting
            SettingsItemRow(
                icon = Icons.Filled.Info,
                title = "About",
                subtitle = "App information & version 2.0.0",
                onClick = { showAboutDialog = true },
                tag = "setting_about"
            )

            // Privacy Policy
            SettingsItemRow(
                icon = Icons.Filled.Lock,
                title = "Privacy Policy",
                subtitle = "How we protect user data",
                onClick = { showPrivacyDialog = true },
                tag = "setting_privacy"
            )

            // Terms & Conditions
            SettingsItemRow(
                icon = Icons.Filled.Description,
                title = if (isBn) "শর্তাবলী ও নিয়মাবলী" else "Terms & Conditions",
                subtitle = if (isBn) "ব্যবহার নির্দেশিকা ও নীতিমালা" else "Usage terms and guidelines",
                onClick = { showTermsDialog = true },
                tag = "setting_terms"
            )

            // Copyright & Fair Use Policy (Zero Infringement / DMCA Protection)
            SettingsItemRow(
                icon = Icons.Filled.Info,
                title = if (isBn) "কপিরাইট ও ফেয়ার ইউজ নীতি" else "Copyright & Fair Use Policy",
                subtitle = if (isBn) "মেধাস্বত্ব ও কন্টেন্ট অপসারণ নির্দেশিকা" else "Fair use doctrine & DMCA takedown",
                onClick = { showCopyrightDialog = true },
                tag = "setting_copyright"
            )

            // Contact Us
            SettingsItemRow(
                icon = Icons.Filled.Email,
                title = "Contact Us",
                subtitle = "Feedback & support team",
                onClick = {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:mdmasumsps@gmail.com")
                        putExtra(Intent.EXTRA_SUBJECT, "NewsHub BD Support Request")
                    }
                    try { context.startActivity(intent) } catch (_: Exception) {}
                },
                tag = "setting_contact"
            )

            // Clear Cache
            SettingsItemRow(
                icon = Icons.Filled.Delete,
                title = if (isBn) "ক্যাশ ডাটা ও স্টোরেজ মুছুন" else "Clear Cache & Free Storage",
                subtitle = if (isBn) "ক্যাশ সাইজ: $cacheSize • ক্যাশ মুছে ফোন হালকা করুন" else "Cache size: $cacheSize • Free storage & reset cache",
                onClick = { viewModel.clearCache() },
                tag = "setting_clear_cache"
            )

            // Exit App
            SettingsItemRow(
                icon = Icons.AutoMirrored.Filled.ExitToApp,
                title = "Exit App",
                subtitle = "Close NewsHub BD",
                onClick = { showExitDialog = true },
                tag = "setting_exit"
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }

    // Theme Picker Dialog
    if (showThemeDialog) {
        AlertDialog(
            onDismissRequest = { showThemeDialog = false },
            title = { Text(strings.theme) },
            text = {
                Column {
                    listOf(
                        ThemeMode.SYSTEM to "System Default",
                        ThemeMode.LIGHT to "Light Mode",
                        ThemeMode.DARK to "Dark Mode"
                    ).forEach { (mode, label) ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    viewModel.setTheme(mode)
                                    showThemeDialog = false
                                }
                                .padding(vertical = 8.dp)
                        ) {
                            RadioButton(
                                selected = currentTheme == mode,
                                onClick = {
                                    viewModel.setTheme(mode)
                                    showThemeDialog = false
                                }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = label)
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showThemeDialog = false }) {
                    Text(strings.done)
                }
            }
        )
    }

    // Language Picker Dialog
    if (showLanguageDialog) {
        AlertDialog(
            onDismissRequest = { showLanguageDialog = false },
            title = { Text(strings.language) },
            text = {
                Column {
                    listOf("English", "বাংলা").forEach { lang ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    viewModel.setLanguage(lang)
                                    showLanguageDialog = false
                                }
                                .padding(vertical = 8.dp)
                        ) {
                            RadioButton(
                                selected = language == lang,
                                onClick = {
                                    viewModel.setLanguage(lang)
                                    showLanguageDialog = false
                                }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = lang)
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showLanguageDialog = false }) {
                    Text(strings.done)
                }
            }
        )
    }

    // About Dialog
    if (showAboutDialog) {
        AlertDialog(
            onDismissRequest = { showAboutDialog = false },
            title = { Text("NewsHub BD") },
            text = {
                Column {
                    Text(
                        text = "Version 2.0.0 (Build 200)",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "All Bangladeshi Newspapers, Media & Portals in One Place.\n\n" +
                                "NewsHub BD brings together 400+ Bangladeshi newspapers, online portals, local division dailies, job circulars, FM radio stations, all 50+ government ministries & citizen portals, stock market financial news, literary magazines, and tech sites.\n\n" +
                                "All sources can be filtered, searched, and accessed directly in-app, with offline news reading support."
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = { showAboutDialog = false }) {
                    Text("Close")
                }
            }
        )
    }

    // Privacy Policy Dialog
    if (showPrivacyDialog) {
        AlertDialog(
            onDismissRequest = { showPrivacyDialog = false },
            title = { Text("Privacy Policy") },
            text = {
                Text(
                    text = "NewsHub BD is committed to user privacy. We do not collect, sell, or transmit any personal identifiers or location data. All favorite newspapers and saved offline reading articles are stored securely in your private on-device Room database."
                )
            },
            confirmButton = {
                TextButton(onClick = { showPrivacyDialog = false }) {
                    Text("OK")
                }
            }
        )
    }

    // Terms Dialog
    if (showTermsDialog) {
        AlertDialog(
            onDismissRequest = { showTermsDialog = false },
            title = { Text(if (isBn) "শর্তাবলী ও নীতিমালা" else "Terms & Conditions") },
            text = {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    Text(
                        text = if (isBn)
                            "১. NewsHub BD একটি পাবলিক নিউজ ডিরেক্টরি এবং আরএসএস ফিড রিডার।\n\n" +
                            "২. সমস্ত সংবাদ শিরোনাম, চিত্র ও কন্টেন্ট তাদের মূল প্রকাশক ও সংবাদ মাধ্যমের নিজস্ব মেধাস্বত্ব।\n\n" +
                            "৩. এই অ্যাপে কোনো কপিরাইটযুক্ত পূর্ণাঙ্গ সংবাদ অননুমোদিতভাবে সংরক্ষণ বা প্রচার করা হয় না। পাঠকদের সুবিধার্থে সংক্ষিপ্ত সারসংক্ষেপ ও সরাসরি রেফারেল লিংক প্রদর্শিত হয় যাতে মূল প্রকাশকরা তাদের ট্রাফিক ও বিজ্ঞাপনের পূর্ণ সুবিধা পান।\n\n" +
                            "৪. অ্যাপটি আন্তর্জাতিক কপিরাইট ও ফেয়ার ইউজ আইন মেনে পরিচালিত হয়।"
                        else
                            "1. NewsHub BD operates strictly as a news index and RSS reader.\n\n" +
                            "2. All news headlines, mastheads, logos, and articles are the intellectual property of their respective publishers.\n\n" +
                            "3. The app does not republish full copyrighted stories. Brief snippets are provided under Fair Use to refer readers directly to the publishers' original websites.\n\n" +
                            "4. Full articles and ad revenue directly benefit the original news publishers.",
                        style = MaterialTheme.typography.bodyMedium,
                        lineHeight = 20.sp
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = { showTermsDialog = false }) {
                    Text(if (isBn) "বুঝেছি" else "OK")
                }
            }
        )
    }

    // Copyright & Fair Use Policy Dialog (DMCA Safe Harbor)
    if (showCopyrightDialog) {
        AlertDialog(
            onDismissRequest = { showCopyrightDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = null,
                        tint = EmeraldPrimary,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isBn) "কপিরাইট ও ফেয়ার ইউজ নীতি" else "Copyright & Fair Use Policy",
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            text = {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = if (isBn) "কপিরাইট সুরক্ষা ও প্রকাশকদের সম্মাননা" else "Copyright & Publisher Protection",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 14.sp
                    )

                    Text(
                        text = if (isBn)
                            "• ফেয়ার ইউজ নীতি (Fair Use): NewsHub BD কোনো সংবাদের মালিকানা দাবি করে না। আন্তর্জাতিক কপিরাইট আইন ও Berne Convention মেনে জনস্বার্থে কেবল সংবাদ শিরোনাম ও সংক্ষিপ্ত সূচি প্রদর্শন করা হয়।\n\n" +
                            "• মূল প্রকাশকের ওয়েবসাইটে রিডাইরেক্ট: ব্যবহারকারী কোনো সংবাদে ক্লিক করলে তা ইন-অ্যাপ ব্রাউজার বা ডিভাইসের ব্রাউজারে মূল সংবাদপত্রের আসল HTTPS লিংকে ওপেন হয়। এর ফলে সমস্ত ভিজিটর, পেজভিউ এবং বিজ্ঞাপন রাজস্ব শতভাগ মূল প্রকাশক লাভ করেন।\n\n" +
                            "• ট্রেডমার্ক ও বুদ্ধিবৃত্তিক সম্পদ: সকল সংবাদপত্রের নাম ও লোগো সংশ্লিষ্ট কর্তৃপক্ষের রেজিস্টার্ড সম্পত্তি।\n\n" +
                            "• দ্রুত কন্টেন্ট অপসারণ নির্দেশিকা (DMCA Takedown): কোনো কপিরাইট স্বত্বাধিকারী বা সংবাদমাধ্যম যদি তাদের ফিড বা লিংক এই প্ল্যাটফর্ম থেকে প্রত্যাহার করতে চান, তবে কোনো আনুষ্ঠানিক বিতর্ক ছাড়াই অনুরোধ গৃহীত হবে।"
                        else
                            "• Fair Use Compliance: NewsHub BD claims no ownership over third-party news content. We operate under international Fair Use doctrines to display only headline excerpts and search indexes.\n\n" +
                            "• Direct Publisher Referral: Tapping any news item directs the reader directly to the original publisher's live website. All traffic, impressions, and ad revenues belong 100% to the publisher.\n\n" +
                            "• Trademarks & Branding: All publisher names and logos are property of their respective owners.\n\n" +
                            "• DMCA & Takedown Requests: Any publisher requesting removal of their RSS feed or index link will be honored immediately without dispute.",
                        style = MaterialTheme.typography.bodySmall,
                        lineHeight = 19.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = if (isBn) "কপিরাইট ও অপসারণের জন্য যোগাযোগ:" else "Contact for DMCA / Takedowns:",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = "Email: mdmasumice@gmail.com",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                color = EmeraldPrimary
                            )
                            Text(
                                text = if (isBn) "সময়সীমা: ২৪-৪৮ ঘণ্টার মধ্যে কার্যকর" else "Response time: Within 24-48 hours",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showCopyrightDialog = false }) {
                    Text(if (isBn) "বন্ধ করুন" else "Close")
                }
            }
        )
    }

    // Exit Confirmation Dialog
    if (showExitDialog) {
        AlertDialog(
            onDismissRequest = { showExitDialog = false },
            title = { Text("Exit NewsHub BD?") },
            text = { Text("Are you sure you want to close the application?") },
            confirmButton = {
                TextButton(onClick = {
                    showExitDialog = false
                    onExitApp()
                }) {
                    Text("Exit", color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = { showExitDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
private fun SettingsItemRow(
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    tag: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .testTag(tag),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
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
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
