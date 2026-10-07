package com.example.data.model

/**
 * Category classification for Newspapers, Media, and Portals.
 * Serial order: All -> Bengali -> Online -> TV News -> Education -> Sports -> Business ->
 * English -> International -> Jobs -> Govt Portal -> Stock Market -> News Agencies ->
 * Tech Sites -> Magazines -> FM Radio -> Local.
 */
enum class NewspaperCategory(val displayName: String, val banglaName: String, val emoji: String) {
    ALL("All", "সব", "📰"),
    BENGALI("Bengali", "বাংলা", "🇧🇩"),
    ONLINE("Online", "অনলাইন", "🌐"),
    TV_NEWS("TV News", "টিভি নিউজ", "📺"),
    EDUCATION("Education", "শিক্ষা", "🎓"),
    SPORTS("Sports", "খেলা", "🏏"),
    BUSINESS("Business", "বাণিজ্য", "📊"),
    ENGLISH("English", "ইংরেজি", "🇬🇧"),
    INTERNATIONAL("International", "আন্তর্জাতিক", "🌎"),
    JOBS("Jobs", "চাকরি", "💼"),
    GOVERNMENT("Govt Portal", "সরকারি সেবা", "🏛️"),
    STOCK_MARKET("Stock Market", "শেয়ার বাজার", "📈"),
    AGENCIES("News Agencies", "সংবাদ সংস্থা", "📰"),
    TECH("Tech Sites", "প্রযুক্তি", "💻"),
    MAGAZINE("Magazines", "ম্যাগাজিন", "📖"),
    RADIO("FM Radio", "রেডিও", "📻"),
    LOCAL("Local", "স্থানীয়", "📍");

    companion object {
        fun fromId(id: String): NewspaperCategory {
            return entries.find { it.name.equals(id, ignoreCase = true) } ?: ALL
        }
    }
}
