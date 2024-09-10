package org.learning.demo.models;

import org.learning.demo.services.GreetingService;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalTime;

@Service
public class GreetingServiceImpl implements GreetingService {

    private final Clock clock;

    public GreetingServiceImpl(Clock clock) {
        this.clock = clock;
    }

    @Override
    public String getGreeting() {
        return "Hello, users!";
    }

    @Override
    public String getUniqueGreeting(String name) {
        return "Hello, " + name + "!";
    }

    @Override
    public String getTimeGreeting(String name) {
        LocalTime now = LocalTime.now(clock);
        if (now.isBefore(LocalTime.NOON)) {
            return "Good morning, " + name + "!";
        } else {
            return "Good afternoon, " + name + "!";
        }
    }
}
