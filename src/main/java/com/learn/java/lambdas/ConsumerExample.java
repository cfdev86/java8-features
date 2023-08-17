package com.learn.java.lambdas;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        //Functional Interface is an interface that has only one abstract method
        //It is annotated with the annotation - @FunctionalInterface
        //Lambdas can be used in place of functional interfaces

        //Consumer Functional Interface have one abstract accept which accepts a value and returns nothing
        Consumer<String> consumer1 = s -> System.out.println(s.toUpperCase());

        Consumer<String> consumer2 = s -> System.out.println("Hi "+s);

        consumer1.accept("Alex");

        //andThen can be used to chain two consumers, first consumer1's accept method is called followed by consumer 2
        consumer1.andThen(consumer2).accept("Alex");

    }

}
