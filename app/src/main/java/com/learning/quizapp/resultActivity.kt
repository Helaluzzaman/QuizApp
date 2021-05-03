   package com.learning.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

   class resultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else{
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility  = View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        val tv_result = findViewById<TextView>(R.id.tv_resultScore)
        val tv_username = findViewById<TextView>(R.id.tv_resultUserName)
        val score = intent.getStringExtra(constants.SCORE)
        val totalQuestion = intent.getStringExtra(constants.TOTAL_QUESTIONS)
        tv_result.text = "Your score is $score out of $totalQuestion"
        tv_username.text = constants.userName

        val btnfinish = findViewById<Button>(R.id.btnFinish)
        btnfinish.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}