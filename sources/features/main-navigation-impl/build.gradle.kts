plugins {
    id("kotlin-kapt")
}

android {
    namespace = "evgenii.goncharov.econome.main_navigation_impl"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = extra["composeVersion"] as String
    }
}

dependencies {
    api(project(":sources:features:main-navigation-api"))

    implementation(project(":sources:engine:di-core"))
    implementation(project(":sources:engine:navigation"))
    implementation(project(":sources:core:common"))
    implementation(project(":sources:resources:ui-kit"))

    implementation(project(":sources:features:main-api"))
    implementation(project(":sources:features:all-spending-api"))
    implementation(project(":sources:features:finance-analysis-api"))
    implementation(project(":sources:features:bank-accounts-api"))
    implementation(project(":sources:features:settings-api"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
    implementation(libs.cicerone)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.fragment.ktx)
}