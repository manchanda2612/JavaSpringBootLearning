package com.example.java_springboot_learning.secondweek_homework.dto;

import com.example.java_springboot_learning.secondweek_homework.annotation.PasswordValidation;
import com.example.java_springboot_learning.secondweek_homework.annotation.PrimeNumberValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class DepartmentDto {


    private Long id;

    @NotBlank
    @Size(min = 3, max = 12, message = "Number of character should be in the range (3-15)")
    private String title;

    @DecimalMin(value = "10000.00", message = "Lowest most salary of this department employee is  : 10000")
    @DecimalMax(value = "1000000.00", message = "Maximum salary of this department employee is  : 1000000")
    @NotNull(message="Salary of the department employee can't be Null")
    @Positive(message = "Salary of the department employee should be positive")
    @Digits(integer = 7, fraction = 2, message = "Salaries can be in the form of only XXXXXXX.YY")
    @Range(min = 10000, max = 1000000, message = "Salary should be in the range between 10000.00 to 1000000.00")
    private Double salary;

    @PastOrPresent(message = "Department formed date can't be of future")
    private LocalDate createdAt;

    @Min(value = 18, message = "Minimum age of employee in this department is 18")
    @Max(value = 60, message = "Maximum age of employee in this department is 60")
    @NotNull
    private Integer age;

    @Null
    private String landLinePhoneNumber;

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits and contain only numbers")
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
