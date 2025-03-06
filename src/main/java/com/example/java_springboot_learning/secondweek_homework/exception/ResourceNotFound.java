package com.example.java_springboot_learning.secondweek_homework.exception;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String string) {
        super(string);
    }
}
