package com.example.EurekaServer.rest

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {

  //  @Value("{local.server.port}")
  //  var port:Int = 0

    @Bean
    fun webClient() = WebClient.builder().baseUrl("http://localhost:8080").build()
}