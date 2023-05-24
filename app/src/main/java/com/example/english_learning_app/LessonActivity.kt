package com.example.english_learning_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LessonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
    }

    fun send(view: View) {
        val intent = Intent(this@LessonActivity, QuizActivity::class.java)
        startActivity(intent)
        finish()
    }
}