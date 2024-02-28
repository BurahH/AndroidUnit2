package com.example.unit2

fun main() {
    nullBegin()
    nullIfElse()
    nullV()
}

fun nullBegin() {
    var number: Int? = 10
    println(number)

    number = null
    println(number)
}

fun nullIfElse() {
    var favoriteActor: String? = "Sandra Oh"

    val lengthOfName = if (favoriteActor != null) {
        favoriteActor.length
    } else {
        0
    }

    println("The number of characters in your favorite actor's name is $lengthOfName.")
}

fun nullV() {
    var favoriteActor: String? = "Sandra Oh"

    val lengthOfName = favoriteActor?.length ?: 0

    println("The number of characters in your favorite actor's name is $lengthOfName.")
}