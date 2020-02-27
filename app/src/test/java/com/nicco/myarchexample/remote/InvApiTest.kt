package com.nicco.myarchexample.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nicco.core.testing.DependencyProvider
import com.nicco.core.testing.CoroutineTestRule
import com.nicco.myarchexample.data.retrofit.InvApi
import io.mockk.coVerify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import java.io.IOException
import java.lang.Exception

class InvApiTest {

    @get:Rule
    val instantTask = InstantTaskExecutorRule()
    @get:Rule
    val coroutinesTestRule = CoroutineTestRule()

    private lateinit var apiService: InvApi
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun init() {
        mockWebServer = MockWebServer()
        apiService = DependencyProvider
            .getRetrofit(mockWebServer.url("/"))
            .create(InvApi::class.java)
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getPosts()  = runBlocking  {
        queueResponse {
            setResponseCode(200)
            setBody(DependencyProvider.getResponseFromJson("posts"))
        }

        withContext(Dispatchers.IO) {
            try {
                val response = apiService.getInvList()

                assert(response != null)
                assert(response.uid != null)
                assert(response.responseCode != null)
                assert(response.data != null)
                assert(response.status != null)

                coVerify { apiService.getInvList() }
            } catch (e: Exception) {
                assert(e != null)
            }
        }
    }

    private fun queueResponse(block: MockResponse.() -> Unit) {
        mockWebServer.enqueue(MockResponse().apply(block))
    }
}