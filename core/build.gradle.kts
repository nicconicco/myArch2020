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

    packagingOptions {
        exclude ("META-INF/gradle/incremental.annotation.processors")
        exclude ("META-INF/gradle/incremental.annotation.processors")
        exclude ("META-INF/DEPENDENCIES")
        exclude ("META-INF/LICENSE")
        exclude ("META-INF/LICENSE.txt")
        exclude ("META-INF/license.txt")
        exclude ("META-INF/NOTICE")
        exclude ("META-INF/NOTICE.txt")
        exclude ("META-INF/notice.txt")
        exclude ("META-INF/ASL2.0")
        exclude("META-INF/*.kotlin_module")
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

    implementation(MockkLibraries.mockk)
    implementation(MockWebServerLibraries.mockwebserver)

    implementation(CoroutinesLibraies.coroutinesAndroid)
    implementation(CoroutinesLibraies.coroutinesCore)
    implementation(CoroutinesLibraies.coroutinesTest)
}