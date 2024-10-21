package com.example

import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.* // embeddedServer
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    /* io.ktor.server.netty.EngineMain.main(args) // funciona sozinho
    * sem importar "netty" */
    //embeddedServer(Netty, 8080,"0.0.0.0").start()
    embeddedServer(Netty, port = 8080, "0.0.0.0", configure = {
        connectionGroupSize = 2
        workerGroupSize = 5
        callGroupSize = 10
        shutdownGracePeriod = 2000
        shutdownTimeout = 3000
    }) {
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
