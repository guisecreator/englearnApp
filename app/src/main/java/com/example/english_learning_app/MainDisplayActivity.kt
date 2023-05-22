package com.example.english_learning_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainDisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sign_in(view: View) {
        val intent = Intent(this@MainDisplayActivity, SigninActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun sign_up(view: View) {
        val intent = Intent(this@MainDisplayActivity, SignupActivity::class.java)
        startActivity(intent)
        finish()
    }
}