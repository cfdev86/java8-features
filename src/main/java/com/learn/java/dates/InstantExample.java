package com.learn.java.dates;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {

    public static void main(String[] args) {

        //Instant - Represents time in a machine-readable format, represents time in seconds since Epoch - 1st Jan, 1970

        Instant instant1 = Instant.now();
        //Prints value in human readable format
        System.out.println("Current instant: "+instant1);

        //Jan 1st 1970 -> Epoch, below method returns seconds since epoch
        System.out.println("Epoch seconds: "+instant1.getEpochSecond());

        System.out.println("Epoch: "+Instant.ofEpochSecond(0));

        Instant instant2 = Instant.now();

        Duration duration = Duration.between(instant1,instant2);
        System.out.println("Difference: "+duration.getNano());



    }
}
