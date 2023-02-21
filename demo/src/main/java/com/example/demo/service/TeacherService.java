package com.example.demo.service;

import com.example.demo.dao.entity.Student;
import com.example.demo.dao.entity.Teacher;
import com.example.demo.dao.repository.TeacherRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public List<Teacher> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    public Teacher findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found with id: " + id));
    }

    public Teacher save(Teacher teacher) {
        return repository.save(teacher);
    }

    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Teacher not found with id: " + id);
        }
    }
}
