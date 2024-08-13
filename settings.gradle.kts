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

rootProject.name = "Vinodel"
include(":app")
include(":base:ui")
include(":base:viewmodel")
include(":base:navigation")
include(":base:network")
include(":features:ingredients:api")
include(":features:ingredients:imp")
include(":features:storage:api")
include(":features:storage:imp")
include(":features:main:api")
include(":features:main:imp")
include(":features:drinks:api")
include(":features:drinks:imp")
include(":features:recipes:api")
include(":features:recipes:imp")
include(":base:di")
include(":features:splash:api")
include(":features:splash:imp")
include(":base:utils")
