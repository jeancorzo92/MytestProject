package com.example.jean.mytestproject.domain


interface Command<out T> {
    fun execute(): T
}