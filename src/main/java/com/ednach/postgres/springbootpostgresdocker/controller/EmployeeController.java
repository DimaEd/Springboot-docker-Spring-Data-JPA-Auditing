package com.ednach.postgres.springbootpostgresdocker.controller;

import com.ednach.postgres.springbootpostgresdocker.EmployeeRepository;
import com.ednach.postgres.springbootpostgresdocker.model.Employee;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);

    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmployeeId(@PathVariable(value = "id") Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow
                (() -> new ResourceNotFoundException("Employee not found " + id));
        return ResponseEntity.ok().body(employee);

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow
                (() -> new ResourceNotFoundException("Employee not found " + id));
        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
