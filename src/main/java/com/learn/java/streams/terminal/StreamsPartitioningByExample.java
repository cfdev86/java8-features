package com.learn.java.streams.terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

public class StreamsPartitioningByExample {

    public static void main(String[] args) {

        Map<Boolean, List<Student>> partitioningMap1 = StudentDataBase.getAllStudents()
                .stream()
                .collect(partitioningBy(student -> student.getGpa()>=3.8));

        System.out.println("PartitioningMap1: "+partitioningMap1);

        Map<Boolean, Set<Student>> partitioningMap2 = StudentDataBase.getAllStudents()
                .stream()
                .collect(partitioningBy(student -> student.getGpa()>=3.8, toSet()));

        System.out.println("PartitioningMap2: "+partitioningMap2);

    }
}
