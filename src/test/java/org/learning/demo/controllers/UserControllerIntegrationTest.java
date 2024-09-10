package org.learning.demo.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Clock clock;

    @Test
    void testGreeting() throws Exception {
        mockMvc.perform(get("/users/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, users!"));
    }

    @Test
    void testUniqueGreeting() throws Exception {
        mockMvc.perform(get("/users/uniquegreeting?name=Jorge"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Jorge!"));
    }

    void testTimeGreeting() throws Exception {
        Instant instant = ZonedDateTime.of(LocalDateTime.of(2024, 9, 9, 0, 0),
                ZoneId.systemDefault()).toInstant();
        when(clock.instant()).thenReturn(instant);
        when(clock.getZone()).thenReturn(ZoneId.systemDefault());

        mockMvc.perform(get("/users/timegreeting?name=Jorge"))
                .andExpect(status().isOk())
                .andExpect(content().string("Good morning, Jorge!"));

        instant = ZonedDateTime.of(LocalDateTime.of(2024, 9, 9, 12, 0),
                ZoneId.systemDefault()).toInstant();
        when(clock.instant()).thenReturn(instant);

        mockMvc.perform(get("/users/timegreeting?name=Jorge"))
                .andExpect(status().isOk())
                .andExpect(content().string("Good afternoon, Jorge!"));
    }
}