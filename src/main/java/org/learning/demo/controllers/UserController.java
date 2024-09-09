package org.learning.demo.controllers;

import org.learning.demo.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final String name = "Jorge";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/greeting")
    public String getGreeting(){
        return userService.message();
    }

    @GetMapping("/uniquegreeting")
    public String getUniqueGreeting(){
        return userService.uniqueGreeting(name);
    }

    @GetMapping("/timegreeting")
    public String getTimeGreeting(){
        return userService.getTimeGreeting(name);
    }
}
