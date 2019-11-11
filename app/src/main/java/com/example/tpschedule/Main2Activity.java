package com.example.tpschedule;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    MyDrawable mydrawing;
    MyDrawableTwo mydrawingday;
    MyDrawableThree mydrawingnext;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydrawing = new MyDrawable();
        mydrawingday = new MyDrawableTwo();
        mydrawingnext = new MyDrawableThree();
        image = findViewById(R.id.imageView);
    }

    public void onClickWeek(View view) {
        image.setImageDrawable(mydrawing);
    }

    public void onClickDay(View view) {
        image.setImageDrawable(mydrawingday);
    }

    public void onClickNext(View view) {
        image.setImageDrawable(mydrawingnext);
    }

    public void onClickSettings(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        /*EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }
}