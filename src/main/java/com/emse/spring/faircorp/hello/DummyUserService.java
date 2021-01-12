package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyUserService implements UserService {

    private final ConsoleGreetingService greeter;

    @Autowired
    public DummyUserService(ConsoleGreetingService greeter) {
        this.greeter = greeter;
    }

    public void greetAll() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("Elodie");
        nameList.add("Charles");

        for (int i = 0; i < nameList.size(); i++) {
            greeter.greet(nameList.get(i));
        }
        //greeter.greet("Elodie");
        //greeter.greet("Charles");
    }
}
