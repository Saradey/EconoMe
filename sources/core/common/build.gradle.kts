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
    implementation(libs.fragment.ktx)

    kapt(libs.dagger.compiler)
}