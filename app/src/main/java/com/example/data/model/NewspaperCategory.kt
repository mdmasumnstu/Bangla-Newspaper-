package com.example.data.model

enum class NewspaperCategory(val displayName: String, val banglaName: String, val emoji: String) {
    ALL("All", "সব", "📰"),
    BENGALI("Bengali", "বাংলা", "🇧🇩"),
    ONLINE("Online", "অনলাইন", "🌐"),
    BUSINESS("Business", "বাণিজ্য", "💼"),
    SPORTS("Sports", "খেলা", "🏏"),
    EDUCATION("Education", "শিক্ষা", "🎓"),
    ENGLISH("English", "ইংরেজি", "🇬🇧"),
    AGENCIES("News Agencies", "সংবাদ সংস্থা", "📰"),
    INTERNATIONAL("International", "আন্তর্জাতিক", "🌎"),
    TV_NEWS("TV News", "টিভি নিউজ", "📺"),
    LOCAL("Local", "স্থানীয়", "📍");

    companion object {
        fun fromId(id: String): NewspaperCategory {
            return entries.find { it.name.equals(id, ignoreCase = true) } ?: ALL
        }
    }
}

