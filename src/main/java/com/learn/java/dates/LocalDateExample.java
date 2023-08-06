package com.learn.java.dates;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample {

    public static void main(String[] args) {

        //Date of the computer/server on which it runs
        LocalDate localDate1 = LocalDate.now();
        System.out.println("Local Date: "+localDate1);

        //Get specific date by passing year, month and dayOfMonth
        LocalDate localDate2 = LocalDate.of(2022, 01, 05);
        System.out.println("Local Date: "+localDate2);

        //Get specific date by passing year and dayOfYear
        LocalDate localDate3 = LocalDate.ofYearDay(2022, 365);
        System.out.println("Local Date: "+localDate3);

        //Get values from LocalDate
        System.out.println("Get month name: "+localDate1.getMonth());
        System.out.println("Get month number: "+localDate1.getMonthValue());
        System.out.println("Day of the week: "+localDate1.getDayOfWeek());
        System.out.println("Day of the month: "+localDate1.getDayOfMonth());
        System.out.println("Get year: "+localDate1.getYear());
        System.out.println("Day of the year: "+localDate1.getDayOfYear());

        //Get values using ChronoField
        System.out.println("Day of the month: "+localDate1.get(ChronoField.DAY_OF_MONTH));
        System.out.println("Clock hour of AM/PM: "+localDate1.get(ChronoField.YEAR));

       //Modifying LocalDate, A new LocalDate object is created because LocalDate is immutable
        System.out.println("Increment date by 2 days: "+localDate1.plusDays(2));
        System.out.println("Increment date by 1 month: "+localDate1.plusMonths(1));
        System.out.println("Increment date by 1 year: "+localDate1.plusYears(1));
        System.out.println("Decrease the date by 3 days: "+localDate1.minusDays(3));
        System.out.println("Change year using with: "+localDate1.withYear(2021));
        System.out.println("Change year using ChronoField: "+localDate1.with(ChronoField.YEAR,2020));
        System.out.println("Change year using ChronoUnit: "+localDate1.minus(1, ChronoUnit.YEARS));

        //Temporal Adjusters to change date
        System.out.println("Change date to first day of next month: "+localDate1.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("Last date of the month: "+localDate1.with(TemporalAdjusters.lastDayOfMonth()));

        //Other important methods
        System.out.println("Is it a leap year? : "+localDate1.isLeapYear());
        System.out.println("Are the dates equal? : "+localDate1.isEqual(localDate2));
        System.out.println("Is LocalDate2 before LocalDate1? : "+localDate2.isBefore(localDate1));
        System.out.println("Is LocalDate1 after LocalDate2? : "+localDate1.isAfter(localDate2));

        //Unsupported, can't use time functionality on Date
//        System.out.println("Change hours using ChronoUnit: "+localDate1.minus(1, ChronoUnit.HOURS));

        //Check if TemporalField or TemporalUnit is supported or not
        System.out.println("Is supported? : "+localDate1.isSupported(ChronoUnit.HOURS));
        System.out.println("Is not supported? : "+localDate1.isSupported(ChronoField.CLOCK_HOUR_OF_AMPM));
    }
}
