package com.logica.rh.service;

import com.logica.rh.domain.Department;
import com.logica.rh.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;


    @Test
    void testDepartmentService() {
        // test getCountries
        Assertions.assertEquals(departmentService.getDepartments().size(), 2);

        //assertThat(countryService.getCountries().size()).isEqualTo(3);

        // test getDepartment
        //String name = "IT";
        //Department department = departmentService.getDepartment(name);

        //test createDepartment
        Department department = new Department();
        department.setName("Financial");
        Employee employee = new Employee();
        employee.setId(2L);
        department.setResponsable(employee);

        //Objet department a recuperer apres insertion
        Department departmentsave = departmentService.createDepartment(department);
        Assertions.assertEquals(departmentsave.getName(), department.getName());

        //test updateDepartment

        //test deleteDepartment

    }

}