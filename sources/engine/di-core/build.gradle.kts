plugins {}

android {
    namespace = "evgenii.goncharov.econome.di_core"
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)

    implementation(libs.cicerone)
    implementation(libs.dagger)
    implementation(libs.fragment.ktx)
}