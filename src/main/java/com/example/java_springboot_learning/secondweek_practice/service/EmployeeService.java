package com.example.java_springboot_learning.secondweek_practice.service;

import com.example.java_springboot_learning.secondweek_practice.dto.EmployeeDto;
import com.example.java_springboot_learning.secondweek_practice.entities.EmployeeEntity;
import com.example.java_springboot_learning.secondweek_practice.exceptions.ResourceNotFound;
import com.example.java_springboot_learning.secondweek_practice.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDto> findEmployee(Long employeeId){
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDto.class));

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

    public EmployeeDto updateEmployeeDetails(Long id, EmployeeDto employeeDto) {
        isEmployeeExist(id);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        employeeEntity.setId(id);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDto.class);
    }

    private void isEmployeeExist(Long id) {
        boolean isExist = employeeRepository.existsById(id);
        if(!isExist) throw new ResourceNotFound("Employee Not Found with id is : "+id);
    }

    public boolean deleteEmployeeDetail(Long id) {
        isEmployeeExist(id);
        employeeRepository.deleteById(id);
        return true;
    }

    public EmployeeDto updateEmployeeInfo(Long id, Map<String, Object> update) {
        isEmployeeExist(id);
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        update.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,employeeEntity, value);
        });

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDto.class);

    }
}
