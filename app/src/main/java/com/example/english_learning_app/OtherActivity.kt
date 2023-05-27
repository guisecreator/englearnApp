package com.example.english_learning_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alphabet)

        val poster_res: RecyclerView =findViewById((R.id.recview1))
        poster_res.adapter = AlphabetAdapter(this, PosterList().list)

        val selectedLink = intent.getStringExtra("selectedLink")
        val linkTextView = findViewById<TextView>(R.id.selectedLinkTextView)
        linkTextView.text = selectedLink
    }
    fun send2(view: View) {
        val intent = Intent(this@OtherActivity, QuizActivity2::class.java)
        startActivity(intent)
        finish()
    }
}