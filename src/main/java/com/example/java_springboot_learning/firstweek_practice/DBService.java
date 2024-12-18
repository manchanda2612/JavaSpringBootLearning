package com.example.java_springboot_learning.firstweek_practice;

import org.springframework.stereotype.Service;

@Service
public class DBService {

    final private DB db;

    public DBService(DB db) {
        this.db = db;
    }
    String getData() {
        return db.getData();
    }

}
