package com.example.java_springboot_learning.secondweek_practice.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation, Integer> {

    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext constraintValidatorContext) {
        return number % 2 == 0;
    }
}
