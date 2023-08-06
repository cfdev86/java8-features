package com.learn.java.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalDateTimeExample {
    public static void main(String[] args) {

        //Get local date and time from the computer/server the program is run on
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println("LocalDateTime 1 : "+localDateTime1);

        //Get specific local date & time
        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 02,12,14,34,22, 985678);
        System.out.println("LocalDateTime 2 : "+localDateTime2);

        //Get values from LocalDateTime
        System.out.println("Get hour from LocalDateTime1 : "+localDateTime1.getHour());
        System.out.println("Day of the month: "+localDateTime1.get(ChronoField.DAY_OF_MONTH));

        //Modify LocalDateTime, A object will be created as LocalDateTime is immutable
        System.out.println("Increase hours: "+localDateTime1.plusHours(2));
        System.out.println("Decrease hours: "+localDateTime1.minusHours(1));
        System.out.println("Change Month: "+localDateTime1.withMonth(9));

        //Convert LocalDate to LocalDateTime
        LocalDate localDate1 = LocalDate.of(2021, 10, 25);
        System.out.println("atTime: "+localDate1.atTime(22,45));

        //Convert LocalTime to LocalDateTime
        LocalTime localTime1 = LocalTime.of(14, 30);
        System.out.println("atDate: "+localTime1.atDate(localDate1));

        //Get LocalDate from LocalDateTime
        System.out.println("ToLocalDate: "+localDateTime1.toLocalDate());

        //Get LocalTime from LocalDateTime
        System.out.println("ToLocalTime: "+localDateTime1.toLocalTime());


    }
}
