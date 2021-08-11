package infrastructure

import infrastructure.config.AppModule
import infrastructure.plugins.configureRouting
import infrastructure.plugins.configureSerialization
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Locations
import io.ktor.server.netty.EngineMain
import org.koin.ktor.ext.Koin

fun main(args: Array<String>) = EngineMain.main(args)

@KtorExperimentalLocationsAPI
@Suppress("unused")
fun Application.module(testing: Boolean = false) {
    install(Koin) {
        modules(AppModule)
    }

    install(Locations)

    configureSerialization()

    configureRouting()
}
