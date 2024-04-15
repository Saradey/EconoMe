pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "EconoMe"
include(":app")
include(":sources:engine:di-core")
include(":sources:engine:navigation")
include(":sources:resources:ui-kit")
include(":sources:resources:uikit-sandbox")
