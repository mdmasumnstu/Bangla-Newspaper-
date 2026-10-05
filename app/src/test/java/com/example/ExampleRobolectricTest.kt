package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("NewsHub BD", appName)
  }

  @Test
  fun `verify newspaper data source has all 120+ newspapers and categories`() {
    val allPapers = com.example.data.model.NewspaperDataSource.allNewspapers
    org.junit.Assert.assertTrue("Should have over 120 newspapers", allPapers.size >= 120)
    
    val prothomAlo = com.example.data.model.NewspaperDataSource.getById("prothom_alo")
    org.junit.Assert.assertNotNull(prothomAlo)
    assertEquals("Prothom Alo", prothomAlo?.name)
    assertEquals("https://www.prothomalo.com", prothomAlo?.websiteUrl)

    val bengaliPapers = com.example.data.model.NewspaperDataSource.getByCategory(com.example.data.model.NewspaperCategory.BENGALI)
    org.junit.Assert.assertTrue("Should have Bengali newspapers", bengaliPapers.isNotEmpty())

    val tvNews = com.example.data.model.NewspaperDataSource.getByCategory(com.example.data.model.NewspaperCategory.TV_NEWS)
    org.junit.Assert.assertTrue("Should have 27 TV channels", tvNews.size >= 27)

    val somoy = com.example.data.model.NewspaperDataSource.getById("somoy_tv")
    org.junit.Assert.assertNotNull(somoy)
    assertEquals("https://www.somoynews.tv", somoy?.websiteUrl)

    val channelS = com.example.data.model.NewspaperDataSource.getById("channel_s_uk")
    org.junit.Assert.assertNotNull(channelS)
    assertEquals("https://chsuk.tv", channelS?.websiteUrl)
  }

  @Test
  fun `verify TV categories and channel assignments`() {
    val newsCat = com.example.ui.screens.TvChannelCategory.NEWS
    assertEquals(13, newsCat.channelIds.size)
    org.junit.Assert.assertTrue(newsCat.channelIds.contains("somoy_tv"))
    org.junit.Assert.assertTrue(newsCat.channelIds.contains("jamuna_tv"))
    org.junit.Assert.assertTrue(newsCat.channelIds.contains("global_tv_bd"))

    val entCat = com.example.ui.screens.TvChannelCategory.ENTERTAINMENT
    assertEquals(26, entCat.channelIds.size)
    org.junit.Assert.assertTrue(entCat.channelIds.contains("channel_i"))
    org.junit.Assert.assertTrue(entCat.channelIds.contains("ntv_bd"))
    org.junit.Assert.assertTrue(entCat.channelIds.contains("duronto_tv"))
    org.junit.Assert.assertTrue(entCat.channelIds.contains("nagorik_tv"))

    val sportsMusicCat = com.example.ui.screens.TvChannelCategory.SPORTS_MUSIC
    assertEquals(3, sportsMusicCat.channelIds.size)
    org.junit.Assert.assertTrue(sportsMusicCat.channelIds.contains("gazi_tv"))
    org.junit.Assert.assertTrue(sportsMusicCat.channelIds.contains("t_sports_tv"))
    org.junit.Assert.assertTrue(sportsMusicCat.channelIds.contains("gaan_bangla"))

    val intlCat = com.example.ui.screens.TvChannelCategory.INTERNATIONAL
    assertEquals(1, intlCat.channelIds.size)
    org.junit.Assert.assertTrue(intlCat.channelIds.contains("channel_s_uk"))

    // Total 43 channels across all categories
    val totalCategorized = com.example.ui.screens.TvChannelCategory.entries.sumOf { it.channelIds.size }
    assertEquals(43, totalCategorized)

    // All channels must have valid URLs starting with http
    com.example.ui.screens.TvChannelCategory.entries.flatMap { it.channelIds }.forEach { channelId ->
      val channel = com.example.data.model.NewspaperDataSource.getById(channelId)
      org.junit.Assert.assertNotNull("Channel $channelId must exist in data source", channel)
      org.junit.Assert.assertTrue("Channel URL must be valid", channel!!.websiteUrl.startsWith("http"))
    }
  }

  @Test
  fun `verify new categories and sources are added to data source`() {
    val allPapers = com.example.data.model.NewspaperDataSource.allNewspapers
    org.junit.Assert.assertTrue("Total sources should exceed 400", allPapers.size >= 400)

    val jobSites = com.example.data.model.NewspaperDataSource.getByCategory(com.example.data.model.NewspaperCategory.JOBS)
    assertEquals(12, jobSites.size)
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("bdjobs"))
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("bikroy_jobs"))

    val radioStations = com.example.data.model.NewspaperDataSource.getByCategory(com.example.data.model.NewspaperCategory.RADIO)
    assertEquals(29, radioStations.size)
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("radio_today"))
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("bangladesh_betar"))

    val govtPortals = com.example.data.model.NewspaperDataSource.getByCategory(com.example.data.model.NewspaperCategory.GOVERNMENT)
    org.junit.Assert.assertTrue("Govt portals should exceed 50", govtPortals.size >= 50)
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("bangladesh_gov"))
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("most_gov"))
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("ministry_of_finance"))
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("pmo_gov"))
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("cabinet_division"))
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("supremecourt_gov"))
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("parliament_gov"))

    val stockMarket = com.example.data.model.NewspaperDataSource.getByCategory(com.example.data.model.NewspaperCategory.STOCK_MARKET)
    assertEquals(20, stockMarket.size)
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("share_news_24"))
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("arthosuchak"))

    val magazines = com.example.data.model.NewspaperDataSource.getByCategory(com.example.data.model.NewspaperCategory.MAGAZINE)
    assertEquals(20, magazines.size)
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("kali_o_kalam"))
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("kishor_alo"))

    val techSites = com.example.data.model.NewspaperDataSource.getByCategory(com.example.data.model.NewspaperCategory.TECH)
    assertEquals(15, techSites.size)
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("courstika"))
    org.junit.Assert.assertNotNull(com.example.data.model.NewspaperDataSource.getById("techtunes"))

    // Ensure all extra sources have valid URLs starting with http
    com.example.data.model.ExtraSourcesDataSource.extraSources.forEach { source ->
      org.junit.Assert.assertTrue("Source ${source.id} must have valid URL", source.websiteUrl.startsWith("http"))
      org.junit.Assert.assertTrue("Source ${source.id} must have non-empty banglaName", source.banglaName.isNotBlank())
    }
  }
}
