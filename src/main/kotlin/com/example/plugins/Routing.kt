package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
//import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {


        authenticate("myAuth") {
            get("/page") {
                call.respondText("Protected content! Name: ${call.principal<UserIdPrincipal>()?.name}")
            }

            get("/page/showLog") {
                call.respondText("Protected content! Name: ${call.principal<UserIdPrincipal>()?.name}  /page/showLog")
            }

        }



        get("/") {
            call.respondText("Hello World! Boa tarde mundo!")
        }

        // Charlie Brown: ele aceita espaço!
        // http://0.0.0.0:8080/alo%20alo
        get("/alo") {
            call.respondText("Hello hello - I say yes - you say no - ")
        }

        //http://0.0.0.0:8080/alo%20alo%20%20alo
        get("/alo/alo-alo") {
            call.respondText("3 alos com espaço :  funciona ")
        }

        //http://0.0.0.0:8080/alo%20alo%20%20alo
        get("/page/alo-alo") {
            call.respondText("/page/alo-alo ")
        }


    }
}
/* documentação */