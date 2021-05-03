package com.learning.quizapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.learning.quizapp.R.*
import com.learning.quizapp.R.drawable.default_option_border_bg
import org.w3c.dom.Text

class QuizQnActivity : AppCompatActivity() , View.OnClickListener{
    @SuppressLint("SetTextI18n")
    private var currentPosition = 1
    private var questionsList: ArrayList<Questions>? = constants.getQuestions()
    var answer: Int = 0
    private var selectedoption: Int = 0
    private var isselected = false
    private var answerAcceptable = false
    var issubmitted = false
    lateinit var submitbtn: Button
    lateinit var opt1: TextView
    lateinit var opt2: TextView
    lateinit var opt3: TextView
    lateinit var opt4: TextView
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_quiz_qn)

        opt1 = findViewById<TextView>(id.option1text)
        opt2 = findViewById<TextView>(id.option2text)
        opt3 = findViewById<TextView>(id.option3text)
        opt4 = findViewById<TextView>(id.option4text)
        submitbtn = findViewById(id.submit_btn)

        opt1.setOnClickListener(this)
        opt2.setOnClickListener(this)
        opt3.setOnClickListener(this)
        opt4.setOnClickListener(this)
        submitbtn.setOnClickListener(this)

        questionsList = constants.getQuestions()
        setquestions(questionsList!!,currentPosition)

    }
    fun setquestions(questionslst: ArrayList<Questions>, currentposition: Int){
        setdefault()
        val questionlst = questionslst
        val nquestion = questionlst[currentposition-1]

        val questiontext = findViewById<TextView>(id.questiontxt)
        val questionimg = findViewById<ImageView>(id.questionimg)
        val progressbar = findViewById<ProgressBar>(id.progressbar)
        val progressBartxt = findViewById<TextView>(id.progresstxt)

        //setting question here
        questiontext.text = nquestion!!.question
        questionimg.setImageResource(nquestion.image)

        // setting progress bar
        progressbar.progress = currentPosition
        progressbar.max = questionslst.size
        progressBartxt.text = "$currentPosition/${progressbar.max}"

        // setting options here
        opt1.text = nquestion.optionOne
        opt2.text = nquestion.optionTwo
        opt3.text = nquestion.optionThree
        opt4.text = nquestion.optionFour

        // setting button text -> submitbtn
        submitbtn.text = "submit"
        // setting acceptable and answer
        answer = questionsList?.get(currentPosition -1)!!.correntAnswer
        answerAcceptable = true
    }
    override fun onClick(v: View?) {
        when(v?.id){
            opt1.id -> selectedfun(opt1, 1)
            opt2.id -> selectedfun(opt2, 2)
            opt3.id -> selectedfun(opt3, 3)
            opt4.id -> selectedfun(opt4, 4)
            this.submitbtn.id -> submit()
        }
    }
    private fun selectedfun( option: TextView, selectedoptionnumber: Int){
        selectedoption = selectedoptionnumber
        isselected = true
        setdefault()
        option.setTextColor(ContextCompat.getColor(this, R.color.buttonTint))
        option.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
        option.typeface = Typeface.DEFAULT_BOLD

    }
    fun setdefault(){
        val optionlst = ArrayList<TextView>()
        optionlst.add(opt1)           // why opt1.. --> crashing ?? here --> solved
        optionlst.add(opt2)
        optionlst.add(opt3)
        optionlst.add(opt4)
        for( option in optionlst){
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
            option.setTextColor(Color.parseColor("#6E6D6D"))
            option.typeface = Typeface.DEFAULT
        }
    }
    
    // my created function........... next four..
    fun setCurrentIncurrect(){

        when (answer){
            1 -> changeRight(opt1)
            2 -> changeRight(opt2)
            3 -> changeRight(opt3)
            4 -> changeRight(opt4)
        }
        if ( selectedoption != answer){
            when(selectedoption){
                1 -> changeWrong(opt1)
                2 -> changeWrong(opt2)
                3 -> changeWrong(opt3)
                4 -> changeWrong(opt4)
            }

        }
    }
    fun changeWrong(opt: TextView){
        opt.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
        opt.setTextColor(ContextCompat.getColor(this, R.color.black))
    }
    fun changeRight(opt: TextView){
        opt.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
    }
    fun submit(){
        if (isselected && answerAcceptable && (this.selectedoption == answer)){
            score++
//            Toast.makeText(this, "for debug $score ", Toast.LENGTH_LONG).show()  // comment out this line
        }

        if ( isselected){

            setCurrentIncurrect()
            issubmitted = true
            answerAcceptable = false
            isselected  = false
            if ( currentPosition < (questionsList!!.size)){          // this worked
                submitbtn.text = "continue to next questions"
            }else{
                submitbtn.text = "finished"
            }
        }else if(issubmitted){
            currentPosition++
            if ( currentPosition <= questionsList!!.size){
                setquestions(questionsList!!, currentPosition)
                isselected = false
                issubmitted = false
            }else{      // work when quiz is finished.
                Toast.makeText(this, "quiz finished.. Your score $score",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, resultActivity::class.java)
                intent.putExtra(constants.TOTAL_QUESTIONS, questionsList?.size.toString())
                intent.putExtra(constants.SCORE, score.toString())
                startActivity(intent)
                finish()
            }
        } else{
            Toast.makeText(this, "Please select one option", Toast.LENGTH_SHORT).show()
        }
    }

}