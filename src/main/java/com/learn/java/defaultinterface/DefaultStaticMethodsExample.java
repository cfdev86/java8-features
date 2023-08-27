package com.learn.java.defaultinterface;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DefaultStaticMethodsExample {

    public static void main(String[] args) {

        //Starting Java 1.8 interfaces can have default and static method, method implementation that won't break existing code
        List<String> stringList = Arrays.asList("Adam","Jenny","Alex","Dan","Mike","Eric");

        stringList.sort(Comparator.naturalOrder()); //static method of Comparator interface

        System.out.println("Sorted list: "+stringList);

        List<Student> students = StudentDataBase.getAllStudents();
        students.sort(Comparator.comparing(Student::getGradeLevel).thenComparing(Student::getName)); //thenComparing can be used to apply next level sort
        System.out.println("Sorted students: "+students);


    }
}
