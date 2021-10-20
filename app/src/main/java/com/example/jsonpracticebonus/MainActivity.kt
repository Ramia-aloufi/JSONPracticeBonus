package com.example.jsonpracticebonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var et:EditText
    lateinit var tv:TextView
    lateinit var btnAdd:Button
    lateinit var rr :ArrayList<Names.NamesItem>
    private val apiInterface = Constants.apiInterface
    var nn = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et = findViewById(R.id.editTextTextPersonName)
        btnAdd = findViewById(R.id.button)
        tv = findViewById(R.id.tv)
        rr = ArrayList()


        btnAdd.setOnClickListener {
            GetNames()
        }


    }


    fun GetNames(){
        var names = ""
        try {
            nn = et.text.toString().toInt() - 1
        }catch (e:Exception){
            Toast.makeText(this,"Write a Number!",Toast.LENGTH_SHORT).show()
        }
        apiInterface?.getInfo()?.enqueue(object :Callback<ArrayList<Names.NamesItem>>{
            override fun onResponse(call: Call<ArrayList<Names.NamesItem>>, response: Response<ArrayList<Names.NamesItem>>) {
                Log.d("po", response.code().toString())
                Toast.makeText(this@MainActivity,"Get",Toast.LENGTH_SHORT).show()
                var uu = response.body()
                for (i in 0 until uu!!.size){
                    rr.add(uu[i])
                }
                for (i in rr.indices){
                    if(i == nn){
                        names = "Name:${ rr[i].name }\nLocation:${ rr[i].location }\nEmail: ${ rr[i].email }Phone: ${ rr[i].mobile }"
                    }
                }
                tv.text = names
            }

            override fun onFailure(call: Call<ArrayList<Names.NamesItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Failure",Toast.LENGTH_SHORT).show()
            }

        })
    }
}