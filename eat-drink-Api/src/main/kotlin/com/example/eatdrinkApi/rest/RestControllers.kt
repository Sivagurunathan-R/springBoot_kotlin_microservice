package com.example.eatdrinkApi.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.util.UriComponents
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/eat-drink")
class RestControllers {

    @Autowired
    lateinit var webclient: WebClient

    val api_key:String = "lGLwWiK4rliGRE6ieJD36HHTiNxN35nyHWye-PX-nXE"

    @GetMapping("/hello")
    fun getHello() = "hello from eat-drink service"


    @Cacheable(value = ["eatrestcall"] , key= "{ #root.methodName , #at ,#cat , #size}")
    @GetMapping("/get")
    fun eatDrinkInfo(@RequestParam at:String, @RequestParam cat:String, @RequestParam size:Int): Mono<Any> {

        val uri: UriComponents = UriComponentsBuilder.newInstance().path("/places/v1/discover/explore").queryParam("at",at).queryParam("cat", cat).queryParam("apiKey" , api_key).queryParam("size" , size).build()

        println("*** Returning NOT from cache ***")

        return webclient.get().uri( uri.toString() ).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Any>()


    }
}