package com.crio.jukebox.services;

import java.util.List;

import com.crio.jukebox.entities.Greeting;
import com.crio.jukebox.repositories.IGreetingRepository;

public class GreetingService{

    private final IGreetingRepository greetingRepository;

    public GreetingService(IGreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }
    
    public Greeting create(String message){
        Greeting g = new Greeting(message);
        return greetingRepository.save(g);
    }

    public List<Greeting> getAllGreetings(){
        return greetingRepository.findAll();
    }

    public Greeting getGreeting(Long id) {
        return greetingRepository.findById(id).orElseThrow(() -> new RuntimeException("Greeting with id: " + id + " not found!"));
    }

}
