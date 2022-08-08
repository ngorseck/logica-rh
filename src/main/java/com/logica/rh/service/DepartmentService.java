package com.logica.rh.service;

import com.logica.rh.domain.Department;
import com.logica.rh.exception.EntityNotFoundException;
import com.logica.rh.exception.RequestException;
import com.logica.rh.mapping.DepartmentMapper;
import com.logica.rh.repository.DepartmentRepository;
import com.logica.rh.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@CacheConfig(cacheNames = "departments")
@AllArgsConstructor
public class DepartmentService {

    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;
    DepartmentMapper departmentMapper;
    MessageSource messageSource;

    @Transactional(readOnly = true)
    public List<Department> getDepartments() {
        return StreamSupport.stream(departmentRepository.findAll().spliterator(), false)
                .map(departmentMapper::toDepartment)
                .collect(Collectors.toList());
    }

    @Cacheable(key = "#name")
    @Transactional(readOnly = true)
    public Department getDepartment(String name) {
        return departmentMapper.toDepartment(departmentRepository.findByNameIgnoreCase(name).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("department.notfound", new Object[]{name},
                        Locale.getDefault()))));
    }

    @Transactional
    public Department createDepartment(Department department) {
        employeeRepository.findById(department.getResponsable().getId()).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("employee.notfound",
                        new Object[]{department.getResponsable().getId()},
                        Locale.getDefault())));

        departmentRepository.findByNameIgnoreCase(department.getName())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("department.exists", new Object[]{department.getName()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        return departmentMapper.toDepartment(departmentRepository.save(departmentMapper.fromDepartment(department)));
    }

    @CachePut(key = "#name")
    @Transactional
    public Department updateDepartment(String name, Department department) {
        return departmentRepository.findByNameIgnoreCase(name)
                .map(entity -> {
                    employeeRepository.findById(department.getResponsable().getId()).orElseThrow(() ->
                            new EntityNotFoundException(messageSource.getMessage("employee.notfound",
                                    new Object[]{department.getResponsable().getId()},
                                    Locale.getDefault())));
                    department.setName(name);
                    return departmentMapper.toDepartment(departmentRepository.save(departmentMapper.fromDepartment(department)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("department.notfound",
                        new Object[]{name},
                        Locale.getDefault())));
    }

    @CacheEvict(key = "#name")
    @Transactional
    public void deleteDepartment(String name) {
        try {
            departmentRepository.deleteById(name);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("department.errordeletion", new Object[]{name},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}