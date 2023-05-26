package com.example.english_learning_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView

class LessonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        val linksListView: ListView = findViewById(R.id.listViewTopics)
        val links = arrayOf("Местоимения", "Глаголы", "Ссылка 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, links)

        linksListView.adapter = adapter

        linksListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedLink = links[position]

            //todo: сделать линки для каждой страницы
            val intent = Intent(this, OtherActivity::class.java)
            intent.putExtra("selectedLink", selectedLink)
            startActivity(intent)
        }

    }
    fun send(view: View) {
        val intent = Intent(this@LessonActivity, QuizActivity::class.java)
        startActivity(intent)
        finish()
    }
}
