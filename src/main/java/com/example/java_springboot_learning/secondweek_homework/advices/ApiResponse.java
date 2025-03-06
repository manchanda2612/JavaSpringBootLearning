package com.example.java_springboot_learning.secondweek_homework.advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private ApiError apiError;
    private T data;
    @JsonFormat(pattern = "hh:mm:ss DD-MM-YYYY")
    private LocalDateTime timeStamp;

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError apiError) {
        this();
        this.apiError = apiError;
    }
}
