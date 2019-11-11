package com.example.tpschedule;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
/*
A class to draw a day schedule
Benjamin Yoon
11/7/2019
Version 1.0
 */
public class MyDrawableTwo extends Drawable {
    WTime wTime = new WTime();

    //draw method to draw the periods in the periods arrayList of the current day on the canvas
    public void draw(Canvas canvas){
        Period period = new Period(new WTime(), new WTime(), "");
            for (int j = 0; j < period.getArrayList().size(); j++){
                if(period.getArrayList().get(j).getDayPeriod() == wTime.getDay())
                    period.getArrayList().get(j).drawDay(canvas);
                else
                    System.out.println("");
            }
    }

    public void setAlpha(int Alpha){}

    public void setColorFilter(ColorFilter colorFilter){}

    public int getOpacity(){
        return PixelFormat.OPAQUE;
    }
}

