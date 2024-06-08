plugins {
    id("kotlin-kapt")
    id("kotlinx-serialization")
}

android {
    namespace = "evgenii.goncharov.econome.currency"
}

dependencies {
    implementation(libs.dagger)
    implementation(libs.kotlinx.serialization.json)
    kapt(libs.dagger.compiler)
}