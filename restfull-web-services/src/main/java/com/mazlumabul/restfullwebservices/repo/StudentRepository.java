package com.mazlumabul.restfullwebservices.repo;

import com.mazlumabul.restfullwebservices.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
