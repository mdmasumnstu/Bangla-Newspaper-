package com.example.data.model

object ExtraSourcesDataSource {

    val radioTypes: List<String> = listOf(
        "All Radio",
        "Top 10 FM",
        "Private FM Online",
        "Off Private FM",
        "State-owned Radio"
    )

    val govtTypes: List<String> = listOf(
        "All Portals",
        "Ministries & Divisions",
        "Citizen Services",
        "Constitutional & Apex"
    )

    // =========================================================================
    // 1. POPULAR BANGLA JOBS SITE (12)
    // =========================================================================
    val jobSites: List<Newspaper> = listOf(
        Newspaper(
            id = "bdjobs",
            name = "BD Jobs",
            banglaName = "বিডিজবস",
            category = NewspaperCategory.JOBS,
            websiteUrl = "https://www.bdjobs.com",
            tagline = "দেশের বৃহত্তম ও শীর্ষ চাকরির পোর্টাল",
            primaryColorHex = 0xFF0D47A1
        ),
        Newspaper(
            id = "bikroy_jobs",
            name = "Bikroy Jobs",
            banglaName = "বিক্রয় জবস",
            category = NewspaperCategory.JOBS,
            websiteUrl = "https://bikroy.com/bn/ads/bangladesh/jobs",
            tagline = "স্থানীয় চাকরির খোঁজে সেরা প্ল্যাটফর্ম",
            primaryColorHex = 0xFF009688
        ),
        Newspaper(
            id = "bdjobs_com_bd",
            name = "BDJobs.com.bd",
            banglaName = "বিডি জবস বাংলাদেশ",
            category = NewspaperCategory.JOBS,
            websiteUrl = "https://www.bdjobs.com.bd",
            tagline = "অনলাইন চাকরি খোঁজা ও ক্যারিয়ার গাইড",
            primaryColorHex = 0xFF1976D2
        ),
        Newspaper(
            id = "bd_jobs_today",
            name = "Bd jobs Today",
            banglaName = "বিডি জবস টুডে",
            category = NewspaperCategory.JOBS,
            websiteUrl = "https://bdjobstoday.com",
            tagline = "প্রতিদিনের সরকারি ও বেসরকারি চাকরির খবর",
            primaryColorHex = 0xFFE65100
        ),
        Newspaper(
            id = "chakri_khobor",
            name = "Chakri Khobor",
            banglaName = "চাকরির খবর",
            category = NewspaperCategory.JOBS,
            websiteUrl = "https://chakrirkhobor.net",
            tagline = "সাপ্তাহিক চাকরির খবর ও নিয়োগ বিজ্ঞপ্তি",
            primaryColorHex = 0xFF2E7D32
        ),
        Newspaper(
            id = "skill_jobs",
            name = "Skill Jobs",
            banglaName = "স্কিল জবস",
            category = NewspaperCategory.JOBS,
            websiteUrl = "https://skill.jobs",
            tagline = "দক্ষতা ভিত্তিক পেশাদার চাকরির পোর্টাল",
            primaryColorHex = 0xFF512DA8
        ),
        Newspaper(
            id = "nrb_jobs",
            name = "NRB Jobs",
            banglaName = "এনআরবি জবস",
            category = NewspaperCategory.JOBS,
            websiteUrl = "https://nrbjobs.com",
            tagline = "প্রবাসী ও দেশি ক্যারিয়ার হাব",
            primaryColorHex = 0xFF00796B
        ),
        Newspaper(
            id = "job_com_bd",
            name = "Job.com.bd",
            banglaName = "জব ডট কম ডট বিডি",
            category = NewspaperCategory.JOBS,
            websiteUrl = "https://job.com.bd",
            tagline = "বাংলাদেশের নির্ভরযোগ্য জব সাইট",
            primaryColorHex = 0xFF0288D1
        ),
        Newspaper(
            id = "careerjet_bd",
            name = "Careerjet",
            banglaName = "ক্যারিয়ারজেট",
            category = NewspaperCategory.JOBS,
            websiteUrl = "https://www.careerjet.com.bd",
            tagline = "চাকরি খোঁজার আন্তর্জাতিক সার্চ ইঞ্জিন",
            primaryColorHex = 0xFFC2185B
        ),
        Newspaper(
            id = "shomvob_jobs",
            name = "Shomvob",
            banglaName = "সম্ভব জবস",
            category = NewspaperCategory.JOBS,
            websiteUrl = "https://shomvob.co",
            tagline = "ব্লু ও গ্রে কলার ক্যারিয়ার প্ল্যাটফর্ম",
            primaryColorHex = 0xFFF57C00
        ),
        Newspaper(
            id = "my_jobs_bd",
            name = "My Jobs",
            banglaName = "মাই জবস বিডি",
            category = NewspaperCategory.JOBS,
            websiteUrl = "https://myjobs.com.bd",
            tagline = "স্মার্ট ক্যারিয়ার এবং নিয়োগ সমাধান",
            primaryColorHex = 0xFF388E3C
        ),
        Newspaper(
            id = "ejobs_bd",
            name = "eJobs",
            banglaName = "ই-জবস বিডি",
            category = NewspaperCategory.JOBS,
            websiteUrl = "https://ejobs.com.bd",
            tagline = "অনলাইন চাকরি ও বিশ্বস্ত নিয়োগ তথ্য",
            primaryColorHex = 0xFF1565C0
        )
    )

