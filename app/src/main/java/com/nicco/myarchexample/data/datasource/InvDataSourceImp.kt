package com.nicco.myarchexample.data.datasource

import androidx.databinding.library.BuildConfig
import com.nicco.core.fake.DUMMY
import com.nicco.myarchexample.data.retrofit.InvApi
import com.nicco.core.response.InvResponse
import kotlinx.coroutines.delay

class InvDataSourceImp(private val api: InvApi) : InvDataSource {
    override suspend fun fetchListInv(): InvResponse {
        return api.getInvList()
    }
}