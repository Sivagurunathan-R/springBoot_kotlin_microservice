package com.example.chargingstationApi.configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class Webclientconfiig {

    @Bean
    fun webClient() = WebClient.builder().baseUrl("https://places.ls.hereapi.com").build()
}