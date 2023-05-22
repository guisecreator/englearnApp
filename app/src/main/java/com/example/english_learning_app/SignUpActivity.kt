package com.example.english_learning_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class SignupActivity : AppCompatActivity() {
    lateinit var Email: EditText
    lateinit var Password: EditText
    lateinit var Password2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        Email = findViewById(R.id.editText4)
        Password = findViewById(R.id.editText3)
        Password2 = findViewById(R.id.editText2)
    }

    fun toPatch(view: View?) {
        if (Email.text.isNotEmpty()
            && Password.text.isNotEmpty()
            && Password2.text.isNotEmpty()
        ) {
            if (validateEmail(Email.text.toString())) {
                if (Password.text.toString()
                    == Password2.text.toString()) {
                    val intent = Intent(this@SignupActivity,
                        MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("Пароли не совпадают")
                        .setPositiveButton("OK", null)
                        .create()
                    alert.show()
                }
            } else {
                val builder = AlertDialog.Builder(this)
                    .setMessage("Введите корректный email")
                    .setPositiveButton("OK", null)
                    .create()
                builder.show()
            }
        } else {
            val alert = AlertDialog.Builder(this)
                .setTitle("Заполните текстовые поля")
                .setPositiveButton("OK", null)
                .create()
            alert.show()
        }
    }

    fun back(view: View) {
        val intent = Intent(this@SignupActivity, MainDisplayActivity::class.java)
        startActivity(intent)
        finish()
    }

}