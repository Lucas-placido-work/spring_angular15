package com.lucas.back.controller;

import com.lucas.back.entity.Employee;
import com.lucas.back.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isEmpty()) {
            throw new RuntimeException("Funcionário não encontrado");
        }
        return employee.get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.deleteById(id);
    }
}
