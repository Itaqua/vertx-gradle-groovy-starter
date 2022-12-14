package io.vertx.starter

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise

class MainVerticle extends AbstractVerticle {
    void start(Promise<Void> promise) {
        println("Starting")
        
        vertx.createHttpServer().requestHandler(req -> {
            req.response()
            .putHeader("content-type", "text/plain")
            .end("Hello from Vert.x!")
        }).listen(8888, http -> {
            if (http.succeeded()) {
                promise.complete()
                println("HTTP server started on port 8888")
            } else {
                promise.fail(http.cause())
            }
        })
        
    }

    void stop() {
        println("Stopping")
    }
}