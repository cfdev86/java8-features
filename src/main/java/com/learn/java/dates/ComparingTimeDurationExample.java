package com.learn.java.dates;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ComparingTimeDurationExample {

    public static void main(String[] args) {

        //Duration is a time based representation in hours, minutes, seconds and nanoseconds
        //It is compatible with LocalTime and LocalDateTime
        //It can be used to calculate the difference between time objects - LocalTime and LocalDateTime

        LocalTime localTime1 = LocalTime.of(21, 45);
        LocalTime localTime2 = LocalTime.of(23, 35);

        //until method can be used to get the difference between two LocalTime objects in the specified TemporalUnit (ChronoUnit)
        long diff = localTime1.until(localTime2, ChronoUnit.MINUTES);
        System.out.println("Diff in minutes: "+diff);

        //between method can be used to get Duration
        Duration duration1 = Duration.between(localTime1, localTime2);
        System.out.println("Diff in hours: "+duration1.toHours());
        System.out.println("Diff in mins: "+duration1.toMinutes());

        Duration duration2 = Duration.ofHours(2);
        System.out.println("Duration in mins: "+duration2.toMinutes());

    }
}
