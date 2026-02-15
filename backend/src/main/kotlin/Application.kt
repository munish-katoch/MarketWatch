import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import model.StockQuote
import model.Fundamentals

fun main() {
    embeddedServer(Netty, port = 8080) {
        module()
    }.start(wait = true)
}

fun Application.module() {

    install(ContentNegotiation) {
        json()
    }

    routing {

        get("/api/stock") {
            val symbol = call.request.queryParameters["symbol"] ?: "AAPL"

            call.respond(
                StockQuote(symbol, 189.12, 1.23)
            )
        }

        get("/api/fundamentals") {
            call.respond(
                Fundamentals(
                    peRatio = 28.5,
                    marketCap = 3_000_000_000_000,
                    revenue = 383_000_000_000
                )
            )
        }
    }
}