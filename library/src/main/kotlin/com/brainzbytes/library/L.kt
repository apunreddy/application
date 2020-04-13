package com.brainzbytes.library

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Component
//@PropertySource("file:./library/build/resources/main/application.yaml")
data class Config (
    @Value("\${test.value}")
    var mongodbUrl: String
)

@Service
class Service(val cfg: Config) {
    fun main()  : String {
        return cfg.mongodbUrl
    }
}

@RestController
class V2EntitlementOrg(
    val service: com.brainzbytes.library.Service
) {
    @GetMapping("/v2/test")
    fun orgQueryEntitlements(
    ): Any {
        return service.main()
    }
}

@SpringBootApplication
class LibraryApplication

fun main(args: Array<String>) {
    runApplication<LibraryApplication>(*args)
}

