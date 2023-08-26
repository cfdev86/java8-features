package com.learn.java.streams;

import java.util.List;

public class StreamReduceExample {

    public static void main(String[] args) {

        List<Integer> integerList = List.of(1,3,5,7);

        //Reduce terminal operator can be used to return one value
        Integer value1 = integerList.stream().reduce(1, (a,b) -> a*b);
        System.out.println("Multiplication value: "+value1);

        Integer value2 = integerList.stream().reduce((a,b) -> a*b).orElse(0);
        System.out.println("Multiplication value: "+value2);

    }
}
