package com.example.eatdrinkApi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class Webclientconfig {

    @Bean
    fun webClient() = WebClient.builder().baseUrl("https://places.ls.hereapi.com").build()
}