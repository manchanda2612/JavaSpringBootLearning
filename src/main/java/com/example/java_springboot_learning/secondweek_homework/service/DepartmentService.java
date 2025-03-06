package com.example.java_springboot_learning.secondweek_homework.service;

import com.example.java_springboot_learning.secondweek_homework.dto.DepartmentDto;
import com.example.java_springboot_learning.secondweek_homework.entities.DepartmentEntity;
import com.example.java_springboot_learning.secondweek_homework.exception.ResourceNotFound;
import com.example.java_springboot_learning.secondweek_homework.repository.DepartmentRepository;
import javafx.scene.effect.Reflection;
import org.modelmapper.ModelMapper;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;

    }

    public DepartmentDto createNewDepartment(DepartmentDto departmentDto) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDto, DepartmentEntity.class);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDto.class);
    }

    public Optional<DepartmentDto> findDepartmentById(Long id) {
        isDepartmentExists(id);
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(id);
        return departmentEntity.map(departmentEntity1 -> modelMapper.map(departmentEntity1, DepartmentDto.class));
    }

    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentEntity> departmentDtoList = departmentRepository.findAll();
        return departmentDtoList.stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDto.class))
                .collect(Collectors.toList());
    }

    public DepartmentDto updateDepartmentCompleteDetails(Long id, DepartmentDto departmentDto) {
        isDepartmentExists(id);
        DepartmentEntity departmentEntity = modelMapper.map(departmentDto, DepartmentEntity.class);
        DepartmentEntity savedDepartment = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartment, DepartmentDto.class);
    }

    public DepartmentDto updateDepartmentDetails(Long id, Map<String, Object> updateDetails) {
        isDepartmentExists(id);
        DepartmentEntity departmentToBeUpdated = departmentRepository.findById(id).get();
        updateDetails.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(DepartmentEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, departmentToBeUpdated, value);
        });

        return modelMapper.map(departmentRepository.save(departmentToBeUpdated), DepartmentDto.class);
    }

    public boolean deleteDepartmentDetails(Long id) {
        isDepartmentExists(id);
        departmentRepository.deleteById(id);
        return true;
    }

    private void isDepartmentExists(Long id) {
        boolean isExist = departmentRepository.existsById(id);
        if (!isExist) {
            throw new ResourceNotFound("Department id not found" + id);
        }
    }


}
