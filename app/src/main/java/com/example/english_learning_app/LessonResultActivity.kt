package com.example.english_learning_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lesson_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_result)

        // Получение переданных данных - результатов проверки знаний
        val score = intent.getIntExtra("score", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)

        // Вычисление процента правильных ответов
        val percentage = (score.toDouble() / totalQuestions.toDouble()) * 100

        // Установка текста с результатом
        resultTextView.text = "Ваш результат: $score из $totalQuestions (${String.format("%.2f", percentage)}%)"

        // Обработка нажатия на кнопку "Завершить"
        finishButton.setOnClickListener {
            // Закрытие приложения
            finish()
        }
    }
}