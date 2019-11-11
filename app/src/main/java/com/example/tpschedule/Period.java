package com.example.tpschedule;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import java.util.ArrayList;
import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

/*
A class to create a period in a schedule with multiple parameters
I did not create the Period class
11/7/2019
Version 1.4 - new draw methods created for each of the schedule types | Load array method created | getArrayList method created | getDay method created
 */
public class Period {
    WTime start;
    WTime end;
    String period;
    String teacher, room, subject;
    private static ArrayList<Period> periods = new ArrayList<Period>();//arrayList to load with the periods
    /*MainActivity p = new MainActivity();
    Part of a failed attempt to load the firebase data into the schedule
    String hobin, two, three, four, five, six, seven;*/
    public Period(WTime start, int periodLength, String period){
        this.start = start;
        this.end = new WTime(start, periodLength);
        this.period = period;
        subject = "";
        room = "";
        teacher = "";
    }
    //LoadArray method to load the periods array with the A week periods
    public void LoadArray(){
        //p.loadArray();
        /*one = "" + (p.getPeriods().get(1));
        two = "" + (p.getPeriods().get(1));
        three = "" + (p.getPeriods().get(2));
        four = "" + (p.getPeriods().get(3));    Part of a failed attempt to load the firebase data into the schedule
        five = "" + (p.getPeriods().get(4));
        six = "" + (p.getPeriods().get(5));
        seven = "" + (p.getPeriods().get(6));
        System.out.println(one);*/
        //hobin = "" + p.getString();
        //Log.i("TAG", hobin);
        //setSubject(hobin);

        //Monday
        periods.add(new Period(new WTime(1, 8, 0), new WTime(1, 8, 15), "ASM"));
        periods.add(new Period(new WTime(1, 8, 20), new WTime(1, 9, 30), "1"));
        periods.add(new Period(new WTime(1, 9, 35), new WTime(1, 10, 20), "2"));
        periods.add(new Period(new WTime(1, 10, 25), new WTime(1, 11, 35), "3"));
        periods.add(new Period(new WTime(1, 11, 45), new WTime(1, 12, 10), "FSM"));
        periods.add(new Period(new WTime(1, 12, 30), new WTime(1, 13, 15), "4"));
        periods.add(new Period(new WTime(1, 13, 20), new WTime(1, 14, 5), "5"));
        periods.add(new Period(new WTime(1, 14, 10), new WTime(1, 14, 55), "6"));
        //Tuesday
        periods.add(new Period(new WTime(2, 8, 0), new WTime(2, 8, 15), "ASC"));
        periods.add(new Period(new WTime(2, 8, 20), new WTime(2, 9, 30), "7"));
        periods.add(new Period(new WTime(2, 9, 35), new WTime(2, 10, 20), "4"));
        periods.add(new Period(new WTime(2, 10, 25), new WTime(2, 11, 35), "2"));
        periods.add(new Period(new WTime(2, 11, 45), new WTime(2, 12, 10), "FSM"));
        periods.add(new Period(new WTime(2, 12, 30), new WTime(2, 13, 15), "5"));
        periods.add(new Period(new WTime(2, 13, 20), new WTime(2, 14, 5), "1"));
        periods.add(new Period(new WTime(2, 14, 10), new WTime(2, 14, 55), "3"));
        //Wednesday
        periods.add(new Period(new WTime(3, 8, 0), new WTime(3, 8, 15), "FLEX"));
        periods.add(new Period(new WTime(3, 8, 20), new WTime(3, 9, 5), "5"));
        periods.add(new Period(new WTime(3, 9, 10), new WTime(3, 9, 55), "6"));
        periods.add(new Period(new WTime(3, 10, 0), new WTime(3, 10, 45), "1"));
        periods.add(new Period(new WTime(3, 10, 50), new WTime(3, 11, 35), "7"));
        //Thursday
        periods.add(new Period(new WTime(4, 8, 0), new WTime(4, 8, 15), "ASC"));
        periods.add(new Period(new WTime(4, 8, 20), new WTime(4, 9, 30), "4"));
        periods.add(new Period(new WTime(4, 9, 35), new WTime(4, 10, 20), "7"));
        periods.add(new Period(new WTime(4, 10, 25), new WTime(4, 11, 35), "6"));
        periods.add(new Period(new WTime(4, 11, 45), new WTime(4, 12, 10), "FSM"));
        periods.add(new Period(new WTime(4, 12, 30), new WTime(4, 13, 15), "2"));
        periods.add(new Period(new WTime(4, 13, 20), new WTime(4, 14, 5), "3"));
        periods.add(new Period(new WTime(4, 14, 10), new WTime(4, 14, 55), "1"));
        //Friday
        periods.add(new Period(new WTime(5, 8, 0), new WTime(5, 8, 45), "3"));
        periods.add(new Period(new WTime(5, 8, 50), new WTime(5, 9, 35), "2"));
        periods.add(new Period(new WTime(5, 9, 40), new WTime(5, 10, 50), "5"));
        periods.add(new Period(new WTime(5, 11, 0), new WTime(5, 11, 40), "ASC"));
        periods.add( new Period(new WTime(5, 11, 45), new WTime(5, 12, 10), "FSM"));
        periods.add(new Period(new WTime(5, 12, 30), new WTime(5, 13, 15), "6"));
        periods.add(new Period(new WTime(5, 13, 20), new WTime(5, 14, 5), "7"));
        periods.add(new Period(new WTime(5, 14, 10), new WTime(5, 14, 55), "4"));
        //Saturday
        periods.add(new Period(new WTime(6, 8, 0), new WTime(6, 11, 35), "FLEX"));
        periods.add(new Period(new WTime(6, 11, 40), new WTime(6, 12, 05), "Lunch"));
    }
    //LoadArrayB method to load the periods array with the B week periods.
    public void LoadArrayB(){
        //Monday
        periods.add(new Period(new WTime(1, 8, 0), new WTime(1, 8, 15), "ASM"));
        periods.add(new Period(new WTime(1, 8, 20), new WTime(1, 9, 30), "1"));
        periods.add(new Period(new WTime(1, 9, 35), new WTime(1, 10, 20), "2"));
        periods.add(new Period(new WTime(1, 10, 25), new WTime(1, 11, 35), "3"));
        periods.add(new Period(new WTime(1, 11, 45), new WTime(1, 12, 10), "FSM"));
        periods.add(new Period(new WTime(1, 12, 30), new WTime(1, 13, 15), "EH"));
        periods.add(new Period(new WTime(1, 13, 20), new WTime(1, 14, 5), "4"));
        periods.add(new Period(new WTime(1, 14, 10), new WTime(1, 14, 55), "6"));
        //Tuesday
        periods.add(new Period(new WTime(2, 8, 0), new WTime(2, 8, 15), "ASC"));
        periods.add(new Period(new WTime(2, 8, 20), new WTime(2, 9, 30), "7"));
        periods.add(new Period(new WTime(2, 9, 35), new WTime(2, 10, 20), "4"));
        periods.add(new Period(new WTime(2, 10, 25), new WTime(2, 11, 35), "2"));
        periods.add(new Period(new WTime(2, 11, 45), new WTime(2, 12, 10), "FSM"));
        periods.add(new Period(new WTime(2, 12, 30), new WTime(2, 13, 15), "EH"));
        periods.add(new Period(new WTime(2, 13, 20), new WTime(2, 14, 5), "5"));
        periods.add(new Period(new WTime(2, 14, 10), new WTime(2, 14, 55), "3"));
        //Wednesday
        periods.add(new Period(new WTime(3, 8, 0), new WTime(3, 8, 55), "Flex"));
        periods.add(new Period(new WTime(3, 9, 0), new WTime(3, 9, 45), "5"));
        periods.add(new Period(new WTime(3, 9, 50), new WTime(3, 10, 35), "6"));
        periods.add(new Period(new WTime(3, 10, 40), new WTime(3, 11, 25), "1"));
        periods.add(new Period(new WTime(3, 11, 30), new WTime(3, 12, 15), "Lunch"));
        //Thursday
        periods.add(new Period(new WTime(4, 8, 0), new WTime(4, 8, 15), "ASC"));
        periods.add(new Period(new WTime(4, 8, 20), new WTime(4, 9, 30), "4"));
        periods.add(new Period(new WTime(4, 9, 35), new WTime(4, 10, 20), "7"));
        periods.add(new Period(new WTime(4, 10, 25), new WTime(4, 11, 35), "6"));
        periods.add(new Period(new WTime(4, 11, 45), new WTime(4, 12, 10), "FSM"));
        periods.add(new Period(new WTime(4, 12, 30), new WTime(4, 13, 15), "2"));
        periods.add(new Period(new WTime(4, 13, 20), new WTime(4, 14, 5), "3"));
        periods.add(new Period(new WTime(4, 14, 10), new WTime(4, 14, 55), "1"));
        //Friday
        periods.add(new Period(new WTime(5, 8, 0), new WTime(5, 8, 45), "3"));
        periods.add(new Period(new WTime(5, 8, 50), new WTime(5, 9, 35), "2"));
        periods.add(new Period(new WTime(5, 9, 40), new WTime(5, 10, 50), "5"));
        periods.add(new Period(new WTime(5, 11, 0), new WTime(5, 11, 40), "ASC"));
        periods.add(new Period(new WTime(5, 11, 45), new WTime(5, 12, 10), "Lunch"));
        periods.add(new Period(new WTime(5, 12, 30), new WTime(5, 13, 15), "EH"));
        periods.add(new Period(new WTime(5, 13, 20), new WTime(5, 14, 5), "7"));
        periods.add(new Period(new WTime(5, 14, 10), new WTime(5, 14, 55), "4"));
        //Saturday
        periods.add(new Period(new WTime(6, 8, 30), new WTime(6, 9, 15), "6"));
        periods.add(new Period(new WTime(6, 9, 20), new WTime(6, 10, 05), "1"));
        periods.add( new Period(new WTime(6, 10, 10), new WTime(6, 10, 55), "7"));
        periods.add(new Period(new WTime(6, 11, 0), new WTime(6, 11, 45), "5"));
        periods.add(new Period(new WTime(6, 11, 50), new WTime(6, 12, 35), "Lunch"));
    }

