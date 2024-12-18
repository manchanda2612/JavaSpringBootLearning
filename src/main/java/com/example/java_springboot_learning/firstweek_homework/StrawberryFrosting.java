package com.example.java_springboot_learning.firstweek_homework;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "cake.type", havingValue="strawberry")
public class StrawberryFrosting implements IFrosting {
    @Override
    public void getFrostingType() {
        System.out.println("Getting Strawberry Frosting");
    }
}
