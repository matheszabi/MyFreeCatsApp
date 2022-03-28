package ro.mathesoft.myfreecatsapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BuildConfigTest {

    @Test
    fun api_key_loaded() {

        assertNotNull(BuildConfig.CAT_API_KEY)

        assertEquals(36, BuildConfig.CAT_API_KEY.length)
    }
}