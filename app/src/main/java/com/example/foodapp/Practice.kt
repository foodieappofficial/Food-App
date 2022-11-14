package com.example.foodapp

import kotlin.random.Random

class Practice {
    fun main() {
        println("Hello")
        val randomNumbers = List(1){ Random.nextInt(0,7) }
        println(randomNumbers)
    }
}