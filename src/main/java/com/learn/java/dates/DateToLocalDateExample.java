package com.learn.java.dates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateToLocalDateExample {

    public static void main(String[] args) {

        //java.util.Date to LocalDate
        Date date1 = new Date();
        System.out.println("Date1: "+date1);
        LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("LocalDate1: "+localDate1);

        //LocalDate to java.util.Date
        Date date2 = new Date().from(localDate1.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("Date2: "+date2);

        //java.sql.Date to LocalDate
        java.sql.Date date3 = java.sql.Date.valueOf(localDate1);
        System.out.println("Date3: "+date3);

        //LocalDate to java.sql.Date
        LocalDate localDate2 = date3.toLocalDate();
        System.out.println("LocalDate2: "+localDate2);


    }
}
