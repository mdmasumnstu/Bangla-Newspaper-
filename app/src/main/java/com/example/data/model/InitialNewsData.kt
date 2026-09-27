package com.example.data.model

import com.example.data.local.entity.ArticleEntity

object InitialNewsData {
    val seedArticles: List<ArticleEntity> = listOf(
        // 1. Prothom Alo (Breaking)
        ArticleEntity(
            id = "seed_art_01_prothom_alo",
            newspaperId = "prothom_alo",
            newspaperName = "Prothom Alo",
            newspaperBanglaName = "প্রথম আলো",
            title = "বাংলাদেশে নতুন শিক্ষাক্রমে বড় পরিবর্তন আনছে সরকার",
            description = "জাতীয় শিক্ষাক্রমের মূল্যায়ন পদ্ধতি ও পাঠ্যবইয়ে সংস্কারের ঘোষণা দিয়েছে শিক্ষা মন্ত্রণালয়। লিখিত পরীক্ষা ও ধারাবাহিক মূল্যায়নের সমন্বয় ঘটবে।",
            content = "শিক্ষা মন্ত্রণালয় জানিয়েছে, দেশের শিক্ষার্থীদের আন্তর্জাতিক মানে গড়ে তুলতে এবং ব্যবহারিক শিক্ষার প্রসারে জাতীয় শিক্ষাক্রমে যুগোপযোগী সংস্কার আনা হচ্ছে। পরীক্ষা পদ্ধতি ও ব্যবহারিক মূল্যায়নের মধ্যে ভারসাম্য স্থাপন করা হবে।",
            articleUrl = "https://www.prothomalo.com/bangladesh/education-reforms",
            imageUrl = "https://images.unsplash.com/photo-1580582932707-520aed937b7b?w=800&auto=format&fit=crop",
            category = "Education",
            publishedAt = System.currentTimeMillis() - (10 * 60 * 1000),
            formattedTime = "10 min ago",
            isTopNews = false,
            isBreaking = true,
            isSaved = false
        ),

        // 2. The Daily Star (Top News)
        ArticleEntity(
            id = "seed_art_02_daily_star",
            newspaperId = "the_daily_star",
            newspaperName = "The Daily Star",
            newspaperBanglaName = "দ্য ডেইলি স্টার",
            title = "Bangladesh's Economic Outlook: Strong Growth Driven by Exports and Remittances",
            description = "The World Bank and IMF forecast robust economic expansion for Bangladesh, highlighting macroeconomic stability and digital financial transformation.",
            content = "Bangladesh's economic resilience continues to impress international financial institutions. Surging exports and consistent remittance inflows support GDP projections while financial technology drives inclusion.",
            articleUrl = "https://www.thedailystar.net/business/economy/bangladesh-growth-outlook",
            imageUrl = "https://images.unsplash.com/photo-1526304640581-d334cdbbf45e?w=800&auto=format&fit=crop",
            category = "Economy",
            publishedAt = System.currentTimeMillis() - (20 * 60 * 1000),
            formattedTime = "20 min ago",
            isTopNews = true,
            isBreaking = false,
            isSaved = false
        ),

        // 3. Samakal (Top News)
        ArticleEntity(
            id = "seed_art_03_samakal",
            newspaperId = "somokal",
            newspaperName = "Samakal",
            newspaperBanglaName = "সমকাল",
            title = "কর্ণফুলী টানেল ঘিরে দক্ষিণ এশিয়ার নতুন শিল্প করিডোর",
            description = "বঙ্গবন্ধু শেখ মুজিবুর রহমান টানেল চালুর পর চট্টগ্রাম ও আনোয়ারা অঞ্চলে দেশি-বিদেশি বিনিয়োগে অভূতপূর্ব গতি সঞ্চার হয়েছে।",
            content = "কর্ণফুলী নদীর তলদেশে নির্মিত দক্ষিণ এশিয়ার প্রথম ভূগর্ভস্থ টানেল চট্টগ্রামকে আধুনিক 'ওয়ান সিটি টু টাউন' মডেলে রূপান্তরিত করেছে। আনোয়ারা অর্থনৈতিক অঞ্চলে দেশি-বিদেশি ভারী শিল্প কারখানা গড়ে উঠছে।",
            articleUrl = "https://www.samakal.com/business/bangabandhu-tunnel-hub",
            imageUrl = "https://images.unsplash.com/photo-1544620347-c4fd4a3d5957?w=800&auto=format&fit=crop",
            category = "Development",
            publishedAt = System.currentTimeMillis() - (30 * 60 * 1000),
            formattedTime = "30 min ago",
            isTopNews = true,
            isBreaking = false,
            isSaved = false
        ),

        // 4. Kaler Kantho (Top News)
        ArticleEntity(
            id = "seed_art_04_kaler_kantho",
            newspaperId = "kaler_kantho",
            newspaperName = "Kaler Kantho",
            newspaperBanglaName = "কালের কণ্ঠ",
            title = "মেট্রোরেলে মতিঝিল থেকে কমলাপুর: রাজধানীতে দ্রুতগতির নতুন দিগন্ত",
            description = "মতিঝিল ছাড়িয়ে কমলাপুর পর্যন্ত মেট্রোরেল সম্প্রসারণের কাজ শেষ পর্যায়ে। প্রতিদিন লাখ লাখ নগরবাসী স্বাচ্ছন্দ্যে যাতায়াত করছেন।",
            content = "ঢাকা ম্যাস ট্রানজিট কোম্পানি লিমিটেড জানিয়েছে, মতিঝিল-কমলাপুর সম্প্রসারণ সম্পন্ন হলে রাজধানীর বৃহত্তম রেলওয়ে স্টেশনের সাথে মেট্রোরেল সরাসরি সংযুক্ত হবে।",
            articleUrl = "https://www.kalerkantho.com/national/metro-rail-kamalapur",
            imageUrl = "https://images.unsplash.com/photo-1494515843206-f3117d3f51b7?w=800&auto=format&fit=crop",
            category = "National",
            publishedAt = System.currentTimeMillis() - (40 * 60 * 1000),
            formattedTime = "40 min ago",
            isTopNews = true,
            isBreaking = false,
            isSaved = false
        ),

        // 5. Ittefaq
        ArticleEntity(
            id = "seed_art_05_ittefaq",
            newspaperId = "ittefaq",
            newspaperName = "Ittefaq",
            newspaperBanglaName = "ইত্তেফাক",
            title = "চট্টগ্রাম বন্দরে স্বয়ংক্রিয় টার্মিনাল চালু, কনটেইনার হ্যান্ডলিংয়ে নতুন রেকর্ড",
            description = "চট্টগ্রাম সমুদ্রবন্দরে অত্যাধুনিক স্বয়ংক্রিয় কি গ্যান্ট্রি ক্রেন ও ডিজিটাল ট্র্যাকিং প্রযুক্তি সংযুক্ত হওয়ায় জাহাজ জট শূন্যে নেমে এসেছে।",
            content = "দেশের প্রধান সমুদ্রবন্দরে কনটেইনার লোড-আনলোডিং কার্যক্রম সম্পূর্ণ ডিজিটাল প্ল্যাটফর্মে পরিচালিত হচ্ছে। এতে আমদানি-রপ্তানি খরচ ও সময় উল্লেখযোগ্যভাবে হ্রাস পেয়েছে।",
            articleUrl = "https://www.ittefaq.com.bd/business/chittagong-port-terminal",
            imageUrl = "https://images.unsplash.com/photo-1578575437130-527eed3abbec?w=800&auto=format&fit=crop",
            category = "Business",
            publishedAt = System.currentTimeMillis() - (50 * 60 * 1000),
            formattedTime = "50 min ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 6. Jugantor
        ArticleEntity(
            id = "seed_art_06_jugantor",
            newspaperId = "jugantor",
            newspaperName = "Jugantor",
            newspaperBanglaName = "যুগান্তর",
            title = "তথ্যপ্রযুক্তি খাতে রপ্তানি আয় ৩০০ কোটি ডলারের মাইলফলক স্পর্শ করেছে",
            description = "সফটওয়্যার তৈরি, কৃত্রিম বুদ্ধিমত্তা সলিউশন এবং ফ্রিল্যান্সিং আয়ে বৈশ্বিক বাজারে বাংলাদেশের তরুণদের চমকপ্রদ সাফল্য।",
            content = "বাংলাদেশ অ্যাসোসিয়েশন অব সফটওয়্যার অ্যান্ড ইনফরমেশন সার্ভিসেস (বেসিস) জানিয়েছে, উত্তর আমেরিকা ও ইউরোপীয় ইউনিয়নে বাংলাদেশি আইটি সেবার চাহিদা দ্রুত বাড়ছে।",
            articleUrl = "https://www.jugantor.com/it/ict-export-milestone",
            imageUrl = "https://images.unsplash.com/photo-1531482615713-2afd69097998?w=800&auto=format&fit=crop",
            category = "Technology",
            publishedAt = System.currentTimeMillis() - (60 * 60 * 1000),
            formattedTime = "1 hour ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 7. Bangladesh Pratidin
        ArticleEntity(
            id = "seed_art_07_bd_pratidin",
            newspaperId = "bangladesh_pratidin",
            newspaperName = "Bangladesh Pratidin",
            newspaperBanglaName = "বাংলাদেশ প্রতিদিন",
            title = "সারাদেশের কমিউনিটি ক্লিনিকে ডিজিটাল স্বাস্থ্যসেবা ও টেলিমেডিসিন চালু",
            description = "গ্রামাঞ্চলের প্রান্তিক জনগোষ্ঠীর দোরগোড়ায় বিশেষজ্ঞ চিকিৎসকদের পরামর্শ পৌঁছে দিতে প্রতিটি ক্লিনিকে ডিজিটাল হেলথ কার্ড সেবা শুরু।",
            content = "স্বাস্থ্য অধিদপ্তরের উদ্যোগে দেশের ১৪ হাজার কমিউনিটি ক্লিনিকে সার্বক্ষণিক ভিডিও কনসালটেশন ও বিনামূল্যে প্রয়োজনীয় ওষুধ সরবরাহ করা হচ্ছে।",
            articleUrl = "https://www.bd-pratidin.com/national/digital-community-clinic",
            imageUrl = "https://images.unsplash.com/photo-1516549655169-df83a0774514?w=800&auto=format&fit=crop",
            category = "Health",
            publishedAt = System.currentTimeMillis() - (70 * 60 * 1000),
            formattedTime = "1 hour ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 8. BDNews24
        ArticleEntity(
            id = "seed_art_08_bdnews24",
            newspaperId = "bdnews24",
            newspaperName = "bdnews24.com",
            newspaperBanglaName = "বিডিনিউজ টোয়েন্টিফোর ডটকম",
            title = "দারুণ বোলিংয়ে শ্রীলঙ্কাকে হারিয়ে টি-টোয়েন্টি সিরিজ জয় বাংলাদেশের",
            description = "মিরপুর শের-ই-বাংলা জাতীয় স্টেডিয়ামে বোলারদের দুর্দান্ত নৈপুণ্যে সফরকারী শ্রীলঙ্কাকে ৪২ রানে পরাজিত করল টাইগাররা।",
            content = "স্পিনারদের নিয়ন্ত্রিত বোলিং এবং পেসারদের শেষ ওভারের অসাধারণ স্পেলে ম্যাচ নিজেদের নিয়ন্ত্রণে নেয় বাংলাদেশ দল। সিরিজ সেরা নির্বাচিত হয়েছেন তাসকিন আহমেদ।",
            articleUrl = "https://bangla.bdnews24.com/cricket/bangladesh-vs-sri-lanka-t20-series",
            imageUrl = "https://images.unsplash.com/photo-1540747913346-19e32dc3e97e?w=800&auto=format&fit=crop",
            category = "Sports",
            publishedAt = System.currentTimeMillis() - (80 * 60 * 1000),
            formattedTime = "1 hour ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 9. Dhaka Tribune
        ArticleEntity(
            id = "seed_art_09_dhaka_tribune",
            newspaperId = "dhaka_tribune",
            newspaperName = "Dhaka Tribune",
            newspaperBanglaName = "ঢাকা ট্রিবিউন",
            title = "Clean Energy Leap: Rooftop Solar Projects Power Commercial Zones Across BD",
            description = "Government and private green initiatives scale rooftop renewable installations, slashing industrial grid reliance and carbon emissions.",
            content = "Industries in Gazipur and Narayanganj adopt net-metering solar arrays to achieve sustainability goals, providing cost-effective clean power.",
            articleUrl = "https://www.dhakatribune.com/business/green-energy-solar-boom",
            imageUrl = "https://images.unsplash.com/photo-1509391365360-2e959784a276?w=800&auto=format&fit=crop",
            category = "Environment",
            publishedAt = System.currentTimeMillis() - (90 * 60 * 1000),
            formattedTime = "1 hour ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 10. Daily Sun
        ArticleEntity(
            id = "seed_art_10_daily_sun",
            newspaperId = "daily_sun",
            newspaperName = "Daily Sun",
            newspaperBanglaName = "ডেইলি সান",
            title = "Bangladeshi Universities Expand AI & Robotics Curriculums for Global Competence",
            description = "Leading engineering institutes inaugurate modern computational laboratories in collaboration with global tech giants.",
            content = "BUET, DU, and private technological institutions roll out specialized degrees in Machine Learning, Cyber Defense, and Smart Manufacturing.",
            articleUrl = "https://www.daily-sun.com/education/ai-robotics-curriculum",
            imageUrl = "https://images.unsplash.com/photo-1485827404703-89b55fcc595e?w=800&auto=format&fit=crop",
            category = "Technology",
            publishedAt = System.currentTimeMillis() - (100 * 60 * 1000),
            formattedTime = "1 hour ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 11. Bonik Barta
        ArticleEntity(
            id = "seed_art_11_bonik_barta",
            newspaperId = "bonik_barta",
            newspaperName = "Bonik Barta",
            newspaperBanglaName = "বণিক বার্তা",
            title = "শেয়ারবাজারে লেনদেনের ঊর্ধ্বগতি, প্রাতিষ্ঠানিক বিনিয়োগকারীদের আস্থা বৃদ্ধি",
            description = "ঢাকা স্টক এক্সচেঞ্জে সূচক বৃদ্ধি পেয়ে চার মাসের মধ্যে সর্বোচ্চ উচ্চতায় পৌঁছেছে। স্বচ্ছতা বৃদ্ধি ও সুশাসনের সুফল মিলছে।",
            content = "পুঁজিবাজারে নতুন তালিকাভুক্ত ভালো মৌলভিত্তিসম্পন্ন কোম্পানিগুলোর শেয়ারের চাহিদা বেড়েছে। বিনিয়োগকারীদের আস্থা ফিরে পাওয়ায় পুঁজিবাজার নতুন সম্ভাবনার মুখে।",
            articleUrl = "https://www.bonikbarta.net/stock-market-rally",
            imageUrl = "https://images.unsplash.com/photo-1611974789855-9c2a0a7236a3?w=800&auto=format&fit=crop",
            category = "Business",
            publishedAt = System.currentTimeMillis() - (110 * 60 * 1000),
            formattedTime = "1 hour ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 12. Somoy TV
        ArticleEntity(
            id = "seed_art_12_somoy_tv",
            newspaperId = "somoy_tv",
            newspaperName = "Somoy TV",
            newspaperBanglaName = "সময় টিভি",
            title = "পদ্মা সেতু রেল সংযোগে গতি ফিরছে দক্ষিণাঞ্চলের সার্বিক অর্থনীতিতে",
            description = "ঢাকা থেকে যশোর ও খুলনা রুটে ট্রেন যোগাযোগ দ্রুতগতির হওয়ায় মৎস্য, শাকসবজি ও শিল্পপণ্যের পরিবহন কয়েক গুণ সহজ হয়েছে।",
            content = "পদ্মা সেতু রেল সংযোগ প্রকল্প দক্ষিণের ২১টি জেলার যোগাযোগ ব্যবস্থায় বিপ্লব এনে দিয়েছে। মাত্র সাড়ে তিন ঘণ্টায় ঢাকা থেকে খুলনা পর্যন্ত পণ্য ও যাত্রী পরিবহন সম্ভব হচ্ছে।",
            articleUrl = "https://www.somoynews.tv/news/padma-rail-connection",
            imageUrl = "https://images.unsplash.com/photo-1477959858617-67f30bc75b82?w=800&auto=format&fit=crop",
            category = "TV News",
            publishedAt = System.currentTimeMillis() - (120 * 60 * 1000),
            formattedTime = "2 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 13. Jamuna TV
        ArticleEntity(
            id = "seed_art_13_jamuna_tv",
            newspaperId = "jamuna_tv",
            newspaperName = "Jamuna TV",
            newspaperBanglaName = "যমুনা টিভি",
            title = "ভেজাল খাদ্য ও সিন্ডিকেট বিরোধী বিশেষ অভিযানে কঠোর প্রশাসন",
            description = "জাতীয় ভোক্তা অধিকার সংরক্ষণ অধিদপ্তর ও আইন শৃঙ্খলা রক্ষাকারী বাহিনীর যৌথ অভিযানে বাজারে পণ্যমূল্য স্থিতিশীল হতে শুরু করেছে।",
            content = "নিত্যপ্রয়োজনীয় পণ্যের কৃত্রিম সংকট তৈরির অপচেষ্টা রুখতে দেশের সব পাইকারি ও খুচরা বাজারে সার্বক্ষণিক মনিটরিং সেল চালু করেছে সরকার।",
            articleUrl = "https://www.jamuna.tv/news/consumer-rights-market-monitoring",
            imageUrl = "https://images.unsplash.com/photo-1542838132-92c53300491e?w=800&auto=format&fit=crop",
            category = "TV News",
            publishedAt = System.currentTimeMillis() - (130 * 60 * 1000),
            formattedTime = "2 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 14. Channel 24
        ArticleEntity(
            id = "seed_art_14_channel_24",
            newspaperId = "channel_24",
            newspaperName = "Channel 24",
            newspaperBanglaName = "চ্যানেল ২৪",
            title = "বিপিএলের নতুন মৌসুমে বিশ্বমানের ব্রডকাস্টিং ও আলট্রা-মডার্ন প্রযুক্তি",
            description = "বাংলাদেশ প্রিমিয়ার লিগের আসন্ন আসরে স্পাইডারক্যাম, ৪কে ড্রোন এবং এআই ভিত্তিক স্নিকো প্রযুক্তির অভিষেক হতে যাচ্ছে।",
            content = "ক্রিকেট ভক্তদের বিশ্বমানের বিনোদন উপহার দিতে প্রস্তুত বিসিবি। স্টেডিয়ামগুলোতে দর্শক সুবিধা বৃদ্ধিতে নেওয়া হয়েছে আধুনিক পরিকল্পনা।",
            articleUrl = "https://www.channel24bd.tv/sports/bpl-modern-broadcasting",
            imageUrl = "https://images.unsplash.com/photo-1531415074968-036ba1b575da?w=800&auto=format&fit=crop",
            category = "TV News",
            publishedAt = System.currentTimeMillis() - (140 * 60 * 1000),
            formattedTime = "2 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 15. BTV
        ArticleEntity(
            id = "seed_art_15_btv",
            newspaperId = "btv_national",
            newspaperName = "BTV",
            newspaperBanglaName = "বিটিভি",
            title = "খাদ্য উৎপাদনে স্বয়ংসম্পূর্ণতা: ধানের বাম্পার ফলনে কৃষকের মুখে হাসি",
            description = "সারাদেশে উচ্চফলনশীল ব্রি জাতের ধানের রেকর্ড ফলন হয়েছে। সরকারি গুদামে সরাসরি কৃষকদের থেকে ধান সংগ্রহ শুরু।",
            content = "কৃষি মন্ত্রণালয় জানিয়েছে, আধুনিক সেচ প্রযুক্তি ও ভর্তুকিমূল্যে উন্নত বীজ সরবরাহের কারণে দুর্যোগ সত্ত্বেও দেশে খাদ্যশস্যের বাম্পার উৎপাদন অর্জিত হয়েছে।",
            articleUrl = "https://btv.gov.bd/news/bumper-crop-harvest",
            imageUrl = "https://images.unsplash.com/photo-1500937386664-56d1dfef3854?w=800&auto=format&fit=crop",
            category = "TV News",
            publishedAt = System.currentTimeMillis() - (150 * 60 * 1000),
            formattedTime = "2 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 16. Financial Express
        ArticleEntity(
            id = "seed_art_16_financial_express",
            newspaperId = "financial_express",
            newspaperName = "The Financial Express",
            newspaperBanglaName = "দ্য ফাইন্যান্সিয়াল এক্সপ্রেস",
            title = "Foreign Direct Investment Surges 18% in Special Economic Zones",
            description = "High-tech manufacturing, automotive parts, and green textile units drive unprecedented FDI inflow at Mirsharai and Matarbari hubs.",
            content = "BEZA officials report that simplified one-stop clearances and robust port connectivity are attracting multinational conglomerates from Japan, Korea, and Europe.",
            articleUrl = "https://thefinancialexpress.com.bd/trade/fdi-surge-economic-zones",
            imageUrl = "https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?w=800&auto=format&fit=crop",
            category = "Business",
            publishedAt = System.currentTimeMillis() - (160 * 60 * 1000),
            formattedTime = "2 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 17. Manab Zamin
        ArticleEntity(
            id = "seed_art_17_manab_zamin",
            newspaperId = "manab_zamin",
            newspaperName = "Manab Zamin",
            newspaperBanglaName = "মানবজমিন",
            title = "নির্বাচনী প্রক্রিয়ায় স্বচ্ছতা নিশ্চিতে রাজনৈতিক ঐকমত্যের তাগিদ",
            description = "সুশীল সমাজ ও নাগরিক ফোরামের যৌথ সংলাপে অংশগ্রহণমূলক ও আস্থাশীল নির্বাচনের পরিবেশ তৈরির আহ্বান জানানো হয়েছে।",
            content = "বিভিন্ন রাজনৈতিক দলের প্রতিনিধি এবং নির্বাচন বিশেষজ্ঞদের অংশগ্রহণে অনুষ্ঠিত গোলটেবিল বৈঠকে গণতান্ত্রিক মূল্যবোধ সুদৃঢ় করার ওপর গুরুত্বারোপ করা হয়।",
            articleUrl = "https://mzamin.com/news/election-transparency-dialogue",
            imageUrl = "https://images.unsplash.com/photo-1540910419892-4a36d2c3266c?w=800&auto=format&fit=crop",
            category = "Politics",
            publishedAt = System.currentTimeMillis() - (170 * 60 * 1000),
            formattedTime = "2 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 18. Naya Diganta
        ArticleEntity(
            id = "seed_art_18_naya_diganta",
            newspaperId = "naya_diganta",
            newspaperName = "Naya Diganta",
            newspaperBanglaName = "নয়া দিগন্ত",
            title = "প্রবাসী আয়ে ঊর্ধ্বগতি: ব্যাংকিং চ্যানেলে রেমিট্যান্স প্রেরণে উৎসাহ প্রদান",
            description = "বৈধ চ্যানেলে প্রবাসী আয় প্রেরণে বিশেষ প্রণোদনা ও ডিজিটাল রেমিট্যান্স অ্যাপ ব্যবহারে ব্যাংকগুলো নতুন সুবিধা চালু করেছে।",
            content = "বাংলাদেশ ব্যাংকের প্রতিবেদনে বলা হয়েছে, মধ্যপ্রাচ্য ও পশ্চিমা দেশগুলো থেকে প্রবাসীদের প্রেরিত অর্থ দেশের বৈদেশিক মুদ্রার রিজার্ভকে শক্তিশালী করছে।",
            articleUrl = "https://www.dailynayadiganta.com/economy/remittance-banking-growth",
            imageUrl = "https://images.unsplash.com/photo-1559526324-4b87b5e36e44?w=800&auto=format&fit=crop",
            category = "Economy",
            publishedAt = System.currentTimeMillis() - (180 * 60 * 1000),
            formattedTime = "3 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 19. Banglanews24
        ArticleEntity(
            id = "seed_art_19_banglanews24",
            newspaperId = "banglanews24",
            newspaperName = "Banglanews24.com",
            newspaperBanglaName = "বাংলানিউজটোয়েন্টিফোর.কম",
            title = "কক্সবাজার রুটে দৃষ্টিনন্দন স্পেশাল ট্রেনের জনপ্রিয়তায় পর্যটন শিল্পে জোয়ার",
            description = "ঝিনুক আকৃতির অত্যাধুনিক রেল স্টেশন ও দ্রুতগতির কোচের কারণে ছুটির দিনে রেকর্ড সংখ্যক পর্যটকের আগমন সৈকত নগরীতে।",
            content = "ঢাকা-কক্সবাজার রেলপথ চালুর পর পর্যটন হোটেল ও রেস্তোরাঁ ব্যবসায় আশাতীত প্রবৃদ্ধি লক্ষ্য করা যাচ্ছে। আন্তর্জাতিক মানের সেবা নিশ্চিতে কাজ করছে পর্যটন পুলিশ।",
            articleUrl = "https://www.banglanews24.com/tourism/coxsbazar-train-tourism-boom",
            imageUrl = "https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=800&auto=format&fit=crop",
            category = "Online",
            publishedAt = System.currentTimeMillis() - (190 * 60 * 1000),
            formattedTime = "3 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 20. Jago News
        ArticleEntity(
            id = "seed_art_20_jago_news",
            newspaperId = "jago_news",
            newspaperName = "Jago News 24",
            newspaperBanglaName = "জাগো নিউজ ২৪",
            title = "আন্তর্জাতিক স্টার্টআপ প্রতিযোগিতায় চ্যাম্পিয়ন বাংলাদেশের এআই উদ্যোক্তারা",
            description = "কৃষি খাতে রোগ নির্ণয় ও স্যাটেলাইট ভিত্তিক ফসল সুরক্ষায় কৃত্রিম বুদ্ধিমত্তা সলিউশন তৈরি করে আন্তর্জাতিক পুরস্কার পেল ঢাকা বিশ্ববিদ্যালয়ের দল।",
            content = "সিঙ্গাপুরে অনুষ্ঠিত এশিয়া-প্যাসিফিক ইনোভেশন সামিটে বিশ্বের ৩০টি দেশের উদ্ভাবকদের পেছনে ফেলে শীর্ষস্থান অর্জন করেছে বাংলাদেশি এই স্টার্টআপ।",
            articleUrl = "https://www.jagonews24.com/technology/bangladesh-startup-champion",
            imageUrl = "https://images.unsplash.com/photo-1522071820081-009f0129c71c?w=800&auto=format&fit=crop",
            category = "Technology",
            publishedAt = System.currentTimeMillis() - (200 * 60 * 1000),
            formattedTime = "3 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 21. Dhaka Post
        ArticleEntity(
            id = "seed_art_21_dhaka_post",
            newspaperId = "dhaka_post",
            newspaperName = "Dhaka Post",
            newspaperBanglaName = "ঢাকা পোস্ট",
            title = "স্মার্ট সিটি বাস্তবায়নে ঢাকায় স্বয়ংক্রিয় ট্রাফিক সিগন্যাল ও সিসিটিভি সার্ভেইল্যান্স",
            description = "রাজধানীর প্রধান মোড়গুলোতে এআই ট্রাফিক লাইট স্থাপন সম্পন্ন। যানজট নিরসনে ট্রাফিক নিয়ন্ত্রক ব্যবস্থায় আধুনিকায়ন।",
            content = "ঢাকা উত্তর ও দক্ষিণ সিটি করপোরেশনের যৌথ উদ্যোগে শহরের ট্রাফিক ব্যবস্থাপনা সেন্ট্রাল কমান্ড রুমের মাধ্যমে মনিটরিং করা হচ্ছে।",
            articleUrl = "https://www.dhakapost.com/national/smart-traffic-signal-dhaka",
            imageUrl = "https://images.unsplash.com/photo-1519501025264-65ba15a82390?w=800&auto=format&fit=crop",
            category = "National",
            publishedAt = System.currentTimeMillis() - (210 * 60 * 1000),
            formattedTime = "3 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 22. Inqilab
        ArticleEntity(
            id = "seed_art_22_inqilab",
            newspaperId = "inqilab",
            newspaperName = "Inqilab",
            newspaperBanglaName = "ইনকিলাব",
            title = "উচ্চশিক্ষায় মৌলিক গবেষণায় বাজেট বৃদ্ধি ও মেধাবীদের জাতীয় ফেলোশিপ",
            description = "বিশ্ববিদ্যালয় মঞ্জুরি কমিশন পাবলিক ও প্রাইভেট বিশ্ববিদ্যালয়ের গবেষণাগার আধুনিকায়নে বিশেষ অনুদান অনুমোদন করেছে।",
            content = "বায়োটেকনোলজি, ন্যানোটেকনোলজি ও ক্লিন এনার্জি খাতে গবেষণারত পিএইচডি গবেষকদের জন্য ফেলোশিপ ভাতার পরিমাণ দ্বিগুণ করা হয়েছে।",
            articleUrl = "https://dailyinqilab.com/education/higher-research-fellowship",
            imageUrl = "https://images.unsplash.com/photo-1532094349884-543bc11b234d?w=800&auto=format&fit=crop",
            category = "Education",
            publishedAt = System.currentTimeMillis() - (220 * 60 * 1000),
            formattedTime = "3 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 23. Dainik Purbokone (Chattogram)
        ArticleEntity(
            id = "seed_art_23_purbokone",
            newspaperId = "dainik_purbokone",
            newspaperName = "Dainik Purbokone",
            newspaperBanglaName = "দৈনিক পূর্বকোণ",
            title = "চট্টগ্রামের মাতারবাড়ি গভীর সমুদ্রবন্দর টার্মিনালে ভিড়ল প্রথম মাদার ভেসেল",
            description = "১৬ মিটার ড্রাফটের বিশালাকার বাণিজ্যিক জাহাজ ভিড়ে বাংলাদেশের মেরিটাইম ইতিহাসে যুক্ত হলো নতুন এক গৌরবোজ্জ্বল অধ্যায়।",
            content = "মাতারবাড়ি গভীর সমুদ্রবন্দর সম্পূর্ণরূপে চালু হলে বাংলাদেশ দক্ষিণ এশিয়ার অন্যতম প্রধান ট্রানজিট ও শিপিং হাবে পরিণত হবে বলে আশা প্রকাশ করেছেন বিশ্লেষকরা।",
            articleUrl = "https://dainikpurbokone.net/business/matarbari-port-mother-vessel",
            imageUrl = "https://images.unsplash.com/photo-1505705694340-019e1e335916?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (230 * 60 * 1000),
            formattedTime = "3 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 24. Dainik Azadi (Chattogram)
        ArticleEntity(
            id = "seed_art_24_azadi",
            newspaperId = "dainik_azadi",
            newspaperName = "Dainik Azadi",
            newspaperBanglaName = "দৈনিক আজাদী",
            title = "কর্ণফুলী নদীর ক্যাপিটাল ড্রেজিং সম্পন্ন: সচল হলো সব গুরুত্বপূর্ণ নৌঘাট",
            description = "বন্দর নগরীর প্রাণপ্রবাহ কর্ণফুলী নদীর নাব্যতা বৃদ্ধিতে সফলভাবে ক্যাপিটাল ড্রেজিং সম্পন্ন করেছে চট্টগ্রাম বন্দর কর্তৃপক্ষ।",
            content = "নদীর তলদেশে জমে থাকা পলি ও অপচনশীল বর্জ্য অপসারণের পর কর্ণফুলীর চ্যানেল দিয়ে অভ্যন্তরীণ পণ্য পরিবহন অনেক দ্রুত ও নিরাপদ হয়েছে।",
            articleUrl = "https://dainikazadi.net/local/karnaphuli-river-dredging-success",
            imageUrl = "https://images.unsplash.com/photo-1473448912268-2022ce9509d8?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (240 * 60 * 1000),
            formattedTime = "4 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 25. Sylheter Dak (Sylhet)
        ArticleEntity(
            id = "seed_art_25_sylheter_dak",
            newspaperId = "sylheter_dak",
            newspaperName = "Sylheter Dak",
            newspaperBanglaName = "সিলেটের ডাক",
            title = "শ্রীমঙ্গলে অর্গানিক চা পাতার রেকর্ড উৎপাদন: ইউরোপ ও মধ্যপ্রাচ্যে রপ্তানি শুরু",
            description = "সিলেট বিভাগের চা বাগানগুলোতে উন্নত প্রক্রিয়াকরণ ও পরিবেশবান্ধব চাষাবাদের ফলে অর্গানিক চায়ের বৈশ্বিক চাহিদা বাড়ছে।",
            content = "বাংলাদেশ চা বোর্ডের নির্দেশনায় গুণগত মান নিয়ন্ত্রণ নিশ্চিত করায় আন্তর্জাতিক নিলামে রেকর্ড দামে বিক্রি হয়েছে সিলেটের বিশেষ ব্ল্যাক ও গ্রিন টি।",
            articleUrl = "https://sylheterdak.com.bd/tea-industry-organic-export",
            imageUrl = "https://images.unsplash.com/photo-1544787219-7f47ccb76574?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (250 * 60 * 1000),
            formattedTime = "4 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 26. Shyamal Sylhet (Sylhet)
        ArticleEntity(
            id = "seed_art_26_shyamal_sylhet",
            newspaperId = "shyamal_sylhet",
            newspaperName = "Shyamal Sylhet",
            newspaperBanglaName = "শ্যামল সিলেট",
            title = "সিলেট ওসমানী আন্তর্জাতিক বিমানবন্দরের নতুন টার্মিনালের নির্মাণ কাজ দ্রুতগতিতে এগিয়ে চলছে",
            description = "আধুনিক সুযোগ-সুবিধা সম্বলিত আন্তর্জাতিক প্যাসেঞ্জার টার্মিনাল চালু হলে সরাসরি সিলেট থেকে যুক্তরাজ্য ও মধ্যপ্রাচ্যের ফ্লাইট আরও বাড়বে।",
            content = "বেসামরিক বিমান চলাচল কর্তৃপক্ষ জানিয়েছে, টার্মিনালটির আধুনিক স্থাপত্যশৈলী ও ডিজিটাল প্যাসেঞ্জার হ্যান্ডলিং যাত্রীদের দুর্ভোগ পুরোপুরি দূর করবে।",
            articleUrl = "https://shyamalsylhet.com/osmani-airport-terminal-expansion",
            imageUrl = "https://images.unsplash.com/photo-1436491865332-7a61a109cc05?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (260 * 60 * 1000),
            formattedTime = "4 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 27. Gramer Kagoj (Khulna/Jashore)
        ArticleEntity(
            id = "seed_art_27_gramer_kagoj",
            newspaperId = "gramer_kagoj",
            newspaperName = "Gramer Kagoj",
            newspaperBanglaName = "দৈনিক গ্রামের কাগজ",
            title = "বেনাপোল স্থলবন্দরে স্বয়ংক্রিয় কার্গো ভেহিক্যাল ট্র্যাকিং সিস্টেম চালু",
            description = "যশোরের বেনাপোল বন্দরে ডিজিটাল গেট ও স্বয়ংক্রিয় ওজন মাপার যন্ত্র বসায় আমদানি-রপ্তানি বাণিজ্য দ্রুততর হয়েছে।",
            content = "প্রতিদিন শত শত ভারতীয় পণ্যবাহী ট্রাক জটমুক্ত পরিবেশে খালাস হচ্ছে। এতে বন্দর ব্যবহারকারী ব্যবসায়ী ও চালকদের দীর্ঘদিনের দুর্ভোগ লাঘব হয়েছে।",
            articleUrl = "https://gramerkagoj.com/benapole-port-automation",
            imageUrl = "https://images.unsplash.com/photo-1601584115197-04ecc0da31d7?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (270 * 60 * 1000),
            formattedTime = "4 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 28. Purbanchal (Khulna)
        ArticleEntity(
            id = "seed_art_28_purbanchal",
            newspaperId = "purbanchal",
            newspaperName = "Purbanchal",
            newspaperBanglaName = "দৈনিক পূর্বাঞ্চল",
            title = "সুন্দরবনের বনজ সম্পদ ও রয়েল বেঙ্গল টাইগার সুরক্ষায় স্মার্ট পেট্রোলিং জোরদার",
            description = "বন অধিদপ্তর সুন্দরবনের দুর্গম অঞ্চলে স্যাটেলাইট ট্র্যাকিং ও ড্রোন ব্যবহার করে হরিণ ও বাঘের বিচরণক্ষেত্র নিরাপদ রাখছে।",
            content = "স্থানীয় কমিউনিটি ভিত্তিক বনরক্ষী ও বন কর্মকর্তাদের যৌথ তৎপরতায় সুন্দরবনের প্রাকৃতিক বাস্তুতন্ত্র ও জীববৈচিত্র্য উল্লেখযোগ্যভাবে বৃদ্ধি পেয়েছে।",
            articleUrl = "https://purbanchal.com/sundarbans-tiger-conservation",
            imageUrl = "https://images.unsplash.com/photo-1549366021-9f761d450615?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (280 * 60 * 1000),
            formattedTime = "4 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 29. Karatoa (Rajshahi/Bogura)
        ArticleEntity(
            id = "seed_art_29_karatoa",
            newspaperId = "karatoa",
            newspaperName = "Karatoa",
            newspaperBanglaName = "দৈনিক করতোয়া",
            title = "বগুড়ার আধুনিক কৃষিযন্ত্র শিল্পে বিপ্লব: দেশীয় চাহিদার ৮০ ভাগ পূরণ করছে স্থানীয় কারখানা",
            description = "বগুড়ার হালকা প্রকৌশল শিল্পে তৈরি উন্নত সেচ পাম্প, থ্রেসার ও বীজ বপন যন্ত্র এখন সারাদেশে সমাদৃত।",
            content = "বিসিক শিল্পনগরীর উদ্যোক্তারা জানান, সরকারি পৃষ্ঠপোষকতা ও সুদমুক্ত ঋণ সহায়তা পেলে তাদের তৈরি কৃষি যন্ত্রপাতি বিদেশেও রপ্তানি সম্ভব হবে।",
            articleUrl = "https://karatoa.com.bd/bogura-agro-machinery-revolution",
            imageUrl = "https://images.unsplash.com/photo-1589923188900-85dae523342b?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (290 * 60 * 1000),
            formattedTime = "4 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 30. Sonali Sangbad (Rajshahi)
        ArticleEntity(
            id = "seed_art_30_sonali_sangbad",
            newspaperId = "sonali_sangbad",
            newspaperName = "Sonali Sangbad",
            newspaperBanglaName = "দৈনিক সোনালী সংবাদ",
            title = "ঐতিহ্যবাহী রাজশাহী রেশম কারখানা নতুন স্পিনিং মেশিনে আধুনিকায়নের উদ্যোগ",
            description = "রেশম চাষি ও তাঁতশিল্পীদের মুখে হাসি ফোটাতে নতুন সুতা উৎপাদন প্রযুক্তি সংযুক্তির অনুমোদন দিয়েছে বস্ত্র ও পাট মন্ত্রণালয়।",
            content = "রাজশাহীর খাঁটি সিল্ক শাড়ির ঐতিহ্য বিশ্বজুড়ে ছড়িয়ে দিতে ডিজিটাল ব্র্যান্ডিং ও ই-কমার্স প্ল্যাটফর্মের সাথে সংযোগ স্থাপন করা হচ্ছে।",
            articleUrl = "https://sonalisangbad.com/rajshahi-silk-revival",
            imageUrl = "https://images.unsplash.com/photo-1617627143750-d86bc21e42bb?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (300 * 60 * 1000),
            formattedTime = "5 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 31. Comillar Kagoj (Cumilla)
        ArticleEntity(
            id = "seed_art_31_comillar_kagoj",
            newspaperId = "comillar_kagoj",
            newspaperName = "Comillar Kagoj",
            newspaperBanglaName = "কুমিল্লার কাগজ",
            title = "ময়নামতী শালবন বিহার ও লালমাই পাহাড়ে পর্যটক আকর্ষণে নতুন হেরিটেজ ট্যুরিজম প্রকল্প",
            description = "ঐতিহাসিক ময়নামতীর বৌদ্ধ সভ্যতার প্রত্নতাত্ত্বিক নিদর্শন সংরক্ষণে আধুনিক ডিজিটাল মিউজিয়াম ও গাইড অ্যাপ উদ্বোধন।",
            content = "দেশ-বিদেশের ইতিহাস গবেষক ও দর্শনার্থীদের জন্য ময়নামতী প্রত্নতত্ত্ব এলাকায় পরিবেশবান্ধব বৈদ্যুতিক গলফ কার্ট ও আধুনিক বিশ্রামাগার তৈরি করা হয়েছে।",
            articleUrl = "https://comillarkagoj.com/maynamati-heritage-tourism",
            imageUrl = "https://images.unsplash.com/photo-1544644181-1484b3fdfc62?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (310 * 60 * 1000),
            formattedTime = "5 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 32. Barishal Times (Barishal)
        ArticleEntity(
            id = "seed_art_32_barishal_times",
            newspaperId = "barishal_times",
            newspaperName = "Barishal Times",
            newspaperBanglaName = "বরিশাল টাইমস",
            title = "পায়রা গভীর সমুদ্রবন্দর কয়লা টার্মিনাল ও তাপবিদ্যুৎ কেন্দ্রে পূর্ণ মাত্রায় বিদ্যুৎ উৎপাদন",
            description = "পটুয়াখালীর পায়রায় উৎপাদিত বিদ্যুৎ জাতীয় গ্রিডে সফলভাবে সঞ্চালন হচ্ছে, দক্ষিণাঞ্চলে নিরবচ্ছিন্ন বিদ্যুতের নিশ্চয়তা।",
            content = "পায়রা বন্দরের আধুনিক টার্মিনালে সরাসরি গভীর সমুদ্রের জাহাজ থেকে কয়লা খালাস হচ্ছে। ফলে উৎপাদন ব্যয় উল্লেখযোগ্য পরিমাণে সাশ্রয় হয়েছে।",
            articleUrl = "https://barishaltimes.com/payra-port-power-generation",
            imageUrl = "https://images.unsplash.com/photo-1473341304170-971dccb5ac1e?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (320 * 60 * 1000),
            formattedTime = "5 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 33. Amader Protidin (Rangpur)
        ArticleEntity(
            id = "seed_art_33_amader_protidin",
            newspaperId = "amader_protidin",
            newspaperName = "Amader Protidin",
            newspaperBanglaName = "আমাদের প্রতিদিন",
            title = "রংপুর বিভাগে গম ও ভুট্টা চাষে নতুন জাতের বাজিমাত: দ্বিগুণ ফলনে খুশি উত্তরাঞ্চলের কৃষক",
            description = "বাংলাদেশ গম ও ভুট্টা গবেষণা ইনস্টিটিউট উদ্ভাবিত খরা-সহনশীল জাত উত্তরাঞ্চলের চরাঞ্চলের অর্থনীতিকে বদলে দিচ্ছে।",
            content = "তিস্তা ও ধরলা নদীর বালুচরে উন্নত প্রযুক্তির সেচ ব্যবস্থার মাধ্যমে চাষাবাদ করায় কৃষকদের আয় বহুগুণ বৃদ্ধি পেয়েছে।",
            articleUrl = "https://amaderprotidin.com/rangpur-corn-wheat-success",
            imageUrl = "https://images.unsplash.com/photo-1574323347407-f5e1ad6d020b?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (330 * 60 * 1000),
            formattedTime = "5 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 34. Mymensingh Pratidin (Mymensingh)
        ArticleEntity(
            id = "seed_art_34_mymensingh_pratidin",
            newspaperId = "mymensingh_pratidin",
            newspaperName = "Mymensingh Pratidin",
            newspaperBanglaName = "ময়মনসিংহ প্রতিদিন",
            title = "ব্রহ্মপুত্র নদের ক্যাপিটাল ড্রেজিং ও মৎস্য গবেষণায় দেশীয় মাছের প্রজনন বৃদ্ধি",
            description = "ময়মনসিংহে বাংলাদেশ মৎস্য গবেষণা ইনস্টিটিউট বিলুপ্তপ্রায় দেশীয় প্রজাতির মাছের কৃত্রিম প্রজনন প্রযুক্তি সফলভাবে উদ্ভাবন করেছে।",
            content = "পাবদা, গুলশা, টেংরা ও মাগুর মাছের পোনা সারাদেশে খামারিদের মাঝে সাশ্রয়ী মূল্যে বিতরণ শুরু হয়েছে, যা আমিষের চাহিদা পূরণে কার্যকর ভূমিকা রাখছে।",
            articleUrl = "https://mymensinghpratidin.com/brahmaputra-fish-research",
            imageUrl = "https://images.unsplash.com/photo-1534043464124-3be32fe00099?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (340 * 60 * 1000),
            formattedTime = "5 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 35. Suprobhat Bangladesh (Chattogram)
        ArticleEntity(
            id = "seed_art_35_suprobhat_bd",
            newspaperId = "suprobhat_bangladesh",
            newspaperName = "Suprobhat Bangladesh",
            newspaperBanglaName = "সুप्रभात বাংলাদেশ",
            title = "চট্টগ্রাম বে টার্মিনাল প্রকল্পকে গ্রিন পোর্ট হিসেবে গড়ে তোলার আন্তর্জাতিক চুক্তি",
            description = "পরিবেশবান্ধব ও শূন্য কার্বন নির্গমন সুবিধার অত্যাধুনিক বে টার্মিনাল নির্মাণে বিশ্বব্যাংক ও আন্তর্জাতিক কনসোর্টিয়াম সহায়তা দিচ্ছে।",
            content = "বে টার্মিনাল চালু হলে যেকোনো জোয়ারে জাহাজ ভেড়ার সুবিধা তৈরি হবে এবং চট্টগ্রাম বন্দরের কনটেইনার ধারণক্ষমতা চারগুণ বৃদ্ধি পাবে।",
            articleUrl = "https://suprobhat.com/bay-terminal-green-port",
            imageUrl = "https://images.unsplash.com/photo-1518241353330-0f7941c2d9b5?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (350 * 60 * 1000),
            formattedTime = "5 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 36. Daily Probaha (Khulna)
        ArticleEntity(
            id = "seed_art_36_daily_probaha",
            newspaperId = "daily_probaha",
            newspaperName = "Daily Probaha",
            newspaperBanglaName = "দৈনিক প্রবাহ",
            title = "খুলনা ও বাগেরহাটের সাদা সোনা খ্যাত বাগদা চিংড়ি ইউরোপের বাজারে রপ্তানি পুনরুদ্ধার",
            description = "আন্তর্জাতিক ল্যাব টেস্টের গুণগত মান নিশ্চিত হওয়ায় পুনরায় ইইউ দেশগুলোতে বাংলাদেশি হিমায়িত চিংড়ির ক্রয়াদেশ ব্যাপক হারে বাড়ছে।",
            content = "চিংড়ি ঘেরে বায়োসিকিউরিটি ও অর্গানিক ফিড ব্যবহারের ফলে উৎপাদনশীলতা বৃদ্ধি পেয়েছে। রপ্তানিকারক সমিতি সরকারের সহায়তা কামনা করেছে।",
            articleUrl = "https://dailyprobaha.com/khulna-shrimp-export-growth",
            imageUrl = "https://images.unsplash.com/photo-1559742811-822873691df8?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (360 * 60 * 1000),
            formattedTime = "6 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 37. Sonar Desh (Rajshahi)
        ArticleEntity(
            id = "seed_art_37_sonar_desh",
            newspaperId = "sonar_desh",
            newspaperName = "Sonar Desh",
            newspaperBanglaName = "দৈনিক সোনার দেশ",
            title = "রাজশাহীর মিষ্টি আম ইউরোপ ও মধ্যপ্রাচ্যের সুপারশপে সরাসরি কার্গোতে রপ্তানি",
            description = "হিমসাগর, ল্যাংড়া ও ফজলি আমের ব্যাগিং প্রযুক্তির মাধ্যমে ক্ষতিকর কীটনাশকমুক্ত উচ্চমানের আম বিদেশে পাঠানো হচ্ছে।",
            content = "কৃষি সম্প্রসারণ অধিদপ্তর জানিয়েছে, আন্তর্জাতিক ফাইটোস্যানিটারি মান মেনে রপ্তানি করায় চাষিরা ন্যায্যমূল্য পাচ্ছেন।",
            articleUrl = "https://sonardesh.com/rajshahi-mango-cargo-export",
            imageUrl = "https://images.unsplash.com/photo-1553279768-865429fa0078?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (370 * 60 * 1000),
            formattedTime = "6 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 38. Dainik Coxsbazar (Chattogram/Cox's Bazar)
        ArticleEntity(
            id = "seed_art_38_dainik_coxsbazar",
            newspaperId = "dainik_coxsbazar",
            newspaperName = "Dainik Coxsbazar",
            newspaperBanglaName = "দৈনিক কক্সবাজার",
            title = "সেন্টমার্টিন দ্বীপে প্রবাল প্রাচীর রক্ষায় কঠোর পরিবেশ নীতি ও সীমিত ইকোট্যুরিজম",
            description = "একমাত্র প্রবাল দ্বীপের জীববৈচিত্র্য সুরক্ষায় প্লাস্টিক নিষিদ্ধকরণ ও পরিবেশবান্ধব পর্যটন নিশ্চিত করতে বিশেষ কমিটি গঠন।",
            content = "পরিবেশ অধিদপ্তর জানিয়েছে, পর্যটকদের অনিয়ন্ত্রিত প্রবেশ সীমিত করে প্রবাল ও সামুদ্রিক কচ্ছপের বংশবৃদ্ধি নিশ্চিত করা হচ্ছে।",
            articleUrl = "https://dainikcoxsbazar.com/saint-martin-coral-sanctuary",
            imageUrl = "https://images.unsplash.com/photo-1512100356356-de1b84283e18?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (380 * 60 * 1000),
            formattedTime = "6 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 39. Daily Jalalabad (Sylhet)
        ArticleEntity(
            id = "seed_art_39_daily_jalalabad",
            newspaperId = "daily_jalalabad",
            newspaperName = "Daily Jalalabad",
            newspaperBanglaName = "দৈনিক জালালাবাদ",
            title = "সুরমা ও কুশিয়ারা নদীর তীর রক্ষা বাঁধ নির্মাণে স্থায়ী বন্যা প্রতিরোধ কাঠামো",
            description = "পানি উন্নয়ন বোর্ডের মেগা প্রকল্পে সিলেট ও সুনামগঞ্জের হাওরাঞ্চলের ফসল রক্ষায় স্থায়ী বাঁধ ও স্লুইস গেট তৈরি সম্পন্ন।",
            content = "হাওরের আগাম বন্যা থেকে বোরো ধান রক্ষায় আধুনিক হাইড্রোলিক সেন্সর স্থাপন করা হয়েছে যাতে দ্রুত সতর্কবার্তা পৌঁছানো যায়।",
            articleUrl = "https://dailyjalalabad.com/surma-river-flood-defense",
            imageUrl = "https://images.unsplash.com/photo-1469854523086-cc02fe5d8800?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (390 * 60 * 1000),
            formattedTime = "6 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 40. Mathabhanga (Khulna/Chuadanga)
        ArticleEntity(
            id = "seed_art_40_mathabhanga",
            newspaperId = "mathabhanga",
            newspaperName = "Mathabhanga",
            newspaperBanglaName = "দৈনিক মাথাভাঙ্গা",
            title = "চুয়াডাঙ্গা ও মেহেরপুরের হাইব্রিড ভুট্টা চাষে রেকর্ড ফলন: গড়ে উঠছে ফিড মিল",
            description = "কৃষি বাণিজ্যিকীকরণের আওতায় স্থানীয় পোল্ট্রি ও ফিশ ফিড মিলগুলোতে সরাসরি কৃষকদের কাছ থেকে ভুট্টা ক্রয় করা হচ্ছে।",
            content = "মধ্যস্বত্বভোগীদের দৌরাত্ম্য দূর হওয়ায় কৃষকরা সরাসরি মিলে ভুট্টা বিক্রি করে ভালো লাভ করতে পারছেন।",
            articleUrl = "https://mathabhanga.com/corn-harvest-feed-mill",
            imageUrl = "https://images.unsplash.com/photo-1551434678-e076c223a692?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (400 * 60 * 1000),
            formattedTime = "6 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 41. Daily Rangpur (Rangpur)
        ArticleEntity(
            id = "seed_art_41_daily_rangpur",
            newspaperId = "daily_rangpur",
            newspaperName = "Daily Rangpur",
            newspaperBanglaName = "ডেইলি রংপুর",
            title = "তিস্তা ব্যারেজ আধুনিকীকরণ ও খাল খনন প্রকল্পে উপকৃত হচ্ছে লক্ষাধিক কৃষক পরিবার",
            description = "তিস্তা সেচ প্রকল্পের আওতায় শুষ্ক মৌসুমে রংপুর, নীলফামারী ও দিনাজপুরের ফসলি জমিতে নিরবচ্ছিন্ন পানি সরবরাহ নিশ্চিত।",
            content = "কৃষি সম্প্রসারণ বিভাগ জানিয়েছে, সেচের খরচ অর্ধেকের বেশি কমে আসায় কৃষকদের লাভজনক ফসল উৎপাদনের উৎসাহ তৈরি হয়েছে।",
            articleUrl = "https://dailyrangpur.com/teesta-barrage-irrigation-scheme",
            imageUrl = "https://images.unsplash.com/photo-1500382017468-9049fed747ef?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (410 * 60 * 1000),
            formattedTime = "6 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 42. Daily Ajker Barta (Barishal)
        ArticleEntity(
            id = "seed_art_42_ajker_barta",
            newspaperId = "daily_ajker_barta",
            newspaperName = "Daily Ajker Barta",
            newspaperBanglaName = "দৈনিক আজকের বার্তা",
            title = "বরিশালের ভীমরুলী ভাসমান পেয়ারা বাজারে অনলাইন ভিত্তিক সরাসরি ডেলিভারি সার্ভিস",
            description = "ঝালকাঠি ও স্বরূপকাঠির ঐতিহ্যবাহী ভাসমান বাজার থেকে ডিজিটাল প্ল্যাটফর্মে সরাসরি টাটকা পেয়ারা ও আমড়া পৌঁছে যাচ্ছে রাজধানীতে।",
            content = "স্থানীয় তরুণ উদ্যোক্তারা কোল্ড চেইন পরিবহন ব্যবহার করে ক্রেতাদের কাছে গুণগত মানসম্পন্ন ফল সরবরাহ করছেন।",
            articleUrl = "https://ajkerbarta.com/barishal-floating-guava-market",
            imageUrl = "https://images.unsplash.com/photo-1619546813926-a78fa6372cd2?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (420 * 60 * 1000),
            formattedTime = "7 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 43. Beanibazar Times (Sylhet)
        ArticleEntity(
            id = "seed_art_43_beanibazar_times",
            newspaperId = "beanibazar_times",
            newspaperName = "Beanibazar Times",
            newspaperBanglaName = "বিয়ানীবাজার টাইমস",
            title = "প্রবাসী বাংলাদেশি বিনিয়োগকারীদের উদ্যোগে সিলেটে আধুনিক মাল্টি-স্পেশালিটি হাসপাতাল",
            description = "যুক্তরাজ্য ও যুক্তরাষ্ট্র প্রবাসী চিকিৎসকদের অর্থায়নে আধুনিক স্বাস্থ্যসেবা কেন্দ্র স্থাপন, সুলভ মূল্যে উন্নত চিকিৎসার সুযোগ।",
            content = "হাসপাতালে আন্তর্জাতিক মানের ক্যান্সার চিকিৎসা ও কার্ডিয়াক সার্জারি ইউনিট চালুর পরিকল্পনা রয়েছে।",
            articleUrl = "https://beanibazartimes.com/diaspora-hospital-investment",
            imageUrl = "https://images.unsplash.com/photo-1586773860418-d37222d8fce3?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (430 * 60 * 1000),
            formattedTime = "7 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 44. Kishoreganj News (Mymensingh/Kishoreganj)
        ArticleEntity(
            id = "seed_art_44_kishoreganj_news",
            newspaperId = "kishoreganj_news",
            newspaperName = "Kishoreganj News",
            newspaperBanglaName = "কিশোরগঞ্জ নিউজ",
            title = "নিকলী ও অষ্টগ্রামের দিগন্তবিস্তৃত হাওর দর্শনে পর্যটকদের ভিড়, জমজমাট নৌবিহার",
            description = "বর্ষায় জলরাশির রূপ ও শুকনো মৌসুমে সুবিশাল অলওয়েদার সড়ক ভ্রমণপ্রেমীদের মাঝে অনন্য আকর্ষণ তৈরি করেছে।",
            content = "স্থানীয় প্রশাসন পরিবেশ রক্ষায় নৌকায় সাউন্ড সিস্টেম বাজানো নিয়ন্ত্রণ ও বর্জ্য ব্যবস্থাপনায় নির্দিষ্ট স্থান নির্ধারণ করে দিয়েছে।",
            articleUrl = "https://kishoreganjnews.com/nikli-haor-tourism-rush",
            imageUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (440 * 60 * 1000),
            formattedTime = "7 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 45. Chandpur Darpan (Cumilla/Chandpur)
        ArticleEntity(
            id = "seed_art_45_chandpur_darpan",
            newspaperId = "chandpur_darpan",
            newspaperName = "Chandpur Darpan",
            newspaperBanglaName = "দৈনিক চাঁদপুর দর্পণ",
            title = "মেঘনা ও পদ্মা মোহনায় রুপালি ইলিশের প্রজনন সুরক্ষায় সফল অভিযান: ঝাঁকে ঝাঁকে ইলিশ",
            description = "ইলিশের অভয়াশ্রমে কঠোর নিরাপত্তা ও জেলেদের সরকারি খাদ্য সহায়তা প্রদানে ইলিশের বংশবৃদ্ধি ও আকার উভয়ই বৃদ্ধি পেয়েছে।",
            content = "চাঁদপুর মাছঘাটে প্রতিদিন দূর-দূরান্ত থেকে পাইকাররা আসছেন টাটকা ইলিশ কিনতে। সরবরাহ বৃদ্ধির কারণে সাধারণ মানুষের নাগালে আসছে ইলিশের দাম।",
            articleUrl = "https://chandpurdarpan.com/hilsa-conservation-success",
            imageUrl = "https://images.unsplash.com/photo-1534482421-64566f976cfa?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (450 * 60 * 1000),
            formattedTime = "7 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 46. Feni News (Cumilla/Feni)
        ArticleEntity(
            id = "seed_art_46_feni_news",
            newspaperId = "feni_news",
            newspaperName = "Feni News",
            newspaperBanglaName = "ফেনী নিউজ",
            title = "মুহুরী সেচ প্রকল্পের আধুনিকীকরণ সম্পন্ন: উপকূলীয় তিন জেলায় রবিশস্যের সমারোহ",
            description = "ফেনীর মুহুরী প্রজেক্টে পানির প্রবাহ নিয়ন্ত্রণ ও মৎস্য চাষে সমন্বিত প্রযুক্তি ব্যবহারের মাধ্যমে হাজারো যুবকের কর্মসংস্থান।",
            content = "মৎস্য বিভাগ জানায়, মুহুরী জলাধারে দেশীয় কার্প জাতীয় মাছের চাষ করে স্থানীয় চাহিদা মিটিয়ে অন্যান্য জেলায় সরবরাহ করা হচ্ছে।",
            articleUrl = "https://feninews.com/muhuri-irrigation-project-boost",
            imageUrl = "https://images.unsplash.com/photo-1498050108023-c5249f4df085?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (460 * 60 * 1000),
            formattedTime = "7 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 47. Satkhira News (Khulna/Satkhira)
        ArticleEntity(
            id = "seed_art_47_satkhira_news",
            newspaperId = "satkhira_news",
            newspaperName = "Satkhira News",
            newspaperBanglaName = "সাতক্ষীরা নিউজ",
            title = "সুন্দরবনের খাঁটি মধু আহরণে মৌয়ালদের জন্য বিশেষ ডিজিটাল রেজিস্ট্রেশন ও আধুনিক প্রশিক্ষণ",
            description = "সাতক্ষীরা রেঞ্জে আধুনিক ও নিরাপদ পদ্ধতিতে মধু সংগ্রহ করায় বন ও মৌমাছির বাস্তুতন্ত্র অক্ষুণ্ণ থাকছে।",
            content = "বন বিভাগ মৌয়ালদের নিরাপত্তা সরঞ্জাম প্রদান করেছে এবং তাদের সংগৃহীত মধুর শতভাগ বিশুদ্ধতা প্রমাণে কিউআর কোড লেবেলিং চালু করেছে।",
            articleUrl = "https://satkhiranews.com/sundarbans-pure-honey-harvest",
            imageUrl = "https://images.unsplash.com/photo-1587049352846-4a222e784d38?w=800&auto=format&fit=crop",
            category = "Local",
            publishedAt = System.currentTimeMillis() - (470 * 60 * 1000),
            formattedTime = "8 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 48. Ekattor TV
        ArticleEntity(
            id = "seed_art_48_ekattor_tv",
            newspaperId = "ekattor_tv",
            newspaperName = "Ekattor TV",
            newspaperBanglaName = "একাত্তর টিভি",
            title = "জলবায়ু পরিবর্তনের ঝুঁকি মোকাবেলায় উপকূলীয় সবুজ বেষ্টনী ও আধুনিক সাইক্লোন শেল্টার",
            description = "বিশ্বের বিভিন্ন পরিবেশ সম্মেলনে বাংলাদেশের জলবায়ু সহনশীল অবকাঠামো মডেল হিসেবে প্রশংসিত হয়েছে।",
            content = "উপকূলীয় অঞ্চলে ম্যানগ্রোভ বনায়ন এবং বহুমুখী আশ্রয়কেন্দ্র দুর্যোগে প্রাণহানি শূন্যের কোঠায় নামিয়ে আনতে সমর্থ হয়েছে।",
            articleUrl = "https://ekattor.tv/environment/climate-resilience-model",
            imageUrl = "https://images.unsplash.com/photo-1511497584788-87676104235f?w=800&auto=format&fit=crop",
            category = "TV News",
            publishedAt = System.currentTimeMillis() - (480 * 60 * 1000),
            formattedTime = "8 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 49. Independent TV
        ArticleEntity(
            id = "seed_art_49_independent_tv",
            newspaperId = "independent_tv",
            newspaperName = "Independent TV",
            newspaperBanglaName = "ইন্ডিপেনডেন্ট টিভি",
            title = "স্মার্ট কৃষিতে ড্রোন ও আইওটি প্রযুক্তির ব্যবহার: কম খরচে বেশি ফলন নিশ্চিত",
            description = "ফসলের জমিতে নিখুঁতভাবে বালাইনাশক স্প্রে ও মাটির আর্দ্রতা মাপতে তরুণ গবেষকদের ড্রোন প্রযুক্তি কৃষকদের কাছে জনপ্রিয় হচ্ছে।",
            content = "কৃষি বিজ্ঞানী ও তথ্যপ্রযুক্তি বিশেষজ্ঞদের যৌথ উদ্যোগে দেশের বিভিন্ন কৃষি ব্লকে এই পাইলট প্রকল্পের সফল বাস্তবায়ন চলছে।",
            articleUrl = "https://independent24.tv/technology/drone-farming-smart-agriculture",
            imageUrl = "https://images.unsplash.com/photo-1527977966376-1c8408f9f108?w=800&auto=format&fit=crop",
            category = "TV News",
            publishedAt = System.currentTimeMillis() - (490 * 60 * 1000),
            formattedTime = "8 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),

        // 50. ATN News
        ArticleEntity(
            id = "seed_art_50_atn_news",
            newspaperId = "atn_news",
            newspaperName = "ATN News",
            newspaperBanglaName = "এটিএন নিউজ",
            title = "তরুণদের ফ্রিল্যান্সিং ও রিমোট জবে শীর্ষস্থান ধরে রেখেছে বাংলাদেশ",
            description = "বিশ্বের শীর্ষ ফ্রিল্যান্সিং মার্কেটপ্লেসগুলোতে ওয়েব ডেভেলপমেন্ট, গ্রাফিক্স ও ডিজিটাল মার্কেটিংয়ে বাংলাদেশি তরুণদের শীর্ষ অবস্থান।",
            content = "জেলা ও উপজেলা পর্যায়ে শেখ কামাল আইটি ট্রেনিং সেন্টার ও হাইটেক পার্কগুলো তরুণদের আন্তর্জাতিক কাজের উপযোগী করে তুলছে।",
            articleUrl = "https://atnnewstv.com/technology/freelancing-youth-achievement",
            imageUrl = "https://images.unsplash.com/photo-1522202176988-66273c2fd55f?w=800&auto=format&fit=crop",
            category = "TV News",
            publishedAt = System.currentTimeMillis() - (500 * 60 * 1000),
            formattedTime = "8 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        )
    )
}
