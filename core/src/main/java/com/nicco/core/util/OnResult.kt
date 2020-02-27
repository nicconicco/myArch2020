package com.nicco.core.util

interface OnResult<T, E> {
    fun onSuccess(result: T)
    fun onError(error: E)
}