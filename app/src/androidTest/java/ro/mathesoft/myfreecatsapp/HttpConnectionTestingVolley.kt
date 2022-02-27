package ro.mathesoft.myfreecatsapp

import android.util.JsonReader
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.json.JSONArray
import org.json.JSONObject
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import java.net.HttpURLConnection
import java.net.URL

@RunWith(AndroidJUnit4::class)
class HttpConnectionTestingVolley {

    @Ignore
    @Test
    fun testConnectionToGoogle() {
        val url = URL("http://www.google.com/")
        with(url.openConnection() as HttpURLConnection) {
            //requestMethod = "GET"  // optional default is GET
            Assert.assertEquals("Response code from $url not as expected", 200, responseCode)
        }
    }
    @Ignore
    @Test
    fun testConnectionToThatApiGuy() {
        val url = URL("https://thatapiguy.com/")
        with(url.openConnection() as HttpURLConnection) {
            Assert.assertEquals("Response code from $url not as expected", 200, responseCode)
        }
    }

    @Test
    fun testRandomCatImageData() {
        //Example
        //Uses https://api.thecatapi.com/v1/images/search to show one random image every to “Another” is clicked.
        val url = URL("https://api.thecatapi.com/v1/images/search")
        with(url.openConnection() as HttpURLConnection) {
            Assert.assertEquals("Response code from $url not as expected", 200, responseCode)
            inputStream.bufferedReader().use {

                val maybeJSON = it.readText()// [{"breeds":[],"id":"MjAwMjk5MQ","url":"https://cdn2.thecatapi.com/images/MjAwMjk5MQ.jpg","width":900,"height":600}]
                val json = JSONArray(maybeJSON)
                val firstJson = json.get(0) as JSONObject
                val imgId = firstJson.getString("id")
                val imgUrl = firstJson.getString("url")
                val imgWidth = firstJson.getString("width")
                val imgHeight = firstJson.getString("height")

                Assert.assertNotNull(imgId)
                Assert.assertNotNull(imgUrl)
                Assert.assertNotNull(imgWidth)
                Assert.assertNotNull(imgHeight)

                //BUILD SUCCESSFUL in 59s
            }
        }
    }
}