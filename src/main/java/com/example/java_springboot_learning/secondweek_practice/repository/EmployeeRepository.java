package com.example.java_springboot_learning.secondweek_practice.repository;

import com.example.java_springboot_learning.secondweek_practice.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
