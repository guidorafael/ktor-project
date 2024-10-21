package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World! Boa tarde mundo!")
        }

        get("/aloalo") {
            call.respondText("Hello hello - I say yes - you say no - ")
        }
    }
}

/* documentação */