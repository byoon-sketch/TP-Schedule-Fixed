package com.example.tpschedule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

/*
A class to run the main menu of the TP Schedule App that allows the user to access the A week or B week schedule and to choose their classes
This program can:
Draw current periods, day and week
Read courses from the database - but cannot implement them
Has a settings screen
A/B Week
Cannot Save settings
Cannot read special days
Benjamin Yoon
11/7/2019
Version 1.0
 */
public class MainActivity extends AppCompatActivity {
    //Array List that holds all of the data from the Firebase Database
    final List<Course> specimens = new ArrayList<>();
    ArrayList<String> periods = new ArrayList<>();
    //declaring the AutoCompleteTextViews
    AutoCompleteTextView editText;
    AutoCompleteTextView editText2;
    AutoCompleteTextView editText3;
    AutoCompleteTextView editText4;
    AutoCompleteTextView editText5;
    AutoCompleteTextView editText6;
    AutoCompleteTextView editText7;

    /*String one;
    String two;
    String three;
    String four;    Declaring Strings to load into the period class - part of a failed attempt to get it to work
    String five;
    String six;
    String seven;*/

    //declaring the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing the Auto-Complete Views
        editText = findViewById(R.id.actv);
        ArrayAdapter<Course> adapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, specimens);
        editText.setAdapter(adapter);

        editText2 = findViewById(R.id.actv2);
        ArrayAdapter<Course> adapter2 = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, specimens);
        editText2.setAdapter(adapter2);

        editText3 = findViewById(R.id.actv3);
        ArrayAdapter<Course> adapter3 = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, specimens);
        editText3.setAdapter(adapter3);

        editText4 = findViewById(R.id.actv4);
        ArrayAdapter<Course> adapter4 = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, specimens);
        editText4.setAdapter(adapter4);

        editText5 = findViewById(R.id.actv5);
        ArrayAdapter<Course> adapter5 = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, specimens);
        editText5.setAdapter(adapter5);

        editText6 = findViewById(R.id.actv6);
        ArrayAdapter<Course> adapter6 = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, specimens);
        editText6.setAdapter(adapter6);

        editText7 = findViewById(R.id.actv7);
        ArrayAdapter<Course> adapter7 = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, specimens);
        editText7.setAdapter(adapter7);
    }
    protected void onStart(){ //method that adds the data to the specimens arraylist
        super.onStart();
        if (specimens.size() < 22) {
            databaseReference.child("Course").addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                    for (DataSnapshot child : children) {
                         specimens.add(new Course(Integer.parseInt(child.child("Course").getValue(String.class)),
                                child.child("Teacher").getValue(String.class),
                                Integer.parseInt(child.child("Period").getValue(String.class)),
                                child.child("Classroom").getValue(String.class),
                                Integer.parseInt(child.child("Section").getValue(String.class)),
                                child.child("COURSE::name").getValue(String.class))
                        );
                    }
                    Course.setCourses(specimens); //adding the data
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }
    //the onClickAWeek class to start up the A week schedule activity - the home class.
    public void onClickAWeek(View view) {
        //one = "" + editText.getText().toString();
        //Log.i("TAG", one);
        /*periods.add(one = "" + editText.getText().toString());
        periods.add(two = "" + editText2.getText().toString());
        periods.add(three = "" + editText3.getText().toString());
        periods.add(four = "" + editText4.getText().toString());
        periods.add(five = "" + editText5.getText().toString());
        periods.add(six = "" + editText6.getText().toString());
        periods.add(seven = "" + editText7.getText().toString());
        one = "" + editText.getText().toString();
        Log.i("TAG", one);
        two = "" + editText2.getText().toString();                         Part of a failed attempt to get the loading into the schedule to work!!!
        three = "" + editText3.getText().toString();
        four = "" + editText4.getText().toString();
        five = "" + editText5.getText().toString();
        six = "" + editText6.getText().toString();
        seven = "" + editText7.getText().toString();
        periods.add(one);
        periods.add(two);
        periods.add(three);
        periods.add(four);
        periods.add(five);
        periods.add(six);
        periods.add(seven);*/
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    //the onClickBWeek class to start up the B week schedule activity - the homeB class.
    public void onClickBWeek(View view) {
        Intent intent = new Intent(this, HomeB.class);
        startActivity(intent);
    }
    /*public void loadArray(){
        periods.add(one);
        periods.add(two);
        periods.add(three);
        periods.add(four);
        periods.add(five);
        periods.add(six);                       Part of a failed attempt to load the firebase data into the schedule
        periods.add(seven);
    }*/
    /*public ArrayList<String> getPeriods(){
        return periods;
    }*/
    //public String getString(){
      //  return one;
    //}
}