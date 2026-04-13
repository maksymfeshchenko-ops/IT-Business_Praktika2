package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public List<Student> findAll() {
        return students;
    }

    public void save(Student student) {
        students.add(student);
    }

    public Student findById(int id) {
        if (id >= 0 && id < students.size()) {
            return students.get(id);
        }
        return null;
    }

    public List<Student> findByName(String name) {
        return students.stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Student> findByEmail(String email) {
        return students.stream()
                .filter(s -> s.getEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());
    }
}