    // =========================================================================
    // 2. BANGLA FM RADIO PORTAL (29)
    // =========================================================================
    val fmRadioStations: List<Newspaper> = listOf(
        // --- Top 10 Bangla FM Radio ---
        Newspaper(
            id = "radio_today",
            name = "Radio Today",
            banglaName = "রেডিও টুডে ৮৯.৬",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radiotodaybd.fm",
            tagline = "দেশের প্রথম ২৪ ঘণ্টা সংবাদ ও মিউজিক এফএম",
            primaryColorHex = 0xFFD32F2F,
            region = "Top 10 FM"
        ),
        Newspaper(
            id = "jago_fm",
            name = "Jago FM",
            banglaName = "জাগো এফএম ৯৪.৪",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://jago.fm",
            tagline = "প্রাণবন্ত তারুণ্যের পছন্দের রেডিও",
            primaryColorHex = 0xFFFF5722,
            region = "Top 10 FM"
        ),
        Newspaper(
            id = "radio_capital",
            name = "Radio Capital",
            banglaName = "রেডিও ক্যাপিটাল ৯৪.৮",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radiocapital.fm",
            tagline = "মিউজিক ও খবরের রাজধানী",
            primaryColorHex = 0xFFE91E63,
            region = "Top 10 FM"
        ),
        Newspaper(
            id = "radio_shadhin",
            name = "Radio Shadhin",
            banglaName = "রেডিও স্বাধীন ৯২.৪",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radioshadhin.fm",
            tagline = "স্বাধীনতার সুরে গান ও আড্ডা",
            primaryColorHex = 0xFF4CAF50,
            region = "Top 10 FM"
        ),
        Newspaper(
            id = "peoples_radio",
            name = "Peoples Radio",
            banglaName = "পিপলস রেডিও ৯১.৬",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://peoplesradio.fm",
            tagline = "জনগণের কণ্ঠস্বর ও বিনোদন",
            primaryColorHex = 0xFF3F51B5,
            region = "Top 10 FM"
        ),
        Newspaper(
            id = "radio_dhoni",
            name = "Radio Dhoni",
            banglaName = "রেডিও ধ্বনি ৯১.২",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radiodhoni.fm",
            tagline = "শব্দে শব্দে বাংলাদেশ",
            primaryColorHex = 0xFF009688,
            region = "Top 10 FM"
        ),
        Newspaper(
            id = "radio_foorti",
            name = "Radio Foorti",
            banglaName = "রেডিও ফুর্তি ৮৮.০",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radiofoorti.com",
            tagline = "হাসি আর গান ২৪ ঘণ্টা ফুর্তি",
            primaryColorHex = 0xFFFF9800,
            region = "Top 10 FM"
        ),
        Newspaper(
            id = "bbc_bangla_radio",
            name = "BBC Bangla Radio",
            banglaName = "বিবিসি বাংলা রেডিও",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://www.bbc.com/bengali",
            tagline = "বিশ্বস্ত নিরপেক্ষ বিশ্বসংবাদ ও বিশ্লেষণ",
            primaryColorHex = 0xFFB71C1C,
            region = "Top 10 FM"
        ),
        Newspaper(
            id = "spice_fm",
            name = "Spice FM",
            banglaName = "স্পাইস এফএম ৯৬.৪",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://spicefmbd.com",
            tagline = "হট অ্যান্ড স্পাইসি মিউজিক স্টেশন",
            primaryColorHex = 0xFFC2185B,
            region = "Top 10 FM"
        ),
        Newspaper(
            id = "dhaka_fm",
            name = "Dhaka FM",
            banglaName = "ঢাকা এফএম ৯০.৪",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://dhakafm904.com",
            tagline = "মেগা সিটির হার্টবিট",
            primaryColorHex = 0xFF1976D2,
            region = "Top 10 FM"
        ),

        // --- Private All Bangla FM Radio online ---
        Newspaper(
            id = "radio_amber",
            name = "Radio Amber",
            banglaName = "রেডিও অম্বর ১০২.৪",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radioamber.fm",
            tagline = "সুরের রঙে রঙিন গান ও আলাপ",
            primaryColorHex = 0xFFFFA000,
            region = "Private FM Online"
        ),
        Newspaper(
            id = "radio_din_raat",
            name = "Radio Din Raat",
            banglaName = "রেডিও দিন রাত ৯৩.২",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radiodinraat.com",
            tagline = "দিন রাত সঙ্গী আপনার",
            primaryColorHex = 0xFF5D4037,
            region = "Private FM Online"
        ),
        Newspaper(
            id = "radio_bhumi",
            name = "Radio Bhumi",
            banglaName = "রেডিও ভূমি ৯২.৮",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radiobhumi.fm",
            tagline = "মাটির টানে লোকজ ও আধুনিক গান",
            primaryColorHex = 0xFF388E3C,
            region = "Private FM Online"
        ),
        Newspaper(
            id = "radio_ekattor",
            name = "Radio Ekattor",
            banglaName = "রেডিও একাত্তর ৯৮.৪",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radioekattor.fm",
            tagline = "একাত্তরের চেতনা ও সংবাদ",
            primaryColorHex = 0xFFD32F2F,
            region = "Private FM Online"
        ),
        Newspaper(
            id = "radio_edge",
            name = "Radio Edge",
            banglaName = "রেডিও এজ ৯৫.৬",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radioedge.fm",
            tagline = "ক্রীড়া ও সংগীতপ্রেমীদের রেডিও",
            primaryColorHex = 0xFF0288D1,
            region = "Private FM Online"
        ),
        Newspaper(
            id = "abc_radio",
            name = "ABC Radio",
            banglaName = "এবিসি রেডিও ৮৯.২",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://abcradio.com.bd",
            tagline = "সব সময় সাথে থাকে",
            primaryColorHex = 0xFFD81B60,
            region = "Private FM Online"
        ),
        Newspaper(
            id = "bangla_radio",
            name = "Bangla Radio",
            banglaName = "বাংলা রেডিও ৯৫.২",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://banglaradio.fm",
            tagline = "হৃদয়ে বাংলা সংস্কৃতি ও সুর",
            primaryColorHex = 0xFF00796B,
            region = "Private FM Online"
        ),
        Newspaper(
            id = "asian_radio",
            name = "Asian Radio",
            banglaName = "এশিয়ান রেডিও ৯০.৮",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://asianradio908.com",
            tagline = "নতুন প্রজন্মের ডিজিটাল সুর",
            primaryColorHex = 0xFF7B1FA2,
            region = "Private FM Online"
        ),
        Newspaper(
            id = "radio_dhol",
            name = "Radio Dhol",
            banglaName = "রেডিও ঢোল ৯৪.০",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radiodhol.fm",
            tagline = "দেশিয় তাল ও ফোক গানের আনন্দ",
            primaryColorHex = 0xFFE65100,
            region = "Private FM Online"
        ),
        Newspaper(
            id = "radio_next",
            name = "Radio Next",
            banglaName = "রেডিও নেক্সট ৯৩.২",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radionext.fm",
            tagline = "ভবিষ্যতের রেডিও এখন আপনার সাথে",
            primaryColorHex = 0xFF00ACC1,
            region = "Private FM Online"
        ),
        Newspaper(
            id = "city_fm",
            name = "City FM",
            banglaName = "সিটি এফএম ৯৬.০",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://cityfm.fm",
            tagline = "শহরের সুর ও তারুণ্যের উৎসব",
            primaryColorHex = 0xFF689F38,
            region = "Private FM Online"
        ),
        Newspaper(
            id = "colours_fm",
            name = "Colours FM",
            banglaName = "কালারস এফএম ১০১.৬",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://colours.fm",
            tagline = "নারী ও তারুণ্যের বহুরঙা প্ল্যাটফর্ম",
            primaryColorHex = 0xFFF06292,
            region = "Private FM Online"
        ),
        Newspaper(
            id = "radio_aamar",
            name = "Radio Aamar",
            banglaName = "রেডিও আমার ৮৮.৪",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radioaamar.com",
            tagline = "আমার গান আমার অহংকার",
            primaryColorHex = 0xFFE53935,
            region = "Private FM Online"
        ),

        // --- Off Private All Bangla FM Radio online ---
        Newspaper(
            id = "radio_prime",
            name = "Radio Prime",
            banglaName = "রেডিও প্রাইম",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radioprime.com.bd",
            tagline = "অনলাইন মিউজিক ও লাইভ শো",
            primaryColorHex = 0xFF512DA8,
            region = "Off Private FM"
        ),
        Newspaper(
            id = "desh_radio",
            name = "Desh Radio",
            banglaName = "দেশ রেডিও",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://deshradio.com",
            tagline = "দেশের গান ও প্রবাসীদের সংযোগ",
            primaryColorHex = 0xFF2E7D32,
            region = "Off Private FM"
        ),
        Newspaper(
            id = "radio_city",
            name = "Radio City",
            banglaName = "রেডিও সিটি",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radiocity.com.bd",
            tagline = "ডিজিটাল আরবান লাইভ স্টেশন",
            primaryColorHex = 0xFF0277BD,
            region = "Off Private FM"
        ),
        Newspaper(
            id = "radio_active",
            name = "Radio Active",
            banglaName = "রেডিও অ্যাক্টিভ",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://radioactive.com.bd",
            tagline = "উদ্যমী ও তরতাজা অনলাইন মিউজিক",
            primaryColorHex = 0xFFF57C00,
            region = "Off Private FM"
        ),
        Newspaper(
            id = "sufi_fm",
            name = "Sufi FM",
            banglaName = "সুফি এফএম",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://sufifm.com",
            tagline = "আধ্যাত্মিক সুফি সংগীত ও কাওয়ালি",
            primaryColorHex = 0xFF4E342E,
            region = "Off Private FM"
        ),

        // --- State-Owned Radio ---
        Newspaper(
            id = "bangladesh_betar",
            name = "Bangladesh Betar",
            banglaName = "বাংলাদেশ বেতার",
            category = NewspaperCategory.RADIO,
            websiteUrl = "https://www.betar.gov.bd",
            tagline = "জাতীয় সম্প্রচার সংস্থা ও সরকারি রেডিও",
            primaryColorHex = 0xFF1B5E20,
            region = "State-owned Radio"
        )
    )

