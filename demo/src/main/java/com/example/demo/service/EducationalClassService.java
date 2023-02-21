package com.example.demo.service;

import com.example.demo.dao.entity.EducationalClass;
import com.example.demo.dao.repository.EducationalClassRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationalClassService {

    @Autowired
    private EducationalClassRepository repository;

    public List<EducationalClass> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    public EducationalClass findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EducationalClass not found with id: " + id));
    }

    public EducationalClass save(EducationalClass educationalClass) {
        return repository.save(educationalClass);
    }

    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("EducationalClass not found with id: " + id);
        }
    }
}
