package com.example.english_learning_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lesson.*

class LessonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        // Установка текста сообщения новых знаний/объяснения материала
        val message = "Ваше сообщение новых знаний/объяснение материала"
        message_text.text = message

        // Обработка нажатия на кнопку "Далее"
        button_lesson.setOnClickListener {
            // Переход к следующему экрану - экрану проверки знаний
            val intent = Intent(this@LessonActivity, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}