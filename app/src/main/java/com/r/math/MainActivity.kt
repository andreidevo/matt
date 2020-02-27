package com.r.math

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import katex.hourglass.`in`.mathlib.MathView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val cardStart : CardView = findViewById(R.id.cardStart)
        cardStart.setOnClickListener{

            val intent  = Intent(this, Examples::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
    }
}
