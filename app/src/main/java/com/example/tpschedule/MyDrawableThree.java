package com.example.tpschedule;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
/*
A class to draw a next period schedule
Benjamin Yoon
11/7/2019
Version 1.0
 */
public class MyDrawableThree extends Drawable {
    ArrayList<Period> period;

    //draw method to draw the current and the next period on the canvas
    public void draw(Canvas canvas) {
        Period p = new Period(new WTime(), new WTime(), "");
        period = p.getArrayList();
            for (int j = 0; j < period.size(); j++) {
                if (p.findContainingPeriod(new WTime()) == period.get(j)){
                    period.get(j).drawNext(canvas);
                    period.get(j + 1).drawNext(canvas);
                }
                else{
                System.out.println("");
                }
            }
    }

    public void setAlpha(int Alpha){}

    public void setColorFilter(ColorFilter colorFilter){}

    public int getOpacity(){
        return PixelFormat.OPAQUE;
    }
}


