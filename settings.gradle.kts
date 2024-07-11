pluginManagement {
    val micronautPluginVersion: String by settings
    val shadowVersion: String by settings

    plugins {
        id("com.github.johnrengelman.shadow") version shadowVersion
        id("io.micronaut.application") version micronautPluginVersion
        id("io.micronaut.aot") version micronautPluginVersion
    }
}

rootProject.name="micronaut-serde-examples"
