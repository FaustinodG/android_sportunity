plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.detekt)
    alias(libs.plugins.google.devtools.ksp)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.androidx.navigation.safeargs)
    alias(libs.plugins.android.maps.platform.gradle.plugin)
}

android {
    namespace = "com.faustinodegroot.sportunity"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.faustinodegroot.sportunity"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
        dataBinding = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    sourceSets {
        getByName("main") {
            java {
                srcDirs("src/main/java")
            }
        }

        getByName("test") {
            java {
                srcDirs("src/test/java")
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.coil.kt)

    // Dagger
    implementation(libs.google.dagger.hilt.android)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.recyclerview)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    ksp(libs.google.dagger.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.hilt.navigation.fragment)

    //Retrofit2
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.retrofit.converter.gson)
    implementation(libs.squareup.okhttp3.logging.interceptor)

    //Coroutines
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)

    //Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.coroutines)
    ksp(libs.androidx.room.compiler)

    implementation(libs.androidx.appcompat)

    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)


    implementation(libs.androidx.swiperefreshlayout)
    implementation(libs.androidx.paging3)

    implementation(libs.timber)

    implementation(libs.android.google.maps)

    implementation(libs.androidx.cardview)

    testImplementation(libs.junit)
    testImplementation(libs.mockito)
    testImplementation(libs.arch.core.testing)

    androidTestImplementation(libs.androidx.test.ext.junit)

}