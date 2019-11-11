package com.example.tpschedule;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
/*
A class to run the B week schedule, which produces a schedule for the week, the day, and the next period based on a button.
Benjamin Yoon
11/7/2019
Version 1.0
 */
public class HomeB extends AppCompatActivity {
    MyDrawable mydrawing;
    MyDrawableTwo mydrawingday;
    MyDrawableThree mydrawingnext;
    ImageView image;
    Switch switch1;
    Period p = new Period(new WTime(), new WTime(), "");


    @Override
    //onCreate method to run the homeB class, which contains the B Week
    protected void onCreate(Bundle savedInstanceState) {
        p.clearList();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_b);
        //instantiating the image view
        image = findViewById(R.id.imageView2);
        //instantiating the three drawables to make a day, week, and next schedule.
        mydrawing = new MyDrawable();
        mydrawingday = new MyDrawableTwo();
        mydrawingnext = new MyDrawableThree();
        //loading the array full of the B Week periods
        p.LoadArrayB();
    }

        //onClickWeek sets the image view to the week drawable
        public void onClickWeek(View view) {
            image.setImageDrawable(mydrawing);
        }

        //onClickDay sets the image view to the day drawable
        public void onClickDay(View view) {
            image.setImageDrawable(mydrawingday);
        }

        //onClickNext sets the image view to the next period drawable
        public void onClickNext(View view) {
            image.setImageDrawable(mydrawingnext);
        }
}