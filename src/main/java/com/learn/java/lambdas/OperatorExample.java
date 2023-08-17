package com.learn.java.lambdas;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorExample {

    //UnaryOperator is a function which accepts an argument and returns a value of the same type
    static UnaryOperator<String> unaryOperator = s -> s.concat("Default");

    //BinaryOperator is a function which accepts two arguments and returns a value of the same type
    static BinaryOperator<Integer> binaryOperator = (a,b) -> a*b;

    public static void main(String[] args) {

        System.out.println("UnaryOperator: "+unaryOperator.apply("Java8"));

        System.out.println("BinaryOperator: "+binaryOperator.apply(3,4));

    }
}
