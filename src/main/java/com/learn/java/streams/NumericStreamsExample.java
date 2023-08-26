package com.learn.java.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamsExample {

    public static void main(String[] args) {

        //Numeric Streams represents the primitive values in a stream - IntStream, LongStream, DoubleStream

        System.out.println("Max using IntStream and range: " +IntStream.range(1,6).max());
        System.out.println("Max using IntStream and rangeClosed: " +IntStream.rangeClosed(1,6).max());

        System.out.println("Sum using LongStream and range: " + LongStream.range(1,6).sum());
        System.out.println("Sum using LongStream and rangeClosed: " +LongStream.rangeClosed(1,6).sum());

        System.out.println("Sum using DoubleStream: "+IntStream.range(1,6).asDoubleStream().sum());

        List<Integer> integerList = IntStream.rangeClosed(1,6)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("List: "+integerList);

    }

}
