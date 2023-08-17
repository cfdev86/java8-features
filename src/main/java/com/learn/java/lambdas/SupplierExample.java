package com.learn.java.lambdas;

import com.learn.java.data.Student;

import java.util.Arrays;
import java.util.function.Supplier;

public class SupplierExample {



    public static void main(String[] args) {

        //A supplier is a functional interface that has one abstract method - get
        //which doesn't expect an argument but returns a value
        Supplier<Student> studentSupplier = () -> {
            return new Student("Adam",2,3.6, "male",10, Arrays.asList("swimming", "basketball","volleyball"));

        };

        System.out.println("Supplier: "+studentSupplier.get());

    }
}
