package com.cpt202.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpt202.demo.entity.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    // Custom queries (if needed)
}
