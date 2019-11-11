package com.example.tpschedule;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
/*
A class to draw a week schedule
Benjamin Yoon
11/7/2019
Version 1.0
 */
public class MyDrawable extends Drawable {
    ArrayList<Period> period;

    //constructor
    public MyDrawable(){}

    //draw method to draw each period in the periods array on the canvas
    public void draw(Canvas canvas) {
        Period p = new Period(new WTime(), new WTime(), "");
        period = p.getArrayList();
            for (int j = 0; j < period.size(); j++) {
                period.get(j).draw(canvas);
            }
    }

    public void setAlpha(int Alpha){}

    public void setColorFilter(ColorFilter colorFilter){}

    public int getOpacity(){
        return PixelFormat.OPAQUE;
    }
}

