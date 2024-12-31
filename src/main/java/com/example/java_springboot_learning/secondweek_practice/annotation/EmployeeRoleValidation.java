package com.example.java_springboot_learning.secondweek_practice.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Here we have just define the validation of the structure. Now we have to provide the constraint or
 * custom logic. For this we will write {#link EmployeeRoleValidator}
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmployeeRoleValidator.class})
public @interface EmployeeRoleValidation {

    String message() default "Role of employee can either be User or Admin";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
