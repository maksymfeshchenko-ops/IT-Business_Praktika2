package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public void addStudent(Student student) {
        repository.save(student);
    }

    public Student getById(int id) {
        return repository.findById(id);
    }

    public List<Student> searchByName(String name) {
        return repository.findByName(name);
    }

    public List<Student> searchByEmail(String email) {
        return repository.findByEmail(email);
    }
}
