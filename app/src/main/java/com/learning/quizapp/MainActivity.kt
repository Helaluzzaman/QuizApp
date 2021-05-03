package com.learning.quizapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun start(view: View){
        val uname= findViewById<EditText>(R.id.username)
        if(uname.text.isBlank()) {
            Toast.makeText(this, "Enter your name!", Toast.LENGTH_SHORT).show()
        }else {
            constants.userName = uname.text.toString()
            val intent = Intent(this, QuizQnActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}