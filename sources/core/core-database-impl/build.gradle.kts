plugins {
    id("kotlin-kapt")
    id("kotlinx-serialization")
}

android {
    namespace = "evgenii.goncharov.econome.core_database_impl"
}

dependencies {
    api(project(":sources:core:core-database-api"))

    api(project(":sources:engine:di-core"))
    implementation(project(":sources:core:common-provider"))

    implementation(libs.room)
    kapt(libs.room.compiler)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.kotlinx.serialization.json)
}