plugins {}

android {
    namespace = "evgenii.goncharov.econome.main_impl"
}

dependencies {
    api(project(":sources:features:main-api"))

    implementation((project(":sources:engine:di-core")))
}