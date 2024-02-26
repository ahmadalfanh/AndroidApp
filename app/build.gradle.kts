plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.alfan.test"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.alfan.test"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        kapt {
            includeCompileClasspath = false
        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        dataBinding = true

    }
    dataBinding {

    }

}

dependencies {


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")

    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.0")
    implementation("androidx.lifecycle:lifecycle-process:2.5.0")
    implementation("androidx.lifecycle:lifecycle-common:2.5.0'")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0")

    //room
    implementation("androidx.room:room-runtime:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    ksp("androidx.room:room-compiler:2.5.0")
    annotationProcessor("androidx.room:room-compiler:2.5.0")


    //Networking, image caching
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.google.code.gson:gson:2.9.1")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.13.2")
    ksp("com.github.bumptech.glide:compiler:4.13.2")

    //shimer
    implementation("com.facebook.shimmer:shimmer:0.5.0")

    // Chucker
    debugImplementation("com.github.chuckerteam.chucker:library:3.5.2")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:3.5.2")
    implementation("com.devbrackets.android:exomedia:5.1.0")

    //koin
    implementation("io.insert-koin:koin-core:3.3.2")
    implementation("io.insert-koin:koin-android:3.3.2")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.43.2")
    annotationProcessor("com.google.dagger:hilt-android-compiler:2.43.2")

    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.10")

    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    //RX FTW!
    implementation("io.reactivex:rxjava:1.3.8")
    implementation("io.reactivex:rxandroid:1.2.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")
    //test
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.1")
    androidTestImplementation("androidx.test.uiautomator:uiautomator:2.2.0")
    implementation("androidx.test.espresso:espresso-idling-resource:3.5.1")
    implementation("androidx.test.espresso.idling:idling-net:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // mockito
    testImplementation("org.mockito:mockito-core:4.2.0")
    testImplementation("org.mockito:mockito-inline:4.2.0")
}