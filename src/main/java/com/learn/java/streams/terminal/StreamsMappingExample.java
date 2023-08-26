package com.learn.java.streams.terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsMappingExample {

    public static void main(String[] args) {

        //collect terminal operation with Collectors.mapping() method
        List<String> names = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList())); //can be used to avoid the intermediate map operation

        System.out.println("Names: "+names);

    }

}
