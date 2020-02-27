package com.nicco.core.usecase

import com.nicco.core.response.InvResponse
import com.nicco.core.util.Callback

interface GetAnotherListUseCase {
    fun execute(callback: Callback<InvResponse, String>)
}