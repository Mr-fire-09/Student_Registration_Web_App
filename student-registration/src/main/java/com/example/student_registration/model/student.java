package com.example.student_registration.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreRemove;

@Entity
public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String course;
    
    // Adding new fields
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String address;
    private String gender;
    private boolean isActive = true;
    private LocalDate enrollmentDate;

    // Existing getters and setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getCourse() {return course;}
    public void setCourse(String course) {this.course = course;}

    // New getters and setters
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public LocalDate getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public boolean isActive() {return isActive;}
    public void setActive(boolean active) {isActive = active;}

    public LocalDate getEnrollmentDate() {return enrollmentDate;}
    public void setEnrollmentDate(LocalDate enrollmentDate) {this.enrollmentDate = enrollmentDate;}

    // Soft delete functionality
    public void softDelete() {
        this.isActive = false;
    }

    // Method called before removal from database
    @PreRemove
    public void preRemove() {
        // Add any cleanup logic before permanent deletion
        System.out.println("Deleting student with ID: " + this.id);
    }
}
