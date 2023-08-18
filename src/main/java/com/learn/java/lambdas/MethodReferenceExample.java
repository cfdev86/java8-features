package com.learn.java.lambdas;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferenceExample {

    static Function<String, String> toUpperCaseLambda = s -> s.toUpperCase();

    //Method reference is a shortcut for writing lambda expressions
    //It refers a method of a class
    //
    //Syntax of method reference
    //ClassName::instance-methodName
    //ClassName::static-methodName
    //Instance::methodName
    static Function<String, String> toUpperCaseMethodReference = String::toUpperCase;

    static Consumer<Student> studentConsumerLambda = System.out::println;

    public static void main(String[] args) {

        System.out.println("toUpperCaseLambda: "+toUpperCaseLambda.apply("java8"));

        System.out.println("toUpperCaseMethodReference: "+toUpperCaseMethodReference.apply("java8"));

        StudentDataBase.getAllStudents().stream().forEach(studentConsumerLambda);

    }
}
