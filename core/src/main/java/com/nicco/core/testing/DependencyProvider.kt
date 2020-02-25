package com.nicco.core.testing

import android.annotation.SuppressLint
import androidx.annotation.VisibleForTesting
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okio.Okio
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeUnit

@VisibleForTesting(otherwise = VisibleForTesting.NONE)
object DependencyProvider {

    /**
     * Returns a Retrofit instance for Testing
     */
    fun getRetrofit(baseUrl: HttpUrl): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS).build()
            )
            .build()
    }


    /**
     *Helper to read a JSON file and return a JSON string
     *Note: JSON file should have the structure "module/resources/api-response/filename.json"
     * @param fileName: File's name
     * @return JSON String
     */
    @SuppressLint("NewApi")
    fun getResponseFromJson(fileName: String): String {
//        val inputStream = javaClass.classLoader?.getResourceAsStream("api-response/$fileName.json")
//
//        inputStream?.let {
//            val source = Okio.buffer(Okio.source(inputStream))
//            return source.readString(StandardCharsets.UTF_8)
//        }

        return "[\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "  }," +
                "]"
    }
}