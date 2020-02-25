package com.nicco.myarchexample.datasource

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nicco.core.fake.DUMMY
import com.nicco.myarchexample.BuildConfig
import com.nicco.myarchexample.CoroutineTestRule
import com.nicco.myarchexample.data.datasource.InvDataSource
import com.nicco.myarchexample.data.datasource.InvDataSourceImp
import com.nicco.myarchexample.data.repository.InvRepositoryImp
import com.nicco.myarchexample.data.retrofit.InvApi
import com.nicco.myarchexample.presentation.viewmodel.InvViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class InvDataSourceTest {
    @get:Rule
    val instantTask = InstantTaskExecutorRule()
    @get:Rule
    val coroutinesTestRule = CoroutineTestRule()

    private val api: InvApi = mockk()
    lateinit var invDataSource: InvDataSource

    @Test
    fun `When invDataSource call should call api getInvList`() = runBlockingTest {
        val response = DUMMY.dummyInvResponse()
        coEvery() { api.getInvList() } returns response

        invDataSource = InvDataSourceImp(api)
        invDataSource.fetchListInv()

        coVerify { api.getInvList() }
    }

}