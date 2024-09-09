package org.learning.demo.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final GreetingService greetingService;

    public UserService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String message() {
        return greetingService.getGreeting();
    }

    public String uniqueGreeting(String name) {
        return greetingService.getUniqueGreeting(name);
    }

    public String getTimeGreeting(String name) {
        return greetingService.getTimeGreeting(name);
    }
}
