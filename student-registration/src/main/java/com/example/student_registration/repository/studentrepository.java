package com.example.student_registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_registration.model.student;

public interface studentrepository extends JpaRepository<student, Long> {
    // This interface will automatically provide CRUD operations for the student entity
}
