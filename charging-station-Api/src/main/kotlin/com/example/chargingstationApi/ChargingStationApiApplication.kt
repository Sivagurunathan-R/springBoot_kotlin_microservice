package com.example.chargingstationApi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.scheduling.annotation.EnableScheduling


@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableScheduling
class ChargingStationApiApplication

fun main(args: Array<String>) {
	runApplication<ChargingStationApiApplication>(*args)
}

