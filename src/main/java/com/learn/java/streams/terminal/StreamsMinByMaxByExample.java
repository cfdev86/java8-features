package com.learn.java.streams.terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.Comparator;
import java.util.Optional;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

public class StreamsMinByMaxByExample {

    public static void main(String[] args) {

        Optional<Student> studentOptional1 = StudentDataBase.getAllStudents()
                .stream()
                .collect(minBy(Comparator.comparing(Student::getGpa)));

        studentOptional1.ifPresent(System.out::println);

        Optional<Student> studentOptional2 = StudentDataBase.getAllStudents()
                .stream()
                .collect(maxBy(Comparator.comparing(Student::getGpa)));

        studentOptional2.ifPresent(System.out::println);

    }
}
