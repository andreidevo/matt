package com.r.math

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
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
import android.opengl.Visibility
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import com.agog.mathdisplay.MTFontManager
import com.agog.mathdisplay.render.MTFont
import katex.hourglass.`in`.mathlib.MathView
import kotlinx.android.synthetic.main.activity_examples.*
import java.security.AccessController.getContext
import kotlin.math.floor


class Examples : AppCompatActivity() {


    //lateinit var math1 : MathView
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
    lateinit var webView : WebView
    var text = ""
    var limitCount = 3
    var Count = 0
    lateinit var   mathView : MathView
    var checkerBtnGo = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examples)

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






        //mathView.setDisplayText("\$x=\\frac{1+y}{1+2z^2}$")
        mathView.getSettings().setLoadWithOverviewMode(true);
        mathView.getSettings().setUseWideViewPort(true);
        //mathView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        //mathView.getSettings().setBuiltInZoomControls(true)
            //.setBuiltInZoomControls(true);
       // math1 = findViewById(R.id.formul)



//        math1.font = MTFontManager.fontWithName("latinmodern-math", dpTopixel(this,25.0f))
//        math1.labelMode = MTMathView.MTMathViewMode.KMTMathViewModeText
//

//        math1.textAlignment = MTMathView.MTTextAlignment.KMTTextAlignmentCenter
//
//        math1.textColor= ContextCompat.getColor(this, R.color.whiteColor)
//        math1.fontSize = dpTopixel(this,25.0f)
//        math1.latex = ("$=\\frac{1+y}{1+2z^2}\$")

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

        carddel.setOnClickListener{
            deleteNumInText()
            vibrate()
        }
        cardgo.setOnClickListener {

            if( !checkerBtnGo )
            {
                val num = text.toInt()
                nextBtn.visibility = View.VISIBLE

                if (num == answer) {
                    nextBtn.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correctColor));
                }
                else
                {
                    nextBtn.setCardBackgroundColor(ContextCompat.getColor(this, R.color.incorrectColor));
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
    }

    fun replaceEcuation()
    {

        var x = (0..1).random()

        if( x == 0)
        {
            var arr = summ(2,2)
            mathView.setDisplayText("${arr[0]} + ${arr[1]} = ")
            answer = arr[0] + arr[1]
        }
        else if( x == 1)
        {
            drobi()

        }

        //answer = arr[0] + arr[1]
        text = ""
        textView.text = ""
        Count = 0
        nextBtn.visibility = View.INVISIBLE
    }

    fun setonClickListener(str : String, card : CardView)
    {
        card.setOnClickListener{
            if( Count <= limitCount)
            {
                addNumToText(str)
                vibrate()
                Count++
            }
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

    var answer = 0
    override fun onResume() {
        super.onResume()
        val arr = summ(2, 2)

       // mathView.setDisplayText("${arr[0]} + ${arr[1]} =")
        drobi()
       // answer = arr[0] + arr[1]
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
    fun drobi() : Int
    {

        var arr = rollNumberDrobi()
        val s = "$\\frac{${arr[0]}}{${arr[1]}} + \\frac{${arr[2]}}{${arr[3]}} = \$"
        mathView.setDisplayText(s)
        answer = ((arr[0]*arr[3] + arr[2] * arr[1])/(arr[1] * arr[3])).toInt()
        return 1
    }
    fun rollNumberDrobi() : ArrayList<Int>
    {

        var check = 0;
        var b = (1..20).random().toDouble()
        var d = (1..20).random().toDouble()
        var a = (1..20).random().toDouble()
        var y = 1


        var arr = arrayListOf<Int>()
        while (check == 0)
        {

            for(i in (1..100))
                if( Math.floor( (a*d + i * b)/(b * d)) == (a*d + i * b)/(b * d) && i != d.toInt() )
                {
                    y = i
                    check = 1
                    arr = arrayListOf(a.toInt(),b.toInt(),y,d.toInt())
                    break
                }

            b = (1..20).random().toDouble()
            d = (1..20).random().toDouble()
            a = (1..20).random().toDouble()
        }

        return  arr
    }

}
