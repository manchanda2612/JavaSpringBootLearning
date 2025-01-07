package com.example.java_springboot_learning.secondweek_homework.service;

import com.example.java_springboot_learning.secondweek_homework.dto.DepartmentDto;
import com.example.java_springboot_learning.secondweek_homework.entities.DepartmentEntity;
import com.example.java_springboot_learning.secondweek_homework.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<DepartmentDto> findDepartmentById(Long id){
         Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(id);
         return departmentEntity.map(departmentEntity1 -> modelMapper.map(departmentEntity1, DepartmentDto.class));
    }




}
