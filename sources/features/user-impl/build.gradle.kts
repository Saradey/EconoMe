plugins {
}

android {
    namespace = "evgenii.goncharov.econome.user_impl"
}

dependencies {
    api(project(":sources:features:user-api"))

    implementation((project(":sources:engine:di-core")))
    implementation(project(":sources:engine:navigation"))

    implementation(libs.cicerone)
    implementation(libs.dagger)
}