package com.nicco.myarchexample.di

import com.nicco.myarchexample.data.retrofit.InvApi
import org.koin.dsl.module
import retrofit2.Retrofit

val invApiModule = module {
    single { invApiModule(get()) }
}

fun invApiModule(retrofit: Retrofit): InvApi = retrofit.create(
    InvApi::class.java)