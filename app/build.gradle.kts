plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinAndroidKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(AndroidSdk.version)
    dataBinding.isEnabled = true

    packagingOptions {
        exclude ("META-INF/gradle/incremental.annotation.processors")
    }

    kotlinOptions {
        // We have to add the explicit cast before accessing the options itself.
        // If we don't, it does not work: "unresolved reference: jvmTarget"
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }

    defaultConfig {
        applicationId = "com.nicco.myarchexample"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        javaCompileOptions.annotationProcessorOptions.includeCompileClasspath = true
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
        unitTests.isIncludeAndroidResources = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(":core"))

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.cardview)
    implementation(Libraries.recyclerView)
    implementation(Libraries.databinding)
    implementation(Libraries.swipelayout)
    implementation(Libraries.viewpager2)

    implementation(Libraries.lifecycleViewmodel)
    implementation(Libraries.lifecycleExtension)
    implementation(Libraries.lifecycleCompiler)
    implementation(Libraries.lifecycleLivedata)
    implementation(Libraries.lifecycleCoreTesting)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.junit4Ext)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)

    implementation(KoinLibraies.koinAndroid)
    implementation(KoinLibraies.koinAndroidScope)
    implementation(KoinLibraies.koinAndroiViewModel)
    androidTestImplementation(KoinLibraies.koinTest)
    testImplementation(KoinLibraies.koinTest)
    androidTestImplementation(KoinLibraies.koinTestRules)

    implementation(CoroutinesLibraies.coroutinesAndroid)
    implementation(CoroutinesLibraies.coroutinesCore)
    implementation(CoroutinesLibraies.coroutinesTest)

    implementation(RetrofitLibraies.retrofit)
    implementation(RetrofitLibraies.retrofitCoroutine)
    implementation(RetrofitLibraies.gson)
    implementation(RetrofitLibraies.moshi)

    implementation(LottieLibraries.lottie)
    implementation(MockkLibraries.mockk)
}


