package com.learn.java.lambdas;

import java.util.function.Consumer;

public class LambdaVariableExample {

    //Class level variable
    static Integer j = 5;

    public static void main(String[] args) {
        //local variable of the method
        Integer i1=5;

        //Below is not permitted, can't use local variable in lambda
//        Consumer<Integer> consumer1 = i1 -> {
//            System.out.println(i1);
//        };

        Consumer<Integer> consumer2 = i2 -> {
            //You can reference local variable within a lambda
            System.out.println(i1);
        };

        Consumer<Integer> consumer3 = i3 -> {
            //You can't modify local variables within a lambda
//            i1++;
            System.out.println(i3);
        };

        Consumer<Integer> consumer4 = i4 -> {
            //You can reference class variable or instance variable within a lambda
            System.out.println(j);
        };

        Consumer<Integer> consumer5 = i5 -> {
            //You can modify class variable or instance variable within a lambda
            j++;
        };
    }
}
