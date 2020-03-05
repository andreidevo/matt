package com.r.math

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import android.view.View
import android.widget.ImageView
import katex.hourglass.`in`.mathlib.MathView
import slang.slanger.viewModel.ViewModel


var answer = 0
var GlobalLvl = 1
class Examples : AppCompatActivity() {

    lateinit var textView : TextView
    lateinit var card1 : CardView
    lateinit var carddel : CardView
    lateinit var card3 : CardView
    lateinit var card4 : CardView
    lateinit var card5 : CardView
    lateinit var card6 : CardView
    lateinit var card7 : CardView
    lateinit var card8 : CardView
    lateinit var card9 : CardView
    lateinit var card0 : CardView
    lateinit var card2 : CardView
    lateinit var cardgo : CardView
    lateinit var nextBtn : CardView
    lateinit var backbtn : ImageView
    lateinit var settingsbtn : ImageView
    var text = ""
    var limitCount = 3
    var Count = 0
    lateinit var   mathView : MathView
    var checkerBtnGo = false

    var ViewModel = ViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examples)

        initViews()
        bindingViews()
        replaceEcuation()
    }

    fun initViews()
    {
        card1  = findViewById(R.id.card1)
        card2  = findViewById(R.id.card2)
        card3  = findViewById(R.id.card3)
        card4  = findViewById(R.id.card4)
        card5  = findViewById(R.id.card5)
        card6  = findViewById(R.id.card6)
        card7  = findViewById(R.id.card7)
        card8  = findViewById(R.id.card8)
        card9  = findViewById(R.id.card9)
        card0  = findViewById(R.id.card0)
        cardgo  = findViewById(R.id.cardgo)
        carddel =  findViewById(R.id.carddel)
        nextBtn =  findViewById(R.id.nextBtn)
        textView =  findViewById(R.id.textView)
        mathView =  findViewById(R.id.mathView)
        backbtn =  findViewById(R.id.backbtn)
        settingsbtn =  findViewById(R.id.settingsBtn)



        mathView.getSettings().setLoadWithOverviewMode(true);
        mathView.getSettings().setUseWideViewPort(true);

        setonClickListener("1", card1)
        setonClickListener("2", card2)
        setonClickListener("3", card3)
        setonClickListener("4", card4)
        setonClickListener("5", card5)
        setonClickListener("6", card6)
        setonClickListener("7", card7)
        setonClickListener("8", card8)
        setonClickListener("9", card9)
        setonClickListener("0", card0)
    }
    fun bindingViews()
    {
        carddel.setOnClickListener{
            deleteNumInText()
            ViewModel.vibrate(this)
        }
        cardgo.setOnClickListener {
            if( !checkerBtnGo && text != "")
            {
                val num = text.toInt()
                nextBtn.visibility = View.VISIBLE

                if (num == answer)
                {
                    nextBtn.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correctColor));
                    textView.setTextColor(ContextCompat.getColor(this, R.color.correctColor))
                }
                else
                {
                    nextBtn.setCardBackgroundColor(ContextCompat.getColor(this, R.color.incorrectColor));
                    textView.setTextColor(ContextCompat.getColor(this, R.color.incorrectColor))
                }
                checkerBtnGo = true
            }
            else
            {
                replaceEcuation()
                checkerBtnGo = false
            }
        }
        nextBtn.setOnClickListener {
            replaceEcuation()
            checkerBtnGo = false
        }
        backbtn.setOnClickListener {
            finish()
        }
        settingsbtn.setOnClickListener {
            var intent = Intent(this, settings::class.java)
            startActivity(intent)
        }
    }

    fun replaceEcuation()
    {
        val x = (0..2).random()

        when (x) {
            0 -> {
                val arr = ViewModel.summ(2,2)
                mathView.setDisplayText(ViewModel.summString(arr))
                answer = ViewModel.summAnswer(arr)
            }
            1 -> ViewModel.summFractionPresent(mathView,1,20)
            2 -> ViewModel.summFractionPresent(mathView,13,30)
            3 ->
            {
                val arr = ViewModel.summ(2,3)
                mathView.setDisplayText(ViewModel.summString(arr))
                answer = ViewModel.summAnswer(arr)
            }
        }

        text = ""
        textView.text = ""
        Count = 0
        nextBtn.visibility = View.INVISIBLE
        textView.setTextColor(ContextCompat.getColor(this, R.color.whiteColor))
    }

    fun setonClickListener(str : String, card : CardView)
    {
        card.setOnClickListener{
            if( Count <= limitCount)
            {
                addNumToText(str)
                ViewModel.vibrate(this)
                Count++
            }
        }
    }
    fun addNumToText(s : String)
    {
        text += s
        textView.text = text

    }

    fun deleteNumInText()
    {
        if( Count > 0)
        {
            Count--
            text = text.dropLast(1)
            textView.text = text

        }
    }
}
