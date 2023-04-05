package com.fisco.spb3demo.controller;

import com.fisco.spb3demo.model.Student;
import com.fisco.spb3demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StrudentController {
    @Autowired
   private StudentService stService;
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
       return stService.addStudent(student);

    }

    @GetMapping("/allStudents")
    public List<Student> getAllStudent(){
       return stService.getAllStudent();
    }
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") String id){
      return   stService.getStudentById(id);
    }

}
