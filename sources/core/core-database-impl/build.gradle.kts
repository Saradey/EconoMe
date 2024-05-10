plugins {
    id("kotlin-kapt")
}

android {
    namespace = "evgenii.goncharov.econome.core_database_impl"
}

dependencies {
    api(project(":sources:core:core-database-api"))

    implementation(libs.room)
    kapt(libs.room.compiler)
}