package com.learn.java.dates;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalTimeExample {

    public static void parseTime(){
        String time1 = "13:00";
        LocalTime localTime1 = LocalTime.parse(time1);
        System.out.println("LocalTime1: "+localTime1);

        LocalTime localTime2 = LocalTime.parse(time1, DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("LocalTime2: "+localTime2);

        //Custom format
        String time2 = "14*25*55";
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH*mm*ss");
        LocalTime localTime3 = LocalTime.parse(time2, dateTimeFormatter1);
        System.out.println("LocalTime3: "+localTime3);
    }

    public static void formatTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH|mm|ss");
        LocalTime localTime = LocalTime.now();
        String formattedTime = localTime.format(dateTimeFormatter);
        System.out.println("Formatted Time: "+formattedTime);
    }

    public static void main(String[] args) {
        parseTime();
        formatTime();
    }
}
