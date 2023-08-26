package com.learn.java.streams;

import com.learn.java.data.StudentDataBase;

public class StreamsMatchExample {

    public static void main(String[] args) {

        //Short-circuiting
        //Allmatch -> returns true if all elements pass the predicate test, else returns false
        boolean value1 = StudentDataBase.getAllStudents()
                .stream()
                .allMatch(student -> student.getGpa()>=3.9);
        System.out.println("Value1: "+value1);

        //Short-circuiting
        //Anymatch -> returns true if any element passes the predicate test, else returns false
        boolean value2 = StudentDataBase.getAllStudents()
                .stream()
                .anyMatch(student -> student.getGpa()>=3.9);
        System.out.println("Value2: "+value2);

        //Short-circuiting
        //Nonematch -> returns true if no element passes the predicate test, else returns false
        boolean value3 = StudentDataBase.getAllStudents()
                .stream()
                .noneMatch(student -> student.getGpa()>=4.5);
        System.out.println("Value3: "+value3);

    }
}
