package com.logica.rh.mapping;

import com.logica.rh.domain.Employee;
import com.logica.rh.entity.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    Employee toEmployee(EmployeeEntity employeeEntity);

    EmployeeEntity fromEmployee(Employee employee);

}
