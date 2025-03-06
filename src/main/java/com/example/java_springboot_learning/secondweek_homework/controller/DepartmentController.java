package com.example.java_springboot_learning.secondweek_homework.controller;

import com.example.java_springboot_learning.secondweek_homework.dto.DepartmentDto;
import com.example.java_springboot_learning.secondweek_homework.exceptions.ResourceNotFound;
import com.example.java_springboot_learning.secondweek_homework.service.DepartmentService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final DepartmentService mDepartmentService;

    public DepartmentController(DepartmentService departmentService) {
        mDepartmentService = departmentService;
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDto> fetchDepartmentById(@PathVariable(name = "id") Long id) {
        Optional<DepartmentDto> departmentDto = mDepartmentService.findDepartmentById(id);

        return departmentDto.map(department -> ResponseEntity.ok(department))
                .orElseThrow(() -> new ResourceNotFound("Department Id not found" + id));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> fetchAllDepartments() {
        return ResponseEntity.ok(mDepartmentService.findAllDepartment());
    }


    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartmentInfo(@Valid DepartmentDto departmentDto) {
        return new ResponseEntity<>(mDepartmentService.savingDepartmentDetails(departmentDto),
                HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEn



}
