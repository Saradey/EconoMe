plugins {}

android {
    namespace = "evgenii.goncharov.econome.core_dependencies_impl"
}

dependencies {
    api(project(":sources:core:core-dependencies-api"))

    implementation(libs.dagger)
}