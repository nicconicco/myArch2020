package com.nicco.myarchexample.di

import com.nicco.myarchexample.presentation.view.adapter.InvListAdapter
import org.koin.dsl.module

val invAdapterModule = module {
    single {
        invListAdapter()
    }
}

fun invListAdapter(): InvListAdapter = InvListAdapter()
