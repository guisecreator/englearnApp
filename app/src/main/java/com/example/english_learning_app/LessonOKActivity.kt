package com.example.english_learning_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lesson_ok.*

class QuizActivity : AppCompatActivity() {

    private var score: Int = 0
    private var currentQuestionIndex: Int = 0

    private val questions = listOf(
        "What’s ... name?",
        "Where ... from?",
        "In my house ... only two bedrooms.",
        "She ... blue eyes.",
        "My father ... in an office.",
        "- Where’s Dad?\n" + "- ... TV in the living room.\n",
        "Last weekend we ...",
        "Is there ... interesting information on that website?",
        "Elephants are ... than lions.",
        "We are going ... to London.",
        "Don’t worry. You... try to relax.",
        "What ... yesterday at 11 p.m.?",
        "Have you ... the president?",
        "Will life ... different in 100 years?",
        "Tomorrow I ... with my friends.",
    )

    private val answers = listOf(
        listOf("he", "your", "she"),
        listOf("are they", "is they", "there are"),
        listOf("there is", "there are", "there are a"),
        listOf("have got", "has got", "got"),
        listOf("work", "works", "working"),
        listOf("He’s watching", "He watches", "He watching"),
        listOf("listen to music", "listened to music", "did listened to music"),
        listOf("any", "some", "an"),
        listOf("heavier", "more heavier", "heavy"),
        listOf("flying", "fly", "to fly"),
        listOf("should", "should to", "shouldn’t"),
        listOf("did you doing", "were you doing", "you were doing"),
        listOf("ever met", "ever meet", "meet"),
        listOf("be", "is", "to be"),
        listOf("am playing", "will play", "play"),
        listOf("won’t", "don’t", "are not"),
    )

    private val correctAnswers = listOf(
        "your",
        "are they",
        "there are",
        "has got",
        "works",
        "He’s watching",
        "listened to music",
        "any",
        "heavier",
        "to fly",
        "should",
        "were you doing",
        "ever met",
        "be",
        "am playing",
        "don’t ",
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
        val checkedOptionId = optionsRadioGroup.checkedRadioButtonId
        val checkedOptionIndex = when (checkedOptionId) {
            R.id.option1TextView -> 0
            R.id.option2TextView -> 1
            R.id.option3TextView -> 2
            else -> -1
        }

        if (checkedOptionIndex != -1 && answers[currentQuestionIndex][checkedOptionIndex] == correctAnswers[currentQuestionIndex]) {
            score++
        }

        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            updateQuestion()
        } else {
            val intent = Intent(this@QuizActivity, ResultActivity::class.java)
            intent.putExtra("score", score)
            intent.putExtra("totalQuestions", questions.size)
            startActivity(intent)
            finish()
        }
    }
}