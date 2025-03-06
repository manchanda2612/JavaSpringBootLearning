package com.example.java_springboot_learning.secondweek_homework.service;

import com.example.java_springboot_learning.secondweek_homework.dto.DepartmentDto;
import com.example.java_springboot_learning.secondweek_homework.entities.DepartmentEntity;
import com.example.java_springboot_learning.secondweek_homework.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository mDepartmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository mDepartmentRepository, ModelMapper modelMapper) {
        this.mDepartmentRepository = mDepartmentRepository;
        this.modelMapper = modelMapper;
    }

    // Getting Department by id
    public Optional<DepartmentDto> findDepartmentById(Long id){
         Optional<DepartmentEntity> departmentEntity = mDepartmentRepository.findById(id);
         return departmentEntity.map(departmentEntity1 -> modelMapper.map(departmentEntity1, DepartmentDto.class));
    }

    // Getting all departments
    public List<DepartmentDto> findAllDepartment() {
        List<DepartmentEntity> departmentEntityList =  mDepartmentRepository.findAll();
        return departmentEntityList
                .stream()
                .map(department -> modelMapper.map(department, DepartmentDto.class))
                .collect(Collectors.toList());
    }

    // Saving Department information
    public DepartmentDto savingDepartmentDetails(DepartmentDto departmentDto) {
        DepartmentEntity saveDepartmentDetails = modelMapper.map(departmentDto, DepartmentEntity.class);
        DepartmentEntity savedDepartmentDetails = mDepartmentRepository.save(saveDepartmentDetails);
        return modelMapper.map(savedDepartmentDetails, DepartmentDto.class);
    }

    //

    




}
