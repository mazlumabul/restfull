package com.mazlumabul.restfullwebservices.service.impl;

import com.mazlumabul.restfullwebservices.model.Student;
import com.mazlumabul.restfullwebservices.repo.StudentRepository;
import com.mazlumabul.restfullwebservices.service.abstracts.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
