package com.example.OnStreetApi.model

class UserTodo( user :User ,var todos:Todos , var comments:Comments) {

    var userId:Int = 0
    var id:Int = 0
    var title:String = ""
    var body:String = ""

    init {

        this.userId = user.userId
        this.id     = user.id
        this.title  = user.title
        this.body   = user.body

    }

}