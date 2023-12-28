// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.androidLibrary) apply false
}
true // Needed to make the Suppress annotation work for the plugins block

allprojects {
    extra["targetSdk"] = 34
    extra["compileSdk"] = 34
    extra["minSdk"] = 24
    extra["versionCode"] = 1
    extra["versionName"] = "0.0.1"
}