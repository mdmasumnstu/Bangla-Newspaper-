package com.example.util

import android.content.Context
import android.os.Build
import android.webkit.WebStorage
import android.webkit.WebView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

/**
 * Intelligent Cache and Storage Manager for NewsHub BD.
 * Prevents unnecessary disk bloat by:
 * 1. Tracking total cache usage (HTTP, Coil, WebView DOM Storage, internal cache).
 * 2. Pruning stale WebView files and old images when size exceeds safe thresholds.
 * 3. Providing one-tap complete cache clear.
 */
object CacheManager {

    private const val MAX_RECOMMENDED_CACHE_BYTES = 50L * 1024 * 1024 // 50 MB threshold

    /**
     * Calculates the total cache size in bytes.
     */
    suspend fun calculateCacheSizeBytes(context: Context): Long = withContext(Dispatchers.IO) {
        var totalSize = 0L
        try {
            val cacheDir = context.cacheDir
            totalSize += getDirSize(cacheDir)

            val codeCacheDir = context.codeCacheDir
            totalSize += getDirSize(codeCacheDir)

            context.externalCacheDir?.let {
                totalSize += getDirSize(it)
            }

            // WebView cache directory
            val webViewCache = File(context.applicationInfo.dataDir, "app_webview")
            if (webViewCache.exists()) {
                totalSize += getDirSize(webViewCache)
            }
        } catch (_: Exception) {}
        totalSize
    }

    /**
     * Formats bytes to human readable format (MB, KB).
     */
    fun formatBytes(bytes: Long): String {
        return when {
            bytes >= 1024 * 1024 * 1024 -> String.format("%.2f GB", bytes / (1024.0 * 1024.0 * 1024.0))
            bytes >= 1024 * 1024 -> String.format("%.1f MB", bytes / (1024.0 * 1024.0))
            bytes >= 1024 -> String.format("%.0f KB", bytes / 1024.0)
            else -> "$bytes B"
        }
    }

    /**
     * Recursively computes directory size.
     */
    private fun getDirSize(dir: File?): Long {
        if (dir == null || !dir.exists()) return 0L
        var size = 0L
        val children = dir.listFiles() ?: return 0L
        for (child in children) {
            size += if (child.isDirectory) {
                getDirSize(child)
            } else {
                child.length()
            }
        }
        return size
    }

    /**
     * Clears all temporary cache:
     * - WebView memory & disk caches, DOM storage
     * - App internal and external cache directories
     * - Coil / Glide image caches
     */
    suspend fun clearAllCache(context: Context): Unit = withContext(Dispatchers.Main) {
        // Clear WebView storage on Main thread
        try {
            WebStorage.getInstance().deleteAllData()
        } catch (_: Exception) {}

        withContext(Dispatchers.IO) {
            try {
                deleteDirContents(context.cacheDir)
                context.externalCacheDir?.let { deleteDirContents(it) }

                // Prune WebView cache folder
                val webViewDir = File(context.applicationInfo.dataDir, "app_webview")
                if (webViewDir.exists()) {
                    val cacheSub = File(webViewDir, "Default/Cache")
                    if (cacheSub.exists()) deleteDirContents(cacheSub)
                    val codeSub = File(webViewDir, "Default/Code Cache")
                    if (codeSub.exists()) deleteDirContents(codeSub)
                }
            } catch (_: Exception) {}
        }
    }

    /**
     * Proactively auto-trims old cache if size exceeds 50MB.
     */
    suspend fun autoTrimIfNeeded(context: Context) = withContext(Dispatchers.IO) {
        try {
            val total = calculateCacheSizeBytes(context)
            if (total > MAX_RECOMMENDED_CACHE_BYTES) {
                // Prune only files older than 3 days in cacheDir
                val threeDaysAgo = System.currentTimeMillis() - (3L * 24 * 60 * 60 * 1000)
                pruneOldFiles(context.cacheDir, threeDaysAgo)
                context.externalCacheDir?.let { pruneOldFiles(it, threeDaysAgo) }
            }
        } catch (_: Exception) {}
    }

    private fun pruneOldFiles(dir: File?, cutoffTime: Long) {
        if (dir == null || !dir.exists()) return
        val files = dir.listFiles() ?: return
        for (f in files) {
            if (f.isDirectory) {
                pruneOldFiles(f, cutoffTime)
            } else if (f.lastModified() < cutoffTime) {
                f.delete()
            }
        }
    }

    private fun deleteDirContents(dir: File?): Boolean {
        if (dir == null || !dir.exists()) return false
        val files = dir.listFiles() ?: return true
        var success = true
        for (f in files) {
            if (f.isDirectory) {
                deleteDirContents(f)
                success = success && f.delete()
            } else {
                success = success && f.delete()
            }
        }
        return success
    }
}
