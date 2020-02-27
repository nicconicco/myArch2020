package com.nicco.myarchexample.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.nicco.core.CoreApp
import com.nicco.core.base.BaseViewModel
import com.nicco.core.network.ErrorResponse
import com.nicco.core.network.ResultWrapper
import com.nicco.core.response.InvResponse
import com.nicco.core.util.Callback
import com.nicco.core.util.SingleLiveEvent
import com.nicco.myarchexample.data.repository.InvRepository
import com.nicco.myarchexample.data.repository.map.InvMap
import com.nicco.myarchexample.presentation.model.InvModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

sealed class InvViewAction {
    open class InvSuccess(val itens: List<InvModel>) : InvViewAction()
    open class InvError(val msg: String) : InvViewAction()
    open class InvLoading(val loading: Boolean) : InvViewAction()
}

class InvViewModel(
    private val invRepository: InvRepository,
    app: CoreApp,
    mainDispacher: CoroutineDispatcher,
    ioDispacher: CoroutineDispatcher
) : BaseViewModel(app, mainDispacher, ioDispacher) {

    private val _actionView = SingleLiveEvent<InvViewAction>()
    val actionView: LiveData<InvViewAction>
        get() = _actionView

    init {
        loadList()
    }

    private fun loadList() {
        viewModelScope.launch {
            _actionView.value = InvViewAction.InvLoading(true)
            val result = invRepository.getListInvModel()
            when (result) {
                is ResultWrapper.NetworkError -> showNetworkError()
                is ResultWrapper.GenericError -> result.error?.let { showGenericError(it) }
                is ResultWrapper.Success -> showSuccess(result.value)
            }
        }
    }

    private fun loadAnotherList() {
        uiScope.launch {
            ioScope.async {
                return@async invRepository.getAnotherList(
                    object : Callback<InvResponse, String>() {
                        override fun onSuccess(response: InvResponse) {
                            showSuccess(response)
                        }

                        override fun onError(error: String) {
                            super.onError(error)
                            showNetworkError()
                        }
                    })
            }.await()
        }
    }

    private fun showSuccess(value: InvResponse) {
        _actionView.value = InvViewAction.InvLoading(false)
        _actionView.value = InvViewAction.InvSuccess(InvMap.mapFrom(value))
    }

    private fun showGenericError(it: ErrorResponse) {
        _actionView.value = InvViewAction.InvLoading(false)
        _actionView.value = InvViewAction.InvError(it.error)
    }

    private fun showNetworkError() {
        _actionView.value = InvViewAction.InvLoading(false)
        _actionView.value = InvViewAction.InvError("NETWORK ERROR")
    }
}