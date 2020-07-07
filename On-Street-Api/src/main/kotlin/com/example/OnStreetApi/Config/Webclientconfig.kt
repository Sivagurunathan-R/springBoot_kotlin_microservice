package com.example.OnStreetApi.Config

import com.netflix.discovery.shared.Application
import org.bouncycastle.crypto.tls.ConnectionEnd.server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class Webclientconfig {

    @Bean
    fun webClient() = WebClient.builder().baseUrl("https://places.ls.hereapi.com").build()
}