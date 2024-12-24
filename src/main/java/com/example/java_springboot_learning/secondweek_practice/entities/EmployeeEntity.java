package com.example.java_springboot_learning.secondweek_practice.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "EmployeeTable")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private LocalDate dateOfJoining;
    private Boolean isActive;
}