    // =========================================================================
    // 3. BEST BANGLADESH GOVERNMENT PORTAL (All Ministries, Divisions & Apex Portals)
    // =========================================================================
    val govtPortals: List<Newspaper> = listOf(
        // --- Citizen Services & Central Portals ---
        Newspaper(
            id = "bangladesh_gov",
            name = "Bangladesh gov",
            banglaName = "বাংলাদেশ জাতীয় তথ্য বাতায়ন",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://bangladesh.gov.bd",
            tagline = "গণপ্রজাতন্ত্রী বাংলাদেশ সরকারের কেন্দ্রীয় ওয়েব পোর্টাল",
            primaryColorHex = 0xFF006A4E,
            region = "Citizen Services"
        ),
        Newspaper(
            id = "bangladesh_govt_portal",
            name = "Bangladesh government portal",
            banglaName = "সরকারি নাগরিক সেবা পোর্টাল (myGov)",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://services.portal.gov.bd",
            tagline = "এক ঠিকানায় সকল সরকারি নাগরিক ই-সেবা",
            primaryColorHex = 0xFF00695C,
            region = "Citizen Services"
        ),
        Newspaper(
            id = "nbr_gov",
            name = "NBR Bangladesh",
            banglaName = "জাতীয় রাজস্ব বোর্ড (আয়কর ও ভ্যাট)",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://nbr.gov.bd",
            tagline = "National Board of Revenue",
            primaryColorHex = 0xFF0D47A1,
            region = "Citizen Services"
        ),
        Newspaper(
            id = "police_gov",
            name = "Bangladesh Police",
            banglaName = "বাংলাদেশ পুলিশ (অনলাইন জিডি)",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://police.gov.bd",
            tagline = "আইনশৃঙ্খলা ও নাগরিক নিরাপত্তা সেবা",
            primaryColorHex = 0xFF1A237E,
            region = "Citizen Services"
        ),
        Newspaper(
            id = "dip_gov",
            name = "Immigration & Passports",
            banglaName = "ইমিগ্রেশন ও পাসপোর্ট অধিদপ্তর (ই-পাসপোর্ট)",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://dip.gov.bd",
            tagline = "অনলাইন পাসপোর্ট আবেদন ও স্ট্যাটাস যাচাই",
            primaryColorHex = 0xFF2E7D32,
            region = "Citizen Services"
        ),
        Newspaper(
            id = "nidw_gov",
            name = "National ID Wing",
            banglaName = "জাতীয় পরিচয়পত্র উইং (NID)",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://services.nidw.gov.bd",
            tagline = "অনলাইন এনআইডি সেবা ও তথ্য সংশোধন",
            primaryColorHex = 0xFF00838F,
            region = "Citizen Services"
        ),
        Newspaper(
            id = "egp_gov",
            name = "e-GP Tender Portal",
            banglaName = "জাতীয় ই-টেন্ডারিং পোর্টাল (e-GP)",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://eprocure.gov.bd",
            tagline = "সরকারি দরপত্র ও জাতীয় ক্রয় ব্যবস্থাপনা",
            primaryColorHex = 0xFF004D40,
            region = "Citizen Services"
        ),

        // --- Ministries & Divisions ---
        Newspaper(
            id = "pmo_gov",
            name = "Chief Adviser's Office",
            banglaName = "প্রধান উপদেষ্টার কার্যালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://pmo.gov.bd",
            tagline = "গণপ্রজাতন্ত্রী বাংলাদেশ সরকারের নির্বাহী কার্যালয়",
            primaryColorHex = 0xFF004D40,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "cabinet_division",
            name = "Cabinet Division",
            banglaName = "মন্ত্রিপরিষদ বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://cabinet.gov.bd",
            tagline = "নীতিমালা ও প্রশাসনিক সমন্বয়কারী শীর্ষ সংস্থা",
            primaryColorHex = 0xFF1B5E20,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mopa_gov",
            name = "MOPA",
            banglaName = "জনপ্রশাসন মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mopa.gov.bd",
            tagline = "Ministry of Public Administration",
            primaryColorHex = 0xFF283593,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "ministry_of_finance",
            name = "Ministry of Finance",
            banglaName = "অর্থ মন্ত্রণালয় (অর্থ বিভাগ)",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mof.gov.bd",
            tagline = "জাতীয় বাজেট, রাজস্ব ও অর্থনৈতিক ব্যবস্থাপনা",
            primaryColorHex = 0xFFC62828,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "fid_gov",
            name = "Financial Institutions Division",
            banglaName = "আর্থিক প্রতিষ্ঠান বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://fid.gov.bd",
            tagline = "ব্যাংক ও আর্থিক প্রতিষ্ঠান নীতি",
            primaryColorHex = 0xFF1565C0,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "erd_gov",
            name = "Economic Relations Division",
            banglaName = "অর্থনৈতিক সম্পর্ক বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://erd.gov.bd",
            tagline = "বৈদেশিক সহায়তা ও আন্তর্জাতিক অর্থনৈতিক সহযোগিতা",
            primaryColorHex = 0xFF00695C,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "ird_gov",
            name = "Internal Resources Division",
            banglaName = "অভ্যন্তরীণ সম্পদ বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://ird.gov.bd",
            tagline = "জাতীয় রাজস্ব ও অভ্যন্তরীণ কর সম্পদ",
            primaryColorHex = 0xFF1976D2,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "plandiv_gov",
            name = "Ministry of Planning",
            banglaName = "পরিকল্পনা মন্ত্রণালয় (পরিকল্পনা বিভাগ)",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://plandiv.gov.bd",
            tagline = "জাতীয় উন্নয়ন পরিকল্পনা ও একনেক ব্যবস্থাপনা",
            primaryColorHex = 0xFF2E7D32,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "sid_gov",
            name = "Statistics Division",
            banglaName = "পরিসংখ্যান ও তথ্য ব্যবস্থাপনা বিভাগ (বিবিএস)",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://sid.gov.bd",
            tagline = "জাতীয় জনশুমারি ও আর্থসামাজিক জরিপ",
            primaryColorHex = 0xFF388E3C,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "imed_gov",
            name = "IMED",
            banglaName = "বাস্তবায়ন পরিবীক্ষণ ও মূল্যায়ন বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://imed.gov.bd",
            tagline = "উন্নয়ন প্রকল্পের মান ও অগ্রগতি তদারকি",
            primaryColorHex = 0xFF558B2F,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mha_gov",
            name = "Ministry of Home Affairs",
            banglaName = "স্বরাষ্ট্র মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mha.gov.bd",
            tagline = "অভ্যন্তরীণ নিরাপত্তা ও শৃঙ্খলা রক্ষা",
            primaryColorHex = 0xFFB71C1C,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "psd_gov",
            name = "Public Security Division",
            banglaName = "জননিরাপত্তা বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mhapsd.gov.bd",
            tagline = "জননিরাপত্তা ও পুলিশ বাহিনী পরিচালনা",
            primaryColorHex = 0xFFC62828,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "ssd_gov",
            name = "Security Services Division",
            banglaName = "সুরক্ষা সেবা বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://ssd.gov.bd",
            tagline = "পাসপোর্ট, কারাগার, মাদক ও ফায়ার সার্ভিস প্রশাসন",
            primaryColorHex = 0xFFD32F2F,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "ministry_of_foreign",
            name = "Ministry of foreign",
            banglaName = "পররাষ্ট্র মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mofa.gov.bd",
            tagline = "Ministry of Foreign Affairs Bangladesh",
            primaryColorHex = 0xFF0277BD,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mod_gov",
            name = "Ministry of Defence",
            banglaName = "প্রতিরক্ষা মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mod.gov.bd",
            tagline = "জাতীয় সার্বভৌমত্ব ও প্রতিরক্ষানীতি",
            primaryColorHex = 0xFF33691E,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "afd_gov",
            name = "Armed Forces Division",
            banglaName = "সশস্ত্র বাহিনী বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://afd.gov.bd",
            tagline = "সেনা, নৌ ও বিমান বাহিনীর শীর্ষ সমন্বয়",
            primaryColorHex = 0xFF1B5E20,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "law_div_gov",
            name = "Ministry of Law & Justice",
            banglaName = "আইন ও বিচার বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://lawjusticediv.gov.bd",
            tagline = "আইন ও বিচার প্রশাসন",
            primaryColorHex = 0xFF3F51B5,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "legislative_gov",
            name = "Legislative Division",
            banglaName = "লেজিসলেটিভ ও সংসদ বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://legislativediv.gov.bd",
            tagline = "আইন প্রণয়ন ও খসড়া প্রস্তুত",
            primaryColorHex = 0xFF4A148C,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "moedu_gov",
            name = "Ministry of Education",
            banglaName = "শিক্ষা মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://moedu.gov.bd",
            tagline = "জাতীয় শিক্ষানীতি ও বাস্তবায়ন",
            primaryColorHex = 0xFF00897B,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "shed_gov",
            name = "SHED",
            banglaName = "মাধ্যমিক ও উচ্চ শিক্ষা বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://shed.gov.bd",
            tagline = "মাধ্যমিক ও উচ্চ শিক্ষা প্রশাসন",
            primaryColorHex = 0xFF00796B,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "tmed_gov",
            name = "TMED",
            banglaName = "কারিগরি ও মাদ্রাসা শিক্ষা বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://tmed.gov.bd",
            tagline = "কারিগরি ও মাদ্রাসা শিক্ষা",
            primaryColorHex = 0xFF0288D1,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mopme_gov",
            name = "Ministry of Primary Education",
            banglaName = "প্রাথমিক ও গণশিক্ষা মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mopme.gov.bd",
            tagline = "প্রাথমিক শিক্ষা ও সাক্ষরতা বিস্তার",
            primaryColorHex = 0xFFE65100,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "ministry_of_health",
            name = "Ministry of Health",
            banglaName = "স্বাস্থ্য ও পরিবার কল্যাণ মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mohfw.gov.bd",
            tagline = "Ministry of Health and Family Welfare",
            primaryColorHex = 0xFF00897B,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "hsd_gov",
            name = "Health Services Division",
            banglaName = "স্বাস্থ্য সেবা বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://hsd.gov.bd",
            tagline = "স্বাস্থ্য সেবা ও হাসপাতাল ব্যবস্থাপনা",
            primaryColorHex = 0xFF00695C,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mefwd_gov",
            name = "Medical Education Division",
            banglaName = "চিকিৎসা শিক্ষা ও পরিবার কল্যাণ বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mefwd.gov.bd",
            tagline = "মেডিকেল শিক্ষা ও জনসংখ্যা ব্যবস্থাপনা",
            primaryColorHex = 0xFF00796B,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "moa_gov",
            name = "Ministry of Agriculture",
            banglaName = "কৃষি মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://moa.gov.bd",
            tagline = "কৃষি উন্নয়ন ও খাদ্য স্বয়ম্ভরতা",
            primaryColorHex = 0xFF2E7D32,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "ministry_of_food",
            name = "Ministry of food",
            banglaName = "খাদ্য মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mofood.gov.bd",
            tagline = "নিরাপদ খাদ্য ও টেকসই খাদ্য নিরাপত্তা",
            primaryColorHex = 0xFF2E7D32,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mincom_gov",
            name = "Ministry of Commerce",
            banglaName = "বাণিজ্য মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mincom.gov.bd",
            tagline = "অভ্যন্তরীণ ও আন্তর্জাতিক বাণিজ্য",
            primaryColorHex = 0xFFC2185B,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "ministry_of_industries",
            name = "Ministry of Industries",
            banglaName = "শিল্প মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://moind.gov.bd",
            tagline = "টেকসই শিল্পায়ন ও উৎপাদনশীলতা বৃদ্ধি",
            primaryColorHex = 0xFFE65100,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "most_gov",
            name = "MOST",
            banglaName = "বিজ্ঞান ও প্রযুক্তি মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://most.gov.bd",
            tagline = "Ministry of Science and Technology",
            primaryColorHex = 0xFF1565C0,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "ictd_gov",
            name = "ICT Division",
            banglaName = "তথ্য ও যোগাযোগ প্রযুক্তি বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://ictd.gov.bd",
            tagline = "স্মার্ট বাংলাদেশ ও তথ্যপ্রযুক্তি অবকাঠামো",
            primaryColorHex = 0xFF0288D1,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "ptd_gov",
            name = "Posts & Telecom Division",
            banglaName = "ডাক ও টেলিযোগাযোগ বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://ptd.gov.bd",
            tagline = "ডাক ও আধুনিক টেলিযোগাযোগ সেবা",
            primaryColorHex = 0xFF512DA8,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "moi_gov",
            name = "MOI",
            banglaName = "তথ্য ও সম্প্রচার মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://moi.gov.bd",
            tagline = "Ministry of Information and Broadcasting",
            primaryColorHex = 0xFF6A1B9A,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mpemr_gov",
            name = "Power & Energy Ministry",
            banglaName = "বিদ্যুৎ ও জ্বালানি মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mpemr.gov.bd",
            tagline = "টেকসই বিদ্যুৎ ও খনিজ সম্পদ",
            primaryColorHex = 0xFFF57C00,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "power_div_gov",
            name = "Power Division",
            banglaName = "বিদ্যুৎ বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://powerdivision.gov.bd",
            tagline = "জাতীয় বিদ্যুৎ উৎপাদন ও বিতরণ",
            primaryColorHex = 0xFFE65100,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "emrd_gov",
            name = "Energy & Mineral Division",
            banglaName = "জ্বালানি ও খনিজ সম্পদ বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://emrd.gov.bd",
            tagline = "গ্যাস, তেল ও জ্বালানি সম্পদ",
            primaryColorHex = 0xFFD84315,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "rthd_gov",
            name = "Road Transport & Bridges",
            banglaName = "সড়ক পরিবহন ও মহাসড়ক বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://rthd.gov.bd",
            tagline = "সড়ক যোগাযোগ ও মহাসড়ক উন্নয়ন",
            primaryColorHex = 0xFF37474F,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "bridges_div_gov",
            name = "Bridges Division",
            banglaName = "সেতু বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://bridgesdivision.gov.bd",
            tagline = "পদ্মা সেতু ও জাতীয় মেগা সেতু সংযোগ",
            primaryColorHex = 0xFF1565C0,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mor_gov",
            name = "Ministry of Railways",
            banglaName = "রেলপথ মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mor.gov.bd",
            tagline = "বাংলাদেশ রেলওয়ে উন্নয়ন ও নিরাপদ যাত্রা",
            primaryColorHex = 0xFF1B5E20,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mos_gov",
            name = "Ministry of Shipping",
            banglaName = "নৌপরিবহন মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mos.gov.bd",
            tagline = "নৌপথ, সমুদ্র বন্দর ও নদী পরিবহন",
            primaryColorHex = 0xFF0277BD,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mocat_gov",
            name = "Civil Aviation & Tourism",
            banglaName = "বেসামরিক বিমান পরিবহন ও পর্যটন",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mocat.gov.bd",
            tagline = "এভিয়েশন নিরাপত্তা ও পর্যটন বিকাশ",
            primaryColorHex = 0xFF00838F,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "lgd_gov",
            name = "Local Government Division",
            banglaName = "স্থানীয় সরকার বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://lgd.gov.bd",
            tagline = "ইউনিয়ন, পৌরসভা ও সিটি কর্পোরেশন সেবা",
            primaryColorHex = 0xFF2E7D32,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "rdcd_gov",
            name = "Rural Development Division",
            banglaName = "পল্লী উন্নয়ন ও সমবায় বিভাগ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://rdcd.gov.bd",
            tagline = "পল্লী অঞ্চলের সামাজিক ও অর্থনৈতিক উন্নয়ন",
            primaryColorHex = 0xFF558B2F,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mowr_gov",
            name = "Ministry of Water Resources",
            banglaName = "পানি সম্পদ মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mowr.gov.bd",
            tagline = "নদী খনন, বন্যা নিয়ন্ত্রণ ও পানিসম্পদ",
            primaryColorHex = 0xFF0288D1,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "moef_gov",
            name = "Environment & Forest",
            banglaName = "পরিবেশ, বন ও জলবায়ু পরিবর্তন মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://moef.gov.bd",
            tagline = "পরিবেশ সুরক্ষা, জলবায়ু পরিবর্তন ও বনায়ন",
            primaryColorHex = 0xFF1B5E20,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "minland_gov",
            name = "Ministry of Land",
            banglaName = "ভূমি মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://minland.gov.bd",
            tagline = "ডিজিটাল ভূমিসেবা ও ভূমি রেকর্ড",
            primaryColorHex = 0xFF8D6E63,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mohpw_gov",
            name = "Housing & Public Works",
            banglaName = "গৃহায়ন ও গণপূর্ত মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mohpw.gov.bd",
            tagline = "সরকারি আবাসন ও নগর উন্নয়ন",
            primaryColorHex = 0xFF5D4037,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mofl_gov",
            name = "Fisheries & Livestock",
            banglaName = "মৎস্য ও প্রাণিসম্পদ মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mofl.gov.bd",
            tagline = "মাছ ও প্রাণিসম্পদের টেকসই উৎপাদন",
            primaryColorHex = 0xFF00695C,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "modmr_gov",
            name = "Disaster Management",
            banglaName = "দুর্যোগ ব্যবস্থাপনা ও ত্রাণ মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://modmr.gov.bd",
            tagline = "দুর্যোগ মোকাবিলা, ত্রাণ ও পুনর্বাসন",
            primaryColorHex = 0xFFC62828,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "msw_gov",
            name = "Ministry of Social Welfare",
            banglaName = "সমাজকল্যাণ মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://msw.gov.bd",
            tagline = "প্রতিবন্ধী, প্রবীণ ও দুস্থ কল্যাণ",
            primaryColorHex = 0xFF6A1B9A,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mowca_gov",
            name = "Women & Children Affairs",
            banglaName = "মহিলা ও শিশু বিষয়ক মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mowca.gov.bd",
            tagline = "নারী ক্ষমতায়ন ও শিশু সুরক্ষা",
            primaryColorHex = 0xFFAD1457,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mole_gov",
            name = "MOLE",
            banglaName = "শ্রম ও কর্মসংস্থান মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mole.gov.bd",
            tagline = "Ministry of Labour and Employment",
            primaryColorHex = 0xFFEF6C00,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "molwa_gov",
            name = "Liberation War Affairs",
            banglaName = "মুক্তিযুদ্ধ বিষয়ক মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://molwa.gov.bd",
            tagline = "বীর মুক্তিযোদ্ধা কল্যাণ ও স্মৃতি সংরক্ষণ",
            primaryColorHex = 0xFFB71C1C,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mora_gov",
            name = "Religious Affairs Ministry",
            banglaName = "ধর্ম বিষয়ক মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mora.gov.bd",
            tagline = "হজ ব্যবস্থাপনা ও ধর্মীয় সম্প্রীতি",
            primaryColorHex = 0xFF004D40,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "moysports_gov",
            name = "Youth & Sports Ministry",
            banglaName = "যুব ও ক্রীড়া মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://moysports.gov.bd",
            tagline = "যুব উন্নয়ন ও ক্রীড়া প্রতিযোগিতা",
            primaryColorHex = 0xFFE65100,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "moca_gov",
            name = "Ministry of Cultural Affairs",
            banglaName = "সংস্কৃতি বিষয়ক মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://moca.gov.bd",
            tagline = "ঐতিহ্য ও সাংস্কৃতিক বিকাশ",
            primaryColorHex = 0xFF7B1FA2,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "motj_gov",
            name = "Textiles & Jute Ministry",
            banglaName = "বস্ত্র ও পাট মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://motj.gov.bd",
            tagline = "সোনালী আঁশ পাট ও টেক্সটাইল শিল্প",
            primaryColorHex = 0xFF558B2F,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "mochta_gov",
            name = "Chittagong Hill Tracts",
            banglaName = "পার্বত্য চট্টগ্রাম বিষয়ক মন্ত্রণালয়",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://mochta.gov.bd",
            tagline = "পার্বত্য অঞ্চলের টেকসই উন্নয়ন",
            primaryColorHex = 0xFF33691E,
            region = "Ministries & Divisions"
        ),
        Newspaper(
            id = "probashi_gov",
            name = "Expatriates' Welfare",
            banglaName = "প্রবাসী কল্যাণ ও বৈদেশিক কর্মসংস্থান",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://probashi.gov.bd",
            tagline = "প্রবাসী শ্রমিক কল্যাণ ও বৈদেশিক কর্মসংস্থান",
            primaryColorHex = 0xFF00796B,
            region = "Ministries & Divisions"
        ),

        // --- Constitutional & Apex Institutions ---
        Newspaper(
            id = "supremecourt_gov",
            name = "Supreme Court",
            banglaName = "বাংলাদেশ সুপ্রীম কোর্ট",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://supremecourt.gov.bd",
            tagline = "বাংলাদেশের সর্বোচ্চ বিচার বিভাগীয় প্রতিষ্ঠান",
            primaryColorHex = 0xFF283593,
            region = "Constitutional & Apex"
        ),
        Newspaper(
            id = "parliament_gov",
            name = "Bangladesh Parliament",
            banglaName = "বাংলাদেশ জাতীয় সংসদ",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://parliament.gov.bd",
            tagline = "জাতীয় সংসদ আইনসভা ও সংসদীয় কার্যক্রম",
            primaryColorHex = 0xFF1B5E20,
            region = "Constitutional & Apex"
        ),
        Newspaper(
            id = "ecs_gov",
            name = "Election Commission",
            banglaName = "বাংলাদেশ নির্বাচন কমিশন",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://ecs.gov.bd",
            tagline = "জাতীয় ও স্থানীয় সরকার নির্বাচন কমিশন",
            primaryColorHex = 0xFF1565C0,
            region = "Constitutional & Apex"
        ),
        Newspaper(
            id = "bpsc_gov",
            name = "BPSC",
            banglaName = "বাংলাদেশ সরকারি কর্ম কমিশন (বিসিএস)",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://bpsc.gov.bd",
            tagline = "সিভিল সার্ভিস নিয়োগ ও পরিচালনা",
            primaryColorHex = 0xFF00695C,
            region = "Constitutional & Apex"
        ),
        Newspaper(
            id = "cag_gov",
            name = "CAG Bangladesh",
            banglaName = "মহা হিসাব-নিরীক্ষক ও নিয়ন্ত্রক",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://cag.org.bd",
            tagline = "রাষ্ট্রীয় হিসাব নিরীক্ষা ও স্বচ্ছতা",
            primaryColorHex = 0xFF4527A0,
            region = "Constitutional & Apex"
        ),
        Newspaper(
            id = "acc_gov",
            name = "Anti-Corruption Commission",
            banglaName = "দুর্নীতি দমন কমিশন (দুদক)",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://acc.org.bd",
            tagline = "দুর্নীতি প্রতিরোধ ও আইনি পদক্ষেপ",
            primaryColorHex = 0xFFC62828,
            region = "Constitutional & Apex"
        ),
        Newspaper(
            id = "bb_gov",
            name = "Bangladesh Bank",
            banglaName = "বাংলাদেশ ব্যাংক (কেন্দ্রীয় ব্যাংক)",
            category = NewspaperCategory.GOVERNMENT,
            websiteUrl = "https://bb.org.bd",
            tagline = "কেন্দ্রীয় আর্থিক ও ব্যাংকিং নিয়ন্ত্রণ সংস্থা",
            primaryColorHex = 0xFF1565C0,
            region = "Constitutional & Apex"
        )
    )

