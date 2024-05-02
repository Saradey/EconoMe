plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.detekt)
    id("kotlin-kapt")
}

android {
    namespace = "evgenii.goncharov.econome"
    compileSdk = extra["compileSdk"].toString().toInt()
    defaultConfig {
        applicationId = "evgenii.goncharov.econome"
        minSdk = extra["minSdk"].toString().toInt()
        targetSdk = extra["targetSdk"].toString().toInt()
        versionCode = extra["versionCode"].toString().toInt()
        versionName = extra["versionName"] as String
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
        jvmTarget = extra["kotlinTarget"] as String
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = extra["composeVersion"] as String
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.cicerone)
    implementation(libs.activity.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.fragment)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)

    // features
    implementation(project(":sources:engine:main-activity"))
    implementation(project(":sources:features:main-navigation-impl"))
    implementation(project(":sources:features:main-impl"))
    implementation(project(":sources:features:spending-impl"))
    implementation(project(":sources:features:bank-accounts-impl"))
    implementation(project(":sources:features:user-impl"))
    implementation(project(":sources:features:wallet-impl"))
    implementation(project(":sources:features:settings-impl"))
    implementation(project(":sources:features:common-categories-impl"))
    implementation(project(":sources:features:finance-analysis-impl"))
    implementation(project(":sources:features:product-cost-analysis-impl"))
    implementation(project(":sources:features:product-categories-impl"))
    implementation(project(":sources:features:all-spending-impl"))

    // core modules
    implementation(project(":sources:engine:di-core"))
    implementation(project(":sources:engine:navigation"))
    implementation(project(":sources:resources:ui-kit"))
    implementation(project(":sources:core:common"))

    // tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}