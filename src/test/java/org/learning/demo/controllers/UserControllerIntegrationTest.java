package org.learning.demo.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Date date;

    @MockBean
    DateFormat dateFormat;


    @Test
    void testGreeting() throws Exception{
        mockMvc.perform(get("/users/greetings"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, users!"));
    }

    @Test
    void testUniqueGreeting() throws Exception{
        mockMvc.perform(get("/users/uniquegreeting?name=Jorge"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Jorge!"));
    }

    @Test
    void testTimeGreeting() throws Exception{
        DateFormat mockDateFormat = Mockito.mock(DateFormat.class);

        Mockito.when(mockDateFormat.format(Mockito.any(Date.class))).thenReturn("11"); // Mockea la hora para AM
        mockMvc.perform(get("/users/timegreeting"))
                .andExpect(status().isOk())
                .andExpect(content().string("Good morning, Jorge!"));

        Mockito.when(mockDateFormat.format(Mockito.any(Date.class))).thenReturn("13"); // Mockea la hora para AM
        mockMvc.perform(get("/users/timegreeting"))
                .andExpect(status().isOk())
                .andExpect(content().string("Good afternoon, Jorge!"));
    }

}