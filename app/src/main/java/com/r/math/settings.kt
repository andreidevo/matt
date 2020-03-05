package com.r.math

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import it.sephiroth.android.library.numberpicker.doOnProgressChanged
import it.sephiroth.android.library.numberpicker.doOnStartTrackingTouch
import it.sephiroth.android.library.numberpicker.doOnStopTrackingTouch
import it.sephiroth.android.library.numberpicker.setListener

class settings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        var numberPicker = findViewById<it.sephiroth.android.library.numberpicker.NumberPicker>(R.id.numberPicker)
        numberPicker.progress = GlobalLvl
        //numberPicker.text
        numberPicker.doOnProgressChanged { numberPicker, progress, formUser ->
            // progress changed
            GlobalLvl = progress
            var x = 5;

        }

    }
}
