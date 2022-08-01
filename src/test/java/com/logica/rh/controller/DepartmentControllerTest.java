package com.logica.rh.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logica.rh.BaseTestClass;
import com.logica.rh.domain.Department;
import com.logica.rh.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets/departments", uriPort = 9090)

class DepartmentControllerTest extends BaseTestClass {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DepartmentService departmentService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testgetDepartments() {
    }

    @Test
    public void testgetDepartment() {
    }

    @Test
    public void testcreateDepartment() {
    }

    @Test
    public void testupdateDepartment() {
    }

    @Test
    public void testdeleteDepartment() throws Exception {
        /*Department department = getDepartment();
        doNothing().when(departmentService).deleteDepartment(department.getName());
        mockMvc.perform(delete("/departments/{name}", department.getName()))
                .andExpect(status().isOk())
                .andDo(document("deleteDepartment"));*/
    }
}