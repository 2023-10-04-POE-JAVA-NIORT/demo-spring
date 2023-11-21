package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class PersonneController {

    List<Personne> personnes = new ArrayList<>();

    @GetMapping("personnes")
    public List<Personne> getPersonnes(){

        return personnes;
    }

    @PostMapping("personnes")
    public Personne addPersonne(@RequestBody Personne newPersonne){
        System.out.println(newPersonne);
        personnes.add(newPersonne);
        return newPersonne;
    }
}
