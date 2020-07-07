package com.example.eatdrinkApi.config

import org.springframework.cache.annotation.CacheEvict
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class Webclientconfig {

    @Bean(name= ["bean1"])
    fun webClient() = WebClient.builder().baseUrl("https://places.ls.hereapi.com").build()


    @Bean(name= ["bean2"])
    fun chargingwebClient() = WebClient.builder().baseUrl("https://parking-v2.cit.cc.api.here.com").build()


    @CacheEvict(allEntries = true, value = ["eatrestcall"])
    @Scheduled(fixedDelay = 300000 ,  initialDelay = 300000)
    public fun clearChargingCache() {

        println("Evicting all entries from eatrestcall.");
    }

    @CacheEvict(allEntries = true, value = ["offstreetrestapi"])
    @Scheduled(fixedDelay = 300000 ,  initialDelay = 300000)
    public fun clearCache() {

        println("Evicting all entries from offstreetrestapi.");
    }


}