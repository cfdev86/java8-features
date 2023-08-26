package com.learn.java.streams.terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summingInt;

public class StreamsSumAvgExample {

    public static void main(String[] args) {

        int sum = StudentDataBase.getAllStudents()
                .stream()
                .collect(summingInt(Student::getNoteBooks));
        System.out.println("Sum: "+sum);

        Double avg = StudentDataBase.getAllStudents()
                .stream()
                .collect(averagingInt(Student::getNoteBooks));
        System.out.println("Avg: "+avg);

    }
}
