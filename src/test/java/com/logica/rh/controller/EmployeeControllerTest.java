package com.logica.rh.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logica.rh.BaseTestClass;
import com.logica.rh.domain.Employee;
import com.logica.rh.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets/employees", uriPort = 9090)
class EmployeeControllerTest extends BaseTestClass {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EmployeeService employeeService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testGetEmployees() throws Exception {
        /*List<Employee> employees = Collections.singletonList(getEmployee());
        Pageable pageable = PageRequest.of(1, 5);
        Page<Employee> page = new PageImpl<>(employees, pageable, employees.size());
        given(employeeService.getEmployees(pageable)).willReturn(page);
        mockMvc.perform(get("/employees")
                .param("page", String.valueOf(pageable.getPageNumber()))
                .param("size", String.valueOf(pageable.getPageSize())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content.[0].id").value(employees.get(0).getId()))
                .andExpect(jsonPath("$.content.[0].firstName").value(employees.get(0).getFirstName()))
                .andExpect(jsonPath("$.content.[0].lastName").value(employees.get(0).getLastName()))
                .andExpect(jsonPath("$.content.[0].gender").value(employees.get(0).getGender()+""))
                .andExpect(jsonPath("$.content.[0].country").value(employees.get(0).getCountry()))
                .andExpect(jsonPath("$.content.[0].city").value(employees.get(0).getCity()))
                .andExpect(jsonPath("$.content.[0].adress").value(employees.get(0).getAdress()))
                .andDo(document("getEmployees"));*/
    }

    @Test
    public void testGetPerson() throws Exception {
        /*Employee employee = getEmployee();
        given(employeeService.getEmployee(employee.getId())).willReturn(employee);
        mockMvc.perform(get("/employees/{id}", employee.getId()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(employee.getId()))
                .andExpect(jsonPath("$.firstName").value(employee.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(employee.getLastName()))
                .andExpect(jsonPath("$.gender").value(employee.getGender()+""))
                .andExpect(jsonPath("$.country").value(employee.getCountry()))
                .andExpect(jsonPath("$.city").value(employee.getCity()))
                .andExpect(jsonPath("$.adress").value(employee.getAdress()))
                .andDo(document("getEmployee"));*/
    }

    @Test
    public void testCreatePerson() throws Exception {
        /*Employee employee = getEmployee();
        given(employeeService.createEmployee(employee)).willReturn(employee);
        mockMvc.perform(post("/employees")
                .content(objectMapper.writeValueAsString(employee))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(employee.getId()))
                .andExpect(jsonPath("$.firstName").value(employee.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(employee.getLastName()))
                .andExpect(jsonPath("$.gender").value(employee.getGender()+""))
                .andExpect(jsonPath("$.country").value(employee.getCountry()))
                .andExpect(jsonPath("$.city").value(employee.getCity()))
                .andExpect(jsonPath("$.adress").value(employee.getAdress()))
                .andDo(document("createEmployee"));*/
    }

    @Test
    public void testUpdatePerson() throws Exception {
        /*Employee employee = getEmployee();
        given(employeeService.updateEmployee(employee.getId(), employee)).willReturn(employee);
        mockMvc.perform(put("/employees/{id}", employee.getId())
                .content(objectMapper.writeValueAsString(employee))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(employee.getId()))
                .andExpect(jsonPath("$.firstName").value(employee.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(employee.getLastName()))
                .andExpect(jsonPath("$.gender").value(employee.getGender()+""))
                .andExpect(jsonPath("$.country").value(employee.getCountry()))
                .andExpect(jsonPath("$.city").value(employee.getCity()))
                .andExpect(jsonPath("$.adress").value(employee.getAdress()))
                .andDo(document("updateEmployee"));*/
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        /*Employee employee = getEmployee();
        doNothing().when(employeeService).deleteEmployee(employee.getId());
        mockMvc.perform(delete("/employees/{id}", employee.getId()))
                .andExpect(status().isOk())
                .andDo(document("deleteEmployee"));*/
    }

}