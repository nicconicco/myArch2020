package com.nicco.myarchexample.viewmodel

import com.nicco.core.fake.FactoryInvResponse
import com.nicco.core.response.InvResponse
import com.nicco.myarchexample.data.repository.map.InvMap
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class InvMapTest {
    @Test
    fun `When given a list of InvReponse transform to list InvModel`() = runBlockingTest {
        val response : InvResponse = FactoryInvResponse.dummyInvResponse()
        val result = InvMap.mapFrom(response)

        assert(result != null)
        assert(response.uid != null)
        assert(response.responseCode != null)
        assert(response.data != null)
        assert(response.status != null)
    }
}