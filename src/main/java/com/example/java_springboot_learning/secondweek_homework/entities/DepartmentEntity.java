package com.example.java_springboot_learning.secondweek_homework.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "DepartmentTable")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Double salary;
    private LocalDate createdAt;
    private Integer age;
    private String LandlinePhoneNumber;
    private String mobileNumber;
    private boolean isActive;
    private boolean isNpsEnabled;
    private Integer yearOfExperience;
    private Integer isPrime;
    private String password;
    private String creditCardNumber;
}
