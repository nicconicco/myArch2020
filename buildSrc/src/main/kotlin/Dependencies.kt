const val kotlinVersion = "1.3.61"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.5.3"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinAndroidKapt = "kotlin-kapt"
    const val androidLibrary = "com.android.library"

}

object AndroidSdk {
    const val min = 26
    const val compile = 29
    const val version = "29.0.2"
    const val target = compile
}

object Libraries {
    private object Versions {
        const val jetpack = "1.1.0"
        const val cardview = "1.0.0"
        const val swipelayout = "1.0.0"
        const val constraintLayout = "1.1.3"
        const val ktx = "1.2.0"
        const val databinding = "3.1.4"
        const val lifecycle = "2.2.0"
        const val lifecycleTesting = "2.1.0"
        const val viewpager2 = "1.0.0"
    }
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.jetpack}"
    const val databinding = "com.android.databinding:compiler:${Versions.databinding}"
    const val swipelayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipelayout}"

    const val lifecycleViewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleCoreTesting = "androidx.arch.core:core-testing:${Versions.lifecycleTesting}"
    const val viewpager2 = "androidx.viewpager2:viewpager2:${Versions.viewpager2}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val junit4Ext = "1.1.1"
        const val testRunner = "1.1.0-alpha4"
        const val espresso = "3.2.0"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val junit4Ext = "androidx.test.ext:junit:${Versions.junit4Ext}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object KoinLibraies {
    private object Versions {
        const val koin = "2.0.1"
        const val koinTest = "1.2.0"
    }

    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinAndroidScope = "org.koin:koin-android-scope:${Versions.koin}"
    const val koinAndroiViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    const val koinTest = "org.koin:koin-test:${Versions.koin}"
    const val koinTestRules = "androidx.test:rules:${Versions.koinTest}"
}

object CoroutinesLibraies {
    private object Versions {
        const val coroutine = "1.3.2"
    }

    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"
}

object RetrofitLibraies {
    private object Versions {
        const val retrofit = "2.6.2"
        const val coroutineAdapter = "0.9.2"
        const val moshi = "2.5.0"
    }

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitCoroutine = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutineAdapter}"
    const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.moshi}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
}