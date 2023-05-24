package com.example.english_learning_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lesson.*
import kotlinx.android.synthetic.main.activity_lesson_ok.*

class QuizActivity : AppCompatActivity() {

    private var score: Int = 0
    private var currentQuestionIndex: Int = 0

    private val questions = listOf(
        "Вопрос 1",
        "Вопрос 2",
        "Вопрос 3"
    )

    private val answers = listOf(
        listOf("Вариант ответа 1", "Вариант ответа 2", "Вариант ответа 3"),
        listOf("Вариант ответа 1", "Вариант ответа 2", "Вариант ответа 3"),
        listOf("Вариант ответа 1", "Вариант ответа 2", "Вариант ответа 3")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_ok)

        updateQuestion()

        button_lesson2.setOnClickListener {
            checkAnswer()
        }
    }

    private fun updateQuestion() {
        val currentQuestion = questions[currentQuestionIndex]
        val currentAnswers = answers[currentQuestionIndex]

        questionTextView.text = currentQuestion
        option1TextView.text = currentAnswers[0]
        option2TextView.text = currentAnswers[1]
        option3TextView.text = currentAnswers[2]

        optionsRadioGroup.clearCheck()
    }

    private fun checkAnswer() {
        val currentAnswers = answers[currentQuestionIndex]
        val checkedOptionId = optionsRadioGroup.checkedRadioButtonId
        val checkedOptionIndex = when (checkedOptionId) {
            R.id.option1TextView -> 0
            R.id.option2TextView -> 1
            R.id.option3TextView -> 2
            else -> -1
        }

        if (checkedOptionIndex != -1 && currentAnswers[checkedOptionIndex] == "Верный ответ") {
            score++
        }

        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            updateQuestion()
        } else {
            val intent = Intent(this@QuizActivity, ResultActivity::class.java)
            intent.putExtra("score", score)
            intent.putExtra("total", score)

            // Все вопросы пройдены, переход к экрану с результатами
            intent.putExtra("totalQuestions", questions.size)
            startActivity(intent)
            finish()
        }
    }
}