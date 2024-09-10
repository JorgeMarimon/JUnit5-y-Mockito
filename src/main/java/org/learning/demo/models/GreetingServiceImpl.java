package org.learning.demo.models;

import org.learning.demo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalTime;

@Service
public class GreetingServiceImpl implements GreetingService {

    //private final DateFormat dateFormat;
    //private final Date date;
    private final Clock clock;

    public GreetingServiceImpl(Clock clock) {
        this.clock = clock;
    }

    /*@Autowired
    public GreetingServiceImpl(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }*/

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
        //double now = Double.parseDouble(dateFormat.format(date));
        if (now.isBefore(LocalTime.NOON)) {
            return "Good morning, " + name + "!";
        } else {
            return "Good afternoon, " + name + "!";
        }
    }
}
