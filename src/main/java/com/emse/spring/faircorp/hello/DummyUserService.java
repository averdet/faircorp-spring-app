package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyUserService implements UserService{

    private ConsoleGreetingService greeter;

    @Autowired
    public DummyUserService(ConsoleGreetingService greeter){
        this.greeter = greeter;
    }
    public void greetAll() {
        greeter.greet("Elodie");
        greeter.greet("Charles");
    }
}
