import `fun`.adaptive.ktor.KtorWorker
import `fun`.adaptive.server.builtin.service
import `fun`.adaptive.server.builtin.worker
import `fun`.adaptive.server.server
import `fun`.adaptive.server.setting.dsl.inline
import `fun`.adaptive.server.setting.dsl.settings
import `fun`.adaptive.wireformat.withJson

fun main() {

    withJson()

    server(true) {

        settings {
            inline(
                "KTOR_PORT" to 8080,
                "KTOR_STATIC" to "../browserApp/build/processedResources/js/main",
                "COUNTER_LIMIT" to 2000,
                "COUNTER_IDLE_INTERVAL" to 60
            )
        }

        service { CounterService() }
        worker { CounterWorker() }

        worker { KtorWorker() }

    }

}
