package com.learn.java.streams.terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamGroupingByExample {

    public static void main(String[] args) {

        //Similar to SQL groupBy
        Map<String, List<Student>> studentMap1 = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender));

        System.out.println("StudentMap1: "+studentMap1);

        //Custom key
        Map<String, List<Student>> studentMap2 = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(student -> student.getGpa()>=3.8 ? "OUTSTANDING" : "AVERAGE"));

        System.out.println("StudentMap2: "+studentMap2);

        //Two level grouping
        Map<Integer, Map<String, List<Student>>> studentMap3 = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel, groupingBy(student -> student.getGpa()>=3.8 ? "OUTSTANDING" : "AVERAGE")));
        System.out.println("StudentMap3: "+studentMap3);

        //3 argument version
        Map<String, Set<Student>> studentMap4 = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getName, HashMap::new, toSet()));

        System.out.println("StudentMap4: "+studentMap4);

        //Max GPA student in each grade
        Map<Integer, Optional<Student>> studentMap5 = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel, maxBy(Comparator.comparing(Student::getGpa))));
        System.out.println("StudentMap5: "+studentMap5);

        //collectingAndThen
        Map<Integer,Student> studentMap6 = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel, collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
        System.out.println("StudentMap6: "+studentMap6);


    }
}
