package com.fisco.studentclient.service;

import com.fisco.studentclient.model.Student;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/students")
public interface StudentClientService {
    @GetExchange("/allStudents")
    List<Student> getAllStudent();
}
