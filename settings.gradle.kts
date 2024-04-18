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
include(":sources:features:user-api")
include(":sources:features:user-impl")
include(":sources:features:wallet-api")
include(":sources:features:wallet-impl")
include(":sources:features:settings-api")
include(":sources:features:settings-impl")
include(":sources:features:common-categories-api")
include(":sources:features:common-categories-impl")
include(":sources:features:finance-analysis-api")
include(":sources:features:finance-analysis-impl")
include(":sources:features:product-cost-analysis-api")
include(":sources:features:product-cost-analysis-impl")
include(":sources:features:product-categories-api")
include(":sources:features:product-categories-impl")
include(":sources:features:all-spending-api")
include(":sources:features:all-spending-impl")
include(":sources:common")
