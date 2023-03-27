package com.mazlumabul.restfullwebservices.controller;

import com.mazlumabul.restfullwebservices.model.Student;
import com.mazlumabul.restfullwebservices.service.abstracts.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/saveStudent")
    ResponseEntity<String> addStudent (@Valid @RequestBody Student student){
        studentService.save(student);
        return ResponseEntity.ok("Student Saved");
    }
}
