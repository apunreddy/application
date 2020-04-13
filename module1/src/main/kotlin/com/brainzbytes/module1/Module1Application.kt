package com.brainzbytes.module1

import com.brainzbytes.library.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
@ComponentScan(basePackages = arrayOf("com.brainzbytes.library", "com.brainzbytes.module1"))
class Module1Application

fun main(args: Array<String>) {
	runApplication<Module1Application>(*args)
}
