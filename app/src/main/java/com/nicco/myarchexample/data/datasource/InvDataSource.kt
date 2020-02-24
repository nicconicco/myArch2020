package com.nicco.myarchexample.data.datasource

import com.nicco.core.response.InvResponse

interface InvDataSource {
    suspend fun fetchListInv(): InvResponse
}