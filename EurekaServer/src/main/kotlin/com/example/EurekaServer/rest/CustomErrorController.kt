package com.example.EurekaServer.rest

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class CustomErrorController : ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    fun errorhandler(request: HttpServletRequest):String{

        var statuscode:Int = (request.getAttribute("javax.servlet.error.exception") as Int)

        var exception:Exception = (request.getAttribute("javax.servlet.error.exception") as Exception)

        return java.lang.String.format("<html><body><h2>Sample Error Page</h2><div>Status code: <b>%s</b></div>"
                + "<div>Exception Message: <b>%s</b></div><body></html>",
                statuscode, if (exception == null) "N/A" else exception.message)
    }

     override fun getErrorPath(): String {
        return "/error"
    }

}