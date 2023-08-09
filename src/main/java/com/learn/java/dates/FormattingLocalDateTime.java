package com.learn.java.dates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateTime {

    public static void parseLocalDateTime(){

        String dateTime1 = "2023-08-01T14:33:33";
        LocalDateTime localDateTime1 = LocalDateTime.parse(dateTime1); //Expects the provided String to be in the DateTimeFormatter.ISO_LOCAL_DATE_TIME format
        System.out.println("LocalDateTime: "+localDateTime1);

        LocalDateTime localDateTime2 = LocalDateTime.parse(dateTime1, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("LocalDateTime2: "+localDateTime2);

        //Custom format
        String dateTime2 = "2023-08-01T14|33|33";
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH|mm|ss");
        LocalDateTime localDateTime3 = LocalDateTime.parse(dateTime2, dateTimeFormatter1);
        System.out.println("LocalDateTime3: "+localDateTime3);

    }

    public static void formatLocalDateTime(){
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH|mm|ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedLocalDateTime = localDateTime.format(dateTimeFormatter1);
        System.out.println("Formatted LocalDateTime: "+formattedLocalDateTime);
    }

    public static void main(String[] args) {
        parseLocalDateTime();
        formatLocalDateTime();
    }
}
