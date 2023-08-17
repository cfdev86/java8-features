package com.learn.java.lambdas;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class LambdaStudentExample {

    static Consumer<Student> c2 = (student) -> System.out.println(student);
    static Consumer<Student> c3 = (student) -> System.out.println(student.getName());
    static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());

    static BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name +": "+activities);

    static Predicate<Student> p1 = student -> student.getGradeLevel()>=3;
    static Predicate<Student> p2 = student -> student.getGpa()>=3.9;

    static BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel>=3 && gpa>=3.9;

    static Supplier<List<Student>> studentSupplier = () -> StudentDataBase.getAllStudents();

    static Consumer<Student> studentConsumer = student -> {
//        if(p1.and(p2).test(student)){
        if(biPredicate.test(student.getGradeLevel(), student.getGpa())){
            biConsumer.accept(student.getName(), student.getActivities());
        }
    };

    static Function<List<Student>, Map<String, Double>> studentFunction = students -> {
        Map<String, Double> studentGradeMap = new HashMap<>();
        students.forEach(student -> {
            if(p2.test(student)){
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        });
        return studentGradeMap;
    };

    public static void main(String[] args) {

//        printName();
//        printNameAndActivitiesUsingCondition();
//        printNameAndActivitiesUsingBiConsumer();
//        printNameAndActivities();
        System.out.println(studentFunction.apply(studentSupplier.get()));
    }

    public static void printName(){

        List<Student> studentList = studentSupplier.get();
        Consumer<Student> consumer = s -> System.out.println("Name: "+s.getName());
        //studentList.forEach(s-> consumer.accept(s));
        studentList.forEach(consumer);

    }

    public static void printNameAndActivities(){

        List<Student> studentList = studentSupplier.get();

        //Consumer chaining allows you to run one lambda after another
//        studentList.forEach(c3.andThen(c4));
        studentList.forEach(studentConsumer);

    }

    public static void printNameAndActivitiesUsingCondition(){

        List<Student> studentList = studentSupplier.get();

        studentList.forEach((student) -> {

            if(student.getGradeLevel()>=3){
                c3.andThen(c4).accept(student);
            }

        });

    }

    public static void printNameAndActivitiesUsingBiConsumer(){

        List<Student> studentList = studentSupplier.get();
        studentList.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));

    }

}
