package com.example.demo.dao.repository;

import com.example.demo.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}