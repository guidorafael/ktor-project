package com.example

import io.ktor.server.application.*
import io.ktor.server.auth.*

import com.example.plugins.*
//import io.ktor.server.application.*
import io.ktor.server.engine.* // embeddedServer
import io.ktor.server.netty.*

fun main() {
    /* io.ktor.server.netty.EngineMain.main(args) // funciona sozinho
    * sem importar "netty" */
    //embeddedServer(Netty, 8080,"0.0.0.0").start()
    embeddedServer(Netty, port = 8080, "0.0.0.0")
    {
        install(Authentication) {
            basic("myAuth") {
                realm = "Access to the '/page' path"
                validate { credentials ->
                    if (credentials.name == "Admin" && credentials.password == "2425") {
                        UserIdPrincipal(credentials.name)
                    } else {
                        null
                    }
                }
            }
        }
        module()// ...
    }.start(wait = true)
}

/* documntação */

fun Application.module() {
    //rename kt configureSerialization()
    //rename kt configureDatabases()
    //rename kt configureTemplating()
    //rename kt configureSecurity()
    configureRouting()
}
