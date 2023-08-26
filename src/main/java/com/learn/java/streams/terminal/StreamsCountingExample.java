package com.learn.java.streams.terminal;

import com.learn.java.data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamsCountingExample {

    public static void main(String[] args) {

        Long count = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.counting());
        System.out.println("Count: "+count);
    }
}
