package com.example.student_registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.student_registration.model.student;
import com.example.student_registration.repository.studentrepository;

@Controller
public class studentcontroller {
    private final studentrepository repo;

    public studentcontroller(studentrepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", repo.findAll());
        model.addAttribute("student", new  student());
        return "index";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute student student) {
        repo.save(student);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        // Handle both soft delete and hard delete based on your requirements
        return "redirect:/";
    }
}
