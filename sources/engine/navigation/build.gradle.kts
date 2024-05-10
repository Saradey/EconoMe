plugins {
    id("kotlin-kapt")
}

android {
    namespace = "evgenii.goncharov.econome.navigation"
}

dependencies {
    implementation(project(":sources:engine:di-core"))

    implementation(libs.cicerone)
    implementation(libs.fragment.ktx)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}