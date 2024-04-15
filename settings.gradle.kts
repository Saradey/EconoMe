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
include(":sources:features:main-navigation-api")
include(":sources:features:main-navigation-impl")
include(":sources:features:main-api")
include(":sources:features:main-impl")
include(":sources:features:spending-api")
include(":sources:features:spending-impl")
include(":sources:features:bank-accounts-api")
include(":sources:features:bank-accounts-impl")
