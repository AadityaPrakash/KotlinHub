package com.example.kotlinhub

import android.app.Application
import com.google.firebase.FirebaseApp

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initApp();
    }

    private fun initApp() {
        FirebaseApp.initializeApp(this)
        //TODO("Not yet implemented")
    }

}