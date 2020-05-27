object Versions {
    const val kotlinVersion = "1.3.72"

    const val compileSdkVersion = 29
    const val targetSdkVersion = 28
    const val minSdkVersion = 24
    const val versionCode = 1
    const val versionName = "v0.0.1"

    const val nav_version = "2.3.0-beta01"
    const val activity_version = "1.2.0-alpha04"
    const val fragment_version = "1.3.0-alpha04"
    const val lifecycle_version = "2.1.0"
    const val lifecycle_ktx_version = "2.2.0"
    const val retrofit_version = "2.9.0"
    const val koin_version = "2.1.5"
    const val room_version = "2.2.5"
}

object Dependencies {
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_version}"
    const val viewModelKtx        = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_ktx_version}"
    const val livedataKtx         = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_ktx_version}"
    const val material            = "com.google.android.material:material:1.2.0-alpha06"
    const val refreshLayout       = "androidx.swiperefreshlayout:swiperefreshlayout:1.0.0"
    const val navigationFragment  = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    const val navigationUI        = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"
    const val dynamicFeature      = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav_version}"
    const val activity            = "androidx.activity:activity:${Versions.activity_version}"
    const val fragment            = "androidx.fragment:fragment-ktx:${Versions.fragment_version}"
    const val retrofit            = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    const val okHttp              = "com.squareup.okhttp3:okhttp:4.7.2"
    const val gson                = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"
    const val okHttpLogger        = "com.squareup.okhttp3:logging-interceptor:4.7.2"
    const val epoxy               = "com.airbnb.android:epoxy:3.11.0"
    const val epoxyKapt           = "com.airbnb.android:epoxy-processor:3.11.0"
    const val epoxyDatabinding    = "com.airbnb.android:epoxy-databinding:3.11.0"
    const val coreKtx             = "androidx.core:core-ktx:1.1.0"
    const val constraintLayout    = "androidx.constraintlayout:constraintlayout:2.0.0-beta6"
    const val timber              = "com.jakewharton.timber:timber:4.7.1"
    const val koinFragment        = "org.koin:koin-androidx-fragment:${Versions.koin_version}"
    const val koinScope           = "org.koin:koin-androidx-scope:${Versions.koin_version}"
    const val koinViewModel       = "org.koin:koin-androidx-viewmodel:${Versions.koin_version}"
    const val koinExt             = "org.koin:koin-androidx-ext:${Versions.koin_version}"
    const val room                = "androidx.room:room-runtime:${Versions.room_version}"
    const val roomKapt            = "androidx.room:room-compiler:${Versions.room_version}"
    const val roomKtx             = "androidx.room:room-ktx:${Versions.room_version}"
    const val roomRx              = "androidx.room:room-rxjava2:${Versions.room_version}"
    const val coil                = "io.coil-kt:coil:0.11.0"

    const val coroutineCore       = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2"
    const val coroutineAndroid    = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.2"
}