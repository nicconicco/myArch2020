package com.nicco.core.di

import com.nicco.core.base.BaseViewModel
import com.nicco.core.provider.AppDispatcherProvider
import org.koin.dsl.module

val baseViewModelModule = module {
    single {
        BaseViewModel(
            get(),
            AppDispatcherProvider().ui(),
            AppDispatcherProvider().io()
        )
    }
}