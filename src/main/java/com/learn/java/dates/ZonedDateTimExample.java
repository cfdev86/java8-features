package com.learn.java.dates;

import java.time.*;

public class ZonedDateTimExample {

    public static void main(String[] args) {

        //ZonedDateTime - Represents the date/time with its time zone

        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        //Prints the date/time along with offset and zone id
        System.out.println("Zoned Date/Time: "+zonedDateTime);

        //Prints offset with regards to UTC
        //UTC - Coordinated universal time, the World's time standard
        System.out.println("Offset time: "+zonedDateTime.getOffset());

        System.out.println("Zone Id: "+zonedDateTime.getZone());

//        System.out.println("Available zones: "+ ZoneId.getAvailableZoneIds());
//
//        ZoneId.getAvailableZoneIds()
//                .stream()
//                .forEach(z -> System.out.println(z));

        //Print CST time
        System.out.println("CST: "+ZonedDateTime.now(ZoneId.of("America/Chicago")));

        //Get LocalDateTime of a particular zone - say CST
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println("Local Date/Time (CST): "+localDateTime);

        System.out.println("ofInstant: "+LocalDateTime.ofInstant(Instant.now(),ZoneId.of("America/Chicago")));


        //Convert LocalDateTime to ZonedDateTime

        //Returns the LocalDateTime of computer/server on which it is run
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println("LocalDateTime1: "+localDateTime1);

        //Creates a ZonedDateTime by adding a zone to the given LocalDate/Time
        //Doesn't convert time, just adds the given zone to the give time
        ZonedDateTime zonedDateTime1 = localDateTime1.atZone(ZoneId.of("America/Chicago"));
        System.out.println("ZonedDateTime1: "+zonedDateTime1);

        //OffsetDateTime will add offset but not zone id
        OffsetDateTime offsetDateTime = localDateTime1.atOffset(ZoneOffset.ofHours(-6));
        System.out.println("OffsetDateTime: "+offsetDateTime);

        //Convert ZonedDateTime from one zone to another

        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println("ZonedDateTime2: "+zonedDateTime2);

        ZonedDateTime zonedDateTime3 = zonedDateTime2.withZoneSameInstant(ZoneId.of("America/Detroit"));
        System.out.println("ZonedDateTime3: "+zonedDateTime3);

    }
}
