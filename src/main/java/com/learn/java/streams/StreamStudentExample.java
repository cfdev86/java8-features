package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.Optional;

public class StreamStudentExample {

    public static void main(String[] args) {

        //Find student with the highest GPA
        Optional<Student> student = StudentDataBase.getAllStudents()
                .stream()
                .reduce((s1,s2) -> {
                    return s1.getGpa()>s2.getGpa() ? s1 : s2;
                });

        student.ifPresent(System.out::println);

        //No of notebooks of students in grade 3 or higher
        int noOfNotebooks = StudentDataBase.getAllStudents()
                .stream()
                .filter(s->s.getGradeLevel()>=3)
                .map(Student::getNoteBooks)
                .reduce(0, Integer::sum);
        System.out.println("No of notebooks: "+noOfNotebooks);

    }
}
