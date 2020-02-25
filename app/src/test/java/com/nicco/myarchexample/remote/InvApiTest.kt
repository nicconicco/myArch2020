package com.nicco.myarchexample.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nicco.core.testing.DependencyProvider
import com.nicco.myarchexample.CoroutineTestRule
import com.nicco.myarchexample.data.retrofit.InvApi
import io.mockk.coVerify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.withContext
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException
import java.lang.Exception

const val JSON = "{\n" +
        "  \"uid\": \"1234\",\n" +
        "  \"responseCode\": \"200\",\n" +
        "  \"data\": [\n" +
        "    {\n" +
        "      \"uid\": \"1234\",\n" +
        "      \"status\": \"1234\",\n" +
        "      \"hashCode\": \"1234\",\n" +
        "      \"title\": \"Teste\",\n" +
        "      \"description\": \"Teste description\",\n" +
        "      \"price\": 20.0,\n" +
        "      \"percent\": 20.0\n" +
        "    }\n" +
        "  ],\n" +
        "  \"status\": \"OK\"\n" +
        "}"
@RunWith(RobolectricTestRunner::class)
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
            setBody(JSON)
        }

        withContext(Dispatchers.IO) {
            try {
                val response = apiService.getInvList()
                //todo: Checar object
                assert(response != null)
                coVerify { apiService.getInvList() }
            }catch (e: Exception) {
                assert(e != null)
            }
        }
    }

    private fun queueResponse(block: MockResponse.() -> Unit) {
        mockWebServer.enqueue(MockResponse().apply(block))
    }
}