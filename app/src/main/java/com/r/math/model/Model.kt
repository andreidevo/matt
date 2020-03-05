package slang.slanger.model

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.provider.MediaStore
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.ByteArrayOutputStream
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import com.r.math.GlobalLvl
import com.r.math.answer
import com.r.math.model.MathClass
import katex.hourglass.`in`.mathlib.MathView



class Model {

    var mathClass = MathClass()

    fun vibrate(context: Context)
    {
        val v = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            v.vibrate(20)
        }
    }



    fun summ(max : Int, count : Int) : ArrayList<Int>
    {
        return mathClass.summ(max, count)
    }
    fun summAnswer(arr : ArrayList<Int>) : Int
    {
        var count = 0;
        for(i in 0 until arr.size-1)
            count+=arr[i]
        return count
    }
    /* generate string */
    fun summString( arr : ArrayList<Int>) : String
    {
        return "${arr[0]} + ${arr[1]} = "
    }

    fun summFractions(min : Int, max : Int) : ArrayList<Int>
    {
        return mathClass.summFractions(min, max)
    }
    fun summFractionsString(arr : ArrayList<Int>) : String
    {
        val string = "$\\frac{${arr[0]  * GlobalLvl }}{${arr[1]  * GlobalLvl}} + \\frac{${arr[2] * GlobalLvl}}{${arr[3] * GlobalLvl}} = \$"
        return string
    }
    fun summFractionsAnswer(arr : ArrayList<Int>) : Int
    {
        return ((arr[0]*arr[3] + arr[2] * arr[1])/(arr[1] * arr[3]))
    }
    fun summFractionPresent(mathView : MathView, min : Int, max : Int)
    {
        val arr = summFractions(1,20)
        mathView.setDisplayText(summFractionsString(arr))
        answer = summFractionsAnswer(arr)
    }


}
