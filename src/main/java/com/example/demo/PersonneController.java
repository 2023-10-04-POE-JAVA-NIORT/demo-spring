package com.example.demo;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class PersonneController {

    List<Personne> personnes = new ArrayList<>();
    int idCount = 0;

    @GetMapping("personnes")
    public List<Personne> getPersonnes(){

        return personnes;
    }

    @PostMapping("personnes")
    public Personne addPersonne(@RequestBody Personne newPersonne){
        idCount++;
        newPersonne.setId(idCount);
        personnes.add(newPersonne);
        return newPersonne;
    }

    @GetMapping("personnes/{id}")
    public Personne getPersonne(@PathVariable("id") Integer id){
        for(Personne p : personnes){
            if(p.getId().equals(id))
                return p;
        }
        return null;
    }
}
