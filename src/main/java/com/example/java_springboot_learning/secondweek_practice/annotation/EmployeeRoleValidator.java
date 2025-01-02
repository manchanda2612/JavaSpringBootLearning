package com.example.java_springboot_learning.secondweek_practice.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {


    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        if(inputRole.isBlank()) return false;
        List<String> roles = List.of("User","Admin");
        return roles.contains(inputRole);
    }
}
