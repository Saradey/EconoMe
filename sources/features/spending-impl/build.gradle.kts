plugins {
    id("kotlin-kapt")
}

android {
    namespace = "evgenii.goncharov.econome.spending_impl"
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = extra["composeVersion"] as String
    }
}

dependencies {
    api(project(":sources:features:spending-api"))

    implementation(project(":sources:engine:di-core"))
    implementation(project(":sources:engine:navigation"))
    implementation(project(":sources:core:common"))
    implementation(project(":sources:core:common-provider"))
    implementation(project(":sources:core:current-user"))
    implementation(project(":sources:core:core-database-api"))
    implementation(project(":sources:resources:ui-kit"))
    implementation(project(":sources:domain:category"))

    implementation(project(":sources:features:main-api"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
    implementation(libs.cicerone)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.fragment.ktx)
    implementation(libs.material)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.kotlinx.serialization.json)
}