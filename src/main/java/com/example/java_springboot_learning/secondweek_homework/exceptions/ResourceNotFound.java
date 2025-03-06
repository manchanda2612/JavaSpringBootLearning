package com.example.java_springboot_learning.secondweek_homework.exceptions;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String message) {
        super(message);
    }
}
