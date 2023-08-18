package com.learn.java.lambdas;

import com.learn.java.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    static Supplier<Student> studentSupplier = Student::new;

    //Constructor reference syntax
    //Class::new
    static Function<String, Student> studentFunction = Student::new;

    public static void main(String[] args) {

        System.out.println(studentSupplier.get());

        System.out.println(studentFunction.apply("Alex"));

    }
}
