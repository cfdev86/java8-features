package com.learn.java.lambdas;

import java.util.Comparator;

public class FirstLambda {

    public static void main(String[] args) {

        //Lambda is equal to a function without a name
        //Lambda's are also referred to as anonymous functions
        //It has method parameters
        //It has method body
        //It has return type

        //Lambdas are not tied to any class like methods
        //Lambda can be assigned to a variable and passed around
        // Syntax: () -> {}
        // () : Lambda input parameters
        // -> : Arrow
        // {} : Lambda body

        //Lambda is mainly used to implement functional interfaces

        //Legacy way of creating an instance of functional interface
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside runnable!");
            }
        };

        new Thread(runnable).start();

        //Using Lambda

        Runnable runnableLambda1 = () -> {
            System.out.println("Inside runnable2!");
        };

        new Thread(runnableLambda1).start();

        //If the lambda has only one statement {} are not required
        Runnable runnableLambda2 = () -> System.out.println("Inside runnable3!");

        new Thread(runnableLambda2).start();

        //Lambda can be used directly in Thread too in place of a functional interface
        new Thread(()-> System.out.println("Inside runnable4!"));


        //Prior to Java 8 functional interfaces were initialized using anonymous classes

        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println("Result of the comparator1 is : "+comparator1.compare(3,2));

        //With Lambda

        Comparator<Integer> comparator2 = (Integer a, Integer b) -> a.compareTo(b);

        System.out.println("Result of comparator2 is : "+comparator2.compare(4,6));

        //You can drop the Datatype -> Integer in Lambda if it is already known
        Comparator<Integer> comparator3 = (a,b) -> a.compareTo(b);

        System.out.println("Result of comparator3 is :"+comparator3.compare(7,2));


    }
}
