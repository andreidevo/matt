package com.r.math.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.r.math.Examples
import com.r.math.R
import slang.slanger.viewModel.ViewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModel()

        val cardStart : CardView = findViewById(R.id.cardStart)
        cardStart.setOnClickListener{
            val intent  = Intent(this, Examples::class.java)
            startActivity(intent)
        }

    }
}