    // =========================================================================
    // 4. STOCK MARKET ALL NEWSPAPER BANGLA ONLINE (20)
    // =========================================================================
    val stockMarketSites: List<Newspaper> = listOf(
        Newspaper(
            id = "share_news_24",
            name = "Share News 24",
            banglaName = "শেয়ার নিউজ ২৪",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://sharenews24.com",
            tagline = "পুঁজিবাজার ও শেয়ার লেনদেনের তাজা খবর",
            primaryColorHex = 0xFF0D47A1
        ),
        Newspaper(
            id = "arthosuchak",
            name = "Arthosuchak",
            banglaName = "অর্থসূচক",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://arthosuchak.com",
            tagline = "পুঁজিবাজার ও ব্যবসা-বাণিজ্যের শীর্ষ পোর্টাল",
            primaryColorHex = 0xFF1565C0
        ),
        Newspaper(
            id = "share_bazar_news",
            name = "Share Bazar News",
            banglaName = "শেয়ার বাজার নিউজ",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://sharebazarnews.com",
            tagline = "শেয়ার লেনদেন ও বিনিয়োগ বিশ্লেষণ",
            primaryColorHex = 0xFF2E7D32
        ),
        Newspaper(
            id = "sun_bd_24",
            name = "Sun bd 24",
            banglaName = "সান বিডি ২৪",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://sunbd24.com",
            tagline = "অর্থনীতি ও শেয়ার বাজারের সর্বশেষ তথ্য",
            primaryColorHex = 0xFFF57F17
        ),
        Newspaper(
            id = "ortho_songbad",
            name = "Ortho Songbad",
            banglaName = "অর্থ সংবাদ",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://orthosongbad.com",
            tagline = "পুঁজিবাজার, ব্যাংক ও বীমা সংবাদ",
            primaryColorHex = 0xFF00838F
        ),
        Newspaper(
            id = "share_market_bd",
            name = "Share Market BD",
            banglaName = "শেয়ার মার্কেট বিডি",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://sharemarketbd.com",
            tagline = "ডিএসই ও সিএসই সূচকের আপডেট",
            primaryColorHex = 0xFF37474F
        ),
        Newspaper(
            id = "share_business",
            name = "Share Business",
            banglaName = "শেয়ার বিজনেস",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://sharebusiness24.com",
            tagline = "শেয়ার ব্যবসা ও বিনিয়োগের তথ্যভাণ্ডার",
            primaryColorHex = 0xFF1B5E20
        ),
        Newspaper(
            id = "corporate_sangbad",
            name = "Corporate Sangbad",
            banglaName = "কর্পোরেট সংবাদ",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://corporatesangbad.com",
            tagline = "কর্পোরেট সেক্টর ও ফাইন্যান্স নিউজ",
            primaryColorHex = 0xFF4527A0
        ),
        Newspaper(
            id = "puji_bazar",
            name = "Puji bazar",
            banglaName = "পুঁজিবাজার ডট কম",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://pujibazar.com",
            tagline = "পুঁজিবাজারের নির্ভরযোগ্য খবর ও ডাটা",
            primaryColorHex = 0xFFC2185B
        ),
        Newspaper(
            id = "business_hour_24",
            name = "Business Hour 24",
            banglaName = "বিজনেস আওয়ার ২৪",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://businesshour24.com",
            tagline = "পুঁজিবাজার ও করপোরেট বিশ্লেষণ",
            primaryColorHex = 0xFFE65100
        ),
        Newspaper(
            id = "biniyoug_barta",
            name = "Biniyoug Barta",
            banglaName = "বিনিয়োগ বার্তা",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://biniyougbarta.com",
            tagline = "সঠিক বিনিয়োগ ও সমৃদ্ধ আগামীর বার্তা",
            primaryColorHex = 0xFF00695C
        ),
        Newspaper(
            id = "ajker_bazzar",
            name = "Ajker Bazzar",
            banglaName = "আজকের বাজার",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://ajkerbazzar.com",
            tagline = "বাণিজ্য, শেয়ারবাজার ও ব্যাংকিং",
            primaryColorHex = 0xFF283593
        ),
        Newspaper(
            id = "banking_news",
            name = "Banking News",
            banglaName = "ব্যাংকিং নিউজ বিডি",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://bankingnewsbd.com",
            tagline = "ব্যাংক, আর্থিক প্রতিষ্ঠান ও অর্থনীতি",
            primaryColorHex = 0xFF303F9F
        ),
        Newspaper(
            id = "arthoniteer_kagoj",
            name = "Arthoniteer Kagoj",
            banglaName = "অর্থনীতির কাগজ",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://arthoniteerkagoj.com",
            tagline = "বাংলাদেশের অর্থনীতি ও আর্থিক খাত",
            primaryColorHex = 0xFF558B2F
        ),
        Newspaper(
            id = "bd_business_news",
            name = "BD Business News",
            banglaName = "বিডি বিজনেস নিউজ",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://bdbusinessnews.com",
            tagline = "বাণিজ্য, রফতানি ও করপোরেট নিউজ",
            primaryColorHex = 0xFF00838F
        ),
        Newspaper(
            id = "daily_stock_bangladesh",
            name = "Daily Stock Bangladesh",
            banglaName = "ডেইলি স্টক বাংলাদেশ",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://dailystockbangladesh.com",
            tagline = "স্টক এক্সচেঞ্জের দৈনিক লেনদেন আপডেট",
            primaryColorHex = 0xFFAD1457
        ),
        Newspaper(
            id = "share_barta",
            name = "Share Barta",
            banglaName = "শেয়ার বার্তা",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://sharebarta.net",
            tagline = "শেয়ারহোল্ডার ও বিনিয়োগকারীদের খবর",
            primaryColorHex = 0xFF00796B
        ),
        Newspaper(
            id = "financial_express_stock",
            name = "The Financial Express",
            banglaName = "ফাইন্যান্সিয়াল এক্সপ্রেস",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://thefinancialexpress.com.bd",
            tagline = "প্রিমিয়ার বিজনেস অ্যান্ড স্টক মার্কেট ডেইলি",
            primaryColorHex = 0xFF1A237E
        ),
        Newspaper(
            id = "sharebazar_protidin",
            name = "ShareBazar Protidin",
            banglaName = "শেয়ারবাজার প্রতিদিন",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://sharebazarprotidin.com",
            tagline = "প্রতিদিনের পুঁজিবাজারের দর ও বিশ্লেষণ",
            primaryColorHex = 0xFFC62828
        ),
        Newspaper(
            id = "business_eye_bd",
            name = "Business Eye BD",
            banglaName = "বিজনেস আই বিডি",
            category = NewspaperCategory.STOCK_MARKET,
            websiteUrl = "https://businesseye.com.bd",
            tagline = "ব্যবসা ও শেয়ারবাজারের বিশ্বস্ত চোখ",
            primaryColorHex = 0xFF3E2723
        )
    )

