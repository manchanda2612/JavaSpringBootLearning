package com.example.java_springboot_learning.secondweek_practice.exceptions;

/**
 * I have created my own exception which is ResourceNotFound exception
 */
public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String message) {
        super(message);
    }
}
