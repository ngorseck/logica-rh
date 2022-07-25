package com.logica.rh.exception;

import com.logica.rh.controller.EmployeeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class APIExceptionHandlerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController)
                .setControllerAdvice(new APIExceptionHandler())
                .build();
    }

    @Test
    public void testHandleRequestException() throws Exception {
        RequestException exception = new RequestException("error message",
                HttpStatus.INTERNAL_SERVER_ERROR);
        when(employeeController.getEmployee(any()))
                .thenThrow(exception);
        mockMvc.perform(get("/employees/{id}", 1L))
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void testHandleEntityNotFoundException() throws Exception {
        EntityNotFoundException exception = new EntityNotFoundException("error message");
        when(employeeController.getEmployee(any()))
                .thenThrow(exception);
        mockMvc.perform(get("/employees/{id}", 1L))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testHandleNumberFormatException() throws Exception {
        NumberFormatException exception = new NumberFormatException();
        when(employeeController.getEmployee(any()))
                .thenThrow(exception);
        mockMvc.perform(get("/employees/{id}", 1L))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMethodArgumentNotValidException() throws Exception {
        MethodArgumentNotValidException exception =
                new MethodArgumentNotValidException(mock(MethodParameter.class), mock(BindingResult.class)) {
                    public String getMessage() {
                        return "error message";
                    }
                };
        given(employeeController.getEmployee(any()))
                .willAnswer(invocationOnMock -> {
                    throw exception;
                });
        mockMvc.perform(get("/employees/{id}", 1L))
                .andExpect(status().isBadRequest());
    }
}