package com.example.java_springboot_learning.firstweek_homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    @Autowired
    IFrosting frosting;

    @Autowired
    ISyrup syrup;

    void bakeCake() {
        frosting.getFrostingType();
        syrup.getSyrupType();
        System.out.println("Baking the strawberry Cake");
    }
}
