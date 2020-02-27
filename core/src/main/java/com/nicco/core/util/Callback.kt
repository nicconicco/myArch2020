package com.nicco.core.util

open class Callback<T, E> : OnResult<T, E> {

    private var data: T? = null
    private var error: E? = null

    override fun onSuccess(result: T) {
        this.data = result
    }

    override fun onError(error: E) {
        this.error = error
    }

    override fun equals(other: Any?): Boolean {
        return true
    }
}