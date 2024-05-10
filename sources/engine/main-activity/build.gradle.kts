plugins {
    id("kotlin-kapt")
}

android {
    namespace = "evgenii.goncharov.econome.main_activity"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.cicerone)
    implementation(libs.activity.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.fragment)

    implementation(project(":sources:engine:di-core"))
    implementation(project(":sources:engine:navigation"))
    implementation(project(":sources:core:common"))
    implementation(project(":sources:core:core-database-api"))

    implementation(project(":sources:features:user-api"))
    implementation(project(":sources:features:main-navigation-api"))
}