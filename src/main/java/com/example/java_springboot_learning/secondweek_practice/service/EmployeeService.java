package com.example.java_springboot_learning.secondweek_practice.service;

import com.example.java_springboot_learning.secondweek_practice.dto.EmployeeDto;
import com.example.java_springboot_learning.secondweek_practice.entities.EmployeeEntity;
import com.example.java_springboot_learning.secondweek_practice.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeEntity findEmployee(Long employeeId){
        return employeeRepository.findById(employeeId).orElse(null);
    }


    public List<EmployeeDto> findAllEmployee(){
        List<EmployeeEntity> employeeEntityList =  employeeRepository.findAll();
        return employeeEntityList
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        EmployeeEntity entity = modelMapper.map(employeeDto, EmployeeEntity.class);
        EmployeeEntity savedEmployeeDto = employeeRepository.save(entity);
        return modelMapper.map(savedEmployeeDto, EmployeeDto.class);
    }
}
