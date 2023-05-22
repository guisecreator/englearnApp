package com.example.english_learning_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RecoveryOkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recoveryok)
    }

    fun back(view: View) {
        val intent = Intent(this@RecoveryOkActivity, SigninActivity::class.java)
        startActivity(intent)
        finish()
    }
}