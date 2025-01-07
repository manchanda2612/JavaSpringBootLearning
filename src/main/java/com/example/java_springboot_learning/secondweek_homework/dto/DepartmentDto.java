package com.example.java_springboot_learning.secondweek_homework.dto;

import com.example.java_springboot_learning.secondweek_homework.annotation.PasswordValidation;
import com.example.java_springboot_learning.secondweek_homework.annotation.PrimeNumberValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Data
public class DepartmentDto {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 15, message = "Number of character should be in the range (3-15)")
    private String title;

    @DecimalMin(value = "10000.00", message = "Lowest most salary of this department employee is  : 10000")
    @DecimalMax(value = "1000000.00", message = "Lowest most salary of this department employee is  : 1000000")
    @NotNull(message="Salary of the department employee can't be Null")
    @Positive(message = "Salary of the department employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "Salaries can be in the form of only XXXXXX.YY")
    @Range(min = 10000, max = 100000, message = "Salary should be in the range between 10000.00 to100000.00")
    private Double salary;

    @PastOrPresent(message = "Department formed date can't be of future")
    private LocalDate createdAt;

    @Min(value = 18, message = "Minimum age of employee in this department is 18")
    @Max(value = 60, message = "Maximum age of employee in this department is 60")
    @NotNull
    private Integer age;

    @Null
    @PositiveOrZero(message = "Number can only between 0-9")
    private String LandlinePhoneNumber;

    @Null
    @Pattern(regexp = "^(0-9)&", message = "Number can only between 0-9")
    @Range(min = 10, max = 10, message = "")
    private String mobileNumber;


    @AssertTrue(message = "Department should be active")
    @JsonProperty("isActive")
    private boolean isActive;

    @AssertFalse(message = "NPS is not enabled for this department employees")
    @JsonProperty("isNpsEnabled")
    private boolean isNpsEnabled;

    @PositiveOrZero(message = "")
    private Integer yearOfExperience;

    @NotNull
    @Positive(message = "Please enter positive number")
    @Min(value = 2, message = "Minimum value should be 2")
    @Max(value = 100, message = "Maximum value should be 100")
    @PrimeNumberValidation
    @JsonProperty("isPrime")
    private Integer isPrime;

    @NotNull
    @PasswordValidation
    @Length(min = 10, max = 20, message = "Password should be between 10 to 20 characters.")
    private String password;


    @CreditCardNumber(ignoreNonDigitCharacters = true, message = "Invalid credit card number")
    private String creditCardNumber;





}
