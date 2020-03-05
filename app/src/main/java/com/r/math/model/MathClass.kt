package com.r.math.model




class MathClass {



    /* params: count digits, count of numbers
    *  return: array of numbers
    *  array: (numbers; answer)
    */
    fun summ(max : Int, count : Int) : ArrayList<Int>
    {
        val array = arrayListOf<Int>()

        var answer = 0
        for(i in 0 until  count)
        {
            array.add((1..(Math.pow(10.0 ,max.toDouble())).toInt()).random())
            answer += array[i]
        }

        array.add(answer)
        return array
    }


    /* params: random (min, max)
    *  return: array of numbers
    *  array: (a,b,c,d)
    */
    fun summFractions(min : Int, max : Int) : ArrayList<Int>
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
                if( Math.floor( (a*d + i * b)/(b * d)) == (a*d + i * b)/(b * d) && i != d.toInt()&& a != b && d != b && i != d.toInt() )
                {
                    y = i
                    check = 1
                    arr = arrayListOf(a.toInt(),b.toInt(),y,d.toInt())
                    break
                }

            b = (2..20).random().toDouble()
            d = (2..20).random().toDouble()
            a = (1..20).random().toDouble()
        }

        return  arr
    }

}