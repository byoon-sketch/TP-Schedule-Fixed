package com.example.tpschedule;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
/*
A class to run the A week schedule, which produces a schedule for the week, the day, and the next period based on a button.
Benjamin Yoon
11/7/2019
Version 1.0
 */
public class Home extends AppCompatActivity {
    ImageView image;
    //declaring the three MyDrawables which each create a different image - a different schedule.
    MyDrawable mydrawing;
    MyDrawableTwo mydrawingday;
    MyDrawableThree mydrawingnext;
    Period p = new Period(new WTime(), new WTime(), "");

        @Override
        //onCreate method to run the homeclass, which contains the A Week
        protected void onCreate(Bundle savedInstanceState) {
            p.clearList();
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            //instantiating the image view
            image = findViewById(R.id.imageView);
            //instantiating the three drawables to make a day, week, and next schedule.
            mydrawing = new MyDrawable();
            mydrawingday = new MyDrawableTwo();
            mydrawingnext = new MyDrawableThree();
            //loading the array full of the A Week periods
            p.LoadArray();
        }

        //onClickWeek sets the image view to the week drawable
        public void onClickWeek(View view) { image.setImageDrawable(mydrawing);
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