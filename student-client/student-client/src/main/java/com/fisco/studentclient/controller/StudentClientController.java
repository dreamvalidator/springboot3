package com.fisco.studentclient.controller;

import com.fisco.studentclient.model.Student;
import com.fisco.studentclient.service.StudentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studentClient")
public class StudentClientController {
    @Autowired
    private StudentClientService studentClientService;
    @GetMapping
    List<Student> getAllStudent(){

        return studentClientService.getAllStudent();
    }
}
