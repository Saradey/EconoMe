import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

allprojects {
    plugins.withId("io.gitlab.arturbosch.detekt") {
        configure<io.gitlab.arturbosch.detekt.extensions.DetektExtension> {
            source = files("src/main/kotlin")
        }
    }
}

subprojects {
    if (displayName.contains("app").not() &&
        displayName.contains("uikit-sandbox").not() &&
        file("src").exists()
    ) {
        with(pluginManager) {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.android")
        }
    }
    plugins.withId("com.android.library") {
        configure<com.android.build.gradle.LibraryExtension> {
            compileSdk = extra["compileSdk"].toString().toInt()
            defaultConfig {
                minSdk = extra["minSdk"].toString().toInt()
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
        }
        tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = "1.8"
                freeCompilerArgs = listOf("-Xexplicit-api=strict")
            }
        }
    }
}

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.gms) apply false
}
true // Needed to make the Suppress annotation work for the plugins block