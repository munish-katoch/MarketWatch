plugins {
    // 1. Define versions once at the root
    kotlin("multiplatform") version "1.9.24" apply false
    id("org.jetbrains.compose") version "1.6.10" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        // 2. CRITICAL: Exact path for Compose Multiplatform artifacts
        maven("https://maven.pkg.jetbrains.space")
    }
}

subprojects {
    plugins.withType<org.jetbrains.compose.ComposePlugin> {
        configure<org.jetbrains.compose.ComposeExtension> {
            // Force the compiler version compatible with Kotlin 1.9.24
            kotlinCompilerPlugin.set("org.jetbrains.compose.compiler:compiler:1.5.14")
        }
    }
}