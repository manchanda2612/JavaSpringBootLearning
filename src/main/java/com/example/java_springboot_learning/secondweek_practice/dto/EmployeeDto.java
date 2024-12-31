package com.example.java_springboot_learning.secondweek_practice.dto;

import com.example.java_springboot_learning.secondweek_practice.annotation.EmployeeRoleValidation;
import com.example.java_springboot_learning.secondweek_practice.annotation.PrimeNumberValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {


    private Long id;

    @NotBlank(message = "Name of the employee cannot be blank.")
    @Size(min = 3, max = 10, message = "Number of the character should be in the range (3-10)")
    private String name;

    @NotBlank(message = "Email can't be blank")
    @Email(message = "Please enter valid email address")
    private String email;

    @NotNull(message = "Age can't be blank")
    @Min(value = 18, message = "Age of the employee can't be less than 18")
    @Max(value = 60, message = "Age of the employee can't be more than 60")
    private Integer age;

    @NotBlank(message = "Role of the employee can't be blank")
    //@Pattern(regexp = "^(Admin|User)$", message = "Role of employee can either be User or Admin")
    @EmployeeRoleValidation
    private String role;

    @PastOrPresent(message = "DateOfJoining field of employee can't be in the future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

    @NotNull(message="Salary of the employee can't be Null")
    @Positive(message = "Salary of the employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "Salary can be in the form of only XXXXXX.YY")
    @DecimalMax(value = "100000.00", message = "Salary of the employee can't be more than 100000.00")
    @DecimalMin(value = "10000.00", message = "Salary of the employee can't be less than 10000.00")
    private Double salary;

    @NotNull
    @Positive(message = "Please enter positive number")
    @Min(value = 2, message = "Minimum value should be 2")
    @Max(value = 100, message = "Maximum value should be 100")
    @PrimeNumberValidation
    @JsonProperty("isPrime")
    private Integer isPrime;
}






