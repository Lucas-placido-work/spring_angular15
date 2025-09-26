package com.lucas.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lucas.back.entity.Employee;
import com.lucas.back.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  public Optional<Employee> findById(Long id) {
    return employeeRepository.findById(id); 
  }

  public void deleteById(Long id) {
    employeeRepository.deleteById(id);
  }
  
}
