package com.crio.jukebox.commands;

import java.util.List;

import com.crio.jukebox.entities.Greeting;
import com.crio.jukebox.services.GreetingService;

public class ListGreetingCommand implements ICommand{
    
    private final GreetingService greetingService; 

    public ListGreetingCommand(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<Greeting> glist = greetingService.getAllGreetings();
        System.out.println(glist);
    }

}

