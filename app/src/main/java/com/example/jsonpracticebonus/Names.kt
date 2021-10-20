package com.example.jsonpracticebonus

 class Names {
     var name :List<NamesItem>? = null

     data class NamesItem(
         var name: String? = null,
         var location: String? = null,
         var mobile: String? = null,
         var email: String? = null,
     )
 }