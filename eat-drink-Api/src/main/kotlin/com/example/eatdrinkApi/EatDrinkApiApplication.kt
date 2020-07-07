package com.example.eatdrinkApi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.scheduling.annotation.EnableScheduling


@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableScheduling
class EatDrinkApiApplication

fun main(args: Array<String>) {
	runApplication<EatDrinkApiApplication>(*args)
}
