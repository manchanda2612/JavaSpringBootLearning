package com.example.java_springboot_learning.secondweek_homework.controller;

import com.example.java_springboot_learning.secondweek_homework.dto.DepartmentDto;
import com.example.java_springboot_learning.secondweek_homework.exceptions.ResourceNotFound;
import com.example.java_springboot_learning.secondweek_homework.service.DepartmentService;
import com.example.java_springboot_learning.secondweek_practice.dto.EmployeeDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(path = "saveDepartmentData")
    public ResponseEntity<DepartmentDto> saveDepartmentData(@Valid @RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.createNewDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable(name = "departmentId") Long id) {
        Optional<DepartmentDto> departmentDto = departmentService.findDepartmentById(id);
        return departmentDto.map(departmentDto1 -> ResponseEntity.ok(departmentDto1))
                .orElseThrow(() -> new ResourceNotFound("Department no found with id " + id));
    }

    @GetMapping(path = "/getAllDepartment")
    public ResponseEntity<List<DepartmentDto>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.findAllDepartments());
    }

    @PutMapping(path = "/updateEntireDepartmentDetails/{departmentId}")
    public ResponseEntity<DepartmentDto> updateEntireDepartmentDetails(@PathVariable(name = "departmentId") long id,
                                                                       @RequestBody DepartmentDto departmentDto) {
         DepartmentDto updatedDepartmentCompleteDetails = departmentService.updateDepartmentCompleteDetails(id, departmentDto);
         return ResponseEntity.ok(updatedDepartmentCompleteDetails);
    }

    @PatchMapping(path = "/updateDepartmentDetails/{departmentId}")
    public ResponseEntity<DepartmentDto> updateDepartmentDetails(@PathVariable(name = "departmentId") long id,
                                                                 @RequestBody Map<String, Object> detailsToBeUpdated) {
       DepartmentDto departmentDto = departmentService.updateDepartmentDetails(id, detailsToBeUpdated);
       if (departmentDto == null) return ResponseEntity.notFound().build();
       return ResponseEntity.ok(departmentDto);
    }

    @DeleteMapping(path = "/deleteDepartmentDetails/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentDetails(@PathVariable(name="departmentId") Long id) {
       boolean isDepartmentDeleted = departmentService.deleteDepartmentDetails(id);
       if(isDepartmentDeleted) return ResponseEntity.ok(true);
       return ResponseEntity.notFound().build();
    }
}
