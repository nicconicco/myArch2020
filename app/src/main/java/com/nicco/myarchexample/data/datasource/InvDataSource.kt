package com.nicco.myarchexample.data.datasource

import com.nicco.core.response.InvResponse
import com.nicco.core.util.Callback

interface InvDataSource {
    suspend fun fetchListInv(): InvResponse
    fun fetchAnotherList(callback: Callback<InvResponse, String>)
}