plugins {
    id("kotlin-kapt")
}

android {
    namespace = "evgenii.goncharov.econome.common"
}

dependencies {
    implementation(project(":sources:engine:di-core"))

    implementation(libs.dagger)
    implementation(libs.lifecycle.viewmodel)

    kapt(libs.dagger.compiler)
}