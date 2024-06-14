plugins {
    id("kotlin-kapt")
}

android {
    namespace = "evgenii.goncharov.econome.current_user"
}

dependencies {
    implementation(project(":sources:engine:di-core"))
    implementation(project(":sources:core:core-database-api"))

    implementation(libs.dagger)
    implementation(libs.androidx.annotation.jvm)
    kapt(libs.dagger.compiler)
}