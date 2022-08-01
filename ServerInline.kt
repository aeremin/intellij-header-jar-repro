package com.example

import io.ktor.server.application.Application
import io.ktor.server.application.log
import io.ktor.server.application.call
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8081, host = "0.0.0.0") {

        this.log.info("Hello world!")
        this.routing {
            get("/") {
                call.respondText("Hello Cloud World!")
            }
        }
    }.start(wait = true)
}

fun foo(app: Application) {}
