package com.example.demo.controller;

import com.example.demo.dao.entity.EducationalClass;
import com.example.demo.service.EducationalClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class EducationalClassController {
    @Autowired
    private EducationalClassService service;

    @GetMapping
    public List<EducationalClass> getAllClasses(@RequestParam(required = false, defaultValue = "lastName") String sortField) {
        return service.findAll(Sort.by(sortField));
    }

    @GetMapping("/{id}")
    public EducationalClass getClassById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public EducationalClass createClass(@RequestBody EducationalClass cls) {
        return service.save(cls);
    }

    @PutMapping("/{id}")
    public EducationalClass updateClass(@PathVariable Long id, @RequestBody EducationalClass cls) {
        EducationalClass existingClass = service.findById(id);
        existingClass.setYear(cls.getYear());
        existingClass.setMnemonic(cls.getMnemonic());
        existingClass.setTeacher(cls.getTeacher());
        existingClass.setStudents(cls.getStudents());
        return service.save(existingClass);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        service.deleteById(id);
    }
}
