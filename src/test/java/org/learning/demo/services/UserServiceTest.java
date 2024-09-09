package org.learning.demo.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceTest {

    private final String RESULT = "Hello, users!";
    private final String NAME = "Hello, Jorge!";
    private final String TIME1 = "Good morning, Jorge!";
    private final String TIME2 = "Good afternoon, Jorge!";

    @Mock
    GreetingService greetingService;

    @InjectMocks
    UserService userService;

    @Test
    public void messageTest() {
        MockitoAnnotations.openMocks(this);
        when(greetingService.getGreeting()).thenReturn(RESULT);
        assertEquals("Hello, users!", userService.message(), "El mensaje debe ser" + RESULT);
    }

    @Test
    public void messageUniqueTest() {
        MockitoAnnotations.openMocks(this);
        when(greetingService.getUniqueGreeting(NAME)).thenReturn(NAME);
        assertEquals("Hello, Jorge!", userService.uniqueGreeting(NAME), "The result should be 'Hello, Jorge!'");
    }

    @Test
    public void messageTimeTest() {
        MockitoAnnotations.openMocks(this);
        when(greetingService.getTimeGreeting(NAME)).thenReturn(TIME1);
        assertEquals("Good morning, Jorge!", userService.getTimeGreeting(NAME), "The result should be 'Good morning, Jorge!");
    }

    @Test
    public void messageTimeTest2() {
        MockitoAnnotations.openMocks(this);
        when(greetingService.getTimeGreeting(NAME)).thenReturn(TIME2);
        assertEquals("Good afternoon, Jorge!", userService.getTimeGreeting(NAME), "The result should be 'Good afternoon, Jorge!");
    }

}