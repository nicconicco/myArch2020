package com.nicco.myarchexample.viewmodel

import com.nicco.myarchexample.presentation.model.InvModel
import org.junit.Test

class InvModelTest {
    @Test
    fun `Test create with right properties`() {
        val result : InvModel? =  InvModel(
            title = "title",
            description = "description",
            price = 20.0F,
            percent = 20.0F
        )

        assert(result != null)
        assert(result?.title is String)
        assert(result?.description is String)
        assert(result?.price is Float)
        assert(result?.percent is Float)
    }
}