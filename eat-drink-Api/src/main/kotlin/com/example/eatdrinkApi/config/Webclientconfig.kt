package com.example.eatdrinkApi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class Webclientconfig {

    @Bean(name= ["bean1"])
    fun webClient() = WebClient.builder().baseUrl("https://places.ls.hereapi.com").build()


    @Bean(name= ["bean2"])
    fun chargingwebClient() = WebClient.builder().baseUrl("https://parking-v2.cit.cc.api.here.com").build()
}