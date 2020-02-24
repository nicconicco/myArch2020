package com.nicco.myarchexample.data.retrofit

import com.nicco.core.response.InvResponse
import retrofit2.http.GET

interface InvApi {
    @GET("invApi")
    suspend fun getInvList(): InvResponse
}