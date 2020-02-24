package com.nicco.myarchexample.di

import com.nicco.myarchexample.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

class CheckHomeModulesTest : KoinTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @ExperimentalCoroutinesApi
    @FlowPreview
    @Test
    fun checkAllModules() = runBlockingTest {
        startKoin {
            listOf(
                invAdapterModule,
                invViewModelModule,
                invRepositoryModule,
                invDataSourceModule,
                invApiModule,
                invDispatchersProvideModule
            )
        }.checkModules()
    }
}