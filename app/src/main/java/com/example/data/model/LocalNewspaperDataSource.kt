package com.example.data.model

object LocalNewspaperDataSource {

    val regions: List<String> = listOf(
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

    val localNewspapers: List<Newspaper> = listOf(
        // ==========================================
        // 1. BARISHAL DIVISION (7)
        // ==========================================
        Newspaper(
            id = "daily_ajker_barta",
            name = "Daily Ajker Barta",
            banglaName = "দৈনিক আজকের বার্তা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://ajkerbarta.com",
            tagline = "বরিশাল বিভাগের প্রাচীন ও জনপ্রিয় আঞ্চলিক দৈনিক",
            primaryColorHex = 0xFF00796B,
            region = "Barishal Division"
        ),
        Newspaper(
            id = "barishal_bani",
            name = "Barishal Bani",
            banglaName = "বরিশাল বাণী",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://barishalbani.com",
            tagline = "দক্ষিণাঞ্চলের বস্তুনিষ্ঠ ও সাহসী কণ্ঠ",
            primaryColorHex = 0xFF0288D1,
            region = "Barishal Division"
        ),
        Newspaper(
            id = "ajker_paribartan",
            name = "Ajker Paribartan",
            banglaName = "আজকের পরিবর্তন",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://ajkerparibartan.com",
            tagline = "পরিবর্তনের প্রত্যয়ে দক্ষিণাঞ্চলের দৈনিক",
            primaryColorHex = 0xFFD32F2F,
            region = "Barishal Division"
        ),
        Newspaper(
            id = "ajker_bhola",
            name = "Ajker Bhola",
            banglaName = "আজকের ভোলা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://ajkerbhola.com",
            tagline = "দ্বীপজেলা ভোলার প্রথম ও সর্বাধিক প্রচারিত সংবাদপত্র",
            primaryColorHex = 0xFF388E3C,
            region = "Barishal Division"
        ),
        Newspaper(
            id = "barishal_times",
            name = "Barishal Times",
            banglaName = "বরিশাল টাইমস",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://barishaltimes.com",
            tagline = "বরিশালের জনপ্রিয় ও সর্বাধিক পঠিত অনলাইন নিউজ",
            primaryColorHex = 0xFF7B1FA2,
            region = "Barishal Division"
        ),
        Newspaper(
            id = "barisal_today",
            name = "Barisal Today",
            banglaName = "বরিশাল টুডে",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://barisaltoday.com",
            tagline = "বরিশালের তাজা সংবাদ প্রতি মুহূর্তের",
            primaryColorHex = 0xFFE64A19,
            region = "Barishal Division"
        ),
        Newspaper(
            id = "bhola_news",
            name = "Bhola News",
            banglaName = "ভোলা নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://bholanews.com",
            tagline = "ভোলার ২৪ ঘণ্টার তাজা খবর ও ফিচার",
            primaryColorHex = 0xFF0097A7,
            region = "Barishal Division"
        ),

        // ==========================================
        // 2. RANGPUR REGION (11)
        // ==========================================
        Newspaper(
            id = "amader_protidin",
            name = "Amader Protidin",
            banglaName = "আমাদের প্রতিদিন",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://amaderprotidin.com",
            tagline = "রংপুর বিভাগের প্রতিদিনের বস্তুনিষ্ঠ খবর",
            primaryColorHex = 0xFF00796B,
            region = "Rangpur Region"
        ),
        Newspaper(
            id = "dainik_poribesh",
            name = "Dainik Poribesh",
            banglaName = "দৈনিক পরিবেশ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dainikporibesh.com",
            tagline = "উত্তরাঞ্চলের গণমানুষের আস্থার প্রতীক",
            primaryColorHex = 0xFF2E7D32,
            region = "Rangpur Region"
        ),
        Newspaper(
            id = "daily_rangpur",
            name = "Daily Rangpur",
            banglaName = "ডেইলি রংপুর",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dailyrangpur.com",
            tagline = "রংপুরের সর্বশেষ সংবাদ ও উন্নয়নের তথ্য",
            primaryColorHex = 0xFFC2185B,
            region = "Rangpur Region"
        ),
        Newspaper(
            id = "rangpur24",
            name = "Rangpur24.com",
            banglaName = "রংপুর২৪ ডটকম",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://rangpur24.com",
            tagline = "রংপুরের ২৪ ঘণ্টার জনপ্রিয় অনলাইন পোর্টাল",
            primaryColorHex = 0xFFE65100,
            region = "Rangpur Region"
        ),
        Newspaper(
            id = "rangpur_news",
            name = "Rangpur News",
            banglaName = "রংপুর নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://rangpurnews.com",
            tagline = "রংপুর বিভাগের ৮ জেলার প্রতিটি মুহূর্তের খবর",
            primaryColorHex = 0xFF303F9F,
            region = "Rangpur Region"
        ),
        Newspaper(
            id = "chilahati_web",
            name = "Chilahati Web",
            banglaName = "চিলাহাটি ওয়েব",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://chilahatiweb.com",
            tagline = "নীলফামারী ও চিলাহাটি সীমান্তের বিশ্বস্ত কণ্ঠস্বর",
            primaryColorHex = 0xFF5D4037,
            region = "Rangpur Region"
        ),
        Newspaper(
            id = "dinajpur24",
            name = "dinajpur24.com",
            banglaName = "দিনাজপুর২৪ ডটকম",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dinajpur24.com",
            tagline = "দিনাজপুরের সংবাদ, ইতিহাস ও সংস্কৃতির দর্পণ",
            primaryColorHex = 0xFF1976D2,
            region = "Rangpur Region"
        ),
        Newspaper(
            id = "dinajpurbarta24",
            name = "dinajpurbarta24.com",
            banglaName = "দিনাজপুর বার্তা ২৪",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dinajpurbarta24.com",
            tagline = "দিনাজপুর অঞ্চলের প্রথম ও দ্রুততম বার্তা",
            primaryColorHex = 0xFF00897B,
            region = "Rangpur Region"
        ),
        Newspaper(
            id = "uttorbangla",
            name = "uttorbangla.com",
            banglaName = "উত্তরবাংলা ডটকম",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://uttorbangla.com",
            tagline = "উত্তরবঙ্গের বৃহত্তম ও নির্ভরযোগ্য সংবাদ নেটওয়ার্ক",
            primaryColorHex = 0xFFD81B60,
            region = "Rangpur Region"
        ),
        Newspaper(
            id = "jugerkhabor",
            name = "jugerkhabor.com",
            banglaName = "যুগের খবর ডটকম",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://jugerkhabor.com",
            tagline = "সময়ের সাহসী উচ্চারণ যুগের খবর",
            primaryColorHex = 0xFF4527A0,
            region = "Rangpur Region"
        ),
        Newspaper(
            id = "emadhukar",
            name = "emadhukar.com",
            banglaName = "ই মধুকর ডটকম",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://emadhukar.com",
            tagline = "কুড়িগ্রাম ও তিস্তাপাড়ের খবর সবার আগে",
            primaryColorHex = 0xFFF57C00,
            region = "Rangpur Region"
        ),

        // ==========================================
        // 3. SYLHET DIVISION (20)
        // ==========================================
        Newspaper(
            id = "sylheter_dak",
            name = "Sylheter Dak",
            banglaName = "সিলেটের ডাক",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://sylheterdak.com.bd",
            tagline = "সিলেট বিভাগের প্রাচীনতম ও ঐতিহ্যবাহী প্রধান দৈনিক",
            primaryColorHex = 0xFF0D6838,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "shyamal_sylhet",
            name = "Shyamal Sylhet",
            banglaName = "শ্যামল সিলেট",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://shyamalsylhet.com",
            tagline = "সিলেটের মাটি ও মানুষের মুখপত্র",
            primaryColorHex = 0xFF388E3C,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "daily_sylhet_mirror",
            name = "Daily Sylhet Mirror",
            banglaName = "দৈনিক সিলেট মিরর",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dailysylhetmirror.com",
            tagline = "সিলেটের প্রতিটি ঘটনার সঠিক দর্পণ",
            primaryColorHex = 0xFF0288D1,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "sylhet_today_24",
            name = "Sylhet Today 24",
            banglaName = "সিলেট টুডে ২৪",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://sylhettoday24.news",
            tagline = "সিলেটের আধুনিক ও জনপ্রিয় ডিজিটাল পোর্টাল",
            primaryColorHex = 0xFFD32F2F,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "beanibazar_times",
            name = "Beanibazar Times",
            banglaName = "বিয়ানীবাজার টাইমস",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://beanibazartimes.com",
            tagline = "বিয়ানীবাজার ও প্রবাসী বাঙালিদের বিশ্বস্ত সংবাদ",
            primaryColorHex = 0xFF7B1FA2,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "daily_jalalabad",
            name = "Daily Jalalabad",
            banglaName = "দৈনিক জালালাবাদ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dailyjalalabad.com",
            tagline = "ঐতিহাসিক জালালাবাদের ঐতিহ্যবাহী সংবাদ মাধ্যম",
            primaryColorHex = 0xFF1976D2,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "daily_sylhet_bani",
            name = "Daily Sylhet Bani",
            banglaName = "দৈনিক সিলেট বাণী",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dailysylhetbani.com",
            tagline = "সিলেটের মানুষের মুক্ত কণ্ঠস্বর",
            primaryColorHex = 0xFF00796B,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "habiganj_samachar",
            name = "Habiganj Samachar",
            banglaName = "হবিগঞ্জ সমাচার",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://habiganjsamachar.com",
            tagline = "হবিগঞ্জ জেলার শীর্ষস্থানীয় দৈনিক পত্রিকা",
            primaryColorHex = 0xFFE64A19,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "khowai",
            name = "Khowai",
            banglaName = "দৈনিক খোয়াই",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://khowai.com",
            tagline = "খোয়াই নদীপাড়ের মানুষের সুখ-দুঃখের কথা",
            primaryColorHex = 0xFF0097A7,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "uttorpurbo",
            name = "Uttorpurbo",
            banglaName = "দৈনিক উত্তরপূর্ব",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://uttorpurbo.com",
            tagline = "উত্তরপূর্বাঞ্চলের আপসহীন দৈনিক পত্রিকা",
            primaryColorHex = 0xFF4527A0,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "sylhet_view_24",
            name = "Sylhet View 24",
            banglaName = "সিলেট ভিউ ২৪",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://sylhetview24.net",
            tagline = "সিলেটের সর্বাধিক পঠিত অনলাইন পত্রিকা",
            primaryColorHex = 0xFF0288D1,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "beanibazar_news24",
            name = "Beanibazar News24",
            banglaName = "বিয়ানীবাজার নিউজ ২৪",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://beanibazarnews24.com",
            tagline = "বিয়ানীবাজারের প্রবাস ও স্থানীয় খবরের মেলবন্ধন",
            primaryColorHex = 0xFF388E3C,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "sylhet_mirror",
            name = "Sylhet Mirror",
            banglaName = "সিলেট মিরর",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://sylhetmirror.com",
            tagline = "সুরমা উপত্যকার সার্বক্ষণিক খবর",
            primaryColorHex = 0xFFD81B60,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "dream_sylhet",
            name = "Dream Sylhet",
            banglaName = "ড্রিম সিলেট",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dreamsylhet.com",
            tagline = "স্বপ্ন ও সম্ভাবনার সমৃদ্ধ সিলেট",
            primaryColorHex = 0xFF00897B,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "sylhet_report",
            name = "Sylhet Report",
            banglaName = "সিলেট রিপোর্ট",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://sylhetreport.com",
            tagline = "সিলেটের গভীর অনুসন্ধানী প্রতিবেদন",
            primaryColorHex = 0xFF5D4037,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "crime_sylhet",
            name = "Crime Sylhet",
            banglaName = "ক্রাইম সিলেট",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://crimesylhet.com",
            tagline = "আইনশৃঙ্খলা, সমাজ ও অপরাধ অনুসন্ধানী সংবাদ",
            primaryColorHex = 0xFFB71C1C,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "habiganj_news24",
            name = "Habiganj News24",
            banglaName = "হবিগঞ্জ নিউজ ২৪",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://habiganjnews24.com",
            tagline = "হবিগঞ্জের দ্রুততম ডিজিটাল বার্তা",
            primaryColorHex = 0xFFF57C00,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "sunamganjer_khobor",
            name = "Sunamganjer Khobor",
            banglaName = "সুনামগঞ্জের খবর",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://sunamganjerkhobor.com",
            tagline = "হাওরাঞ্চলের গণমানুষের জীবন ও জীবিকার কথা",
            primaryColorHex = 0xFF00796B,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "habiganj_express",
            name = "Habiganj Express",
            banglaName = "হবিগঞ্জ এক্সপ্রেস",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://habiganjexpress.com",
            tagline = "হবিগঞ্জের প্রতিটি মুহূর্তের তাজা আপডেট",
            primaryColorHex = 0xFF1976D2,
            region = "Sylhet Division"
        ),
        Newspaper(
            id = "provatbela",
            name = "Provatbela",
            banglaName = "প্রভাতবেলা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://provatbela.com",
            tagline = "নতুন দিনের প্রত্যয়ে সিলেটের সকালের বার্তা",
            primaryColorHex = 0xFF7B1FA2,
            region = "Sylhet Division"
        ),

        // ==========================================
        // 4. CHATTOGRAM REGION (23)
        // ==========================================
        Newspaper(
            id = "dainik_purbokone",
            name = "Dainik Purbokone",
            banglaName = "দৈনিক পূর্বকোণ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dainikpurbokone.net",
            tagline = "চট্টগ্রামের বহুল প্রচারিত শীর্ষ দৈনিক পত্রিকা",
            primaryColorHex = 0xFFB71C1C,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "dainik_azadi",
            name = "Dainik Azadi",
            banglaName = "দৈনিক আজাদী",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dainikazadi.net",
            tagline = "স্বাধীন বাংলাদেশের প্রথম দৈনিক পত্রিকা",
            primaryColorHex = 0xFF0D6838,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "suprobhat_bangladesh",
            name = "Suprobhat Bangladesh",
            banglaName = "সুप्रभात বাংলাদেশ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://suprobhat.com",
            tagline = "চট্টগ্রামের প্রগতিশীল ও আধুনিক ভাবনার দৈনিক",
            primaryColorHex = 0xFF0288D1,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "dainik_coxsbazar",
            name = "Dainik Coxsbazar",
            banglaName = "দৈনিক কক্সবাজার",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dainikcoxsbazar.com",
            tagline = "বিশ্বের দীর্ঘতম সমুদ্র সৈকতের নগরীর প্রথম দৈনিক",
            primaryColorHex = 0xFF0097A7,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "ctg_times",
            name = "CTG Times",
            banglaName = "সিটিজি টাইমস",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://ctgtimes.com",
            tagline = "বাণিজ্যিক রাজধানী চট্টগ্রামের সর্বশেষ খবর",
            primaryColorHex = 0xFFE65100,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "cht_times_24",
            name = "CHT Times 24",
            banglaName = "সিএইচটি টাইমস ২৪",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://chttimes24.com",
            tagline = "পার্বত্য চট্টগ্রামের তিন জেলার অনলাইন নিউজ পোর্টাল",
            primaryColorHex = 0xFF388E3C,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "daily_purbodesh",
            name = "Daily Purbodesh",
            banglaName = "দৈনিক পূর্বদেশ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://purbodesh.com",
            tagline = "চট্টগ্রামের আস্থার প্রতীক ও নিরপেক্ষ দৃষ্টিভঙ্গি",
            primaryColorHex = 0xFF1976D2,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "the_daily_shangu",
            name = "The Daily Shangu",
            banglaName = "দৈনিক সাঙ্গু",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://shangu.com.bd",
            tagline = "পাহাড় ও সমতলের সুদৃঢ় মেলবন্ধন",
            primaryColorHex = 0xFF5D4037,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "chattogram_pratidin",
            name = "Chattogram Pratidin",
            banglaName = "চট্টগ্রাম প্রতিদিন",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://chattogrampratidin.com",
            tagline = "চট্টগ্রামের প্রতিটি মুহূর্তের সার্বক্ষণিক সংবাদ",
            primaryColorHex = 0xFFD81B60,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "daily_rangamati",
            name = "Daily Rangamati",
            banglaName = "দৈনিক রাঙ্গামাটি",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dailyrangamati.com",
            tagline = "হৃদয়ে রাঙ্গামাটি, পাহাড়ের কণ্ঠস্বর",
            primaryColorHex = 0xFF2E7D32,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "parbatta_news",
            name = "Parbatta News",
            banglaName = "পার্বত্য নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://parbattanews.com",
            tagline = "পার্বত্য তিন জেলার সমৃদ্ধ তথ্যকোষ",
            primaryColorHex = 0xFF00796B,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "pahar24",
            name = "pahar24.com",
            banglaName = "পাহাড়২৪ ডটকম",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://pahar24.com",
            tagline = "পাহাড় ও জনপদের খবরাখবর সবার আগে",
            primaryColorHex = 0xFF4527A0,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "chakaria_news",
            name = "Chakaria News",
            banglaName = "চকরিয়া নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://chakarianews.com",
            tagline = "চকরিয়া ও মাতামুহুরী উপত্যকার সংবাদ",
            primaryColorHex = 0xFF00897B,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "raozan_news",
            name = "Raozan News",
            banglaName = "রাউজান নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://raozannews.com",
            tagline = "রাউজান ও উত্তর চট্টগ্রামের উন্নয়নের সংবাদ",
            primaryColorHex = 0xFF0288D1,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "coxs_bazar_news_cbn",
            name = "Coxs-Bazar News (CBN)",
            banglaName = "কক্সবাজার নিউজ (সিবিএন)",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://coxsbazarnews.com",
            tagline = "কক্সবাজারের সর্বাধিক পঠিত জনপ্রিয় অনলাইন",
            primaryColorHex = 0xFFE64A19,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "ekushey_patrika",
            name = "Ekushey Patrika",
            banglaName = "একুশে পত্রিকা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://ekushey-patrika.com",
            tagline = "চট্টগ্রামের নির্ভীক ও অনুসন্ধানী পত্রিকা",
            primaryColorHex = 0xFF7B1FA2,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "paharbarta",
            name = "PaharBarta",
            banglaName = "পাহাড়বার্তা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://paharbarta.com",
            tagline = "বান্দরবান ও পার্বত্য অঞ্চলের প্রথম অনলাইন",
            primaryColorHex = 0xFF388E3C,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "khabarica",
            name = "Khabarica",
            banglaName = "খবরিকা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://khabarica.com",
            tagline = "চট্টগ্রামের মুক্তধারা সংবাদপত্র",
            primaryColorHex = 0xFF0097A7,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "ctg_sun",
            name = "CTG Sun",
            banglaName = "সিটিজি সান",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://ctgsun.com",
            tagline = "চট্টগ্রামের খবরের নির্ভরযোগ্য সূর্যোদয়",
            primaryColorHex = 0xFFF57C00,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "teknaf_today",
            name = "Teknaf Today",
            banglaName = "টেকনাফ টুডে",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://teknaftoday.com",
            tagline = "সীমান্ত ও উপকূলীয় অঞ্চলের বিশেষায়িত সংবাদ",
            primaryColorHex = 0xFFC2185B,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "hillbd24",
            name = "Hillbd24",
            banglaName = "হিলবিডি২৪",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://hillbd24.com",
            tagline = "পাহাড়ের জনপদের তথ্যের অনন্য ভাণ্ডার",
            primaryColorHex = 0xFF2E7D32,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "cht_today",
            name = "CHT Today",
            banglaName = "সিএইচটি টুডে",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://chttoday.com",
            tagline = "পার্বত্য চট্টগ্রামের তাজা খবর প্রতি মুহূর্তে",
            primaryColorHex = 0xFF1976D2,
            region = "Chattogram Region"
        ),
        Newspaper(
            id = "cht_news24",
            name = "CHT News24",
            banglaName = "সিএইচটি নিউজ ২৪",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://chtnews24.com",
            tagline = "পার্বত্য জনপদের প্রতিদিনের বিশ্বস্ত বার্তা",
            primaryColorHex = 0xFF5D4037,
            region = "Chattogram Region"
        ),

        // ==========================================
        // 5. MYMENSINGH REGION (6)
        // ==========================================
        Newspaper(
            id = "mymensingh_pratidin",
            name = "Mymensingh Pratidin",
            banglaName = "ময়মনসিংহ প্রতিদিন",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://mymensinghpratidin.com",
            tagline = "ময়মনসিংহ বিভাগের জনপ্রিয় ও সর্বাধিক পঠিত দৈনিক",
            primaryColorHex = 0xFF0D6838,
            region = "Mymensingh Region"
        ),
        Newspaper(
            id = "durjoy_bangla",
            name = "Durjoy Bangla",
            banglaName = "দুর্জয় বাংলা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://durjoybangla.com",
            tagline = "ময়মনসিংহের বস্তুনিষ্ঠ ও প্রত্যয়ী সংবাদপত্র",
            primaryColorHex = 0xFFD32F2F,
            region = "Mymensingh Region"
        ),
        Newspaper(
            id = "kishoreganj_news",
            name = "Kishoreganj News",
            banglaName = "কিশোরগঞ্জ নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://kishoreganjnews.com",
            tagline = "হাওর ও সমতলের কিশোরগঞ্জের প্রথম অনলাইন",
            primaryColorHex = 0xFF0288D1,
            region = "Mymensingh Region"
        ),
        Newspaper(
            id = "shemol_bangla",
            name = "Shemol Bangla",
            banglaName = "শ্যামল বাংলা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://shemolbangla.com",
            tagline = "শেরপুর ও গারো পাহাড় অঞ্চলের শীর্ষ সংবাদপত্র",
            primaryColorHex = 0xFF388E3C,
            region = "Mymensingh Region"
        ),
        Newspaper(
            id = "netrokona_news24",
            name = "Netrokona News24",
            banglaName = "নেত্রকোনা নিউজ ২৪",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://netrokonanews24.com",
            tagline = "নেত্রকোনার গণমানুষের সংবাদ মাধ্যম",
            primaryColorHex = 0xFF7B1FA2,
            region = "Mymensingh Region"
        ),
        Newspaper(
            id = "jamalpur_barta",
            name = "Jamalpur Barta",
            banglaName = "জামালপুর বার্তা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://jamalpurbarta.com",
            tagline = "জামালপুর জেলার প্রতিচ্ছবি ও আধুনিক বার্তা",
            primaryColorHex = 0xFFE64A19,
            region = "Mymensingh Region"
        ),

        // ==========================================
        // 6. KHULNA REGION (13)
        // ==========================================
        Newspaper(
            id = "purbanchal",
            name = "Purbanchal",
            banglaName = "দৈনিক পূর্বাঞ্চল",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://purbanchal.com",
            tagline = "খুলনার প্রাচীনতম ও সর্বাধিক প্রচারিত প্রধান দৈনিক",
            primaryColorHex = 0xFF00796B,
            region = "Khulna Region"
        ),
        Newspaper(
            id = "khulnanchal",
            name = "Khulnanchal",
            banglaName = "দৈনিক খুলনাঞ্চল",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://khulnanchal.com",
            tagline = "খুলনা ও দক্ষিণাঞ্চলের গণমানুষের পত্রিকা",
            primaryColorHex = 0xFF0288D1,
            region = "Khulna Region"
        ),
        Newspaper(
            id = "gramer_kagoj",
            name = "Gramer Kagoj",
            banglaName = "দৈনিক গ্রামের কাগজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://gramerkagoj.com",
            tagline = "যশোর ও দক্ষিণ-পশ্চিমাঞ্চলের শীর্ষ দৈনিক",
            primaryColorHex = 0xFF2E7D32,
            region = "Khulna Region"
        ),
        Newspaper(
            id = "mathabhanga",
            name = "Mathabhanga",
            banglaName = "দৈনিক মাথাভাঙ্গা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://mathabhanga.com",
            tagline = "চুয়াডাঙ্গার নির্ভরযোগ্য ও ঐতিহ্যবাহী সংবাদপত্র",
            primaryColorHex = 0xFFD81B60,
            region = "Khulna Region"
        ),
        Newspaper(
            id = "daily_probaha",
            name = "Daily Probaha",
            banglaName = "দৈনিক প্রবাহ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dailyprobaha.com",
            tagline = "খুলনার ঐতিহ্যবাহী ও বস্তুনিষ্ঠ দৈনিক",
            primaryColorHex = 0xFF1976D2,
            region = "Khulna Region"
        ),
        Newspaper(
            id = "meherpur_news",
            name = "Meherpur News",
            banglaName = "মেহেরপুর নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://meherpurnews.com",
            tagline = "ঐতিহাসিক মেহেরপুরের প্রথম অনলাইন পত্রিকা",
            primaryColorHex = 0xFFE65100,
            region = "Khulna Region"
        ),
        Newspaper(
            id = "magura_news",
            name = "Magura News",
            banglaName = "মাগুরা নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://maguranews.com",
            tagline = "মাগুরা জেলার সব খবর একসাথে",
            primaryColorHex = 0xFF7B1FA2,
            region = "Khulna Region"
        ),
        Newspaper(
            id = "satkhira_news",
            name = "Satkhira News",
            banglaName = "সাতক্ষীরা নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://satkhiranews.com",
            tagline = "সুন্দরবনের কোলঘেঁষা সাতক্ষীরার খবরাখবর",
            primaryColorHex = 0xFF00897B,
            region = "Khulna Region"
        ),
        Newspaper(
            id = "patradoot",
            name = "Patradoot",
            banglaName = "দৈনিক পত্রদূত",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://patradoot.net",
            tagline = "সাতক্ষীরার গণমানুষের আপসহীন মুখপত্র",
            primaryColorHex = 0xFFB71C1C,
            region = "Khulna Region"
        ),
        Newspaper(
            id = "kuakata_news",
            name = "Kuakata News",
            banglaName = "কুয়াকাটা নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://kuakatanews.com",
            tagline = "সাগরকন্যা কুয়াকাটার উপকূলীয় সংবাদ",
            primaryColorHex = 0xFF0097A7,
            region = "Khulna Region"
        ),
        Newspaper(
            id = "spandan",
            name = "Spandan",
            banglaName = "দৈনিক স্পন্দন",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://spandannews.com",
            tagline = "যশোরের গণমুখী ও জনপ্রিয় দৈনিক",
            primaryColorHex = 0xFF4527A0,
            region = "Khulna Region"
        ),
        Newspaper(
            id = "one_news_bd",
            name = "One News BD",
            banglaName = "ওয়ান নিউজ বিডি",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://onenewsbd.com",
            tagline = "দক্ষিণ-পশ্চিমাঞ্চলের সার্বক্ষণিক সংবাদ",
            primaryColorHex = 0xFFF57C00,
            region = "Khulna Region"
        ),
        Newspaper(
            id = "kushtia_news",
            name = "Kushtia News",
            banglaName = "কুষ্টিয়া নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://kushtianews.com",
            tagline = "বাউলসম্রাট লালনের দেশ কুষ্টিয়ার খবর",
            primaryColorHex = 0xFF5D4037,
            region = "Khulna Region"
        ),

        // ==========================================
        // 7. RAJSHAHI REGION (12)
        // ==========================================
        Newspaper(
            id = "sonali_sangbad",
            name = "Sonali Sangbad",
            banglaName = "দৈনিক সোনালী সংবাদ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://sonalisangbad.com",
            tagline = "রাজশাহীর শীর্ষস্থানীয় ও বহুল প্রচারিত প্রধান দৈনিক",
            primaryColorHex = 0xFFC2185B,
            region = "Rajshahi Region"
        ),
        Newspaper(
            id = "daily_sunshine",
            name = "Daily Sunshine",
            banglaName = "দৈনিক সানশাইন",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dailysunshine.com.bd",
            tagline = "পদ্মাপাড়ের আধুনিক ও গতিশীল সংবাদপত্র",
            primaryColorHex = 0xFFE65100,
            region = "Rajshahi Region"
        ),
        Newspaper(
            id = "sonar_desh",
            name = "Sonar Desh",
            banglaName = "দৈনিক সোনার দেশ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://sonardesh.com",
            tagline = "রাজশাহীর গণমানুষের জনপ্রিয় দৈনিক",
            primaryColorHex = 0xFF0D6838,
            region = "Rajshahi Region"
        ),
        Newspaper(
            id = "karatoa",
            name = "Karatoa",
            banglaName = "দৈনিক করতোয়া",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://karatoa.com.bd",
            tagline = "বগুড়া ও উত্তরবঙ্গের সর্বাধিক পঠিত জনপ্রিয় দৈনিক",
            primaryColorHex = 0xFF1976D2,
            region = "Rajshahi Region"
        ),
        Newspaper(
            id = "rajshahi_news_24",
            name = "Rajshahi News 24",
            banglaName = "রাজশাহী নিউজ ২৪",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://rajshahinews24.com",
            tagline = "পদ্মাপাড়ের ২৪ ঘণ্টার সার্বক্ষণিক খবর",
            primaryColorHex = 0xFF7B1FA2,
            region = "Rajshahi Region"
        ),
        Newspaper(
            id = "padma_news",
            name = "Padma News",
            banglaName = "পদ্মা নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://padmanews24.com",
            tagline = "পদ্মার স্রোতের মতোই সত্য ও বস্তুনিষ্ঠ",
            primaryColorHex = 0xFF0288D1,
            region = "Rajshahi Region"
        ),
        Newspaper(
            id = "chandni_bazar",
            name = "Chandni Bazar",
            banglaName = "দৈনিক চাঁদনী বাজার",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://chandnibazar.com",
            tagline = "বগুড়ার স্থানীয় ও নির্ভরযোগ্য দৈনিক",
            primaryColorHex = 0xFF388E3C,
            region = "Rajshahi Region"
        ),
        Newspaper(
            id = "bogra_sangbad",
            name = "Bogra Sangbad",
            banglaName = "বগুড়া সংবাদ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://bograsangbad.com",
            tagline = "বগুড়া জেলার খবরের সমৃদ্ধ পোর্টাল",
            primaryColorHex = 0xFF00796B,
            region = "Rajshahi Region"
        ),
        Newspaper(
            id = "mukto_provat",
            name = "Mukto Provat",
            banglaName = "দৈনিক মুক্ত প্রভাত",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://muktoprovat.com",
            tagline = "বগুড়া থেকে প্রকাশিত নির্ভীক সংবাদপত্র",
            primaryColorHex = 0xFFB71C1C,
            region = "Rajshahi Region"
        ),
        Newspaper(
            id = "chapainawabganj_news",
            name = "Chapainawabganj News",
            banglaName = "চাঁপাইনবাবগঞ্জ নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://chapainawabganjnews.com",
            tagline = "আমের রাজধানী চাঁপাইনবাবগঞ্জের প্রথম অনলাইন",
            primaryColorHex = 0xFFF57C00,
            region = "Rajshahi Region"
        ),
        Newspaper(
            id = "onabil_net",
            name = "onabil.net",
            banglaName = "অনাবিল নেট",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://onabil.net",
            tagline = "নাটোর ও রাজশাহী অঞ্চলের সংবাদ প্রবাহ",
            primaryColorHex = 0xFF0097A7,
            region = "Rajshahi Region"
        ),
        Newspaper(
            id = "gour_bangla",
            name = "Gour Bangla",
            banglaName = "গৌড় বাংলা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://gourbangla.com",
            tagline = "ঐতিহাসিক গৌড় ও চাঁপাইনবাবগঞ্জের কণ্ঠস্বর",
            primaryColorHex = 0xFF4527A0,
            region = "Rajshahi Region"
        ),

        // ==========================================
        // 8. CUMILLA REGION (17)
        // ==========================================
        Newspaper(
            id = "comillar_kagoj",
            name = "Comillar Kagoj",
            banglaName = "কুমিল্লার কাগজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://comillarkagoj.com",
            tagline = "কুমিল্লার সর্বাধিক প্রচারিত ও জনপ্রিয় ঐতিহ্যবাহী দৈনিক",
            primaryColorHex = 0xFF0D6838,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "daily_rupashi_bangla",
            name = "Daily Rupashi Bangla",
            banglaName = "দৈনিক রূপসী বাংলা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dailyrupashibangla.com",
            tagline = "কুমিল্লা অঞ্চলের জনপ্রিয় পত্রিকা",
            primaryColorHex = 0xFF0288D1,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "comillar_dak",
            name = "Comillar Dak",
            banglaName = "কুমিল্লার ডাক",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://comillardak.com",
            tagline = "কুমিল্লার মানুষের প্রথম পছন্দ",
            primaryColorHex = 0xFFC2185B,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "cumilla_protidin",
            name = "Cumilla Protidin",
            banglaName = "কুমিল্লা প্রতিদিন",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://cumillaprotidin.com",
            tagline = "কুমিল্লার প্রতিদিনের খবর সবার আগে",
            primaryColorHex = 0xFFD32F2F,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "ajker_cumilla",
            name = "Ajker Cumilla",
            banglaName = "আজকের কুমিল্লা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://ajkercumilla.com",
            tagline = "কুমিল্লার অনলাইন পোর্টাল ও ব্রেকিং নিউজ",
            primaryColorHex = 0xFFE65100,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "comillar_barta",
            name = "Comillar Barta",
            banglaName = "কুমিল্লার বার্তা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://comillarbarta.com",
            tagline = "কুমিল্লার সব সংবাদ ও নাগরিক ভাবনা",
            primaryColorHex = 0xFF7B1FA2,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "amader_brahmanbaria",
            name = "Amader Brahmanbaria",
            banglaName = "আমাদের ব্রাহ্মণবাড়িয়া",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://amaderbrahmanbaria.com",
            tagline = "তিতাসপাড়ের সংবাদ ও সংস্কৃতির সমৃদ্ধ দর্পণ",
            primaryColorHex = 0xFF00796B,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "lakshmipur_24",
            name = "Lakshmipur 24",
            banglaName = "লক্ষ্মীপুর ২৪",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://lakshmipur24.com",
            tagline = "উপকূলীয় লক্ষ্মীপুরের প্রথম অনলাইন পত্রিকা",
            primaryColorHex = 0xFF388E3C,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "cumillar_paper",
            name = "Cumillar Paper",
            banglaName = "কুমিল্লার পেপার",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://cumillarpaper.com",
            tagline = "কুমিল্লার সাম্প্রতিক তথ্য ও বিশ্লেষণ",
            primaryColorHex = 0xFF1976D2,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "daily_amar_shohor",
            name = "Daily Amar Shohor",
            banglaName = "দৈনিক আমার শহর",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dailyamarshohor.com",
            tagline = "কুমিল্লার স্থানীয় ও গণমানুষের দৈনিক",
            primaryColorHex = 0xFF5D4037,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "dainik_cumilla",
            name = "Dainik Cumilla",
            banglaName = "দৈনিক কুমিল্লা",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dainikcumilla.com",
            tagline = "কুমিল্লার বিশ্বাসযোগ্য ও নিরপেক্ষ সংবাদপত্র",
            primaryColorHex = 0xFF00897B,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "brahmanbaria24",
            name = "brahmanbaria24.com",
            banglaName = "ব্রাহ্মণবাড়িয়া২৪ ডটকম",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://brahmanbaria24.com",
            tagline = "ব্রাহ্মণবাড়িয়ার শীর্ষ ও জনপ্রিয় অনলাইন",
            primaryColorHex = 0xFFB71C1C,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "daily_comilla_news",
            name = "Daily Comilla News",
            banglaName = "ডেইলি কুমিল্লা নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://dailycomillanews.com",
            tagline = "কুমিল্লার সংবাদ প্রতিদিন",
            primaryColorHex = 0xFF0288D1,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "feni_news",
            name = "Feni News",
            banglaName = "ফেনী নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://feninews.com",
            tagline = "ফেনী জেলার প্রথম ও সর্বাধিক পঠিত অনলাইন পত্রিকা",
            primaryColorHex = 0xFF0097A7,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "chandpur_darpan",
            name = "Chandpur Darpan",
            banglaName = "দৈনিক চাঁদপুর দর্পণ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://chandpurdarpan.com",
            tagline = "ইলিশের বাড়ি চাঁদপুরের প্রধান ও বহুল প্রচারিত দৈনিক",
            primaryColorHex = 0xFF00796B,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "chandpur_news",
            name = "Chandpur News",
            banglaName = "চাঁদপুর নিউজ",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://chandpurnews.com",
            tagline = "চাঁদপুরের সার্বক্ষণিক খবরাখবর",
            primaryColorHex = 0xFFE65100,
            region = "Cumilla Region"
        ),
        Newspaper(
            id = "chandpur_times",
            name = "Chandpur Times",
            banglaName = "চাঁদপুর টাইমস",
            category = NewspaperCategory.LOCAL,
            websiteUrl = "https://chandpurtimes.com",
            tagline = "চাঁদপুরের জনপ্রিয় ও সমৃদ্ধ অনলাইন নিউজ পোর্টাল",
            primaryColorHex = 0xFF4527A0,
            region = "Cumilla Region"
        )
    )

    fun getByRegion(region: String): List<Newspaper> {
        return if (region == "All Regions" || region.isBlank()) localNewspapers
        else localNewspapers.filter { it.region == region }
    }
}