    //clearList method clears the array so you can switch between the A and B week.
    public void clearList(){
        periods.clear();
    }

    public Period(Period a){
        start = a.start;
        end = a.end;
        period = a.period;
        teacher = a.teacher;
        room = a.room;
        subject = a.subject;
    }
    public Period (WTime start, WTime end, String period){
        this.start = start;
        this.end = end;
        this.period = period;
        subject = "";
        room = "";
        teacher = "";
    }

    //getArrayList method to return the array list
    public ArrayList<Period> getArrayList() {
        ArrayList<Period> list = new ArrayList<Period>();
        for (int i = 0; i < periods.size(); i++) {
            list.add(periods.get(i));
        }
        return list;
    }

    //a getDayPeriod method to get the day of the period
    public int getDayPeriod(){
        return start.getDay();
    }

    public void setSubject(String g){
        subject = g;
    }
    public String getSubject(){
        return subject;
    }
    public void setRoom(String g){
        room = g;
    }
    public String getRoom(){
        return room;
    }
    public void setTeacher(String g){
        teacher= g;
    }
    public String getTeacher(){
        return teacher;
    }
    public String getPeriod(){
        return period;
    }

    public static int loadPeriods(InputStream PeriodData)throws IOException{
        Period p;
        WTime start;
        int num = 0;
        String line = "";
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(PeriodData, Charset.forName("UTF-8")));
        try{
            reader.readLine();
            while ((line = reader.readLine())!= null){
                String[] tokens = line.split(",");
                start = new WTime(Integer.parseInt(tokens[0]),
                        Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),0);
                p = new Period(start, Integer.parseInt(tokens[4]),(tokens[5]));
                periods.add(p);
                num++;
            }
        }
        catch (IOException e) {
            System.out.println("Error reading data file on line " + line);
            e.printStackTrace();
            throw e;
        }
        return num;
    }
    public static void setAllPeriodInfo(String num,String meets, String className, String room, String teacher){
        System.out.println("num "+num+" meets "+meets+" className "+className+" Room "+room+" Teacher "+teacher);
        int meetsSession = 1;
        int meetsNum = 0;
        for (Period p:periods){
            if (p.period.equals(num)){
                if (meets.length() < 1){
                    p.setSubject(className);
                    p.setRoom(room);
                    p.setTeacher(teacher);
                }
                else if (meets.length() > meetsNum && meets.substring(meetsNum,meetsNum+1).equals(""+meetsSession)){
                    meetsNum++;
                    meetsSession++;
                    p.setSubject(className);
                    p.setRoom(room);
                    p.setTeacher(teacher);
                }
            }
        }
    }
    public static void setAllPeriodInfo(String num, String className){
        setAllPeriodInfo(num,"",className,"","");
    }
    public static Period findContainingPeriod(WTime target){
        for (Period p:periods){
            if (p.contains(target)){
                return p;
            }
        }
        return null;
    }
    //Returns the period before the current passing block or the previous period to the current period
    // if between last period of the week and the first period of the week return the last period of the week
    public static Period findPreviousPeriod(WTime target){
        Period previous = null;
        Period current = null;
        current = findContainingPeriod(target);
        if (current != null){  //return the previous period
            int index = periods.indexOf(current);
            if (index > 0)
                return periods.get(index-1);
            else
                return periods.get(periods.size()-1);
        }
        else{    //not a current period ie a passing block
            current  = findNextPeriod(target);
            if (periods.indexOf(current) == 0)
                return periods.get(periods.size()-1);
            else
                return periods.get(periods.indexOf(current)-1);
        }
        // return null;
    }
    //Returns the period after the current passing block or the period after current period
    // if between last period of the week and the first period of the week return the first period of the week
    public static Period findNextPeriod(WTime target){
        Period previous = null;
        for (Period p:periods){
            if (!p.startsAfter(target))
                return p;
        }
        return periods.get(0);
    }

    public boolean startsAfter(WTime target){
        return start.isBefore(target);
    }

    public boolean contains(WTime target){
        if (start.isBefore(target) && end.isAfter(target))
            return true;
        return false;
    }

    public void setStart(WTime a){
        start = a;
    }

    public void setPeriodNumber(String g){
        period = g;
    }


    //draw method to draw the week schedule
    public void draw (Canvas canvas){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(15);
        paint.setStrokeWidth(2);
        paint.setColor(Color.BLACK);
        int day = start.getDay();
        WTime starts = new WTime(day,8, 0);
        int gs = (start.ticks - starts.ticks)/200;
        int ge = (end.ticks - starts.ticks)/200;
        Log.i("ge",""+ge);
        Log.i("gs", ""+gs);
        Rect rect = new Rect(day*140, gs, day*140 + 140, ge);
        canvas.drawRect(rect, paint);
        canvas.drawText(start.getHourAMPM()+":"+start.getMinuteS(),((day*140 + day*140+140)/2)+20,gs+20, paint);
        canvas.drawText(end.getHourAMPM()+":"+end.getMinuteS(),((day*140 + day*140+140)/2)-60,ge-10, paint);
        canvas.drawText(subject, (day*140 + day*140+140)/2-15,(ge+gs)/2 - 10, paint);
        canvas.drawText(getPeriod(),(day*140 + day*140+140)/2-15,(ge+gs)/2, paint);
    }

    //drawDay method to draw a day schedule
    public void drawDay (Canvas canvas){
        Paint paintDay = new Paint();
        paintDay.setStyle(Paint.Style.STROKE);
        paintDay.setTextSize(17);
        paintDay.setStrokeWidth(3);
        paintDay.setColor(Color.BLACK);
        int day = start.getDay();
        WTime starts = new WTime(8, 0);
        int gs = (start.ticks - starts.ticks)/200;
        int ge = (end.ticks - starts.ticks)/200;
        Rect rect = new Rect (400, gs, 700, ge);
        canvas.drawRect(rect, paintDay);
        canvas.drawText(start.getHourAMPM()+":"+start.getMinuteS(),((400 + 700)/2)+90,gs+30, paintDay);
        canvas.drawText(end.getHourAMPM()+":"+end.getMinuteS(),((400 + 700)/2)-140,ge-10, paintDay);
        canvas.drawText(subject, (400 + 700)/2,(ge+gs)/2+10, paintDay);
        canvas.drawText(getPeriod(),(400 + 700)/2,(ge+gs)/2, paintDay);
    }

    //drawNext method to draw the current and next period
    public void drawNext (Canvas canvas){
        Paint paintDay = new Paint();
        paintDay.setStyle(Paint.Style.STROKE);
        paintDay.setTextSize(17);
        paintDay.setStrokeWidth(3);
        paintDay.setColor(Color.BLACK);
        int day = start.getDay();
        WTime starts = new WTime (8, 0);
        int hour = start.getHour();
        int gs = (start.ticks - starts.ticks)/150;
        int ge = (end.ticks - starts.ticks)/150;
        Rect rect = new Rect (400, gs, 700, ge);
        canvas.drawRect(rect, paintDay);
        canvas.drawText(start.getHourAMPM()+":"+start.getMinuteS(),((400 + 700)/2)+90,gs+30, paintDay);
        canvas.drawText(end.getHourAMPM()+":"+end.getMinuteS(),((400 + 700)/2)-140,ge-10, paintDay);
        canvas.drawText(subject, (400 + 700)/2,(ge+gs)/2+10, paintDay);
        canvas.drawText(getPeriod(),(400 + 700)/2,(ge+gs)/2, paintDay);

    }
    public static ArrayList<Period> getTodaysPeriods(int dDay){
        ArrayList <Period> dayPeriods = new ArrayList<Period>();
        for(Period p:periods){
            if(p.start.getDay() == dDay)
                dayPeriods.add(p);
        }
        return dayPeriods;
    }
    public String toString(){
        return "Period :"+period+" starts "+start+" ends "+end;
    }
    // for testing
    public static void main(String[] args) {
        Period test1 = new Period(new WTime(1, 8, 40), new WTime(1, 9, 30), "1");
        System.out.println(test1);
        InputStream f = null;
        try {
            f = new FileInputStream("PeriodTimes.csv");
            loadPeriods(f);
        } catch (IOException e) {
            System.out.println("file not found " + e);
        }
        setAllPeriodInfo("4", "Lunch");
        setAllPeriodInfo("5", "App Development");
        WTime a = new WTime();
        // WTime a = new WTime(6,14,30,0);  //saturday after classes
        //  WTime a = new WTime(0,14,30,0);   // Sunday Morning
        //WTime a = new WTime(1,8,30,0);   // Monday Morning
        //WTime a = new WTime(1, 9, 32, 0);   // Monday Morning passing block
        System.out.println(a);
        System.out.println(Period.findContainingPeriod(a));
        System.out.println(Period.findNextPeriod(a));
        System.out.println(Period.findPreviousPeriod(a));
        //  for (Period a: periods){
        //    System.out.println(a);
        //  }
    }}