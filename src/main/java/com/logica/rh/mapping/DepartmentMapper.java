package com.logica.rh.mapping;

import com.logica.rh.domain.Department;
import com.logica.rh.entity.DepartmentEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {

    Department toDepartment(DepartmentEntity departmentEntity);

    DepartmentEntity fromDepartment(Department department);

}
