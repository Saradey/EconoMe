plugins {
    id("kotlin-kapt")
}

android {
    namespace = "evgenii.goncharov.econome.bank_accounts_impl"
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = extra["composeVersion"] as String
    }
}

dependencies {
    api(project(":sources:features:bank-accounts-api"))

    implementation((project(":sources:engine:di-core")))
    implementation((project(":sources:engine:navigation")))
    implementation(project(":sources:core:common"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
    implementation(libs.cicerone)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.fragment.ktx)
}