package com.example.chargingstationApi.configs

import org.springframework.cache.annotation.CacheEvict
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class Webclientconfiig {

    @Bean(name= ["bean1"])
    fun webClient() = WebClient.builder().baseUrl("https://places.ls.hereapi.com").build()


    @Bean(name= ["bean2"])
    fun chargingwebClient() = WebClient.builder().baseUrl("https://ev-v2.cit.cc.api.here.com").build()


    @CacheEvict(allEntries = true, value = ["chargingrestcall"])
    @Scheduled(fixedDelay = 300000 ,  initialDelay = 300000)
    public fun clearChargingCache() {

        println("Evicting all entries from chargingrestcall.");
    }

    @CacheEvict(allEntries = true, value = ["chargingrestapi"])
    @Scheduled(fixedDelay = 300000 ,  initialDelay = 300000)
    public fun clearCache() {

        println("Evicting all entries from chargingrestapi.");
    }

}