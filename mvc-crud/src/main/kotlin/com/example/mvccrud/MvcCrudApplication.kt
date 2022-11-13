package com.example.mvccrud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MvcCrudApplication

fun main(args: Array<String>) {
    runApplication<MvcCrudApplication>(*args)
}
