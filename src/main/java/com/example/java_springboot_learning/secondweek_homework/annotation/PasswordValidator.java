package com.example.java_springboot_learning.secondweek_homework.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValidation,String> {

    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@~#*$%^&+=!]).{10,}$";

    @Override
    public boolean isValid(String passwordString, ConstraintValidatorContext constraintValidatorContext) {
        return passwordString.matches(PASSWORD_PATTERN);

    }
}
