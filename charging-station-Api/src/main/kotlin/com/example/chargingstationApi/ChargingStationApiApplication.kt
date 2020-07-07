package com.example.chargingstationApi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.scheduling.annotation.Scheduled

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
class ChargingStationApiApplication

fun main(args: Array<String>) {
	runApplication<ChargingStationApiApplication>(*args)
}

@CacheEvict(allEntries = true, value = ["product"])
@Scheduled(fixedDelay = 5000 ,  initialDelay = 5000)
public fun clearCache() {

	println("Cache cleared");
}