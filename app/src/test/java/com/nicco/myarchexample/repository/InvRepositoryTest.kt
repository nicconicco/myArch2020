package com.nicco.myarchexample.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nicco.core.fake.DUMMY
import com.nicco.myarchexample.CoroutineTestRule
import com.nicco.myarchexample.data.datasource.InvDataSource
import com.nicco.myarchexample.data.repository.InvRepository
import com.nicco.myarchexample.data.repository.InvRepositoryImp
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class InvRepositoryTest {

    @get:Rule
    val instantTask = InstantTaskExecutorRule()
    @get:Rule
    val coroutinesTestRule = CoroutineTestRule()

    lateinit var repository: InvRepository
    private val dataSource: InvDataSource = mockk()
    private val dispatcher: CoroutineDispatcher = TestCoroutineDispatcher()

    @Test
    fun `When repository call, should call dataSource fetchListInv`() = runBlockingTest {
        val response = DUMMY.dummyInvResponse()
        coEvery() { dataSource.fetchListInv() } returns response

        repository = InvRepositoryImp(dataSource, dispatcher)
        repository.getListInvModel()

        coVerify { repository.getListInvModel() }
    }
}