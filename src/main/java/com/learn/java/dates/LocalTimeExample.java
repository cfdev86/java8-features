package com.learn.java.dates;

import com.sun.security.jgss.GSSUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeExample {

    public static void main(String[] args) {

        //Returns the local time of the computer/server on which it runs
        LocalTime localTime1 = LocalTime.now();
        System.out.println("Local time: "+localTime1);

        //Get specific local time
        LocalTime localTime2 = LocalTime.of(21,20);
        System.out.println("Local time: "+localTime2);

        LocalTime localTime3 = LocalTime.of(21,20, 45);
        System.out.println("Local time: "+localTime3);

        LocalTime localTime4 = LocalTime.of(21,20, 45,989094580); //Nanosecond is one billionth of a second
        System.out.println("Local time: "+localTime4);


        //Get values from LocalTime
        System.out.println("Get hour: "+localTime1.getHour());
        System.out.println("Get minute: "+localTime1.getMinute());
        System.out.println("Get second: "+localTime1.getSecond());
        System.out.println("Get Nano second: "+localTime1.getNano());

        //Get values using ChronoField
        System.out.println("Get clock hour: "+localTime1.get(ChronoField.CLOCK_HOUR_OF_AMPM));
        System.out.println("Get hour of the day: "+localTime1.get(ChronoField.HOUR_OF_DAY));

        System.out.println("Get second of the day: "+localTime1.toSecondOfDay());

        //Modify LocalTime, created new LocalTime object since it is immutable
        System.out.println("Subtract two hours: "+localTime1.minusHours(2));
        System.out.println("Subtract two hours: "+localTime1.minus(2, ChronoUnit.HOURS));
        System.out.println("Add two hours: "+localTime1.plusHours(2));

        System.out.println("Replace hour: "+localTime1.withHour(10));
        System.out.println("Replace hour: "+localTime1.with(ChronoField.HOUR_OF_DAY, 10)); //ChronoField implements TemporalField
        System.out.println("Change hour to midnight: " +localTime1.with(LocalTime.MIDNIGHT)); //LocalTime implements TemporalAdjuster

    }
}
