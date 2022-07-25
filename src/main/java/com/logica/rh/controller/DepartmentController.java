package com.logica.rh.controller;

import com.logica.rh.domain.Department;
import com.logica.rh.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("departments")
@AllArgsConstructor
public class DepartmentController {

    DepartmentService departmentService;

    @GetMapping
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("{name}")
    public Department getDepartment(@PathVariable("name") String name) {
        return departmentService.getDepartment(name);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Department createDepartment(@Valid @RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("{name}")
    public Department updateCountry(@PathVariable("name") String name, @Valid @RequestBody Department department) {
        return departmentService.updateDepartment(name, department);
    }

    @DeleteMapping("{name}")
    public void deleteCountry(@PathVariable("name") String name) {
        departmentService.deleteDepartment(name);
    }

}