package com.nicco.core.response

import com.nicco.core.fake.FactoryInvResponse.makeInvData
import org.junit.Test

class InvResponseTest {

    @Test
    fun `InvResponse Test create with right properties`() {
        val result : InvResponse? =  InvResponse(
            uid = "uid",
            responseCode = "responseCode",
            data = makeInvData(5),
            status = "status"
        )

        assert(result != null)
        assert(result?.uid is String)
        assert(result?.responseCode is String)
        assert(result?.status is String)

        assert(result?.data != null)
        val data = result?.data?.let {
            assert(result.data!!.isNotEmpty())
            assert(result.data!![0].uid is String)
            assert(result.data!![0].status is String)
            assert(result.data!![0].hashCode is String)
            assert(result.data!![0].title is String)
            assert(result.data!![0].description is String)
            assert(result.data!![0].price is Float)
            assert(result.data!![0].percent is Float)
        }
    }
}