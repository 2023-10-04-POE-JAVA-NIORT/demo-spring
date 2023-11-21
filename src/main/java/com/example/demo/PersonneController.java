package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class PersonneController {

    @GetMapping("personnes")
    public List<Personne> sayHello(){

        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne("Alain", "Delon"));
        personnes.add(new Personne("Steve", "Mac Queen"));
        return personnes;
    }
}
