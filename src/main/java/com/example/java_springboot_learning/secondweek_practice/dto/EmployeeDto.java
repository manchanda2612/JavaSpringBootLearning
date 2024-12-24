package com.example.java_springboot_learning.secondweek_practice.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EmployeeDto {

    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private LocalDate dateOfJoining;
    private Boolean isActive;

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", isActive=" + isActive +
                '}';
    }
}






