package com.nicco.myarchexample.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicco.core.network.ErrorResponse
import com.nicco.core.network.ResultWrapper
import com.nicco.myarchexample.data.repository.InvRepository
import com.nicco.myarchexample.data.repository.map.InvMap
import com.nicco.core.response.InvResponse
import com.nicco.myarchexample.presentation.model.InvModel
import kotlinx.coroutines.launch

sealed class InvViewAction {
    open class InvSuccess(val itens: List<InvModel>) : InvViewAction()
    open class InvError(val msg: String) : InvViewAction()
    open class InvLoading(val loading: Boolean) : InvViewAction()
}

class InvViewModel(private val invRepository: InvRepository) : ViewModel() {

    private val _actionView = MediatorLiveData<InvViewAction>()
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