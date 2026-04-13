package com.example.demo.controller;

import com.example.demo.model.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class MainController {

    private List<Student> students = new ArrayList<>();

    @GetMapping("/hello_world")
    public String helloWorld(Model model) {
        model.addAttribute("message", "hello world!!!");
        return "hello-world";
    }

    // Показати список студентів
    @GetMapping
    public String showStudents(Model model) {
        model.addAttribute("students", students);
        return "students";
    }

    // Показати форму додавання
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    // Обробка POST-запиту
    @PostMapping("/add")
    public String addStudent(
            @ModelAttribute Student student) {
        students.add(student);
        return "redirect:/students";
    }
}
