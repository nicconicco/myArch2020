package com.nicco.myarchexample.data.repository

import com.nicco.core.network.ErrorResponse
import com.nicco.core.network.ResultWrapper
import com.nicco.core.response.InvResponse
import com.nicco.core.util.Callback
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

interface InvRepository {
    suspend fun getListInvModel() : ResultWrapper<InvResponse>
    fun getAnotherList(callback: Callback<InvResponse, String>)
}

