package com.example.java_springboot_learning.secondweek_homework.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapperInstance() {
        return new ModelMapper();
    }

}
