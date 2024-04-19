plugins {
    id("kotlin-kapt")
}

android {
    namespace = "evgenii.goncharov.econome.navigation"
}

dependencies {
    implementation(project(":sources:engine:di-core"))

    implementation(libs.cicerone)
    implementation(libs.dagger)
    implementation(libs.fragment.ktx)
    kapt(libs.dagger.compiler)
}