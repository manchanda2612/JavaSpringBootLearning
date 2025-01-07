package com.example.java_springboot_learning.secondweek_homework.repository;

import com.example.java_springboot_learning.secondweek_homework.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
