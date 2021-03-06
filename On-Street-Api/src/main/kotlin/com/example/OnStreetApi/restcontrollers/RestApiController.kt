package com.example.OnStreetApi.restcontrollers

import com.sun.jndi.toolkit.url.Uri
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RequestPredicates.queryParam
import org.springframework.web.util.UriComponents
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import org.springframework.web.util.UriBuilder as UtilUriBuilder

@RestController
@RequestMapping("/parking-facility")
class RestApiController {

    @Autowired
    @Qualifier("bean1")
    lateinit var webclient: WebClient


    @Autowired
    @Qualifier("bean2")
    lateinit var onstreetwebclient: WebClient

    val api_key:String = "lGLwWiK4rliGRE6ieJD36HHTiNxN35nyHWye-PX-nXE"

    @Value("\${here.app_id}")
    val app_id:String = ""

    @Value("\${here.app_code}")
    val app_code:String =""

    @Cacheable(value = ["parkingrestcall"] , key= "{ #root.methodName , #at ,#cat , #size}")
    @GetMapping("/get")
    fun parkingFacilityInfo(@RequestParam at:String , @RequestParam cat:String , @RequestParam size:Int): Mono<Any> {

        val uri: UriComponents = UriComponentsBuilder.newInstance().path("/places/v1/discover/explore").queryParam("at",at).queryParam("cat", cat).queryParam("apiKey" , api_key).queryParam("size" , size).build()

        println("*** Returning NOT from cache ***")

        return webclient.get().uri( uri.toString() ).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Any>()


    }

    @Cacheable(value = ["onstreetrestapi"] , key= "{ #root.methodName , #prox }")
    @GetMapping("/getService")
    fun onstreetStationapi(@RequestParam prox:String): Mono<Any> {

        val uri: UriComponents = UriComponentsBuilder.newInstance().path("/segments.xml").queryParam("prox",prox).queryParam("app_id", app_id).queryParam("app_code" , app_code).queryParam("size" , 3).build()

        println("*** Returning NOT from cache ***")

        return onstreetwebclient.get().uri( uri.toString() ).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Any>()


    }

    @GetMapping("/hello")
    fun getHello() = "hello"

    /*
   @GetMapping("/testjsons")
   fun testApi():Flux<Any>{

   val result: Mono<User> = webclient.get().uri("/posts/1").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<User>()

   val result2 : Mono<Todos> = webclient.get().uri("/todos/1").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Todos>()

    val result3 : Mono<Comments> = webclient.get().uri("/comments/1").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono<Comments>()

    //Mono.zip(result, result2 , result3).flatMap{ }

       return Flux.merge(result , result2 , result3)
  }
*/


}





