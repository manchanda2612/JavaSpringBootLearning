package com.example.java_springboot_learning.secondweek_practice.controller;

import com.example.java_springboot_learning.secondweek_practice.dto.EmployeeDto;
import com.example.java_springboot_learning.secondweek_practice.entities.EmployeeEntity;
import com.example.java_springboot_learning.secondweek_practice.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/giveGreetingToEmployee")
    private String getGreetings() {
        return "Hello Neeraj! Good Morning";
    }

    /*@GetMapping(path = "/fetchEmployeeInfo/{employeeId}")
    private String fetchEmployeeDetails(@PathVariable Long employeeId) {
        return "User id is : " + employeeId;
    }*/

    @GetMapping(path = "/{employeeId}")
    private String fetchEmployeeDetails(@PathVariable(name = "employeeId") Long id) {
        return "User id is : " + id;
    }

   /* @GetMapping
    private String fetchEmployeeInfo(@RequestParam(name = "id",required = false) Long id){
        return "Employee id is : " + id;
    }*/

    @GetMapping
    private String fetchEmployeeInfo(@RequestParam(name = "id") Long id,
                                     @RequestParam(name = "name", required = false) String name){
        return "Employee id is : " + id;
    }

    @PostMapping(path = "createNewEmployeeData")
    private String createEmployeeData(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeDto1 = new EmployeeDto(employeeDto.getId(), employeeDto.getName(),
                employeeDto.getAddress(), employeeDto.getPhoneNumber());
        return employeeDto1.toString();
    }

    @PutMapping(path = "/updateEmployeeDetails/{employeeId}")
    private String updateEmployeeDetails(@PathVariable(name = "employeeId") Long id) {
        return "Update employee details whose id is : " + id;
    }

    /**
     * 2.3 The Persistence Layer and JPA Layer practice
     */
    @GetMapping(path = "getEmployeeById/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long employeeId){
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @GetMapping(path="getAllEmployee")
    private List<EmployeeEntity> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping(path = "saveEmployeeInH2DB")
    private EmployeeEntity createEmployeeData(@RequestBody EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }



}
