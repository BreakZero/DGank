plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
    id("koin")
}
android {
    compileSdkVersion(Versions.compileSdkVersion)
    buildToolsVersion("29.0.3")

    defaultConfig {
        applicationId = "com.dj.dgank"
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    androidExtensions {
        isExperimental = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    lintOptions {
        isAbortOnError = false
    }
    buildFeatures {
        dataBinding = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    dynamicFeatures = mutableSetOf(":meizi")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(kotlin("stdlib-jdk7", Versions.kotlinVersion))
    api(Dependencies.coreKtx)

    api(Dependencies.koinFragment)
    api(Dependencies.koinScope)
    api(Dependencies.koinViewModel)
    api(Dependencies.koinExt)

    api(Dependencies.epoxy)
    api(Dependencies.epoxyDatabinding)
    kapt(Dependencies.epoxyKapt)

    api(Dependencies.coroutineCore)
    api(Dependencies.coroutineAndroid)
    api(project(":baselib"))
}