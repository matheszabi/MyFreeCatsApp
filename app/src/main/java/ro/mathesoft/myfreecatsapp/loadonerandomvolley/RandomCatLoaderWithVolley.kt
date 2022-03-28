package ro.mathesoft.myfreecatsapp.loadonerandomvolley

import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class RandomCatLoaderWithVolley {


    companion object {

        suspend fun randomCatImageData(): ImageMetadata {
            //Example
            //Uses https://api.thecatapi.com/v1/images/search to show one random image every to “Another” is clicked.
            val url = URL("https://api.thecatapi.com/v1/images/search")
            with(url.openConnection() as HttpURLConnection) {
                assert(200 == responseCode)

                inputStream.bufferedReader().use {

                    val maybeJSON = it.readText()
                    val json = JSONArray(maybeJSON)
                    val firstJson = json.get(0) as JSONObject

                    return ImageMetadata(
                        firstJson.getString("id"),
                        firstJson.getString("url"),
                        firstJson.getString("width"),
                        firstJson.getString("height")
                    )
                }
            }
        }
    }
}