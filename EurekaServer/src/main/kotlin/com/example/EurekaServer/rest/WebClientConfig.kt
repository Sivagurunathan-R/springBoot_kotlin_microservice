package com.example.EurekaServer.rest

import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.CacheEvict
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {

    @Bean
    fun webClient() = WebClient.builder().baseUrl("http://localhost:8080").build()

    @CacheEvict(allEntries = true, value = ["chargingrestcall"])
    @Scheduled(fixedDelay = 300000 ,  initialDelay = 300000)
    public fun clearChargingCache() {

        println("Evicting all entries from chargingrestcall.");
    }

    @CacheEvict(allEntries = true, value = ["chargingrestapi"])
    @Scheduled(fixedDelay = 300000 ,  initialDelay = 300000)
    public fun clearChargingRestCache() {

        println("Evicting all entries from chargingrestapi.");
    }

    @CacheEvict(allEntries = true, value = ["chargingrestcallwith"])
    @Scheduled(fixedDelay = 300000 ,  initialDelay = 300000)
    public fun clearChargingRestCachewith() {

        println("Evicting all entries from chargingrestcallwith.");
    }
}