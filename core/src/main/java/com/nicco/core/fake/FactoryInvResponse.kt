package com.nicco.core.fake

import com.nicco.core.response.InvData
import com.nicco.core.response.InvResponse
import java.util.*

object FactoryInvResponse {
    fun dummyInvResponse(): InvResponse {
        return makeInvResponse()
    }

    private fun makeInvResponse(
        count: Int = 15
    ): InvResponse = InvResponse(
        uid = Random().toString(),
        responseCode = Random().toString(),
        data = makeInvData(count),
        status = Random().toString()
    )

    private fun makeInvData(qtd: Int): List<InvData> {
        val list: MutableList<InvData> = mutableListOf()
        var i = 1
        while(i<qtd) {
            list.add(
                InvData(
                    uid = Random().toString(),
                    status = Random().toString(),
                    hashCode = Random().toString(),
                    title = Random().toString(),
                    description = Random().toString(),
                    price = Random().nextFloat(),
                    percent = Random().nextFloat()
                )
            )
            i++
        }
        return list
    }
}