package com.example.english_learning_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class SigninActivity : AppCompatActivity() {
    lateinit var Login:EditText
    lateinit var Password:EditText

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        Login=findViewById(R.id.loginText)
        Password=findViewById(R.id.passwordText)
    }
    fun next(view: View) {
        if(Login.text.toString().isNotEmpty()&&Password.text.toString().isNotEmpty()) {
            val intent = Intent(this@SigninActivity, PatchActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val alert=AlertDialog.Builder(this)
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