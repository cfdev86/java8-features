package com.learn.java.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamFactoryMethodExample {

    public static void main(String[] args) {

        //Creates a stream with the values passed to the of method
        Stream<String> stringStream = Stream.of("adam", "dan", "julie");
        stringStream.forEach(System.out::println);

        //Used to create infinite stream
        Stream.iterate(1,x->x*2).limit(10).forEach(System.out::println);

        //Used to create infinite stream
        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier).limit(5).forEach(System.out::println);

    }
}
