package com.example.kotlinhub.activities

import android.util.Log

class KotlinCodes {

    companion object Factory {
        private const val word:String = "Why this mess!"

        fun create(){
            Log.d("KotlinCode","Hello world!")
            print(word)

        }

        private fun main() {

        }
    }

    //Program entry point
    fun main(){
        println("Hello world!")
    }
}