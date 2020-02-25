package com.nicco.myarchexample.data.datasource

import com.nicco.core.fake.FactoryInvResponse
import com.nicco.myarchexample.data.retrofit.InvApi
import com.nicco.core.response.InvResponse
import com.nicco.myarchexample.BuildConfig
import kotlinx.coroutines.delay

class InvDataSourceImp(private val api: InvApi) : InvDataSource {
    override suspend fun fetchListInv(): InvResponse {
        if (BuildConfig.DEBUG) {
            delay(3000)
            return FactoryInvResponse.dummyInvResponse()
        } else {
            return api.getInvList()
        }
    }
}