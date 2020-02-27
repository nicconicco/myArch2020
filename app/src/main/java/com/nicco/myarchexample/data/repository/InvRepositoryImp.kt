package com.nicco.myarchexample.data.repository

import com.nicco.core.network.ResultWrapper
import com.nicco.core.response.InvResponse
import com.nicco.core.util.Callback
import com.nicco.myarchexample.data.datasource.InvDataSource
import com.nicco.myarchexample.util.BaseRepository.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher

class InvRepositoryImp(
    private val dataSource: InvDataSource,
    private val dispatcher: CoroutineDispatcher
) : InvRepository {
    override suspend fun getListInvModel(): ResultWrapper<InvResponse> {
        return safeApiCall(dispatcher) { dataSource.fetchListInv() }
    }

    override fun getAnotherList(callback: Callback<InvResponse, String>) = dataSource.fetchAnotherList(callback)
}