package com.nicco.myarchexample.di

import com.nicco.myarchexample.data.datasource.InvDataSource
import com.nicco.myarchexample.data.datasource.InvDataSourceImp
import org.koin.dsl.module

val invDataSourceModule = module {
    factory<InvDataSource> { InvDataSourceImp(get()) }
}