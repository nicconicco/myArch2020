package com.nicco.myarchexample.di

import com.nicco.myarchexample.data.repository.InvRepository
import com.nicco.myarchexample.data.repository.InvRepositoryImp
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val invRepositoryModule = module {
    single<InvRepository> { InvRepositoryImp(get(), get()) }
}