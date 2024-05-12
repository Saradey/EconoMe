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
    kapt(libs.dagger.compiler)
    implementation(platform(libs.firebase.auth.bom))
    implementation(libs.firebase.auth)
}