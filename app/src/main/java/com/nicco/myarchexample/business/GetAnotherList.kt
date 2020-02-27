package com.nicco.myarchexample.business

import com.nicco.core.response.InvResponse
import com.nicco.core.usecase.GetAnotherListUseCase
import com.nicco.core.util.Callback
import com.nicco.myarchexample.data.repository.InvRepository

class GetAnotherList(private val repository: InvRepository) : GetAnotherListUseCase {
    override fun execute(callback: Callback<InvResponse, String>) = repository.getAnotherList(callback)
}