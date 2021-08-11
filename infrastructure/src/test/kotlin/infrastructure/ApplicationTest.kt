package infrastructure

import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.assertj.core.api.Assertions
import org.koin.core.annotation.KoinInternalApi
import kotlin.test.Test
import kotlin.test.assertEquals

@KtorExperimentalLocationsAPI
@KoinInternalApi
class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                Assertions.assertThat(response.content).isEqualTo("Hello World!")
            }
        }
    }
}
