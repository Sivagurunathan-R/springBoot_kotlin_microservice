package com.example.EurekaServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableEurekaServer
@EnableCaching
@EnableScheduling
class EurekaServerApplication

fun main(args: Array<String>) {
	runApplication<EurekaServerApplication>(*args)
}

