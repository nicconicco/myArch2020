package com.nicco.myarchexample.data.datasource

import com.nicco.core.response.InvResponse
import com.nicco.core.util.Callback
import com.nicco.myarchexample.data.retrofit.InvApi
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception

class InvDataSourceImp(private val api: InvApi) : InvDataSource {
    override suspend fun fetchListInv(): InvResponse {
//        if (BuildConfig.DEBUG) {
//            delay(3000)
//            return FactoryInvResponse.dummyInvResponse()
//        } else {
        return api.getInvList()
//        }
    }

    override fun fetchAnotherList(callback: Callback<InvResponse, String>) {

        val result: Call<InvResponse?> = api.getAnotherList()

        try {
            result.enqueue(object : retrofit2.Callback<InvResponse?> {
                override fun onFailure(call: Call<InvResponse?>, t: Throwable) {
                    callback.onError(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<InvResponse?>,
                    response: Response<InvResponse?>
                ) {
                    response.body()?.let {
                        callback.onSuccess(it)
                    }
                }
            })
        } catch (e: Exception) {
            callback.onError(e.localizedMessage)
        }
    }
}