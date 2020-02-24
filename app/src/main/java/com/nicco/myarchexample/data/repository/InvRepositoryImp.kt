package com.nicco.myarchexample.data.repository

import com.nicco.core.network.ResultWrapper
import com.nicco.core.response.InvResponse
import com.nicco.myarchexample.data.datasource.InvDataSource
import kotlinx.coroutines.CoroutineDispatcher

class InvRepositoryImp(
    private val dataSource: InvDataSource,
    private val dispatcher: CoroutineDispatcher
) : BaseRepository(), InvRepository {
    override suspend fun getListInvModel(): ResultWrapper<InvResponse> {
        return safeApiCall(dispatcher) { dataSource.fetchListInv() }
    }
}