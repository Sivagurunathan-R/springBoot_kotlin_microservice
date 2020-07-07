package com.example.EurekaServer.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.util.UriComponents
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class RestServices {

    @Autowired
    lateinit var webclient: WebClient

    @GetMapping("/hello")
    fun testApi(): Flux<Any> {

        val result: Mono<String> = webclient.get().uri("/parking-facility/hello").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<String>()

        val result2 : Mono<String> = webclient.get().uri("/eat-drink/hello").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<String>()

        val result3 : Mono<String> = webclient.get().uri("/charging-station/hello").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<String>()

        //Mono.zip(result, result2 , result3).flatMap{ }

        return Flux.merge(result , result2 , result3)
    }


    @Cacheable(value = ["chargingrestcall"] , key= "{ #root.methodName , #at , #size}")
    @GetMapping("/getdata/{at}/{size}")
    fun testApiData(@PathVariable at:String , @PathVariable size:Int): Flux<Any> {

        println("*** Returning NOT from cache ***")

        val shoppingUri: UriComponents = UriComponentsBuilder.newInstance().path("/parking-facility/get").queryParam("at",at).queryParam("cat","shopping").queryParam("size" , size).build()

        val eatDrinkUri: UriComponents = UriComponentsBuilder.newInstance().path("/eat-drink/get").queryParam("at",at).queryParam("cat","eat-drink").queryParam("size" , size).build()

        val chargingStationUri: UriComponents = UriComponentsBuilder.newInstance().path("/charging-station/get").queryParam("at",at).queryParam("cat","petrol-station").queryParam("size" , size).build()

        val shoppingresult: Mono<Any> = webclient.get().uri(shoppingUri.toString()).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Any>()

        val eatDrinkresult : Mono<Any> = webclient.get().uri(eatDrinkUri.toString()).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Any>()

        val chargingStationresult : Mono<Any> = webclient.get().uri(chargingStationUri.toString()).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Any>()

        return Flux.merge(shoppingresult , eatDrinkresult , chargingStationresult)
    }

    @Cacheable(value = ["chargingrestcallwith"] , key= "{ #root.methodName , #at }")
    @GetMapping("/getdata/{at}")
    fun testApiDatawithAt(@PathVariable at:String): Flux<Any> {

        println("*** Returning NOT from cache ***")

        val defaultSize = 3

        val shoppingUri: UriComponents = UriComponentsBuilder.newInstance().path("/parking-facility/get").queryParam("at",at).queryParam("cat","shopping").queryParam("size" , defaultSize).build()

        val eatDrinkUri: UriComponents = UriComponentsBuilder.newInstance().path("/eat-drink/get").queryParam("at",at).queryParam("cat","eat-drink").queryParam("size" , defaultSize).build()

        val chargingStationUri: UriComponents = UriComponentsBuilder.newInstance().path("/charging-station/get").queryParam("at",at).queryParam("cat","petrol-station").queryParam("size" , defaultSize).build()

        val shoppingresult: Mono<Any> = webclient.get().uri(shoppingUri.toString()).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Any>()

        val eatDrinkresult : Mono<Any> = webclient.get().uri(eatDrinkUri.toString()).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Any>()

        val chargingStationresult : Mono<Any> = webclient.get().uri(chargingStationUri.toString()).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Any>()

        return Flux.merge(shoppingresult , eatDrinkresult , chargingStationresult)
    }


    @Cacheable(value = ["chargingrestapi"] , key= "{ #root.methodName , #prox }")
    @GetMapping("/getVCS/{prox}")
    fun restApi(@PathVariable prox:String): Flux<Any> {

        println("*** Returning NOT from cache ***")

        val shoppingUri: UriComponents = UriComponentsBuilder.newInstance().path("/parking-facility/getService").queryParam("prox",prox).build()

        val eatDrinkUri: UriComponents = UriComponentsBuilder.newInstance().path("/eat-drink/getService").queryParam("prox",prox).build()

        val chargingStationUri: UriComponents = UriComponentsBuilder.newInstance().path("/charging-station/getService").queryParam("prox",prox).build()

        val onStreetresult: Mono<Any> = webclient.get().uri(shoppingUri.toString()).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Any>()

        val OffStreetresult : Mono<Any> = webclient.get().uri(eatDrinkUri.toString()).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Any>()

        val chargingStationresult : Mono<Any> = webclient.get().uri(chargingStationUri.toString()).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Any>()

        return Flux.merge(onStreetresult , OffStreetresult , chargingStationresult)
    }


}