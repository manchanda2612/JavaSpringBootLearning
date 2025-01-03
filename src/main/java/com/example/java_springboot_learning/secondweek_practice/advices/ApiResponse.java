package com.example.java_springboot_learning.secondweek_practice.advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private T data;
    private ApiError error;
    @JsonFormat(pattern = "hh:mm:ss DD-MM-YYYY")
    private LocalDateTime timeStamp;

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }
}
