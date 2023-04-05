package com.fisco.spb3demo.services;

import com.fisco.spb3demo.model.Student;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    public static List<Student> studentList=new ArrayList<>();
    @Autowired

    ObservationRegistry observationRegistry;
    public  Student addStudent(Student student){
        studentList.add(student);
        //return student;
        return Observation.createNotStarted("addStudent",observationRegistry)
                .observe(()-> student);
    }


    public List<Student> getAllStudent() {
       // return studentList;
        return Observation.createNotStarted("getAllStudent",observationRegistry)
                .observe(()-> studentList);
    }

    public Student getStudentById(String id) {
       // return studentList.stream().filter(s -> s.id().equals(id)).findFirst().orElseThrow(()-> new RuntimeException("student id not found"));
        return Observation.createNotStarted("getStudent",observationRegistry)
                .observe(()->studentList.stream()
                        .filter(s -> s.id().equals(id)).findFirst()
                        .orElseThrow(()-> new RuntimeException("student id not found")));

    }
}
