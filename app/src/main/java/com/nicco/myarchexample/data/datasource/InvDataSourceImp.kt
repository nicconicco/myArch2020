package com.nicco.myarchexample.data.datasource

import com.nicco.core.fake.DUMMY
import com.nicco.myarchexample.data.retrofit.InvApi
import com.nicco.core.response.InvResponse
import com.nicco.myarchexample.BuildConfig

class InvDataSourceImp(private val api: InvApi) : InvDataSource {
    override suspend fun fetchListInv(): InvResponse {
        if (BuildConfig.DEBUG) {
            return DUMMY.dummyInvResponse()
        } else {
            return api.getInvList()
        }
    }
}