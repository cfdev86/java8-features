package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMapExample {

    public static void main(String[] args) {

        List<String> names = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName) // map is used to convert from one type to another, it expects a Function
                .collect(Collectors.toList());

        System.out.println("Names: "+names);

        //FlatMap is used to create a stream from a collection
        List<String> activities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct() //ensures distinct elements are passed to the next step
                .collect(Collectors.toList());

        System.out.println("Distinct activities: "+activities);

        long count = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct() //ensures distinct elements are passed to the next step
                .count();

        System.out.println("Count of distinct activities: "+count);

        List<String> sortedActivities1 = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct() //ensures distinct elements are passed to the next step
                .sorted() //sorts the stream in alphabetical order
                .collect(Collectors.toList());

        System.out.println("Sorted activities: "+sortedActivities1);

        List<Student> sortedActivities2 = StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName)) //sort students by name in ascending order, ???
                .collect(Collectors.toList());

        System.out.println("Sorted students: "+sortedActivities2);

        List<Student> sortedActivities3 = StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName).reversed()) //sort students by name in descending order, ???
                .collect(Collectors.toList());

        System.out.println("Sorted students: "+sortedActivities3);

    }
}
