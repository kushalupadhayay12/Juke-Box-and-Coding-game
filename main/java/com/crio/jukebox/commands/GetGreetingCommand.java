package com.crio.jukebox.commands;

import java.util.List;

import com.crio.jukebox.entities.Greeting;
import com.crio.jukebox.services.GreetingService;

public class GetGreetingCommand implements ICommand{
    
    private final GreetingService greetingService; 

    public GetGreetingCommand(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long id = Long.parseLong(tokens.get(1));
        try {
            Greeting getGreet = greetingService.getGreeting(id);
            System.out.println(getGreet);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
