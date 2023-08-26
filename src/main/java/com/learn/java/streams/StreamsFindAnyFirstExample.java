package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Optional;

public class StreamsFindAnyFirstExample {

    public static void main(String[] args) {

        //Short-circuiting
        //FindAny will return first encountered element
        Optional<Student> student1 = StudentDataBase.getAllStudents()
                .stream()
                .filter(s->s.getGpa()>3.9)
                .findAny();

        student1.ifPresent(System.out::println);

        //Short-circuiting
        //FindFirst will return the first element
        Optional<Student> student2 = StudentDataBase.getAllStudents()
                .stream()
                .filter(s->s.getGpa()>3.9)
                .findFirst();

        student2.ifPresent(System.out::println);

    }
}
