package com.example.english_learning_app

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        var timer = object : CountDownTimer(8000, 1000)
        {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val intent = Intent(this@LoadingActivity, SigninActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()
    }
}