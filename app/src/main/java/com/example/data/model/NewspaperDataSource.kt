package com.example.data.model

object NewspaperDataSource {
    private val _baseNewspapers: List<Newspaper> = listOf(
        // ==================== BENGALI NEWSPAPERS (25) ====================
        Newspaper(
            id = "prothom_alo",
            name = "Prothom Alo",
            banglaName = "প্রথম আলো",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.prothomalo.com",
            rssUrl = "https://www.prothomalo.com/feed",
            tagline = "যা কিছু ভালো তার সঙ্গে প্রথম আলো",
            primaryColorHex = 0xFFD8232A
        ),
        Newspaper(
            id = "ittefaq",
            name = "Ittefaq",
            banglaName = "ইত্তেফাক",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.ittefaq.com.bd",
            rssUrl = "https://www.ittefaq.com.bd/rss.xml",
            tagline = "ঐতিহ্য ও বিশ্বাসের প্রতীক",
            primaryColorHex = 0xFF0284C7
        ),
        Newspaper(
            id = "kaler_kantho",
            name = "Kaler Kantho",
            banglaName = "কালের কণ্ঠ",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.kalerkantho.com",
            rssUrl = "https://www.kalerkantho.com/rss.xml",
            tagline = "সত্যের সঙ্গে সন্ধিহীন",
            primaryColorHex = 0xFF0D9488
        ),
        Newspaper(
            id = "bangladesh_pratidin",
            name = "Bangladesh Pratidin",
            banglaName = "বাংলাদেশ প্রতিদিন",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.bd-pratidin.com",
            rssUrl = "https://www.bd-pratidin.com/rss.xml",
            tagline = "সর্বাধিক প্রচারিত বাংলা দৈনিক",
            primaryColorHex = 0xFF0E7490
        ),
        Newspaper(
            id = "somokal",
            name = "Samakal",
            banglaName = "সমকাল",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.samakal.com",
            rssUrl = "https://samakal.com/rss.xml",
            tagline = "মুক্তচিন্তার দৈনিক",
            primaryColorHex = 0xFFE11D48
        ),
        Newspaper(
            id = "jugantor",
            name = "Jugantor",
            banglaName = "যুগান্তর",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.jugantor.com",
            rssUrl = "https://www.jugantor.com/rss.xml",
            tagline = "সত্যের সন্ধানে নির্ভীক",
            primaryColorHex = 0xFF2563EB
        ),
        Newspaper(
            id = "kalbela",
            name = "Kalbela",
            banglaName = "কালবেলা",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.kalbela.com",
            rssUrl = null,
            tagline = "সঠিক তথ্যে সময়োচিত খবর",
            primaryColorHex = 0xFFDC2626
        ),
        Newspaper(
            id = "manabzamin",
            name = "Manab Zamin",
            banglaName = "মানবজমিন",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.mzamin.com",
            rssUrl = null,
            tagline = "দেশ বিদেশের প্রতি মুহূর্তের খবর",
            primaryColorHex = 0xFF991B1B
        ),
        Newspaper(
            id = "jai_jai_din",
            name = "Jai Jai Din",
            banglaName = "যায়যায়দিন",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.jaijaidinbd.com",
            rssUrl = null,
            tagline = "জনগণের নির্ভীক কণ্ঠস্বর",
            primaryColorHex = 0xFFB45309
        ),
        Newspaper(
            id = "amader_shomoy",
            name = "Amader Shomoy",
            banglaName = "আমাদের সময়",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.dainikamadershomoy.com",
            rssUrl = null,
            tagline = "সময়ের সাথে মানুষের পাশে",
            primaryColorHex = 0xFF7C3AED
        ),
        Newspaper(
            id = "janakantha",
            name = "Janakantha",
            banglaName = "জনকণ্ঠ",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.dailyjanakantha.com",
            rssUrl = null,
            tagline = "সত্য ও ন্যায় প্রতিষ্ঠার অঙ্গীকার",
            primaryColorHex = 0xFFC026D3
        ),
        Newspaper(
            id = "sangbad",
            name = "Sangbad",
            banglaName = "সংবাদ",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://sangbad.net.bd",
            rssUrl = null,
            tagline = "ঐতিহ্যবাহী প্রাচীনতম দৈনিক",
            primaryColorHex = 0xFF4338CA
        ),
        Newspaper(
            id = "inqilab",
            name = "Inqilab",
            banglaName = "ইনকিলাব",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://dailyinqilab.com",
            rssUrl = null,
            tagline = "কওম ও জাতির মুখপাত্র",
            primaryColorHex = 0xFF15803D
        ),
        Newspaper(
            id = "ajkaler_khobor",
            name = "Ajkaler Khobor",
            banglaName = "আজকালের খবর",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://ajkalerkhobor.com",
            rssUrl = null,
            tagline = "বস্তুনিষ্ঠ সংবাদের প্রতিফলন",
            primaryColorHex = 0xFFEA580C
        ),
        Newspaper(
            id = "ajker_patrika",
            name = "Ajker Patrika",
            banglaName = "আজকের পত্রিকা",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.ajkerpatrika.com",
            rssUrl = null,
            tagline = "সারা দেশের খবরের বিশ্বস্ত উৎস",
            primaryColorHex = 0xFF0284C7
        ),
        Newspaper(
            id = "protidiner_sangbad",
            name = "Protidiner Sangbad",
            banglaName = "প্রতিদিনের সংবাদ",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.protidinersangbad.com",
            rssUrl = null,
            tagline = "প্রতিদিনের সত্য সংবাদ",
            primaryColorHex = 0xFF059669
        ),
        Newspaper(
            id = "bangladesher_khabor",
            name = "Bangladesher Khabor",
            banglaName = "বাংলাদেশের খবর",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://bangladesherkhabor.net",
            rssUrl = null,
            tagline = "সারাদেশের জনপদের কথা",
            primaryColorHex = 0xFFD97706
        ),
        Newspaper(
            id = "protidiner_bangladesh",
            name = "Protidiner Bangladesh",
            banglaName = "প্রতিদিনের বাংলাদেশ",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://protidinerbangladesh.com",
            rssUrl = null,
            tagline = "নতুন দিনের নবযাত্রা",
            primaryColorHex = 0xFFBE185D
        ),
        Newspaper(
            id = "amar_desh",
            name = "Amar Desh",
            banglaName = "আমার দেশ",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://amardesh.com",
            rssUrl = null,
            tagline = "দেশের কথা মানুষের কথা",
            primaryColorHex = 0xFF1E3A8A
        ),
        Newspaper(
            id = "bangladesh_journal",
            name = "Bangladesh Journal",
            banglaName = "বাংলাদেশ জার্নাল",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.bd-journal.com",
            rssUrl = null,
            tagline = "সত্য প্রকাশে অবিচল",
            primaryColorHex = 0xFF0D9488
        ),
        Newspaper(
            id = "amar_sangbad",
            name = "Amar Sangbad",
            banglaName = "আমার সংবাদ",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.amarsangbad.com",
            rssUrl = null,
            tagline = "জনতার পক্ষে সারাক্ষণ",
            primaryColorHex = 0xFF047857
        ),
        Newspaper(
            id = "vorer_pata",
            name = "Vorer Pata",
            banglaName = "ভোরের পাতা",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.vorerpata.com",
            rssUrl = null,
            tagline = "ভোরের আলোয় প্রতিদিনের খবর",
            primaryColorHex = 0xFFE11D48
        ),
        Newspaper(
            id = "sangram",
            name = "Sangram",
            banglaName = "সংগ্রাম",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://dailysangram.com",
            rssUrl = null,
            tagline = "ঐতিহাসিক আন্দোলনের মুখপত্র",
            primaryColorHex = 0xFF4F46E5
        ),
        Newspaper(
            id = "desh_rupantor",
            name = "Desh Rupantor",
            banglaName = "দেশ রূপান্তর",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://www.deshrupantor.com",
            rssUrl = null,
            tagline = "দায়িত্বশীল তারুণ্যের প্রতিচ্ছবি",
            primaryColorHex = 0xFF9333EA
        ),
        Newspaper(
            id = "manobkantha",
            name = "Manobkantha",
            banglaName = "মানবকণ্ঠ",
            category = NewspaperCategory.BENGALI,
            websiteUrl = "https://manobkantha.com.bd",
            rssUrl = null,
            tagline = "মানুষের অধিকারের মুখপত্র",
            primaryColorHex = 0xFF0891B2
        ),

        // ==================== 🌐 ONLINE PORTALS (56) ====================
        Newspaper(
            id = "bdnews24",
            name = "bdnews24",
            banglaName = "বিডিনিউজ টোয়েন্টিফোর",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://bangla.bdnews24.com",
            rssUrl = "https://bdnews24.com/rss",
            tagline = "প্রথম অনলাইন সংবাদ মাধ্যম",
            primaryColorHex = 0xFFC026D3
        ),
        Newspaper(
            id = "banglanews24",
            name = "Banglanews24",
            banglaName = "বাংলানিউজ২৪",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://www.banglanews24.com",
            rssUrl = null,
            tagline = "২৪ ঘণ্টা সংবাদের সাথেই",
            primaryColorHex = 0xFF4F46E5
        ),
        Newspaper(
            id = "bd24live",
            name = "BD24Live",
            banglaName = "বিডি২৪লাইভ",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://www.bd24live.com",
            rssUrl = null,
            tagline = "সত্য ও দ্রুততম অনলাইন খবর",
            primaryColorHex = 0xFFDC2626
        ),
        Newspaper(
            id = "bangla_tribune",
            name = "Bangla Tribune",
            banglaName = "বাংলা ট্রিবিউন",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://www.banglatribune.com",
            rssUrl = "https://www.banglatribune.com/rss/rss.xml",
            tagline = "খবর এখন হাতের মুঠোয়",
            primaryColorHex = 0xFF059669
        ),
        Newspaper(
            id = "jago_news_24",
            name = "Jago News 24",
            banglaName = "জাগো নিউজ ২৪",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://www.jagonews24.com",
            rssUrl = "https://www.jagonews24.com/rss/rss.xml",
            tagline = "বস্তুনিষ্ঠ সংবাদের অঙ্গীকার",
            primaryColorHex = 0xFFEA580C
        ),
        Newspaper(
            id = "risingbd",
            name = "Risingbd",
            banglaName = "রাইজিংবিডি",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://www.risingbd.com",
            rssUrl = "https://www.risingbd.com/rss.xml",
            tagline = "পজিটিভ বাংলাদেশ বিনির্মাণে",
            primaryColorHex = 0xFF2563EB
        ),
        Newspaper(
            id = "dhakatimes24",
            name = "DhakaTimes24",
            banglaName = "ঢাকা টাইমস ২৪",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://www.dhakatimes24.com",
            rssUrl = null,
            tagline = "নির্ভীক নিরপেক্ষ সংবাদ",
            primaryColorHex = 0xFF0D9488
        ),
        Newspaper(
            id = "amadershomoy_online",
            name = "AmaderShomoy.com",
            banglaName = "আমাদের সময় ডট কম",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://amadershomoy.com",
            rssUrl = null,
            tagline = "ডিজিটাল খবর ও বিশ্লেষণ",
            primaryColorHex = 0xFF7C3AED
        ),
        Newspaper(
            id = "mtnews24",
            name = "MTnews24",
            banglaName = "এমটিনিউজ২৪",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://mtnews24.com",
            rssUrl = null,
            tagline = "আপসহীন মুক্ত সংবাদ",
            primaryColorHex = 0xFFE11D48
        ),
        Newspaper(
            id = "dhaka_post",
            name = "Dhaka Post",
            banglaName = "ঢাকা পোস্ট",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://dhakapost.com",
            rssUrl = null,
            tagline = "সর্বশেষ ও ব্রেকিং নিউজ",
            primaryColorHex = 0xFF0284C7
        ),
        Newspaper(
            id = "bangladesh_times",
            name = "Bangladesh Times",
            banglaName = "বাংলাদেশ টাইমস",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://bangladeshtimes.com",
            rssUrl = null,
            tagline = "বাংলাদেশের কণ্ঠস্বর",
            primaryColorHex = 0xFF15803D
        ),
        Newspaper(
            id = "sarabangla",
            name = "Sarabangla",
            banglaName = "সারাবাংলা",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://sarabangla.net",
            rssUrl = null,
            tagline = "সারাবাংলার সব খবর",
            primaryColorHex = 0xFFD97706
        ),
        Newspaper(
            id = "barta24",
            name = "Barta24",
            banglaName = "বার্তা২৪",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://barta24.com",
            rssUrl = null,
            tagline = "ভিজ্যুয়াল জার্নালিজমের নতুন ধারা",
            primaryColorHex = 0xFF9333EA
        ),
        Newspaper(
            id = "shomoyer_alo",
            name = "Shomoyer Alo",
            banglaName = "সময়ের আলো",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://www.shomoyeralo.com",
            rssUrl = null,
            tagline = "সত্যের নির্ভীক প্রকাশ",
            primaryColorHex = 0xFFB45309
        ),
        Newspaper(
            id = "dmp_news",
            name = "DMP News",
            banglaName = "ডিএমপি নিউজ",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://dmpnews.org",
            rssUrl = null,
            tagline = "আইন শৃঙ্খলা ও নাগরিক তথ্য",
            primaryColorHex = 0xFF1E3A8A
        ),
        Newspaper(
            id = "bd_morning",
            name = "BD Morning",
            banglaName = "বিডি মর্নিং",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://bdmorning.com",
            rssUrl = null,
            tagline = "সকালের নতুন খবর",
            primaryColorHex = 0xFF047857
        ),
        Newspaper(
            id = "bangla_telegraph",
            name = "Bangla Telegraph",
            banglaName = "বাংলা টেলিগ্রাফ",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://banglatelegraph.com",
            rssUrl = null,
            tagline = "দূরদর্শী গণমাধ্যম",
            primaryColorHex = 0xFFBE185D
        ),
        Newspaper(
            id = "last_news_bd",
            name = "Last News BD",
            banglaName = "লাস্ট নিউজ বিডি",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://lastnewsbd.com",
            rssUrl = null,
            tagline = "লেটেস্ট ব্রেকিং নিউজ",
            primaryColorHex = 0xFFB91C1C
        ),
        Newspaper(
            id = "zoom_bangla",
            name = "Zoom Bangla",
            banglaName = "জুম বাংলা",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://zoombangla.com",
            rssUrl = null,
            tagline = "অনলাইন ট্রেন্ড ও খবর",
            primaryColorHex = 0xFF0891B2
        ),
        Newspaper(
            id = "somoyer_konthosor",
            name = "Somoyer Konthosor",
            banglaName = "সময়ের কণ্ঠস্বর",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://www.somoyerkonthosor.com",
            rssUrl = null,
            tagline = "প্রতি মুহূর্তের জীবন্ত সংবাদ",
            primaryColorHex = 0xFF6D28D9
        ),
        Newspaper(
            id = "the_report_24",
            name = "The Report 24",
            banglaName = "দ্য রিপোর্ট ২৪",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://thereport24.com",
            rssUrl = null,
            tagline = "ইন-ডেপথ রিপোর্ট ও অনুসন্ধান",
            primaryColorHex = 0xFF1D4ED8
        ),
        Newspaper(
            id = "just_news_bd",
            name = "Just News BD",
            banglaName = "জাস্ট নিউজ বিডি",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://justnewsbd.com",
            rssUrl = null,
            tagline = "ন্যায় ও নিষ্ঠার প্রতীক",
            primaryColorHex = 0xFF991B1B
        ),
        Newspaper(
            id = "bbarta24",
            name = "BBarta24",
            banglaName = "বিবার্তা২৪",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://bbarta24.net",
            rssUrl = null,
            tagline = "সত্য প্রকাশের অঙ্গীকার",
            primaryColorHex = 0xFF059669
        ),
        Newspaper(
            id = "barta_bazar",
            name = "Barta Bazar",
            banglaName = "বার্তা বাজার",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://bartabazar.com",
            rssUrl = null,
            tagline = "সারাদেশের সংবাদের হাট",
            primaryColorHex = 0xFFD97706
        ),
        Newspaper(
            id = "dhaka_today",
            name = "Dhaka Today",
            banglaName = "ঢাকা টুডে",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://dhakatoday.com",
            rssUrl = null,
            tagline = "রাজধানী ও দেশের খবর",
            primaryColorHex = 0xFF0284C7
        ),
        Newspaper(
            id = "gonokantho",
            name = "Gonokantho",
            banglaName = "গণকণ্ঠ",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://gonokantho.com",
            rssUrl = null,
            tagline = "গণমানুষের মনের কথা",
            primaryColorHex = 0xFFEA580C
        ),
        Newspaper(
            id = "fair_news_service",
            name = "Fair News Service",
            banglaName = "ফেয়ার নিউজ সার্ভিস",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://fairnewsservice.com",
            rssUrl = null,
            tagline = "ন্যায্য ও নির্ভরযোগ্য সংবাদ",
            primaryColorHex = 0xFF15803D
        ),
        Newspaper(
            id = "politics_news_24",
            name = "Politics News 24",
            banglaName = "পলিটিক্স নিউজ ২৪",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://politicsnews24.com",
            rssUrl = null,
            tagline = "রাজনীতির অন্দরের খবর",
            primaryColorHex = 0xFFB91C1C
        ),
        Newspaper(
            id = "uttaradhikar_71_news",
            name = "Uttaradhikar 71 News",
            banglaName = "উত্তরাধিকার ৭১ নিউজ",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://uttaradhikar71news.com",
            rssUrl = null,
            tagline = "মুক্তিযুদ্ধের চেতনায় উজ্জ্বল",
            primaryColorHex = 0xFF0D9488
        ),
        Newspaper(
            id = "bd_view_24",
            name = "BD View 24",
            banglaName = "বিডি ভিউ ২৪",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://bdview24.com",
            rssUrl = null,
            tagline = "সব দৃষ্টিভঙ্গির খবর",
            primaryColorHex = 0xFF4F46E5
        ),
        Newspaper(
            id = "fulki",
            name = "Fulki",
            banglaName = "ফুলকি",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://fulki.news",
            rssUrl = null,
            tagline = "আলো ছড়ানো খবর",
            primaryColorHex = 0xFFE11D48
        ),
        Newspaper(
            id = "dhaka_news_24",
            name = "Dhaka News 24",
            banglaName = "ঢাকা নিউজ ২৪",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://dhakanews24.com",
            rssUrl = null,
            tagline = "দ্রুততম ঢাকা সংবাদ",
            primaryColorHex = 0xFF047857
        ),
        Newspaper(
            id = "amader_protidin",
            name = "Amader Protidin",
            banglaName = "আমাদের প্রতিদিন",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://amaderprotidin.com",
            rssUrl = null,
            tagline = "প্রতিদিনের সত্য তথ্য",
            primaryColorHex = 0xFF7C3AED
        ),
        Newspaper(
            id = "natun_barta",
            name = "Natun Barta",
            banglaName = "নতুন বার্তা",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://natunbarta.com",
            rssUrl = null,
            tagline = "নতুন বার্তা নতুন আশায়",
            primaryColorHex = 0xFF0891B2
        ),
        Newspaper(
            id = "united_news_24",
            name = "United News 24",
            banglaName = "ইউনাইটেড নিউজ ২৪",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://unitednews24.com",
            rssUrl = null,
            tagline = "সংহতি ও সংবাদের সম্মিলন",
            primaryColorHex = 0xFF1E3A8A
        ),
        Newspaper(
            id = "dhaka_protidin",
            name = "Dhaka Protidin",
            banglaName = "ঢাকা প্রতিদিন",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://dhakaprotidin.com",
            rssUrl = null,
            tagline = "প্রতিদিনের তাজা খবর",
            primaryColorHex = 0xFFDC2626
        ),
        Newspaper(
            id = "bangla_post_bd",
            name = "Bangla Post BD",
            banglaName = "বাংলা পোস্ট বিডি",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://banglapostbd.com",
            rssUrl = null,
            tagline = "বিশ্বজুড়ে বাংলাভাষীর জন্য",
            primaryColorHex = 0xFF2563EB
        ),
        Newspaper(
            id = "sorejomin_barta",
            name = "Sorejomin Barta",
            banglaName = "সরেজমিন বার্তা",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://sorejominbarta.com",
            rssUrl = null,
            tagline = "মাঠপর্যায়ের সত্য চিত্র",
            primaryColorHex = 0xFFB45309
        ),
        Newspaper(
            id = "alokito_protidin",
            name = "Alokito Protidin",
            banglaName = "আলোকিত প্রতিদিন",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://alokitoprotidin.com",
            rssUrl = null,
            tagline = "সত্যের আলোয় উদ্ভাসিত",
            primaryColorHex = 0xFF15803D
        ),
        Newspaper(
            id = "prothom_khabor",
            name = "Prothom Khabor",
            banglaName = "প্রথম খবর",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://prothomkhabor.com",
            rssUrl = null,
            tagline = "সবার আগে প্রথম খবর",
            primaryColorHex = 0xFFD97706
        ),
        Newspaper(
            id = "barta_bangla",
            name = "Barta Bangla",
            banglaName = "বার্তা বাংলা",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://bartabangla.com",
            rssUrl = null,
            tagline = "বাংলার বার্তা ঘরে ঘরে",
            primaryColorHex = 0xFF9333EA
        ),
        Newspaper(
            id = "news71_online",
            name = "News71 Online",
            banglaName = "নিউজ ৭১ অনলাইন",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://news71online.com",
            rssUrl = null,
            tagline = "একাত্তরের প্রেরণায় পরিচালিত",
            primaryColorHex = 0xFFB91C1C
        ),
        Newspaper(
            id = "latest_bd_news",
            name = "Latest BD News",
            banglaName = "লেটেস্ট বিডি নিউজ",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://latestbdnews.com",
            rssUrl = null,
            tagline = "তাত্ক্ষণিক খবরের পোর্টাল",
            primaryColorHex = 0xFF0284C7
        ),
        Newspaper(
            id = "one_news_bd",
            name = "One News BD",
            banglaName = "ওয়ান নিউজ বিডি",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://onenewsbd.com",
            rssUrl = null,
            tagline = "এক ঠিকানায় সব খবর",
            primaryColorHex = 0xFF059669
        ),
        Newspaper(
            id = "khola_kagoj",
            name = "Khola Kagoj",
            banglaName = "খোলা কাগজ",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://kholakagojbd.com",
            rssUrl = null,
            tagline = "খোলা মনের খোলামেলা সংবাদ",
            primaryColorHex = 0xFFEA580C
        ),
        Newspaper(
            id = "bahumatrik",
            name = "Bahumatrik",
            banglaName = "বহুমাত্রিক",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://bahumatrik.com",
            rssUrl = null,
            tagline = "বহুমাত্রিক সংবাদের ভাণ্ডার",
            primaryColorHex = 0xFF4338CA
        ),
        Newspaper(
            id = "shotto_bani",
            name = "Shotto Bani",
            banglaName = "সত্য বাণী",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://shottobani.com",
            rssUrl = null,
            tagline = "সত্য প্রকাশে নির্দ্বিধায়",
            primaryColorHex = 0xFF0D9488
        ),
        Newspaper(
            id = "lakhokantho",
            name = "Lakhokantho",
            banglaName = "লাখোকণ্ঠ",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://lakhokantho.com",
            rssUrl = null,
            tagline = "লাখো মানুষের জাগ্রত কণ্ঠ",
            primaryColorHex = 0xFFE11D48
        ),
        Newspaper(
            id = "medivoice",
            name = "MediVoice",
            banglaName = "মেডিভয়েস",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://medivoicebd.com",
            rssUrl = null,
            tagline = "দেশের শীর্ষ স্বাস্থ্য ও চিকিৎসা সংবাদ",
            primaryColorHex = 0xFF047857
        ),
        Newspaper(
            id = "sangbad_protidin_24",
            name = "Sangbad Protidin 24",
            banglaName = "সংবাদ প্রতিদিন ২৪",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://sangbadprotidin24.com",
            rssUrl = null,
            tagline = "প্রতিদিনের সার্বক্ষণিক তথ্য",
            primaryColorHex = 0xFF1E3A8A
        ),
        Newspaper(
            id = "khobor_protidin_24",
            name = "Khobor Protidin 24",
            banglaName = "খবর প্রতিদিন ২৪",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://khoborprotidin24.com",
            rssUrl = null,
            tagline = "তাৎক্ষণিক সংবাদের ঠিকানা",
            primaryColorHex = 0xFFB45309
        ),
        Newspaper(
            id = "khabor",
            name = "Khabor",
            banglaName = "খবর",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://khabor.com",
            rssUrl = null,
            tagline = "শুদ্ধ সংবাদ ও আপডেট",
            primaryColorHex = 0xFF7C3AED
        ),
        Newspaper(
            id = "bd_bulletin",
            name = "BD Bulletin",
            banglaName = "বিডি বুলেটিন",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://bdbulletin.com",
            rssUrl = null,
            tagline = "নিয়মিত সংবাদ বুলেটিন",
            primaryColorHex = 0xFFDC2626
        ),
        Newspaper(
            id = "bbc24_news",
            name = "BBC24 News",
            banglaName = "বিবিসি২৪ নিউজ",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://bbc24news.com",
            rssUrl = null,
            tagline = "আন্তর্জাতিক মানসম্পন্ন সংবাদ",
            primaryColorHex = 0xFF15803D
        ),
        Newspaper(
            id = "suprobhat",
            name = "Suprobhat",
            banglaName = "সুপ্রভাত",
            category = NewspaperCategory.ONLINE,
            websiteUrl = "https://suprobhat.com",
            rssUrl = null,
            tagline = "সুপ্রভাত বাংলাদেশ",
            primaryColorHex = 0xFF0284C7
        ),

        // ==================== 💼 BUSINESS (12) ====================
        Newspaper(
            id = "bonik_barta",
            name = "Bonik Barta",
            banglaName = "বণিক বার্তা",
            category = NewspaperCategory.BUSINESS,
            websiteUrl = "https://bonikbarta.net",
            rssUrl = null,
            tagline = "অর্থনীতি ও বাণিজ্যের অগ্রদূত",
            primaryColorHex = 0xFFD97706
        ),
        Newspaper(
            id = "arthosuchak",
            name = "ArthoSuchak",
            banglaName = "অর্থসূচক",
            category = NewspaperCategory.BUSINESS,
            websiteUrl = "https://arthosuchak.com",
            rssUrl = null,
            tagline = "পুঁজিবাজার ও অর্থনীতির বিশ্বস্ত বিশ্লেষণ",
            primaryColorHex = 0xFF15803D
        ),
        Newspaper(
            id = "sharenews24",
            name = "ShareNews24",
            banglaName = "শেয়ারনিউজ২৪",
            category = NewspaperCategory.BUSINESS,
            websiteUrl = "https://sharenews24.com",
            rssUrl = null,
            tagline = "শেয়ারবাজার ও কর্পোরেট সংবাদ",
            primaryColorHex = 0xFF2563EB
        ),
        Newspaper(
            id = "dhaka_stock_exchange",
            name = "Dhaka Stock Exchange",
            banglaName = "ঢাকা স্টক এক্সচেঞ্জ",
            category = NewspaperCategory.BUSINESS,
            websiteUrl = "https://dsebd.org",
            rssUrl = null,
            tagline = "ডিএসই লাইভ বাজার দর ও মূল্যসূচক",
            primaryColorHex = 0xFF1E3A8A
        ),
        Newspaper(
            id = "ajker_bazzar",
            name = "Ajker Bazzar",
            banglaName = "আজকের বাজার",
            category = NewspaperCategory.BUSINESS,
            websiteUrl = "https://ajkerbazzar.com",
            rssUrl = null,
            tagline = "দ্রব্যমূল্য ও ব্যবসার খবর",
            primaryColorHex = 0xFFEA580C
        ),
        Newspaper(
            id = "share_bazar_news",
            name = "Share Bazar News",
            banglaName = "শেয়ার বাজার নিউজ",
            category = NewspaperCategory.BUSINESS,
            websiteUrl = "https://sharebazarnews.com",
            rssUrl = null,
            tagline = "পুঁজিবাজারের প্রতিটি মুহূর্তের তথ্য",
            primaryColorHex = 0xFF0D9488
        ),
        Newspaper(
            id = "sharebarta24",
            name = "ShareBarta24",
            banglaName = "শেয়ারবার্তা২৪",
            category = NewspaperCategory.BUSINESS,
            websiteUrl = "https://sharebarta24.com",
            rssUrl = null,
            tagline = "বিনিয়োগকারীদের সহায়ক তথ্যসূত্র",
            primaryColorHex = 0xFF059669
        ),
        Newspaper(
            id = "sharemarket_bd",
            name = "ShareMarketBD",
            banglaName = "শেয়ারমার্কেট বিডি",
            category = NewspaperCategory.BUSINESS,
            websiteUrl = "https://sharemarketbd.com",
            rssUrl = null,
            tagline = "বাংলাদেশ শেয়ারমার্কেট পোর্টাল",
            primaryColorHex = 0xFFB45309
        ),
        Newspaper(
            id = "share_biz",
            name = "Share Biz",
            banglaName = "শেয়ার বিজ",
            category = NewspaperCategory.BUSINESS,
            websiteUrl = "https://sharebiz.net",
            rssUrl = null,
            tagline = "করপোরেট সুশাসন ও আর্থিক বিশ্লেষণ",
            primaryColorHex = 0xFF0284C7
        ),
        Newspaper(
            id = "business24bd",
            name = "Business24BD",
            banglaName = "বিজনেস২৪ বিডি",
            category = NewspaperCategory.BUSINESS,
            websiteUrl = "https://business24bd.com",
            rssUrl = null,
            tagline = "ব্যবসা ও বাণিজ্যের সার্বক্ষণিক আপডেট",
            primaryColorHex = 0xFF7C3AED
        ),
        Newspaper(
            id = "bank_bima_shilpa",
            name = "Bank Bima Shilpa",
            banglaName = "ব্যাংক বীমা শিল্প",
            category = NewspaperCategory.BUSINESS,
            websiteUrl = "https://bankbimashilpa.com",
            rssUrl = null,
            tagline = "ব্যাংকিং ও আর্থিক খাতের বিশ্বস্ত আয়না",
            primaryColorHex = 0xFF047857
        ),
        Newspaper(
            id = "arthoniteer_kagoj",
            name = "Arthoniteer Kagoj",
            banglaName = "অর্থনীতির কাগজ",
            category = NewspaperCategory.BUSINESS,
            websiteUrl = "https://arthoniteerkagoj.com",
            rssUrl = null,
            tagline = "জাতীয় অর্থনীতির দিকদর্শন",
            primaryColorHex = 0xFF991B1B
        ),

        // ==================== 🏏 SPORTS (5) ====================
        Newspaper(
            id = "bdcrictime",
            name = "bdcrictime",
            banglaName = "বিডিক্রিকটাইম",
            category = NewspaperCategory.SPORTS,
            websiteUrl = "https://www.bdcrictime.com",
            rssUrl = null,
            tagline = "বাংলাদেশ ক্রিকেট ও খেলার লাইভ আপডেট",
            primaryColorHex = 0xFF15803D
        ),
        Newspaper(
            id = "t_sports",
            name = "T Sports",
            banglaName = "টি স্পোর্টস",
            category = NewspaperCategory.SPORTS,
            websiteUrl = "https://tsports.com",
            rssUrl = null,
            tagline = "দেশের একমাত্র পূর্ণাঙ্গ স্পোর্টস চ্যানেল",
            primaryColorHex = 0xFFDC2626
        ),
        Newspaper(
            id = "cricfrenzy",
            name = "Cricfrenzy",
            banglaName = "ক্রিকফ্রেনজি",
            category = NewspaperCategory.SPORTS,
            websiteUrl = "https://cricfrenzy.com",
            rssUrl = null,
            tagline = "ক্রিকেট উন্মাদনার নির্ভরযোগ্য পোর্টাল",
            primaryColorHex = 0xFF2563EB
        ),
        Newspaper(
            id = "sportsmail24",
            name = "Sportsmail24.com",
            banglaName = "স্পোর্টসমেইল২৪",
            category = NewspaperCategory.SPORTS,
            websiteUrl = "https://sportsmail24.com",
            rssUrl = null,
            tagline = "বিশ্ব ক্রীড়াঙ্গনের টাটকা সংবাদ",
            primaryColorHex = 0xFFD97706
        ),
        Newspaper(
            id = "offside_bangladesh",
            name = "Offside Bangladesh",
            banglaName = "অফসাইড বাংলাদেশ",
            category = NewspaperCategory.SPORTS,
            websiteUrl = "https://offsidebangladesh.com",
            rssUrl = null,
            tagline = "দেশি ফুটবল ও আন্তর্জাতিক ক্রীড়া খবর",
            primaryColorHex = 0xFF0D9488
        ),

        // ==================== 🎓 EDUCATION (3) ====================
        Newspaper(
            id = "dainik_shiksha",
            name = "Dainik Shiksha",
            banglaName = "দৈনিক শিক্ষা",
            category = NewspaperCategory.EDUCATION,
            websiteUrl = "https://www.dainikshiksha.com",
            rssUrl = null,
            tagline = "শিক্ষা ও শিক্ষকদের প্রথম জাতীয় পত্রিকা",
            primaryColorHex = 0xFF0284C7
        ),
        Newspaper(
            id = "the_daily_campus",
            name = "The Daily Campus",
            banglaName = "দ্য ডেইলি ক্যাম্পাস",
            category = NewspaperCategory.EDUCATION,
            websiteUrl = "https://thedailycampus.com",
            rssUrl = null,
            tagline = "বিশ্ববিদ্যালয় ও ক্যাম্পাস জীবনের সার্বক্ষণিক খবর",
            primaryColorHex = 0xFF15803D
        ),
        Newspaper(
            id = "shikkhabarta",
            name = "Shikkhabarta",
            banglaName = "শিক্ষাবার্তা",
            category = NewspaperCategory.EDUCATION,
            websiteUrl = "https://shikkhabarta.com",
            rssUrl = null,
            tagline = "শিক্ষা ও ভর্তি সংক্রান্ত যাবতীয় তথ্য",
            primaryColorHex = 0xFF7C3AED
        ),

        // ==================== 🇬🇧 ENGLISH (12) ====================
        Newspaper(
            id = "the_daily_star",
            name = "Daily Star",
            banglaName = "দ্য ডেইলি স্টার",
            category = NewspaperCategory.ENGLISH,
            websiteUrl = "https://www.thedailystar.net",
            rssUrl = "https://www.thedailystar.net/frontpage/rss.xml",
            tagline = "Journalism Without Fear or Favour",
            primaryColorHex = 0xFF1E3A8A
        ),
        Newspaper(
            id = "dhaka_tribune",
            name = "Dhaka Tribune",
            banglaName = "ঢাকা ট্রিবিউন",
            category = NewspaperCategory.ENGLISH,
            websiteUrl = "https://www.dhakatribune.com",
            rssUrl = "https://www.dhakatribune.com/rss",
            tagline = "News you can trust",
            primaryColorHex = 0xFFBE185D
        ),
        Newspaper(
            id = "new_age",
            name = "New Age",
            banglaName = "নিউ এজ",
            category = NewspaperCategory.ENGLISH,
            websiteUrl = "https://www.newagebd.net",
            rssUrl = null,
            tagline = "The Outspoken Daily",
            primaryColorHex = 0xFFDC2626
        ),
        Newspaper(
            id = "daily_sun",
            name = "Daily Sun",
            banglaName = "ডেইলি সান",
            category = NewspaperCategory.ENGLISH,
            websiteUrl = "https://www.daily-sun.com",
            rssUrl = "https://www.daily-sun.com/rss",
            tagline = "True and Impartial",
            primaryColorHex = 0xFFCA8A04
        ),
        Newspaper(
            id = "financial_express",
            name = "Financial Express",
            banglaName = "ফাইন্যান্সিয়াল এক্সপ্রেস",
            category = NewspaperCategory.ENGLISH,
            websiteUrl = "https://thefinancialexpress.com.bd",
            rssUrl = "https://thefinancialexpress.com.bd/rss",
            tagline = "First Financial Daily in Bangladesh",
            primaryColorHex = 0xFF15803D
        ),
        Newspaper(
            id = "the_daily_observer",
            name = "Observer",
            banglaName = "অবজারভার",
            category = NewspaperCategory.ENGLISH,
            websiteUrl = "https://observerbd.com",
            rssUrl = null,
            tagline = "Reflecting truth in objective journalism",
            primaryColorHex = 0xFF0D9488
        ),
        Newspaper(
            id = "the_bangladesh_today",
            name = "Bangladesh Today",
            banglaName = "বাংলাদেশ টুডে",
            category = NewspaperCategory.ENGLISH,
            websiteUrl = "https://thebangladeshtoday.com",
            rssUrl = null,
            tagline = "Voice of the Emerging Nation",
            primaryColorHex = 0xFF059669
        ),
        Newspaper(
            id = "the_asian_age",
            name = "Asian Age",
            banglaName = "এশিয়ান এজ",
            category = NewspaperCategory.ENGLISH,
            websiteUrl = "https://dailyasianage.com",
            rssUrl = null,
            tagline = "Independent and Progressive",
            primaryColorHex = 0xFF4F46E5
        ),
        Newspaper(
            id = "prothom_alo_english",
            name = "Prothom Alo English",
            banglaName = "প্রথম আলো ইংরেজি",
            category = NewspaperCategory.ENGLISH,
            websiteUrl = "https://en.prothomalo.com",
            rssUrl = null,
            tagline = "Bangladesh in Global Perspective",
            primaryColorHex = 0xFFD8232A
        ),
        Newspaper(
            id = "bangladesh_post",
            name = "Bangladesh Post",
            banglaName = "বাংলাদেশ পোস্ট",
            category = NewspaperCategory.ENGLISH,
            websiteUrl = "https://bangladeshpost.net",
            rssUrl = null,
            tagline = "Committed to National Progress",
            primaryColorHex = 0xFF2563EB
        ),
        Newspaper(
            id = "energy_bangla",
            name = "Energy Bangla",
            banglaName = "এনার্জি বাংলা",
            category = NewspaperCategory.ENGLISH,
            websiteUrl = "https://energybangla.com",
            rssUrl = null,
            tagline = "Energy, Power & Sustainable Resources",
            primaryColorHex = 0xFFEA580C
        ),
        Newspaper(
            id = "good_morning",
            name = "Good Morning",
            banglaName = "গুড মর্নিং",
            category = NewspaperCategory.ENGLISH,
            websiteUrl = "https://dailygoodmorning.com",
            rssUrl = null,
            tagline = "Daily Insightful English Digest",
            primaryColorHex = 0xFFB45309
        ),

        // ==================== 📰 NEWS AGENCIES (3) ====================
        Newspaper(
            id = "bss_news",
            name = "BSS News",
            banglaName = "বাংলাদেশ সংবাদ সংস্থা (বাসস)",
            category = NewspaperCategory.AGENCIES,
            websiteUrl = "https://www.bssnews.net",
            rssUrl = null,
            tagline = "National News Agency of Bangladesh",
            primaryColorHex = 0xFF047857
        ),
        Newspaper(
            id = "unb_news",
            name = "UNB",
            banglaName = "ইউনাইটেড নিউজ অব বাংলাদেশ",
            category = NewspaperCategory.AGENCIES,
            websiteUrl = "https://unb.com.bd",
            rssUrl = null,
            tagline = "Independent Wire Service in South Asia",
            primaryColorHex = 0xFF1D4ED8
        ),
        Newspaper(
            id = "ena_news",
            name = "Eastern News Agency (ENA)",
            banglaName = "ইস্টার্ন নিউজ এজেন্সি",
            category = NewspaperCategory.AGENCIES,
            websiteUrl = "https://enabd.com",
            rssUrl = null,
            tagline = "First Private News Agency in Bangladesh",
            primaryColorHex = 0xFF991B1B
        ),

        // ==================== 🌎 INTERNATIONAL (5) ====================
        Newspaper(
            id = "bbc_bangla",
            name = "BBC Bangla",
            banglaName = "বিবিসি বাংলা",
            category = NewspaperCategory.INTERNATIONAL,
            websiteUrl = "https://www.bbc.com/bengali",
            rssUrl = "https://feeds.bbci.co.uk/bengali/rss.xml",
            tagline = "বিশ্বজুড়ে কোটি কোটি বাঙালির বিশ্বাস",
            primaryColorHex = 0xFFB91C1C
        ),
        Newspaper(
            id = "voa_bangla",
            name = "VOA Bangla",
            banglaName = "ভয়েস অব আমেরিকা বাংলা",
            category = NewspaperCategory.INTERNATIONAL,
            websiteUrl = "https://www.voabangla.com",
            rssUrl = null,
            tagline = "আন্তর্জাতিক সংবাদ ও আমেরিকা পরিপ্রেক্ষিত",
            primaryColorHex = 0xFF1E3A8A
        ),
        Newspaper(
            id = "dw_bangla",
            name = "DW Bangla",
            banglaName = "ডয়চে ভেলে বাংলা",
            category = NewspaperCategory.INTERNATIONAL,
            websiteUrl = "https://www.dw.com/bn",
            rssUrl = null,
            tagline = "জার্মানি ও আন্তর্জাতিক নিরপেক্ষ সংবাদ",
            primaryColorHex = 0xFF0284C7
        ),
        Newspaper(
            id = "nhk_world_bangla",
            name = "NHK World Bangla",
            banglaName = "এনএইচকে ওয়ার্ল্ড বাংলা",
            category = NewspaperCategory.INTERNATIONAL,
            websiteUrl = "https://www3.nhk.or.jp/nhkworld/bn",
            rssUrl = null,
            tagline = "জাপানের আন্তর্জাতিক সম্প্রচার পরিষেবা",
            primaryColorHex = 0xFFEA580C
        ),
        Newspaper(
            id = "cri_bangla",
            name = "CRI Bangla",
            banglaName = "সিআরআই বাংলা",
            category = NewspaperCategory.INTERNATIONAL,
            websiteUrl = "https://bengali.cri.cn",
            rssUrl = null,
            tagline = "চীন আন্তর্জাতিক বেতার বাংলা বিভাগ",
            primaryColorHex = 0xFFC026D3
        ),

        // ==================== 📺 TV NEWS & BROADCAST CHANNELS (27) ====================
        // --- 1. News TV Channels ---
        Newspaper(
            id = "somoy_tv",
            name = "Somoy TV",
            banglaName = "সময় টিভি",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.somoynews.tv",
            rssUrl = null,
            tagline = "সব সময় সব খবরের সাথে",
            primaryColorHex = 0xFFDC2626
        ),
        Newspaper(
            id = "jamuna_tv",
            name = "Jamuna TV",
            banglaName = "যমুনা টিভি",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.jamuna.tv",
            rssUrl = null,
            tagline = "২৪ ঘণ্টার খবরের সঙ্গী",
            primaryColorHex = 0xFFB91C1C
        ),
        Newspaper(
            id = "independent_tv",
            name = "Independent TV",
            banglaName = "ইনডিপেনডেন্ট টিভি",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.itvbd.com",
            rssUrl = null,
            tagline = "স্পষ্ট ও নিরপেক্ষ সংবাদ",
            primaryColorHex = 0xFF2563EB
        ),
        Newspaper(
            id = "channel_24",
            name = "Channel 24",
            banglaName = "চ্যানেল ২৪",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.channel24bd.tv",
            rssUrl = null,
            tagline = "২৪ ঘণ্টার সংবাদ চ্যানেল",
            primaryColorHex = 0xFFEA580C
        ),
        Newspaper(
            id = "ekattor_tv",
            name = "Ekattor TV",
            banglaName = "একাত্তর টিভি",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://ekattor.tv",
            rssUrl = null,
            tagline = "সংবাদ নয়, সত্য প্রকাশে একাত্তর",
            primaryColorHex = 0xFF047857
        ),
        Newspaper(
            id = "atn_news",
            name = "ATN News",
            banglaName = "এটিএন নিউজ",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.atnnewstv.com",
            rssUrl = null,
            tagline = "প্রথম ২৪ ঘণ্টার সংবাদ চ্যানেল",
            primaryColorHex = 0xFF1D4ED8
        ),
        Newspaper(
            id = "dbc_news",
            name = "DBC News",
            banglaName = "ডিবিসি নিউজ",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://dbcnews.tv",
            rssUrl = null,
            tagline = "নির্ভীক সংবাদের প্রতিচ্ছবি",
            primaryColorHex = 0xFFBE185D
        ),
        Newspaper(
            id = "news24_tv",
            name = "NEWS24",
            banglaName = "নিউজ ২৪",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.news24bd.tv",
            rssUrl = null,
            tagline = "সত্যের সন্ধানে সার্বক্ষণিক",
            primaryColorHex = 0xFFB45309
        ),
        Newspaper(
            id = "ekhon_tv",
            name = "Ekhon TV",
            banglaName = "এখন টিভি",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://ekhon.tv",
            rssUrl = null,
            tagline = "ব্যবসা ও অর্থনীতির ২৪ ঘণ্টার সংবাদ",
            primaryColorHex = 0xFF0D9488
        ),
        Newspaper(
            id = "btv_news",
            name = "BTV News",
            banglaName = "বিটিভি নিউজ",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://btv.gov.bd",
            rssUrl = null,
            tagline = "বাংলাদেশ টেলিভিশনের সার্বক্ষণিক সংবাদ",
            primaryColorHex = 0xFF15803D
        ),

        // --- 2. General Entertainment TV Channels ---
        Newspaper(
            id = "channel_i",
            name = "Channel i",
            banglaName = "চ্যানেল আই",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.channelionline.com",
            rssUrl = null,
            tagline = "হৃদয়ে বাংলাদেশ",
            primaryColorHex = 0xFF16A34A
        ),
        Newspaper(
            id = "atn_bangla",
            name = "ATN Bangla",
            banglaName = "এটিএন বাংলা",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.atnbangla.tv",
            rssUrl = null,
            tagline = "অবিরাম বাংলার মুখ",
            primaryColorHex = 0xFF1E40AF
        ),
        Newspaper(
            id = "ntv_bd",
            name = "NTV",
            banglaName = "এনটিভি",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.ntvbd.com",
            rssUrl = null,
            tagline = "সময়ের সাথে আগামীর পথে",
            primaryColorHex = 0xFF0284C7
        ),
        Newspaper(
            id = "rtv_online",
            name = "RTV",
            banglaName = "আরটিভি",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://rtvonline.com",
            rssUrl = null,
            tagline = "আজ এবং আগামী",
            primaryColorHex = 0xFFDC2626
        ),
        Newspaper(
            id = "bangla_vision",
            name = "Bangla Vision",
            banglaName = "বাংলাভিশন",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.bvnews24.com",
            rssUrl = null,
            tagline = "দৃষ্টি জুড়ে দেশ",
            primaryColorHex = 0xFF7C3AED
        ),
        Newspaper(
            id = "ekushey_tv",
            name = "Ekushey Television",
            banglaName = "একুশে টেলিভিশন",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.ekushey-tv.com",
            rssUrl = null,
            tagline = "পরিবর্তনে অঙ্গীকারবদ্ধ",
            primaryColorHex = 0xFFB91C1C
        ),
        Newspaper(
            id = "boishakhi_tv",
            name = "Boishakhi TV",
            banglaName = "বৈশাখী টিভি",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.boishakhionline.com",
            rssUrl = null,
            tagline = "বাঙালির প্রাণের উৎসব",
            primaryColorHex = 0xFFEA580C
        ),
        Newspaper(
            id = "maasranga_tv",
            name = "Maasranga TV",
            banglaName = "মাছরাঙা টিভি",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://maasranga.tv",
            rssUrl = null,
            tagline = "রঙে রঙে রঙিন জীবন",
            primaryColorHex = 0xFF059669
        ),
        Newspaper(
            id = "desh_tv",
            name = "Desh TV",
            banglaName = "দেশ টিভি",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.desh.tv",
            rssUrl = null,
            tagline = "সবার জন্য দেশ",
            primaryColorHex = 0xFF0284C7
        ),
        Newspaper(
            id = "my_tv",
            name = "My TV",
            banglaName = "মাই টিভি",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://mytvbd.tv",
            rssUrl = null,
            tagline = "আমার টিভি মাই টিভি",
            primaryColorHex = 0xFF9333EA
        ),
        Newspaper(
            id = "satv_bd",
            name = "SATV",
            banglaName = "এসএটিভি",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.satv.tv",
            rssUrl = null,
            tagline = "সাউথ এশিয়ান টেলিভিশন",
            primaryColorHex = 0xFFE11D48
        ),
        Newspaper(
            id = "deepto_tv",
            name = "Deepto TV",
            banglaName = "দীপ্ত টিভি",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.deepto.tv",
            rssUrl = null,
            tagline = "আলোয় আলোয় দীপ্ত",
            primaryColorHex = 0xFFF59E0B
        ),
        Newspaper(
            id = "btv_national",
            name = "BTV",
            banglaName = "বাংলাদেশ টেলিভিশন (বিটিভি)",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://btv.gov.bd",
            rssUrl = null,
            tagline = "জাতীয় সম্প্রচার মাধ্যম",
            primaryColorHex = 0xFF15803D
        ),

        // --- 3. Sports & Music TV Channels ---
        Newspaper(
            id = "gazi_tv",
            name = "Gazi TV (GTV)",
            banglaName = "গাজী টিভি (জিটিভি)",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://www.gazitv.com",
            rssUrl = null,
            tagline = "লাইভ খেলা ও বিনোদন",
            primaryColorHex = 0xFFDC2626
        ),
        Newspaper(
            id = "t_sports_tv",
            name = "T Sports",
            banglaName = "টি স্পোর্টস",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://tsports.com",
            rssUrl = null,
            tagline = "দেশের একমাত্র পূর্ণাঙ্গ স্পোর্টস চ্যানেল",
            primaryColorHex = 0xFFDC2626
        ),
        Newspaper(
            id = "gaan_bangla",
            name = "Gaan Bangla",
            banglaName = "গান বাংলা",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://gaanbangla.tv",
            rssUrl = null,
            tagline = "মিউজিক ও সংস্কৃতির প্রথম চ্যানেল",
            primaryColorHex = 0xFF9333EA
        ),

        // --- 4. International Bengali TV Channels ---
        Newspaper(
            id = "channel_s_uk",
            name = "Channel S UK",
            banglaName = "চ্যানেল এস ইউকে",
            category = NewspaperCategory.TV_NEWS,
            websiteUrl = "https://chsuk.tv",
            rssUrl = null,
            tagline = "ভয়েস অব দ্য ব্রিটিশ বাংলাদেশি",
            primaryColorHex = 0xFFBE185D
        )
    )

    val allNewspapers: List<Newspaper> by lazy {
        _baseNewspapers + LocalNewspaperDataSource.localNewspapers + ExtraSourcesDataSource.extraSources
    }

    private val byIdMap: Map<String, Newspaper> by lazy {
        allNewspapers.associateBy { it.id }
    }

    private val byCategoryMap: Map<NewspaperCategory, List<Newspaper>> by lazy {
        allNewspapers.groupBy { it.category }
    }

    fun getById(id: String): Newspaper? = byIdMap[id]

    fun getByCategory(category: NewspaperCategory): List<Newspaper> {
        return if (category == NewspaperCategory.ALL) allNewspapers
        else byCategoryMap[category] ?: emptyList()
    }
}
