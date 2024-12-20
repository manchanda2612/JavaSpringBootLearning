package com.example.java_springboot_learning.secondweek_practice.controller;

import com.example.java_springboot_learning.secondweek_practice.dto.EmployeeDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

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

    @GetMapping
    private String fetchEmployeeInfo(@RequestParam(name = "id",required = false) Long id){
        return "Employee id is : " + id;
    }

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



}
