package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {

    static Predicate<Student> studentPredicate = student -> student.getGpa()>3.7;

    public static void main(String[] args) {

        //Stream is a sequence of elements which can be created out of a collection such as List, Arrays, etc.
        //Streams API - primary objective is to perform operations on collections
        //Stream doesn't modify the existing collection
        //Element can be accessed only in sequence
        //Stream are lazily constructed
        //Stream can be traversed only once
        //Stream performs internal iteration to iterate through the elements
        //Stream passes elements from the first operation till the last one by one i.e. after the terminal operation is performed on the first element
        //the second element is passed to the first operation

        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGradeLevel()>=3) //intermediate operation
                .peek(student -> System.out.println("After 1st filter: " +student)) //doesn't affect the stream, can be used for logging
                .filter(studentPredicate) //intermediate operation
                .collect(Collectors.toMap(Student::getName, Student::getActivities)); //terminal operation

        System.out.println(studentMap);

    }
}
