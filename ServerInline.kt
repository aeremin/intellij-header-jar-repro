package com.example

import io.ktor.server.application.Application
import io.ktor.server.application.log
import io.ktor.server.application.call
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    val environment = applicationEngineEnvironment {
        module {
            main()
        }

        connector {
            port = 8080
            host = "127.0.0.1"
        }
    }
    Application(environment)
}


