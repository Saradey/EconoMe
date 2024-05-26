plugins {
    id("kotlin-kapt")
}

android {
    namespace = "evgenii.goncharov.econome.common_provider"
}

dependencies {
    implementation(project(":sources:engine:di-core"))

    implementation(libs.dagger)
    implementation(libs.androidx.annotation.jvm)
    implementation(libs.playservices.auth)
    kapt(libs.dagger.compiler)
}