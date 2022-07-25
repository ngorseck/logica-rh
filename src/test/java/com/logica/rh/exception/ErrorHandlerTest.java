package com.logica.rh.exception;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ErrorHandler.class)
class ErrorHandlerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testHandleError() throws Exception {
        mockMvc.perform(get("/error"))
                .andExpect(status().isNotFound());
    }
}