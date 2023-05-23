package com.example.english_learning_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class SignupActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var password2EditText: EditText
    private lateinit var userManager: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        emailEditText = findViewById(R.id.editText4)
        passwordEditText = findViewById(R.id.editText3)
        password2EditText = findViewById(R.id.editText2)

        userManager = UserManager(this)
    }

    fun toPatch(view: View?) {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val password2 = password2EditText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty() && password2.isNotEmpty()) {
            if (validateEmail(email)) {
                if (password == password2) {
                    // registration new user
                    userManager.registerUser(email, password)

                    val intent = Intent(this@SignupActivity, MainActivity::class.java)
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