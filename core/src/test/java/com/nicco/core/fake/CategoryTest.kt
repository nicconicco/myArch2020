package com.nicco.core.fake

import org.junit.Test

class CategoryTest {
    @Test
    fun `Test create with right properties`() {
        val result: Category? = Category(
            id = 1,
            name = "name"
        )

        assert(result != null)
        assert(result?.id is Int)
        assert(result?.name is String)
    }
}