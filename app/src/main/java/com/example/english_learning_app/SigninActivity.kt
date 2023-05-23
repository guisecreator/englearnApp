package com.example.english_learning_app

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SigninActivity : AppCompatActivity() {
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var userManager: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        loginEditText = findViewById(R.id.loginText)
        passwordEditText = findViewById(R.id.passwordText)

        // Создание экземпляра UserManager
        userManager = UserManager(this)
    }

    fun next(view: View) {
        val enteredUsername = loginEditText.text.toString()
        val enteredPassword = passwordEditText.text.toString()

        if (enteredUsername.isNotEmpty() && enteredPassword.isNotEmpty()) {
            if (userManager.checkCredentials(enteredUsername, enteredPassword)) {
                val intent = Intent(this@SigninActivity, PatchActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val alert = AlertDialog.Builder(this)
                    .setTitle("Доступ запрещен")
                    .setPositiveButton("OK", null)
                    .create()
                    .show()
            }
        } else {
            val alert = AlertDialog.Builder(this)
                .setTitle("Заполните текстовые поля")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
    }

    fun next2(view: View) {
        val intent = Intent(this@SigninActivity, RecoveryActivity::class.java)
        startActivity(intent)
        finish()
    }
}