package org.learning.demo.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private final String RESULT = "Hello, users!";
    private final String NAME = "Hello, Jorge!";
    private final String TIME1 = "Good morning, Jorge!";
    private final String TIME2 = "Good afternoon, Jorge!";

    @Mock
    GreetingService greetingService;

    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(greetingService);
    }

    @Test
    public void messageTest() {
        when(greetingService.getGreeting()).thenReturn(RESULT);
        assertEquals("Hello, users!", userService.message(), "El mensaje debe ser" + RESULT);
        verify(greetingService).getGreeting();
    }

    @Test
    public void messageUniqueTest() {
        when(greetingService.getUniqueGreeting(NAME)).thenReturn(NAME);
        assertEquals("Hello, Jorge!", userService.uniqueGreeting(NAME), "The result should be 'Hello, Jorge!'");
        verify(greetingService).getUniqueGreeting(NAME);
    }

    @Test
    public void messageTimeTest() {
        when(greetingService.getTimeGreeting(NAME)).thenReturn(TIME1);
        assertEquals("Good morning, Jorge!", userService.getTimeGreeting(NAME), "The result should be 'Good morning, Jorge!");
        verify(greetingService).getTimeGreeting(NAME);
    }

    @Test
    public void messageTimeTest2() {
        when(greetingService.getTimeGreeting(NAME)).thenReturn(TIME2);
        assertEquals("Good afternoon, Jorge!", userService.getTimeGreeting(NAME), "The result should be 'Good afternoon, Jorge!");
        verify(greetingService).getTimeGreeting(NAME);
    }

}