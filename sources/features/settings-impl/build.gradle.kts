plugins {
    id("kotlin-kapt")
}

android {
    namespace = "evgenii.goncharov.econome.settings_impl"
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = extra["composeVersion"] as String
    }
}

dependencies {
    api(project(":sources:features:settings-api"))

    implementation((project(":sources:engine:di-core")))
    implementation((project(":sources:engine:navigation")))
    implementation(project(":sources:core:common"))

    implementation(project(":sources:features:user-api"))
    implementation(project(":sources:features:wallet-api"))
    implementation(project(":sources:features:common-categories-api"))
    implementation(project(":sources:features:product-categories-api"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
    implementation(libs.cicerone)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.fragment.ktx)
}