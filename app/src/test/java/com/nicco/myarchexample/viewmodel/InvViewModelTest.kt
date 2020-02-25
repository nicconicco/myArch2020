package com.nicco.myarchexample.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nicco.core.fake.DUMMY
import com.nicco.core.network.ErrorResponse
import com.nicco.core.network.ResultWrapper
import com.nicco.core.response.InvResponse
import com.nicco.myarchexample.CoroutineTestRule
import com.nicco.myarchexample.data.repository.InvRepository
import com.nicco.myarchexample.presentation.viewmodel.InvViewAction
import com.nicco.myarchexample.presentation.viewmodel.InvViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class InvViewModelTest {

    private val listener: InvViewAction = InvViewAction.InvLoading(false)
    @get:Rule
    val instantTask = InstantTaskExecutorRule()
    @get:Rule
    val coroutinesTestRule = CoroutineTestRule()

    val repository = mockk<InvRepository>()
    lateinit var viewModel: InvViewModel

    @Test
    fun `When  viewmodel call, return Success state`() = runBlockingTest {
        val response : InvResponse = DUMMY.dummyInvResponse()
        val responseOk: ResultWrapper<InvResponse> = ResultWrapper.Success(response)

        coEvery() { repository.getListInvModel() } returns responseOk

        viewModel = InvViewModel(repository)

        assert(viewModel.actionView.value != null)
        coVerify { repository.getListInvModel() }
        assert(viewModel.actionView.value is InvViewAction.InvSuccess)
    }

    @Test
    fun `When  viewmodel call, return NetworkError error state`() = runBlockingTest {
        val responseOk: ResultWrapper<InvResponse> = ResultWrapper.NetworkError
        coEvery() { repository.getListInvModel() } returns responseOk

        viewModel = InvViewModel(repository)

        assert(viewModel.actionView.value != null)
        coVerify { repository.getListInvModel() }
        assert(viewModel.actionView.value is InvViewAction.InvError)
    }

    @Test
    fun `When  viewmodel call, return GenericError error state`() = runBlockingTest {
        val responseOk: ResultWrapper<InvResponse> = ResultWrapper.GenericError(code = 200, error = ErrorResponse("Error server"))
        coEvery() { repository.getListInvModel() } returns responseOk

        viewModel = InvViewModel(repository)

        assert(viewModel.actionView.value != null)
        coVerify { repository.getListInvModel() }
        assert(viewModel.actionView.value is InvViewAction.InvError)
    }
}