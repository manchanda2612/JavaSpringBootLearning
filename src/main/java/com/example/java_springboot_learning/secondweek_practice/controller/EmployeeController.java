package com.example.java_springboot_learning.secondweek_practice.controller;

import com.example.java_springboot_learning.secondweek_practice.dto.EmployeeDto;
import com.example.java_springboot_learning.secondweek_practice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    /*private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping(path = "/giveGreetingToEmployee")
    public String getGreetings() {
        return "Hello Neeraj! Good Morning";
    }

    *//*@GetMapping(path = "/fetchEmployeeInfo/{employeeId}")
    public String fetchEmployeeDetails(@PathVariable Long employeeId) {
        return "User id is : " + employeeId;
    }*//*

    @GetMapping(path = "/{employeeId}")
    public String fetchEmployeeDetails(@PathVariable(name = "employeeId") Long id) {
        return "User id is : " + id;
    }

   *//* @GetMapping
    public String fetchEmployeeInfo(@RequestParam(name = "id",required = false) Long id){
        return "Employee id is : " + id;
    }*//*

    @GetMapping
    public String fetchEmployeeInfo(@RequestParam(name = "id") Long id,
                                     @RequestParam(name = "name", required = false) String name){
        return "Employee id is : " + id;
    }

    @PostMapping(path = "createNewEmployeeData")
    public String createEmployeeData(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeDto1 = new EmployeeDto(employeeDto.getId(), employeeDto.getName(),
                employeeDto.getAddress(), employeeDto.getPhoneNumber());
        return employeeDto1.toString();
    }

    @PutMapping(path = "/updateEmployeeDetails/{employeeId}")
    public String updateEmployeeDetails(@PathVariable(name = "employeeId") Long id) {
        return "Update employee details whose id is : " + id;
    }

    *//**
     * 2.3 The Persistence Layer and JPA Layer practice
     *//*
    @GetMapping(path = "getEmployeeById/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long employeeId){
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @GetMapping(path="getAllEmployee")
    public List<EmployeeEntity> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping(path = "saveEmployeeInH2DB")
    public EmployeeEntity createEmployeeData(@RequestBody EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }*/


    /**
     * 2.4 Service Layer
     */

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "getEmployeeById/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "employeeId") Long employeeId){
        Optional<EmployeeDto> employeeDto = employeeService.findEmployee(employeeId);
        return employeeDto.map(employeeDto1 -> ResponseEntity.ok(employeeDto1))
                          .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path="getAllEmployee")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.findAllEmployee()) ;
    }

    @PostMapping(path = "saveEmployeeInH2DB")
    public ResponseEntity<EmployeeDto> createEmployeeData(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createNewEmployee(employeeDto), HttpStatus.CREATED);
    }

    /**
     * 2.5 PUT PATCH and DELETE MAPPING
     */

    @PutMapping(path = "updateEntireEmployeeDetail/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployeeDetails(@PathVariable(name = "employeeId") Long employeeId,
                                             @RequestBody EmployeeDto employeeDto) {

        return ResponseEntity.ok(employeeService.updateEmployeeDetails(employeeId, employeeDto));
    }

    @DeleteMapping(path = "deleteEmployee/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable(name = "employeeId") Long id) {
        boolean isUserDeleted = employeeService.deleteEmployeeDetail(id);
        if(isUserDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "updateEmployeeData/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployeeInfo(@PathVariable(name = "employeeId") Long id,
                                          @RequestBody Map<String, Object> update) {
        EmployeeDto employeeDto = employeeService.updateEmployeeInfo(id, update);
        if (employeeDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDto);
    }
}
