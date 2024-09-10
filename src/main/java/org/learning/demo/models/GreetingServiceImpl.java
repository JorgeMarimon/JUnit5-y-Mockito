package org.learning.demo.models;

import org.learning.demo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;

@Service
public class GreetingServiceImpl implements GreetingService {

    private final DateFormat dateFormat;
    private final Date date;

    @Autowired
    public GreetingServiceImpl(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
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
        double now = Double.parseDouble(dateFormat.format(date));
        if (now < 12.00) {
            return "Good morning, " + name + "!";
        } else {
            return "Good afternoon, " + name + "!";
        }
    }
}
