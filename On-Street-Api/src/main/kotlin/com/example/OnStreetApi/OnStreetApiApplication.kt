package com.example.OnStreetApi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.reactive.function.client.WebClient

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
class OnStreetApiApplication

fun main(args: Array<String>) {
	runApplication<OnStreetApiApplication>(*args)
}

@CacheEvict(allEntries = true, value = ["product"])
@Scheduled(fixedDelay = 5000 ,  initialDelay = 5000)
public fun clearCache() {

	println("Cache cleared");
}