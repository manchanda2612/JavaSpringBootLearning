package com.example.java_springboot_learning.secondweek_homework.controller;

import com.example.java_springboot_learning.secondweek_homework.dto.DepartmentDto;
import com.example.java_springboot_learning.secondweek_homework.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("saveDepartmentData")
    public ResponseEntity<DepartmentDto> saveDepartmentData(DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.createNewDepartment(departmentDto), HttpStatus.CREATED);
    }


}
