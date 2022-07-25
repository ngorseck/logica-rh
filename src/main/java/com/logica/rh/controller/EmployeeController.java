package com.logica.rh.controller;

import com.logica.rh.domain.Employee;
import com.logica.rh.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("employees")
@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping
    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeService.getEmployees(pageable);
    }

    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @Valid @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

}