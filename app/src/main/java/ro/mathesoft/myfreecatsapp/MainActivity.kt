package ro.mathesoft.myfreecatsapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ro.mathesoft.myfreecatsapp.loadonerandomvolley.RandomCatLoaderWithVolley


class MainActivity : AppCompatActivity() , CoroutineScope by MainScope(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onGetOneRandomClicked(view: View) {

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        linearLayout.removeAllViews()
        val imageView = ImageView(this)

        linearLayout.addView(imageView)
        linearLayout.invalidate()

        launch (Dispatchers.IO){// go to IO, otherwise: NetworkOnMainThreadException
            val imgData = RandomCatLoaderWithVolley.randomCatImageData()
            //example: imgId=J4kA9Bs9w, imgUrl=https://cdn2.thecatapi.com/images/J4kA9Bs9w.jpg, imgWidth=1280, imgHeight=1280

            // load the image with http connection or any other helper library: https://redwerk.com/blog/advanced-feature-in-android-image-loaders-picasso-vs-glide-vs-fresco/
            //val imageView: ImageView = findViewById(R.id.image)

            launch (Dispatchers.Main) {
                Glide.with(this@MainActivity).load(imgData.imgUrl)
                    .into(imageView) // java.lang.IllegalArgumentException: You must call this method on the main thread
                // how the fuck call an image loading process in main thread?!
                // fucking libraries, want to control my code!!!
            }
        }
    }

    fun onSearchClicked(view: View) {

    }

}