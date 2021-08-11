
plugins {
    id("com.github.johnrengelman.shadow") version "7.0.0"
    application
}

tasks {
    jar {
        manifest {
            attributes(
                mapOf(
                    "Main-Class" to "io.ktor.server.cio.EngineMain",
                    "ImplementationTitle" to project.name,
                    "Implementation-Version" to project.version
                )
            )
        }
    }
    shadowJar {
        manifest.inheritFrom(jar.get().manifest)
    }
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
//    mainClass.set("docker.ktor.ApplicationKt")
}

dependencies {
    implementation(projects.domain)
    implementation(projects.interfaces)
    implementation(projects.useCases)
    implementation(projects.repositories)

    implementation("io.ktor", "ktor-jackson", libs.versions.ktor.get())
    implementation("io.ktor", "ktor-server-core", libs.versions.ktor.get())
    implementation("io.ktor", "ktor-server-netty", libs.versions.ktor.get())
    implementation("io.ktor", "ktor-locations", libs.versions.ktor.get())

    implementation("ch.qos.logback", "logback-classic", libs.versions.logback.get())
    implementation("io.insert-koin", "koin-ktor", libs.versions.koin.get())

    testImplementation("io.ktor", "ktor-server-tests", libs.versions.ktor.get())
}
