package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // список
    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", service.getAll());
        return "students";
    }

    // деталі
    @GetMapping("/{id}")
    public String details(@PathVariable int id, Model model) {
        model.addAttribute("student", service.getById(id));
        model.addAttribute("id", id);
        return "student-details";
    }

    // форма
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    // збереження
    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Student student,
                       BindingResult result) {
        if (result.hasErrors()) {
            return "add-student";
        }
        service.addStudent(student);
        return "redirect:/students";
    }

    // пошук
    @GetMapping("/search")
    public String search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer id,
            Model model) {

        if (name != null && !name.isEmpty()) {
            model.addAttribute("students", service.searchByName(name));
        } else if (email != null && !email.isEmpty()) {
            model.addAttribute("students", service.searchByEmail(email));
        } else if (id != null) {
            model.addAttribute("students",
                    java.util.List.of(service.getById(id)));
        } else {
            model.addAttribute("students", service.getAll());
        }

        return "students";
    }
}
