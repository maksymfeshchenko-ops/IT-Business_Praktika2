package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    void addStudent(Student student);

    Student getById(int id);

    List<Student> searchByName(String name);
    List<Student> searchByEmail(String email);
}
