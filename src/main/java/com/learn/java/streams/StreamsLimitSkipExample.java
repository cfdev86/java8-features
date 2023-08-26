package com.learn.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(6,7,8,9,10);

        //Short-circuiting
        //limit example
        Optional<Integer> integerOptional1 = integerList
                .stream()
                .limit(2) //limits the stream to just the first two element
                .reduce((x,y)->x+y);

        integerOptional1.ifPresent(System.out::println);

        //skip example
        Optional<Integer> integerOptional2 = integerList
                .stream()
                .skip(3) //skips the first three elements
                .reduce((x,y)->x+y);

        integerOptional2.ifPresent(System.out::println);

    }
}
