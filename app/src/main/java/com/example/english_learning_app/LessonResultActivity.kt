package com.example.english_learning_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lesson_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_result)

        val score = intent.getIntExtra("score", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)
        val percentage = (score.toDouble() / totalQuestions.toDouble()) * 100

        resultTextView.text = "Ваш результат: $score из $totalQuestions (${String.format("%.2f", percentage)}%)"

        finishButton.setOnClickListener {
            finish()
        }
    }
}