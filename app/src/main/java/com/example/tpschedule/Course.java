package com.example.tpschedule;

import java.util.ArrayList;
import java.util.List;
/*
A class to help define the datatype of the Firebasedatabase
Ben Yoon
Version 1.0
11/9/2019
 */
    public class Course{
        static ArrayList<Course> courses = new ArrayList<>();
        String name;
        int courseNum;
        int section;
        int period;
        String teacher;
        String classroom;

        //constructor
       Course(int courseNo, String teacher, int period, String classroom, int section, String name) {
           this.courseNum = courseNum;
           this.teacher = teacher;
           this.period = period;
           this.classroom = classroom;
           this.section = section;
           this.name = name;
       }

       public static ArrayList<Course> getCourses() {
           return courses;
       }
        //setCourses method to help add to the array list in the MainActivity Class
       public static void setCourses(List<Course> c) {
           courses = (ArrayList<Course>) c;
       }
        /*
        Getters and Setters
         */
       public int getCourseNum() {
           return courseNum;
       }

       public void setCourseNum(int courseNum) {
           this.courseNum = courseNum;
       }

       public String getTeacher() {
           return teacher;
       }

       public void setTeacher(String teacher) {
           this.teacher = teacher;
       }

       public int getPeriod() {
           return period;
       }

       public void setPeriod(int period) {
           this.period = period;
       }

       public String getClassroom() {
           return classroom;
       }

       public void setClassRoom(String classroom) {
           this.classroom = classroom;
       }

       public int getSection() {
           return section;
       }

       public void setSection(int section) {
           this.section = section;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }
        //To String method only including the course name
       @Override
       public String toString(){
        return "" + name;
       }
    }