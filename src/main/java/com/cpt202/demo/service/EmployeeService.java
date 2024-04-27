package com.cpt202.demo.service;

import com.cpt202.demo.entity.Employee;
import com.cpt202.demo.repository.EmployeeRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {
    private final EmployeeRepo employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {  
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

}
