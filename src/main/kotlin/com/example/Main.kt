package com.example

import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import java.io.IOException
import java.net.URI

/**
 * Main class.
 *
 */
object Main {
    // Base URI the Grizzly HTTP server will listen on
    const val BASE_URI = "http://localhost:8080/myapp/"

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    fun startServer(): HttpServer {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example package
        val rc = ResourceConfig().packages("com.example")

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc)
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>)  = startServer().let {
        println("Jersey app started with WADL available at ${BASE_URI}application.wadl\nHit enter to stop it...")
        readLine()
        it.shutdownNow()
    }
}