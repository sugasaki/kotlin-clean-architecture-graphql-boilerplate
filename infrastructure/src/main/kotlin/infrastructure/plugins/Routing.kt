package infrastructure.plugins

import infrastructure.router.configureUser
import interfaces.controller.Response
import io.ktor.application.Application
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing

@KtorExperimentalLocationsAPI
fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/news") {
            call.respondText("news!")
        }

        configureUser()
    }
}

suspend inline fun <reified T> ApplicationCall.respondCustomResponse(response: Response<T>, onlyStatusCode: Boolean = false) {
    val statusCode = HttpStatusCodeConverter(response.statusCode).call()
    val errorMessage = response.errorMessage
    val data = response.data
    return if (errorMessage != null) {
        respond(statusCode, errorMessage)
    } else {
        if (data == null || onlyStatusCode) {
            respond(statusCode)
        } else {
            respond(statusCode, data)
        }
    }
}

data class HttpStatusCodeConverter(private val statusCode: Int) {
    fun call(): HttpStatusCode {
        return HttpStatusCode.allStatusCodes.find { it.value == statusCode }
            ?: throw NotImplementedError("No such statusCode exists.")
    }
}
