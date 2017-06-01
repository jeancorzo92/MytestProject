package com.example.jean.mytestproject

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.setContentView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }
}
