package ro.mathesoft.myfreecatsapp

import androidx.test.ext.junit.runners.AndroidJUnit4
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
    @Test
    fun testConnectionToThatApiGuy() {
        val url = URL("https://thatapiguy.com/")
        with(url.openConnection() as HttpURLConnection) {
            Assert.assertEquals("Response code from $url not as expected", 200, responseCode)
        }
    }
}