package com.learn.java.lambdas;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionExample {

    //Function is a functional interface which has one abstract method apply
    //which accepts one argument and returns one value
    static Function<String, String> function = (name) -> name.toUpperCase();

    static Function<String, String> addSomeString = (name) -> name.concat(" is awesome!");

    //BiFunction accepts two arguments and returns one value
    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (students, studentPredicate) -> {
        Map<String, Double> studentGradeMap = new HashMap<>();
        students.forEach(student -> {
            if(studentPredicate.test(student)){
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        });
        return studentGradeMap;
    };

    public static void main(String[] args) {

        System.out.println("Result is: "+function.apply("java8"));

        //When you use andThen function will be performed first followed by addSomeString, the result of function is passed to addSomeString
        //as an argument.
        //You can chain n number of addThen
        System.out.println("Result of andthen: "+function.andThen(addSomeString).apply("java8"));

        //When you use compose addSomeString will be performed first followed by function, the result of addSomeString is passed to
        //function as an argument
        //You can chain n number of compose
        System.out.println("Result of compose: "+function.compose(addSomeString).apply("java8"));

        System.out.println("BiFunction result: "+biFunction.apply(StudentDataBase.getAllStudents(), LambdaStudentExample.p1));

    }
}