    // =========================================================================
    // 5. ALL BANGLA MAGAZINE (20)
    // =========================================================================
    val banglaMagazines: List<Newspaper> = listOf(
        Newspaper(
            id = "kali_o_kalam",
            name = "Kali O Kalam",
            banglaName = "কালি ও কলম",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://www.kaliokalam.com",
            tagline = "শিল্প সাহিত্য ও সংস্কৃতির মাসিক পত্রিকা",
            primaryColorHex = 0xFF880E4F
        ),
        Newspaper(
            id = "kishor_alo",
            name = "Kishor Alo",
            banglaName = "কিশোর আলো",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://kishoralo.com",
            tagline = "কিশোর-কিশোরীদের প্রিয় মাসিক প্রকাশনা",
            primaryColorHex = 0xFFFF6F00
        ),
        Newspaper(
            id = "abasar",
            name = "Abasar",
            banglaName = "অবসর",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://abasar.net",
            tagline = "সাহিত্য, বিজ্ঞান ও সংস্কৃতির অনলাইন সাময়িকী",
            primaryColorHex = 0xFF33691E
        ),
        Newspaper(
            id = "at_tahreek",
            name = "At Tahreek",
            banglaName = "মাসিক আত-তাহরীক",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://at-tahreek.com",
            tagline = "ধর্ম, সমাজ ও সাহিত্য বিষয়ক মাসিক সাময়িকী",
            primaryColorHex = 0xFF004D40
        ),
        Newspaper(
            id = "parabaas",
            name = "Parabaas",
            banglaName = "পরবাস",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://www.parabaas.com",
            tagline = "বাংলা ওয়েব সাহিত্য সাময়িকী",
            primaryColorHex = 0xFF4A148C
        ),
        Newspaper(
            id = "anannya",
            name = "Anannya",
            banglaName = "অনন্যা",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://anannya.com.bd",
            tagline = "নারী ও সমাজের অধিকার ভিত্তিক পাক্ষিক",
            primaryColorHex = 0xFFC2185B
        ),
        Newspaper(
            id = "porospor",
            name = "Porospor",
            banglaName = "পরস্পর",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://porospor.com",
            tagline = "শিল্প ও চিন্তার মুক্ত সাহিত্য পত্রিকা",
            primaryColorHex = 0xFF263238
        ),
        Newspaper(
            id = "ananda_alo",
            name = "Ananda Alo",
            banglaName = "আনন্দ আলো",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://anandaalo.com",
            tagline = "বিনোদন, ফ্যাশন ও জীবনযাপন সাময়িকী",
            primaryColorHex = 0xFFE65100
        ),
        Newspaper(
            id = "career_intelligence",
            name = "Career Intelligence",
            banglaName = "ক্যারিয়ার ইন্টেলিজেন্স",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://careerintel.net",
            tagline = "ক্যারিয়ার উন্নয়ন ও প্রফেশনাল ম্যাগাজিন",
            primaryColorHex = 0xFF0D47A1
        ),
        Newspaper(
            id = "bangla_mati",
            name = "Bangla Mati",
            banglaName = "বাংলা মাটি",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://banglamati.com",
            tagline = "কৃষি, প্রকৃতি ও লোকজ সংস্কৃতি সাময়িকী",
            primaryColorHex = 0xFF2E7D32
        ),
        Newspaper(
            id = "canvas_mag",
            name = "Canvas",
            banglaName = "ক্যানভাস",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://canvasmagazine.com.bd",
            tagline = "ফ্যাশন, স্টাইল ও লাইফস্টাইল ম্যাগাজিন",
            primaryColorHex = 0xFFB71C1C
        ),
        Newspaper(
            id = "bangla_street",
            name = "Bangla Street",
            banglaName = "বাংলা স্ট্রিট",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://banglastreet.com",
            tagline = "সাহিত্য, গল্প, কবিতা ও তরুণদের রচনা",
            primaryColorHex = 0xFF006064
        ),
        Newspaper(
            id = "hatpakha",
            name = "Hatpakha",
            banglaName = "হাতপাখা",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://hatpakha.com",
            tagline = "ঐতিহ্য, রূপকথা ও সাহিত্য সাময়িকী",
            primaryColorHex = 0xFFBF360C
        ),
        Newspaper(
            id = "doshdik",
            name = "Doshdik",
            banglaName = "দশদিক",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://doshdik.com",
            tagline = "সমাজ, দর্শন ও সাহিত্যের ত্রৈমাসিক",
            primaryColorHex = 0xFF1A237E
        ),
        Newspaper(
            id = "computer_jagat",
            name = "Computer Jagat",
            banglaName = "কম্পিউটার জগৎ",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://www.comjagat.com",
            tagline = "দেশের প্রথম আইসিটি ও প্রযুক্তি ম্যাগাজিন",
            primaryColorHex = 0xFF01579B
        ),
        Newspaper(
            id = "ananda_mela",
            name = "Ananda Mela",
            banglaName = "আনন্দমেলা",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://anandamela.anandabazar.com",
            tagline = "ছোটদের প্রিয় কিশোর ও শিশুতোষ পত্রিকা",
            primaryColorHex = 0xFFFF8F00
        ),
        Newspaper(
            id = "sananda",
            name = "Sananda",
            banglaName = "সানন্দা",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://sananda.in",
            tagline = "নারীদের লাইফস্টাইল, ফ্যাশন ও পরিবার",
            primaryColorHex = 0xFFAD1457
        ),
        Newspaper(
            id = "anandalok",
            name = "Anandalok",
            banglaName = "আনন্দলোক",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://anandalok.in",
            tagline = "সিনেমা, সেলিব্রিটি ও বিনোদন সাময়িকী",
            primaryColorHex = 0xFF6A1B9A
        ),
        Newspaper(
            id = "parjatan_bichitra",
            name = "Parjatan Bichitra",
            banglaName = "পর্যটন বিচিত্রা",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://parjatanbichitra.com",
            tagline = "ভ্রমণ ও পর্যটন বিষয়ক প্রথম ম্যাগাজিন",
            primaryColorHex = 0xFF00695C
        ),
        Newspaper(
            id = "kishore_bangla",
            name = "Kishore Bangla",
            banglaName = "কিশোর বাংলা",
            category = NewspaperCategory.MAGAZINE,
            websiteUrl = "https://kishorebangla.com",
            tagline = "শিশু-কিশোর সাহিত্য ও সৃজনশীল প্রতিভা",
            primaryColorHex = 0xFF0288D1
        )
    )

