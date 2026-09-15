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
  }
}
