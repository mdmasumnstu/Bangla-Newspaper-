package com.example.data.model

import com.example.data.local.entity.ArticleEntity

object InitialNewsData {
    val seedArticles: List<ArticleEntity> = listOf(
        // Breaking News
        ArticleEntity(
            id = "breaking_edu_reform_2026",
            newspaperId = "prothom_alo",
            newspaperName = "Prothom Alo",
            newspaperBanglaName = "প্রথম আলো",
            title = "বাংলাদেশে নতুন শিক্ষাক্রমে বড় পরিবর্তন আনছে সরকার",
            description = "জাতীয় শিক্ষাক্রমের মূল্যায়ন পদ্ধতি ও পাঠ্যবইয়ে গুরুত্বপূর্ণ সংস্কারের ঘোষণা দিয়েছে শিক্ষা মন্ত্রণালয়। নতুন নির্দেশনায় শিখন মূল্যায়ন ও লিখিত পরীক্ষার সমন্বয় ঘটবে।",
            content = """
                শিক্ষা মন্ত্রণালয় জানিয়েছে, দেশের শিক্ষার্থীদের আন্তর্জাতিক মানে গড়ে তুলতে এবং ব্যবহারিক শিক্ষার প্রসারে জাতীয় শিক্ষাক্রমে যুগোপযোগী কিছু পরিমার্জন আনা হচ্ছে।

                নতুন নির্দেশনায় পরীক্ষা পদ্ধতি ও ব্যবহারিক ধারাবাহিক মূল্যায়নের মধ্যে একটি ভারসাম্য স্থাপন করা হবে। প্রাথমিক থেকে মাধ্যমিক স্তর পর্যন্ত পাঠ্যবইয়ে আধুনিক বিজ্ঞান, তথ্যপ্রযুক্তি ও নৈতিক শিক্ষার বিষয়বস্তু আরো সহজবোধ্য করে উপস্থাপন করা হবে।

                শিক্ষা বিশেষজ্ঞদের মতে, এ পরিবর্তনের ফলে শিক্ষার্থীদের ওপর পরীক্ষার অযাচিত মানসিক চাপ কমবে এবং সৃজনশীল চিন্তা ও সমস্যা সমাধানের দক্ষতা বৃদ্ধি পাবে। আগামী শিক্ষাবর্ষের শুরু থেকেই এই সংশোধিত সিলেবাস ও মূল্যায়ন নির্দেশিকা কার্যকর করার প্রস্তুতি চলছে।
            """.trimIndent(),
            articleUrl = "https://www.prothomalo.com/bangladesh/education-reforms",
            imageUrl = "https://images.unsplash.com/photo-1580582932707-520aed937b7b?w=800&auto=format&fit=crop",
            category = "Education",
            publishedAt = System.currentTimeMillis() - (15 * 60 * 1000),
            formattedTime = "15 min ago",
            isTopNews = false,
            isBreaking = true,
            isSaved = false
        ),

        // Top News (Carousel)
        ArticleEntity(
            id = "top_election_prep_ec",
            newspaperId = "prothom_alo",
            newspaperName = "Prothom Alo",
            newspaperBanglaName = "প্রথম আলো",
            title = "সংসদ নির্বাচনের প্রস্তুতি শুরু: ইসি",
            description = "সুষ্ঠু ও নিরপেক্ষ জাতীয় সংসদ নির্বাচন অনুষ্ঠানের লক্ষ্যে সব ধরনের প্রস্তুতি গ্রহণ করছে নির্বাচন কমিশন। নতুন ভোটার তালিকা হালনাগাদ ও ভোটকেন্দ্রের নিরাপত্তা খতিয়ে দেখা হচ্ছে।",
            content = """
                নির্বাচন কমিশন (ইসি) আগামী জাতীয় সংসদ নির্বাচনের সার্বিক প্রস্তুতি গ্রহণ শুরু করেছে। প্রধান নির্বাচন কমিশনার জানিয়েছেন, সব রাজনৈতিক দলের আস্থা অর্জন ও একটি অবাধ ও সুষ্ঠু নির্বাচনের জন্য প্রযুক্তিগত ও প্রশাসনিক সক্ষমতা বৃদ্ধি করা হচ্ছে।

                জেলা ও উপজেলা পর্যায়ে ভোটার তালিকা ত্রুটিমুক্তভাবে চূড়ান্তকরণের কাজ এগিয়ে চলছে। সিসিটিভি ক্যামেরার ব্যবহার, স্মার্ট ভোটার যাচাই ব্যবস্থা এবং রিটার্নিং কর্মকর্তাদের বিশেষ প্রশিক্ষণ প্রদানের পরিকল্পনা হাতে নেওয়া হয়েছে।

                রাজনৈতিক বিশ্লেষকরা বলছেন, স্বচ্ছতা ও সকল অংশীজনের সক্রিয় সহযোগিতাই একটি অংশগ্রহণমূলক নির্বাচন নিশ্চিত করতে সবচেয়ে গুরুত্বপূর্ণ ভূমিকা রাখবে।
            """.trimIndent(),
            articleUrl = "https://www.prothomalo.com/bangladesh/election-preparation",
            imageUrl = "https://images.unsplash.com/photo-1541872703-74c5e44368f9?w=800&auto=format&fit=crop",
            category = "National",
            publishedAt = System.currentTimeMillis() - (20 * 60 * 1000),
            formattedTime = "20 min ago",
            isTopNews = true,
            isBreaking = false,
            isSaved = false
        ),
        ArticleEntity(
            id = "top_world_bank_economy",
            newspaperId = "the_daily_star",
            newspaperName = "The Daily Star",
            newspaperBanglaName = "দ্য ডেইলি স্টার",
            title = "Bangladesh's Economic Outlook: Strong Growth Driven by Exports and Remittances",
            description = "The World Bank and IMF forecast robust economic expansion for Bangladesh, highlighting macroeconomic stability and digital financial transformation.",
            content = """
                Bangladesh's economic resilience continues to impress international financial institutions. According to the latest development update, projected GDP growth is supported by surging garment exports and consistent remittance inflows from expatriate workers.

                The report emphasizes accelerating structural reforms in the banking sector, fostering private investment, and enhancing trade competitiveness. Bangladesh’s rapid digital transformation, spearheaded by mobile financial services, is hailed as an exemplary engine of financial inclusion.
            """.trimIndent(),
            articleUrl = "https://www.thedailystar.net/business/economy/bangladesh-growth-outlook",
            imageUrl = "https://images.unsplash.com/photo-1526304640581-d334cdbbf45e?w=800&auto=format&fit=crop",
            category = "Economy",
            publishedAt = System.currentTimeMillis() - (35 * 60 * 1000),
            formattedTime = "35 min ago",
            isTopNews = true,
            isBreaking = false,
            isSaved = false
        ),
        ArticleEntity(
            id = "top_bangabandhu_tunnel",
            newspaperId = "somokal",
            newspaperName = "Somokal",
            newspaperBanglaName = "সমকাল",
            title = "কর্ণফুলী টানেল ঘিরে দক্ষিণ এশিয়ার নতুন শিল্প করিডোর",
            description = "বঙ্গবন্ধু শেখ মুজিবুর রহমান টানেল চালুর পর চট্টগ্রাম ও আনোয়ারা অঞ্চলে দেশি-বিদেশি বিনিয়োগে অভূতপূর্ব গতি সঞ্চার হয়েছে। গড়ে উঠছে নতুন অর্থনৈতিক অঞ্চল।",
            content = """
                কর্ণফুলী নদীর তলদেশে নির্মিত দক্ষিণ এশিয়ার প্রথম ভূগর্ভস্থ টানেল চট্টগ্রামকে বিশ্বের সবচেয়ে আধুনিক 'ওয়ান সিটি টু টাউন' মডেলে রূপান্তরিত করেছে।

                আনোয়ারার দিকে তৈরি পোশাক, তথ্যপ্রযুক্তি ও ভারী শিল্পের শতাধিক কারখানা গড়ে উঠছে। টানেলের কারণে ঢাকা-চট্টগ্রাম-কক্সবাজার রুটে পরিবহন সময় ও ব্যয় এক-তৃতীয়াংশ হ্রাস পেয়েছে, যা জাতীয় অর্থনীতিতে বিশাল প্রবৃদ্ধি যুক্ত করছে।
            """.trimIndent(),
            articleUrl = "https://www.samakal.com/business/bangabandhu-tunnel-hub",
            imageUrl = "https://images.unsplash.com/photo-1544620347-c4fd4a3d5957?w=800&auto=format&fit=crop",
            category = "Development",
            publishedAt = System.currentTimeMillis() - (45 * 60 * 1000),
            formattedTime = "45 min ago",
            isTopNews = true,
            isBreaking = false,
            isSaved = false
        ),
        ArticleEntity(
            id = "top_metro_rail_expansion",
            newspaperId = "kaler_kantho",
            newspaperName = "Kaler Kantho",
            newspaperBanglaName = "কালের কণ্ঠ",
            title = "মেট্রোরেলে মতিঝিল থেকে কমলাপুর: রাজধানীতে দ্রুতগতির নতুন দিগন্ত",
            description = "মতিঝিল ছাড়িয়ে কমলাপুর পর্যন্ত মেট্রোরেল সম্প্রসারণের কাজ শেষ পর্যায়ে। প্রতিদিন লাখ লাখ নগরবাসী স্বাচ্ছন্দ্যে যাতায়াত করছেন।",
            content = """
                ঢাকা ম্যাস ট্রানজিট কোম্পানি লিমিটেড (ডিএমটিসিএল) জানিয়েছে, মেট্রোরেল লাইন-৬ এর সম্প্রসারিত কমলাপুর স্টেশন আগামী কয়েক মাসের মধ্যেই সম্পূর্ণ কার্যক্ষম হবে।

                উত্তরা থেকে মতিঝিল পর্যন্ত ইতিমধ্যে দৈনিক তিন লাখের বেশি যাত্রী নিরাপদে ও দ্রুততম সময়ে গন্তব্যে পৌঁছাচ্ছেন। নতুন কোচ সংযোজন এবং সকাল থেকে মধ্যরাত পর্যন্ত শিডিউল বৃদ্ধির পর নগরবাসীর ভোগান্তি অনেকাংশে দূর হয়েছে।
            """.trimIndent(),
            articleUrl = "https://www.kalerkantho.com/national/metro-rail-kamalapur",
            imageUrl = "https://images.unsplash.com/photo-1494515843206-f3117d3f51b7?w=800&auto=format&fit=crop",
            category = "National",
            publishedAt = System.currentTimeMillis() - (60 * 60 * 1000),
            formattedTime = "1 hour ago",
            isTopNews = true,
            isBreaking = false,
            isSaved = false
        ),

        // Latest News (Matching the exact cards in the design)
        ArticleEntity(
            id = "latest_daily_star_economy",
            newspaperId = "the_daily_star",
            newspaperName = "The Daily Star",
            newspaperBanglaName = "দ্য ডেইলি স্টার",
            title = "বাংলাদেশের অর্থনীতি নিয়ে নতুন পরিকল্পনা",
            description = "মুদ্রাস্ফীতি নিয়ন্ত্রণ ও বৈদেশিক মুদ্রার রিজার্ভ শক্তিশালী করতে বাংলাদেশ ব্যাংক নতুন মুদ্রানীতি ও সমন্বিত অর্থনৈতিক পরিকল্পনা ঘোষণা করেছে।",
            content = """
                মুদ্রাস্ফীতি কমিয়ে আনা এবং বৈদেশিক মুদ্রা বাজারে স্থিতিশীলতা ফিরিয়ে আনতে কেন্দ্রীয় ব্যাংক একাধিক কৌশলগত সিদ্ধান্ত নিয়েছে। 

                রপ্তানিকারকদের সহজ শর্তে ঋণ প্রদান, অপ্রয়োজনীয় আমদানি নিয়ন্ত্রণ এবং রেমিট্যান্সের উপর প্রণোদনা আরো সহজতর করার নির্দেশনা দেওয়া হয়েছে। অর্থনীতিবিদরা মনে করছেন, এই পরিকল্পনা সফলভাবে বাস্তবায়িত হলে চলতি অর্থবছর শেষে সামগ্রিক অর্থনীতিতে শৃঙ্খলা নিশ্চিত হবে।
            """.trimIndent(),
            articleUrl = "https://www.thedailystar.net/bangla/economy-new-plan",
            imageUrl = "https://images.unsplash.com/photo-1590283603385-17ffb3a7f29f?w=800&auto=format&fit=crop",
            category = "Economy",
            publishedAt = System.currentTimeMillis() - (30 * 60 * 1000),
            formattedTime = "30 min ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),
        ArticleEntity(
            id = "latest_kaler_kantho_sports",
            newspaperId = "kaler_kantho",
            newspaperName = "Kaler Kantho",
            newspaperBanglaName = "কালের কণ্ঠ",
            title = "বিশ্বকাপে বাংলাদেশের বড় জয়",
            description = "শ্বাসরুদ্ধকর ম্যাচে প্রতিপক্ষকে হারিয়ে ক্রিকেট বিশ্বকাপে ঐতিহাসিক বিজয় অর্জন করল বাংলাদেশ জাতীয় দল। দুর্দান্ত অলরাউন্ড পারফরম্যান্সে ম্যাচসেরা তারকা অলরাউন্ডার।",
            content = """
                বিশ্বকাপের গুরুত্বপূর্ণ ম্যাচে এক অবিস্মরণীয় জয় ছিনিয়ে নিল বাংলাদেশ টাইগাররা। ব্যাটিং ও বোলিং দুই বিভাগেই নিয়ন্ত্রিত নৈপুণ্য দেখিয়ে দর্শকদের মাতিয়ে রাখেন জাতীয় দলের খেলোয়াড়েরা।

                শেষ ওভারের রোমাঞ্চকর ক্ষণে অসাধারণ ইয়র্কার ও বুদ্ধিদীপ্ত ফিল্ডিংয়ে জয় নিশ্চিত হয়। দেশের বিভিন্ন প্রান্তে ক্রিকেটপ্রেমীরা রাস্তায় নেমে আনন্দ মিছিল ও মিষ্টি বিতরণ করেছেন।
            """.trimIndent(),
            articleUrl = "https://www.kalerkantho.com/sports/world-cup-triumph",
            imageUrl = "https://images.unsplash.com/photo-1531415074968-036ba1b575da?w=800&auto=format&fit=crop",
            category = "Sports",
            publishedAt = System.currentTimeMillis() - (60 * 60 * 1000),
            formattedTime = "1 hour ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),
        ArticleEntity(
            id = "latest_prothom_alo_infra",
            newspaperId = "prothom_alo",
            newspaperName = "Prothom Alo",
            newspaperBanglaName = "প্রথম আলো",
            title = "বাংলাদেশে অবকাঠামো উন্নয়নে বহুজাতিক ব্যাংকের নতুন বিনিয়োগ",
            description = "এশীয় উন্নয়ন ব্যাংক (এডিবি) ও বিশ্বব্যাংক বাংলাদেশের যোগাযোগ, সৌরশক্তি ও স্মার্ট গ্রিড অবকাঠামো খাতে ৩ বিলিয়ন ডলারের নতুন অর্থায়ন অনুমোদন করেছে।",
            content = """
                বাংলাদেশের দীর্ঘমেয়াদী টেকসই অর্থনৈতিক রূপান্তরের অংশ হিসেবে এই মেগা তহবিল অনুমোদন করা হয়েছে।

                এর অধীনে দেশের উপকূলীয় অঞ্চলের বাঁধ সংস্কার, নবায়নযোগ্য জ্বালানি প্রকল্প এবং মহাসড়ক চার লেনে উন্নীতকরণের কাজ বাস্তবায়ন করা হবে। আন্তর্জাতিক অংশীদারদের এই জোরালো সমর্থন বাংলাদেশের ভবিষ্যৎ উন্নয়নের সক্ষমতাকে সুস্পষ্ট করে।
            """.trimIndent(),
            articleUrl = "https://www.prothomalo.com/business/infrastructure-investment",
            imageUrl = "https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?w=800&auto=format&fit=crop",
            category = "Development",
            publishedAt = System.currentTimeMillis() - (10 * 60 * 1000),
            formattedTime = "10 min ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),
        ArticleEntity(
            id = "latest_prothom_alo_curriculum",
            newspaperId = "prothom_alo",
            newspaperName = "Prothom Alo",
            newspaperBanglaName = "প্রথম আলো",
            title = "নতুন শিক্ষাক্রমে যে পরিবর্তন আসছে",
            description = "শিক্ষার্থীদের হাতে-কলমে শিক্ষা এবং বৈশ্বিক মানের সাথে খাপ খাওয়াতে পাঠ্যক্রম ও গ্রেডিং পদ্ধতিতে যুক্ত হচ্ছে বাস্তবমুখী নির্দেশিকা।",
            content = """
                শিক্ষাবিদ ও নীতিনির্ধারকদের যৌথ পরামর্শে নতুন কারিকুলামে একাধিক সংস্কার আনা হচ্ছে। মুখস্থ বিদ্যার পরিবর্তে ব্যবহারিক প্রজেক্ট ও গ্রুপ অ্যাক্টিভিটিকে মূল্যায়নের ভিত্তি করা হচ্ছে।

                শিক্ষকদের আধুনিক শিক্ষাদানের উপযুক্ত প্রশিক্ষণ দিতে দেশজুড়ে ওয়ার্কশপ ও ডিজিটাল প্ল্যাটফর্ম চালু করা হয়েছে।
            """.trimIndent(),
            articleUrl = "https://www.prothomalo.com/education/curriculum-details",
            imageUrl = "https://images.unsplash.com/photo-1509062522246-3755977927d7?w=800&auto=format&fit=crop",
            category = "Education",
            publishedAt = System.currentTimeMillis() - (30 * 60 * 1000),
            formattedTime = "30 min ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),
        ArticleEntity(
            id = "latest_prothom_alo_economy_signals",
            newspaperId = "prothom_alo",
            newspaperName = "Prothom Alo",
            newspaperBanglaName = "প্রথম আলো",
            title = "দেশের অর্থনীতিতে ইতিবাচক সংকেত",
            description = "চলতি মাসে রেমিট্যান্স প্রবাহ ও খাদ্য উৎপাদন বাড়ায় সামগ্রিক মূল্যস্ফীতির সূচকে স্বস্তিদায়ক লক্ষণ দেখা যাচ্ছে।",
            content = """
                বাংলাদেশ পরিসংখ্যান ব্যুরোর সাম্প্রতিক তথ্য অনুযায়ী, কৃষি খাতে বাম্পার ফলন এবং জ্বালানি তেল আমদানির খরচ কমে আসায় নিত্যপণ্যের বাজারে স্থিতিশীলতা পরিলক্ষিত হচ্ছে।

                একই সাথে প্রবাসী বাংলাদেশিদের ব্যাংকিং চ্যানেলে অর্থ পাঠানোর পরিমাণ গত বছরের একই সময়ের তুলনায় ১৮ শতাংশ বৃদ্ধি পেয়েছে।
            """.trimIndent(),
            articleUrl = "https://www.prothomalo.com/economy/positive-signals",
            imageUrl = "https://images.unsplash.com/photo-1460925895917-afdab827c52f?w=800&auto=format&fit=crop",
            category = "Economy",
            publishedAt = System.currentTimeMillis() - (60 * 60 * 1000),
            formattedTime = "1 hour ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),
        ArticleEntity(
            id = "latest_jugantor_tech",
            newspaperId = "jugantor",
            newspaperName = "Jugantor",
            newspaperBanglaName = "যুগান্তর",
            title = "স্মার্ট বাংলাদেশে আইটি ফ্রিল্যান্সারদের বৈশ্বিক সাফল্য",
            description = "বিশ্বের ফ্রিল্যান্সিং বাজারে বাংলাদেশের অবস্থান এখন দ্বিতীয়। কৃত্রিম বুদ্ধিমত্তা ও সফটওয়্যার ডেভলপমেন্টে এগিয়ে আসছেন তরুণ পেশাদাররা।",
            content = """
                আইসিটি বিভাগের হিসাব অনুযায়ী দেশে প্রায় সাড়ে ছয় লাখ সক্রিয় তথ্যপ্রযুক্তি ফ্রিল্যান্সার কাজ করছেন। বার্ষিক এক বিলিয়ন ডলারের বেশি সমপরিমাণ বৈদেশিক মুদ্রা এই তরুণদের হাত ধরে দেশে আসছে।

                জেলা ও উপজেলায় শেখ কামাল আইটি ট্রেনিং সেন্টার ও হাইটেক পার্ক স্থাপনের মাধ্যমে গ্রামীণ তরুণরাও বৈশ্বিক প্রযুক্তি বিপ্লবের অংশীদার হচ্ছেন।
            """.trimIndent(),
            articleUrl = "https://www.jugantor.com/tech/freelancing-revolution",
            imageUrl = "https://images.unsplash.com/photo-1519389950473-47ba0277781c?w=800&auto=format&fit=crop",
            category = "Online",
            publishedAt = System.currentTimeMillis() - (120 * 60 * 1000),
            formattedTime = "2 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),
        ArticleEntity(
            id = "latest_bonik_barta_business",
            newspaperId = "bonik_barta",
            newspaperName = "Bonik Barta",
            newspaperBanglaName = "বণিক বার্তা",
            title = "শেয়ারবাজারে লেনদেনের ঊর্ধ্বগতি, বিনিয়োগকারীদের আস্থা বৃদ্ধি",
            description = "ঢাকা স্টক এক্সচেঞ্জে (ডিএসই) সূচক বৃদ্ধি পেয়ে চার মাসের মধ্যে সর্বোচ্চ উচ্চতায় পৌঁছেছে। প্রাতিষ্ঠানিক বিনিয়োগকারীদের অংশগ্রহণ বৃদ্ধি পেয়েছে।",
            content = """
                পুঁজিবাজারে নতুন তালিকাভুক্ত ভালো মৌলভিত্তিসম্পন্ন কোম্পানিগুলোর শেয়ারের চাহিদা বেড়েছে। সিকিউরিটিজ অ্যান্ড এক্সচেঞ্জ কমিশনের নীতিগত সহায়তার কারণে বাজারে শৃঙ্খলা ফিরে এসেছে।

                বাজার বিশেষজ্ঞরা মনে করছেন, দীর্ঘমেয়াদে বিনিয়োগ ধরে রাখলে পুঁজিবাজার লাভজনক প্ল্যাটফর্মে পরিণত হতে পারে।
            """.trimIndent(),
            articleUrl = "https://www.bonikbarta.net/stock-market-rally",
            imageUrl = "https://images.unsplash.com/photo-1611974789855-9c2a0a7236a3?w=800&auto=format&fit=crop",
            category = "Business",
            publishedAt = System.currentTimeMillis() - (180 * 60 * 1000),
            formattedTime = "3 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        ),
        ArticleEntity(
            id = "latest_somoy_tv_padma",
            newspaperId = "somoy_tv",
            newspaperName = "Somoy TV",
            newspaperBanglaName = "সময় টিভি",
            title = "পদ্মা সেতু রেল সংযোগে গতি ফিরছে দক্ষিণাঞ্চলের অর্থনীতিতে",
            description = "ঢাকা থেকে যশোর ও খুলনা রুটে ট্রেন যোগাযোগ দ্রুতগতির হওয়ায় মৎস্য, শাকসবজি ও শিল্পপণ্যের পরিবহন কয়েক গুণ সহজ হয়েছে।",
            content = """
                পদ্মা সেতু রেল সংযোগ প্রকল্প দক্ষিণের ২১টি জেলার যোগাযোগ ব্যবস্থায় বিপ্লব এনে দিয়েছে। মাত্র সাড়ে তিন ঘণ্টায় ঢাকা থেকে মোংলা বন্দর পর্যন্ত পণ্যবাহী ট্রেন চলাচলের সুফল পাচ্ছেন সাধারণ ব্যবসায়ীরা।

                কৃষকরা এখন টাটকা কৃষিপণ্য ঢাকায় এনে ন্যায্যমূল্যে বিক্রি করতে পারছেন।
            """.trimIndent(),
            articleUrl = "https://www.somoynews.tv/news/padma-rail-connection",
            imageUrl = "https://images.unsplash.com/photo-1477959858617-67f30bc75b82?w=800&auto=format&fit=crop",
            category = "TV News",
            publishedAt = System.currentTimeMillis() - (240 * 60 * 1000),
            formattedTime = "4 hours ago",
            isTopNews = false,
            isBreaking = false,
            isSaved = false
        )
    )
}
