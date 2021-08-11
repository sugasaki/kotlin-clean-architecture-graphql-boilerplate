pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(
    ":domain",
    ":infrastructure",
    ":repositories",
    ":use-cases",
    ":interfaces"
)

enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("coroutines", "1.5.1")
            version("ktor", "1.6.2")
            version("logback", "1.2.5")
            version("mockk", "1.12.0")
            version("koin", "3.1.2")
            version("kotlinResult", "1.1.12")
            version("assertj", "3.20.2")
            version("kmapper", "0.36")
        }
    }
}
