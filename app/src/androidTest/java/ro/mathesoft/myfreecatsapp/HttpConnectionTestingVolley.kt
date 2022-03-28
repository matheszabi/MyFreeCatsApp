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

    @Test
    fun testRandomCatImageData() {
        //Example
        //Uses https://api.thecatapi.com/v1/images/search to show one random image every to “Another” is clicked.
        val url = URL("https://api.thecatapi.com/v1/images/search")
        with(url.openConnection() as HttpURLConnection) {
            Assert.assertEquals("Response code from $url not as expected", 200, responseCode)
            inputStream.bufferedReader().use {

                val maybeJSON = it.readText()// [{"breeds":[],"id":"MjAwMjk5MQ","url":"https://cdn2.thecatapi.com/images/MjAwMjk5MQ.jpg","width":900,"height":600}]
                val json = JSONArray(maybeJSON) // [{"breeds":[{"weight":{"imperial":"6 - 12","metric":"3 - 5"},"id":"sphy","name":"Sphynx","cfa_url":"http:\/\/cfa.org\/Breeds\/BreedsSthruT\/Sphynx.aspx","vetstreet_url":"http:\/\/www.vetstreet.com\/cats\/sphynx","vcahospitals_url":"https:\/\/vcahospitals.com\/know-your-pet\/cat-breeds\/sphynx","temperament":"Loyal, Inquisitive, Friendly, Quiet, Gentle","origin":"Canada","country_codes":"CA","country_code":"CA","description":"The Sphynx is an intelligent, inquisitive, extremely friendly people-oriented breed. Sphynx commonly greet their owners  at the front door, with obvious excitement and happiness. She has an unexpected sense of humor that is often at odds with her dour expression.","life_span":"12 - 14","indoor":0,"lap":1,"alt_names":"Canadian Hairless, Canadian Sphynx","adaptability":5,"affection_level":5,"child_friendly":4,"dog_friendly":5,"energy_level":3,"grooming":2,"health_issues":4,"intelligence":5,"shedding_level":1,"social_needs":5,"stranger_friendly":5,"vocalisation":5,"experimental":0,"hairless":1,"natural":0,"rare":1,"rex":0,"suppressed_tail":0,"short_legs":0,"wikipedia_url":"https:\/\/en.wikipedia.org\/wiki\/Sphynx_(cat)","hypoallergenic":1,"reference_image_id":"BDb8ZXb1v"}],"id":"bSu2exlkB","url":"https:\/\/cdn2.thecatapi.com\/images\/bSu2exlkB.jpg","width":2380,"height":2462}]
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