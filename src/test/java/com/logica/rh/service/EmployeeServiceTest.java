package com.logica.rh.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;



    @Test
    void testEmployeeService() {
        // test getEmployees
        //Assertions.assertEquals(employeeService.getEmployees(PageRequest.of(0,3)).getContent().size(), 3);

        // test getEmployee

        // test createEmployee

        // test updateEmployee


        // test deleteEmployee

    }
}