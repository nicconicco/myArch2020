plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinAndroidKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(AndroidSdk.version)
    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            buildConfigField ("String", "API_URL", "\"https://5e488360728fde0014e34e31.mockapi.io/api/v1/\"")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("release") {
            isMinifyEnabled = false
            buildConfigField ("String", "API_URL", "\"https://5e488360728fde0014e34e31.mockapi.io/api/v1/\"")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
        unitTests.isIncludeAndroidResources = true
    }
}

dependencies {

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)

    testImplementation (TestLibraries.junit4)
    androidTestImplementation (TestLibraries.testRunner)
    androidTestImplementation (TestLibraries.espresso)

    implementation (RetrofitLibraies.retrofit)
    implementation (RetrofitLibraies.retrofitCoroutine)
    implementation (RetrofitLibraies.gson)
    implementation (RetrofitLibraies.moshi)

    implementation (KoinLibraies.koinAndroid)
    implementation (KoinLibraies.koinAndroidScope)
    implementation (KoinLibraies.koinAndroiViewModel)
    androidTestImplementation (KoinLibraies.koinTest)
    testImplementation (KoinLibraies.koinTest)
    androidTestImplementation (KoinLibraies.koinTestRules)
}