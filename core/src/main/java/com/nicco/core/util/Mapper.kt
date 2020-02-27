package com.nicco.core.util

interface Mapper<E, T>{
    fun mapFrom(from: E): T
    fun reverseFrom(from: T): E
}