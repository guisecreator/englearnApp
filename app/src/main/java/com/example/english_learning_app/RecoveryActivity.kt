package com.example.english_learning_app

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class RecoveryActivity : AppCompatActivity() {
    lateinit var Email: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recovery)
        Email = findViewById(R.id.editText4)

    }
    fun send(view: View) {
        val email = Email.text.toString()
        if (email.isNotEmpty()) {
            val isValidEmail = validateEmail(email)
            if (isValidEmail) {
                val intent = Intent(this@RecoveryActivity, RecoveryOkActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val alert = AlertDialog.Builder(this)
                    .setTitle("Введите корректный email")
                    .setPositiveButton("OK", null)
                    .create()
                alert.show()
            }
        } else {
            val alert = AlertDialog.Builder(this)
                .setTitle("Заполните это текстовое поле")
                .setPositiveButton("OK", null)
                .create()
            alert.show()
        }
    }

    fun back(view: View) {
        val intent = Intent(this@RecoveryActivity, SigninActivity::class.java)
        startActivity(intent)
        finish()
    }
}