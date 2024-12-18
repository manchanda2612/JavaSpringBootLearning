package com.example.java_springboot_learning.firstweek_homework;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "cake.type", havingValue="chocolate")
public class ChocolateFrosting implements IFrosting {
    @Override
    public void getFrostingType() {
        System.out.println("Getting Chocolate Frosting");
    }
}
