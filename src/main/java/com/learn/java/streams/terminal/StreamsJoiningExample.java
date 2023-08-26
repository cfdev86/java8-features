package com.learn.java.streams.terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamsJoiningExample {

    public static void main(String[] args) {

        String joinValue1 = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));
        System.out.println("joinValue: "+joinValue1);

        String joinValue2 = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining("-", "(",")"));
        System.out.println("joinValue: "+joinValue2);


    }
}
