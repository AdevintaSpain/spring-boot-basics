package com.adevinta.springbootbasics.infrastructure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
  scanBasePackages = [
    "com.adevinta.springbootbasics.infrastructure.controller",
    "com.adevinta.springbootbasics.infrastructure.configuration"
  ]
)
class Application

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
