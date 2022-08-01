package com.logica.rh.service;

import com.logica.rh.domain.Employee;
import com.logica.rh.exception.EntityNotFoundException;
import com.logica.rh.exception.RequestException;
import com.logica.rh.mapping.EmployeeMapper;
import com.logica.rh.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Locale;

@Service
@CacheConfig(cacheNames = "employees")
@AllArgsConstructor
public class EmployeeService {

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;
    MessageSource messageSource;

    @Transactional(readOnly = true)
    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable).map(employeeMapper::toEmployee);
    }

    @Cacheable(key = "#id")
    @Transactional(readOnly = true)
    public Employee getEmployee(Long id) {
        return employeeMapper.toEmployee(employeeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("employee.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public Employee createEmployee(Employee employee) {
        employeeRepository.findById(employee.getId())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("employee.exists", new Object[]{employee.getId()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        return employeeMapper.toEmployee(employeeRepository.save(employeeMapper.fromEmployee(employee)));
    }

    @CachePut(key = "#id")
    @Transactional
    public Employee updateEmployee(Long id, Employee employee) {
        return employeeRepository.findById(id)
                .map(entity -> {
                    employee.setId(id);
                    return employeeMapper.toEmployee(
                            employeeRepository.save(employeeMapper.fromEmployee(employee)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("employee.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @CacheEvict(key = "#id")
    @Transactional
    public void deleteEmployee(Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("employee.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}