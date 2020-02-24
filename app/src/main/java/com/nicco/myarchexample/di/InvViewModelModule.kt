package com.nicco.myarchexample.di

import com.nicco.myarchexample.data.repository.InvRepository
import com.nicco.myarchexample.presentation.viewmodel.InvViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val invViewModelModule = module {
    viewModel { InvViewModel(invRepository = get() as InvRepository) }
}