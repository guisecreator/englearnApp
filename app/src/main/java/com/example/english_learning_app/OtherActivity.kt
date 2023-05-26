package com.example.english_learning_app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alphabet)

        val selectedLink = intent.getStringExtra("selectedLink")
        val linkTextView = findViewById<TextView>(R.id.selectedLinkTextView)
        linkTextView.text = selectedLink
    }
}