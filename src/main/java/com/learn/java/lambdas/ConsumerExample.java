package com.learn.java.lambdas;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerExample {

    static Consumer<Student> c2 = (student) -> System.out.println(student);
    static Consumer<Student> c3 = (student) -> System.out.println(student.getName());
    static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());

    static BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name +": "+activities);

    static Predicate<Student> p1 = student -> student.getGradeLevel()>=3;
    static Predicate<Student> p2 = student -> student.getGpa()>=3.9;

    static Consumer<Student> studentConsumer = student -> {
        if(p1.and(p2).test(student)){
            biConsumer.accept(student.getName(), student.getActivities());
        }
    };



    public static void main(String[] args) {

        //Functional Interface is an interface that has only one abstract method
        //It is annotated with the annotation - @FunctionalInterface
        //Lambdas can be used in place of functional interfaces

        //Consumer Functional Interface have one abstract accept which accepts a value and returns nothing
        Consumer<String> consumer1 = s -> System.out.println(s.toUpperCase());
        consumer1.accept("Hello!");

//        printName();
//        printNameAndActivitiesUsingCondition();
//        printNameAndActivitiesUsingBiConsumer();
        printNameAndActivities();

    }

    public static void printName(){

        List<Student> studentList = StudentDataBase.getAllStudents();
        Consumer<Student> consumer = s -> System.out.println("Name: "+s.getName());
        //studentList.forEach(s-> consumer.accept(s));
        studentList.forEach(consumer);

    }

    public static void printNameAndActivities(){

        List<Student> studentList = StudentDataBase.getAllStudents();

        //Consumer chaining allows you to run one lambda after another
//        studentList.forEach(c3.andThen(c4));
        studentList.forEach(studentConsumer);

    }

    public static void printNameAndActivitiesUsingCondition(){

        List<Student> studentList = StudentDataBase .getAllStudents();

        studentList.forEach((student) -> {

            if(student.getGradeLevel()>=3){
                c3.andThen(c4).accept(student);
            }

        });

    }

    public static void printNameAndActivitiesUsingBiConsumer(){

        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));

    }
}
