plugins {
    id("kotlin-kapt")
    id("kotlinx-serialization")
}

android {
    namespace = "evgenii.goncharov.econome.common_provider"
}

dependencies {
    implementation(project(":sources:engine:di-core"))

    implementation(libs.dagger)
    implementation(libs.androidx.annotation.jvm)
    implementation(libs.playservices.auth)
    implementation(libs.kotlinx.serialization.json)
    kapt(libs.dagger.compiler)
}