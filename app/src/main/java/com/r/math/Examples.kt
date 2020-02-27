package com.r.math

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.MotionEvent
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.agog.mathdisplay.MTMathView
import android.graphics.Typeface
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.agog.mathdisplay.render.MTFont


class Examples : AppCompatActivity() {


    lateinit var math1 : MTMathView
    lateinit var textView : TextView
    lateinit var card1 : CardView
    lateinit var carddel : CardView
    lateinit var card3 : CardView
    lateinit var card4 : CardView
    var text = ""
    var limitCount = 3
    var Count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examples)

        card1  = findViewById(R.id.card1)
        carddel =  findViewById(R.id.carddel)
        textView =  findViewById(R.id.textView)

        math1 = findViewById(R.id.formul)
        math1.textColor= ContextCompat.getColor(this, R.color.whiteColor)
        math1.fontSize = dpTopixel(this,25.0f)
        math1.latex = ("$=\\frac{1+y}{1+2z^2}\$")

        card1.setOnClickListener{
            if( Count <= limitCount)
            {
                addNumToText("1")
                vibrate()
                Count++
            }
        }
        carddel.setOnClickListener{
            deleteNumInText()
            vibrate()
        }

    }

    fun vibrate()
    {
        val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            v.vibrate(20)
        }
    }
    fun addNumToText(s : String)
    {
        text += s
        textView.text = "$text"

    }

    fun pixelTodp(c: Context, pixel: Float): Float {
        val density = c.resources.displayMetrics.density
        return pixel / density
    }

    fun dpTopixel(c: Context, dp: Float): Float {
        val density = c.resources.displayMetrics.density
        return dp * density
    }
    fun deleteNumInText()
    {
        if( Count > 0)
        {
            Count--
            text = text.dropLast(1)
            textView.text = "$text"

        }
    }
    @SuppressLint("ClickableViewAccessibility")

    fun onclick(card : CardView)
    {

        card.setOnTouchListener { v, event ->
            val action = event.action
            if (action == MotionEvent.ACTION_DOWN) {

                //var color = ContextCompat.getColor(this, R.color.btn1Color)
                //card.setCardBackgroundColor(color)


               // color = ContextCompat.getColor(this, R.color.blockColor)
               // card.setCardBackgroundColor(color)
            }

            false
        }
    }
    override fun onResume() {
        super.onResume()


        val arr = summ(2, 2)
        math1.latex = ("$$ ${arr[0]} + ${arr[1]} = &&")
        math1.latex = ("$=\\frac{1+y}{1+2z^2}\$")

    }


    /* params: count digits, count of numbers
    *  return: array of numbers
    *  */
    fun summ(max : Int, count : Int) : ArrayList<Int>
    {
        if( count == 2)
        {
            val x = (1..(Math.pow(10.0 ,max.toDouble())).toInt()).random()
            val y = (1..(Math.pow(10.0 ,max.toDouble())).toInt()).random()

            return arrayListOf(x, y)
        }
        else
            return arrayListOf()
    }
}
