plugins {
}

android {
    namespace = "evgenii.goncharov.econome.user_impl"
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = extra["composeVersion"] as String
    }
}

dependencies {
    api(project(":sources:features:user-api"))

    implementation((project(":sources:engine:di-core")))
    implementation(project(":sources:engine:navigation"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
    implementation(libs.app.compat)
    implementation(libs.cicerone)
    implementation(libs.dagger)
    implementation(libs.fragment.ktx)
}