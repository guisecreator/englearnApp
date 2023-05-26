package com.example.english_learning_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lesson_ok.*

class QuizActivity2: AppCompatActivity() {
    private var score: Int = 0
    private var currentQuestionIndex: Int = 0

    private val questions = listOf(
        "Найдите строчную букву для B.", //1
        "a _ c d e f _ h i _ k l _. Каких букв не хватает?",  //2
        "a b c d e f g h i j k l m n o p. Найдите все гласные буквы.",  //3
        "Выберите ряд, в котором только согласные буквы.",  //4
        "Выберите ряд, в котором слова расположены в алфавитном порядке.",//5
        "b p b b b b p b b b d d b . Посчитайте количество строчных букв B.",//6
        "m n n n n n m n m m n. Посчитайте количество строчных букв N.",// 7
        "Сколько букв в английском алфавите?",//8
        "Какая буква должна стоять между… l _____n", //9
        "Выберите маленькую букву G", //10
    )

    private val answers = listOf(
        listOf("g", "b", "q"),                                   //1
        listOf("j q g m", "b g j m", "p q m o"),                //2
        listOf("a e i n", "d e a o", "a e i o"),                //3
        listOf("h k l o m n", "g e r u i o l", "c b m k l p"), //4
        listOf("apple, ball, cat, dog", "crocodile, dolphin, bear, ant", "deer, bee, alligator, cow"),                     //5
        listOf("7", "8", "6"),   //6
        listOf("7", "8", "5"),  //7
        listOf("25", "26", "27"),//8
        listOf("o", "p", "m"), //9
        listOf("b", "d", "g"), //10
    )

    private val correctAnswers = listOf(
        "b",
        "b g j m",
        "a e i o",
        "c b m k l p",
        "apple, ball, cat, dog",
        "9",
        "7",
        "26",
        "m",
        "g",
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
            val intent = Intent(this@QuizActivity2, ResultActivity::class.java)
            intent.putExtra("score", score)
            intent.putExtra("totalQuestions", questions.size)
            startActivity(intent)
            finish()
        }
    }
}
