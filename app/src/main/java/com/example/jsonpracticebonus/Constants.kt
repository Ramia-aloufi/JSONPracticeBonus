package com.example.jsonpracticebonus



object Constants {
     const val url =  "https://dojo-recipes.herokuapp.com"
    val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

}

