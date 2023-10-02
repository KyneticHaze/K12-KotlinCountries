plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.kotlincountries"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kotlincountries"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}

val navVersion = "2.7.3"
val lifeCycleExtensionVersion = "1.1.1"
val retrofitVersion = "2.9.0"
val glideVersion = "4.16.0"
val rxJavaVersion = "3.1.8"
val rxAndroidVersion = "3.0.2"
val roomVersion = "2.5.2"
val preferencesVersion = "1.2.1"

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("android.arch.lifecycle:extensions:$lifeCycleExtensionVersion")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")

    //Room
    implementation ("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    kapt ("androidx.room:room-compiler:$roomVersion")
    implementation ("androidx.room:room-ktx:$roomVersion")
    implementation("androidx.room:room-rxjava3:$roomVersion")

    //Coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    //Navigation
    implementation ("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation ("androidx.navigation:navigation-ui-ktx:$navVersion")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation ("com.squareup.retrofit2:adapter-rxjava3:$retrofitVersion")

    //RxJava and RxAndroid
    implementation ("io.reactivex.rxjava3:rxjava:$rxJavaVersion")
    implementation ("io.reactivex.rxjava3:rxandroid:$rxAndroidVersion")

    //Glide
    implementation ("com.github.bumptech.glide:glide:$glideVersion")

    implementation ("androidx.preference:preference-ktx:$preferencesVersion")


}