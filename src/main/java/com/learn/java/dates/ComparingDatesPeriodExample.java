package com.learn.java.dates;

import java.time.LocalDate;
import java.time.Period;

public class ComparingDatesPeriodExample {

    public static void main(String[] args) {

        //Period is a date-based representation of time in Days, Months and Years, it is compatible with LocalDate

        LocalDate localDate1 = LocalDate.of(2022, 10, 02);
        LocalDate localDate2 = LocalDate.of(2022, 11,22);

        //until method can be used to return a period
        Period period1 = localDate1.until(localDate2);

        //Get values from period
        System.out.println("getDays: "+period1.getDays()); // Results -> 22-2=20
        System.out.println("getMonths "+period1.getMonths()); // Results -> 11-10=1
        System.out.println("getYears: "+period1.getYears()); // Results -> 2022-2022=0


        Period period2 = Period.ofDays(45);
        System.out.println("period2.getDays: "+period2.getDays());

        Period period3 = Period.ofYears(10);
        System.out.println("period3.getYears: "+period3.getYears());
        System.out.println("period.toTotalMonths: "+period3.toTotalMonths());

        //between method can also be used to get a period
        Period period4 = Period.between(localDate1, localDate2);

        System.out.println("getDays: "+period4.getDays()); // Results -> 22-2=20
        System.out.println("getMonths "+period4.getMonths()); // Results -> 11-10=1
        System.out.println("getYears: "+period4.getYears()); // Results -> 2022-2022=0

    }
}
