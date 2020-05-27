plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Versions.compileSdkVersion)
    buildToolsVersion("29.0.3")

    defaultConfig {
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures{
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(kotlin("stdlib-jdk7", Versions.kotlinVersion))
    api(Dependencies.coreKtx)

    api(Dependencies.timber)

    api(Dependencies.material)
    api(Dependencies.refreshLayout)
    api(Dependencies.constraintLayout)

    api(Dependencies.fragment)
    api(Dependencies.navigationFragment)
    api(Dependencies.navigationUI)

    api(Dependencies.lifecycleExtensions)
    api(Dependencies.viewModelKtx)
    api(Dependencies.livedataKtx)

    api(Dependencies.retrofit)
    api(Dependencies.okHttp)
    api(Dependencies.okHttpLogger)
    api(Dependencies.gson)
    api(Dependencies.coil)

    api(Dependencies.dynamicFeature)
}