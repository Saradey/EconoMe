plugins {}

android {
    namespace = "evgenii.goncharov.econome.di_core"
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = extra["composeVersion"] as String
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
    implementation(libs.app.compat)

    implementation(libs.cicerone)
    implementation(libs.dagger)
    implementation(libs.fragment.ktx)
}