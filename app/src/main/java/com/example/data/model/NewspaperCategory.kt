package com.example.data.model

enum class NewspaperCategory(val displayName: String, val banglaName: String, val emoji: String) {
    ALL("All", "সব", "📰"),
    BENGALI("Bengali", "বাংলা", "🇧🇩"),
    ONLINE("Online", "অনলাইন", "🌐"),
    LOCAL("Local", "স্থানীয়", "📍"),
    JOBS("Jobs", "চাকরি", "💼"),
    RADIO("FM Radio", "রেডিও", "📻"),
    GOVERNMENT("Govt Portal", "সরকারি সেবা", "🏛️"),
    STOCK_MARKET("Stock Market", "শেয়ার বাজার", "📈"),
    MAGAZINE("Magazines", "ম্যাগাজিন", "📖"),
    TECH("Tech Sites", "প্রযুক্তি", "💻"),
    TV_NEWS("TV News", "টিভি নিউজ", "📺"),
    BUSINESS("Business", "বাণিজ্য", "📊"),
    SPORTS("Sports", "খেলা", "🏏"),
    EDUCATION("Education", "শিক্ষা", "🎓"),
    ENGLISH("English", "ইংরেজি", "🇬🇧"),
    AGENCIES("News Agencies", "সংবাদ সংস্থা", "📰"),
    INTERNATIONAL("International", "আন্তর্জাতিক", "🌎");

    companion object {
        fun fromId(id: String): NewspaperCategory {
            return entries.find { it.name.equals(id, ignoreCase = true) } ?: ALL
        }
    }
}
