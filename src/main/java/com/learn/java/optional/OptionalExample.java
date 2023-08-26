package com.learn.java.optional;

import com.learn.java.data.Bike;
import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Optional;

public class OptionalExample {

    public static Optional<String> getStudentNameOptional(){

        //Optional is useful to overcome Null pointer exceptions
        //Optional ofNullable will give an empty optional if the provided value is null
        Optional<Student> optional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        //checks if optional has a value
        if(optional.isPresent()){
            return optional.map(Student::getName); //map
        }else{
            //return an empty optional
            return Optional.empty();
        }
    }

    public static void main(String[] args) {

        Optional<String> stringOptional1 = getStudentNameOptional();

        if(stringOptional1.isPresent()){
            System.out.println("Name: "+stringOptional1.get());
        }

        //Will throw an exception if a null value is provided
        Optional<String> stringOptional2 = Optional.of("Hello");
        //ifPresent checks if the value is present and calls a consumer
        stringOptional2.ifPresent(System.out::println);

        Optional<String> stringOptional3 = Optional.ofNullable(null);
        //orElse value is returned if the optional doesn't have a value - null or empty
        String stringOptional4 = stringOptional3.orElse("Default");
        System.out.println("StringOptional4: "+stringOptional4);

        //orElseGet is similar to orElse but it expects a supplier
        Optional<String> stringOptional5 = Optional.ofNullable(null);
        //orElse value is returned if the optional doesn't have a value - null or empty
        String stringOptional6 = stringOptional5.orElseGet(() -> "Default Value!");
        System.out.println("StringOptional6: "+stringOptional6);

        //orElseThrow will throw an error is a value is not present
        Optional<String> stringOptional7 = Optional.ofNullable("hello");
        String value = stringOptional7.orElseThrow(RuntimeException::new);
        System.out.println("Value: "+value);


        //filter method
        Optional<Student> studentOptional8 = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        studentOptional8.filter(s->s.getGpa()>=3.8).ifPresent(System.out::println);

        //flatMap -> returns an optional within an optional
        Optional<Student> studentOptional9 = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<String> bikeName = studentOptional9.filter(s->s.getGpa()>=3.8)
                .flatMap(Student::getBike)
                .map(Bike::getName);

        bikeName.ifPresent(System.out::println);

    }
}
