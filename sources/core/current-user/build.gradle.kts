plugins {
    id("kotlin-kapt")
}

android {
    namespace = "evgenii.goncharov.econome.current_user"
}

dependencies {
    implementation(libs.dagger)
    implementation(libs.androidx.annotation.jvm)
    kapt(libs.dagger.compiler)
}