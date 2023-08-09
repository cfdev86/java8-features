package com.learn.java.dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateExample {

    //parse - convert string to LocalDate
    public static void parseLocalDate(){

        String date1 = "2023-08-01";
        LocalDate localDate1 = LocalDate.parse(date1);
        LocalDate localDate2 = LocalDate.parse(date1, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("LocalDate1: "+localDate1);
        System.out.println("LocalDate2: "+localDate2);

        String date2 = "20230801";
        LocalDate localDate3 = LocalDate.parse(date2, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("LocalDate3: "+localDate3);

        //Custom format
        String date3 = "2023|08|01";
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        LocalDate localDate4 = LocalDate.parse(date3, dateTimeFormatter1);
        System.out.println("LocalDate4: "+localDate4);

    }

    //format - convert LocalDate to String
    public static void formatLocalDate(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        LocalDate localDate =LocalDate.now();
        String formattedDate = localDate.format(dateTimeFormatter);
        System.out.println("formattedDate: "+formattedDate);
    }

    public static void main(String[] args) {
        parseLocalDate();
        formatLocalDate();
    }
}