    // =========================================================================
    // 6. TOP BANGLA TECH SITE (15)
    // =========================================================================
    val techSites: List<Newspaper> = listOf(
        Newspaper(
            id = "courstika",
            name = "Courstika",
            banglaName = "কোর্সটিকা",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://courstika.com",
            tagline = "ডিজিটাল পাঠ্যক্রম ও টেকনিক্যাল লার্নিং",
            primaryColorHex = 0xFF1565C0
        ),
        Newspaper(
            id = "bangla_tech_24",
            name = "Bangla Tech 24",
            banglaName = "বাংলা টেক ২৪",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://banglatech24.com",
            tagline = "প্রযুক্তি টিপস, রিভিউ ও আইটি সংবাদ",
            primaryColorHex = 0xFF00897B
        ),
        Newspaper(
            id = "tuner_page",
            name = "Tuner Page",
            banglaName = "টিউনার পেজ",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://tunerpage.com",
            tagline = "বাংলা প্রযুক্তির উন্মুক্ত টিউন ও টিপস কমিউনিটি",
            primaryColorHex = 0xFFEF6C00
        ),
        Newspaper(
            id = "somewhere_in_blog",
            name = "Somewhere In Blog",
            banglaName = "সামহোয়্যার ইন ব্লগ",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://somewhereinblog.net",
            tagline = "বাঁধ ভাঙার আওয়াজ — শীর্ষ বাংলা কমিউনিটি ব্লগ",
            primaryColorHex = 0xFF3E2723
        ),
        Newspaper(
            id = "techtunes",
            name = "Techtunes",
            banglaName = "টেকটিউনস",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://techtunes.io",
            tagline = "বাংলাদেশের মেগা টেকনোলজি সোশ্যাল নেটওয়ার্ক",
            primaryColorHex = 0xFF0288D1
        ),
        Newspaper(
            id = "tech_zoom",
            name = "Tech Zoom",
            banglaName = "টেক জুম",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://techzoom.tv",
            tagline = "আধুনিক গ্যাজেট, ফোন ও ইনোভেশন নিউজ",
            primaryColorHex = 0xFFD81B60
        ),
        Newspaper(
            id = "tech_shohor",
            name = "Tech Shohor",
            banglaName = "টেক শহর",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://techshohor.com",
            tagline = "তথ্যপ্রযুক্তি, গ্যাজেট ও টেলিকম সংবাদ",
            primaryColorHex = 0xFF00ACC1
        ),
        Newspaper(
            id = "pc_helpline_bd",
            name = "PC Helpline BD",
            banglaName = "পিসি হেল্পলাইন বিডি",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://pchelplinebd.com",
            tagline = "কম্পিউটার সমস্যা সমাধান ও সফটওয়্যার টিপস",
            primaryColorHex = 0xFF2E7D32
        ),
        Newspaper(
            id = "hoicoi_bangla",
            name = "Hoicoi Bangla",
            banglaName = "হইচই বাংলা",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://hoicoibangla.com",
            tagline = "প্রযুক্তি, গেমিং ও ইন্টারনেট টিপস পোর্টাল",
            primaryColorHex = 0xFF7B1FA2
        ),
        Newspaper(
            id = "trick_blog_bd",
            name = "Trick Blog BD",
            banglaName = "ট্রিক ব্লগ বিডি",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://trickblogbd.com",
            tagline = "অ্যান্ড্রয়েড ট্রিকস ও অনলাইন আয় গাইড",
            primaryColorHex = 0xFFF57C00
        ),
        Newspaper(
            id = "tech_jano",
            name = "Tech Jano",
            banglaName = "টেক জানো",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://techjano.com",
            tagline = "প্রযুক্তি জানুন বাংলায় সহজ ভাষায়",
            primaryColorHex = 0xFF0D47A1
        ),
        Newspaper(
            id = "adda_buzz",
            name = "Adda buzz",
            banglaName = "আড্ডা বাজ",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://addabuzz.com",
            tagline = "আইটি জ্ঞান, সোশ্যাল মিডিয়া ও অনলাইন ট্রেন্ডস",
            primaryColorHex = 0xFF689F38
        ),
        Newspaper(
            id = "tech_site_bangla",
            name = "Tech Site Bangla",
            banglaName = "টেক সাইট বাংলা",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://techsitebangla.com",
            tagline = "মোবাইল টিপস, টিউটোরিয়াল ও রিভিউ",
            primaryColorHex = 0xFFC2185B
        ),
        Newspaper(
            id = "digi_bangla_tech",
            name = "Digi Bangla Tech",
            banglaName = "ডিজি বাংলা টেক",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://digibanglatech.com",
            tagline = "ডিজিটাল বাংলাদেশ ও স্মার্ট প্রযুক্তি",
            primaryColorHex = 0xFF00796B
        ),
        Newspaper(
            id = "trix_bd",
            name = "Trix BD",
            banglaName = "ট্রিক্স বিডি",
            category = NewspaperCategory.TECH,
            websiteUrl = "https://trixbd.com",
            tagline = "সেরা টেক ট্রিকস ও ডিজিটাল সহায়তা",
            primaryColorHex = 0xFFE65100
        )
    )

    val extraSources: List<Newspaper> = jobSites + fmRadioStations + govtPortals + stockMarketSites + banglaMagazines + techSites
}
