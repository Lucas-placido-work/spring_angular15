package com.lucas.back.service;

import java.util.List;

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

  public Employee findById(Long id) {
    return employeeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
  }

  public void deleteById(Long id) {
    employeeRepository.deleteById(id);
  }
  
}
