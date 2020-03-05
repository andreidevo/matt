package slang.slanger.viewModel

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.RadialGradient
import android.util.DisplayMetrics
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import katex.hourglass.`in`.mathlib.MathView
import slang.slanger.model.Model

class ViewModel {
    var Model: Model = Model()


    fun vibrate(context: Context)
    {
        Model.vibrate(context)
    }

    fun summ(max : Int, count : Int) : ArrayList<Int>
    {
        return Model.summ(max, count)
    }
    fun summString( arr : ArrayList<Int>) : String
    {
        return Model.summString(arr)
    }
    fun summAnswer(arr : ArrayList<Int>) : Int
    {
        return Model.summAnswer(arr)
    }


    fun summFractions(min : Int, max : Int) : ArrayList<Int>
    {
       return Model.summFractions(min, max)
    }
    fun summFractionsString(arr : ArrayList<Int>) : String
    {
        return Model.summFractionsString(arr)
    }
    fun summFractionsAnswer(arr : ArrayList<Int>) : Int
    {
        return Model.summFractionsAnswer(arr)
    }
    fun summFractionPresent(mathView : MathView, min : Int, max : Int)
    {
        return Model.summFractionPresent(mathView, min, max)
    }


}