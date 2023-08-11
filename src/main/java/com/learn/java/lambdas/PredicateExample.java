package com.learn.java.lambdas;

import java.util.function.Predicate;

public class PredicateExample {

    static Predicate<Integer> p1 = i -> i%2==0;
    static Predicate<Integer> p2 = i -> i%5==0;

    public static void main(String[] args) {

        //Predicate has one abstract method test that accepts one argument and returns a boolean
//        Predicate<Integer> p = (i) -> {return i%2==0;};

        System.out.println(p1.test(4));

        //You can use And to chain two predicates, if both are true, true is returned else false is returned
        System.out.println("And: "+p1.and(p2).test(6));

        //You can use Or to chain two predicates, if either is true, true is returned else false is returned
        System.out.println("Or: "+p1.or(p2).test(6));

        //Negate can be used to reverse the result
        System.out.println("Negate: "+p1.or(p2).negate().test(6));

    }

}
