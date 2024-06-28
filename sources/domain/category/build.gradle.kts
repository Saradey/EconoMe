plugins {
    id("kotlin-kapt")
    id("kotlinx-serialization")
}

android {
    namespace = "evgenii.goncharov.econome.category"
}

dependencies {
    implementation(project(":sources:engine:di-core"))
    implementation(project(":sources:core:common-provider"))
    implementation(project(":sources:core:common"))
    implementation(project(":sources:core:core-database-api"))

    implementation(libs.dagger)
    implementation(libs.kotlinx.serialization.json)
    kapt(libs.dagger.compiler)
}