package com.nicco.myarchexample.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val invDispatchersProvideModule = module {
    factory { getDispatcher() }
}

fun getDispatcher(): CoroutineDispatcher = Dispatchers.IO
