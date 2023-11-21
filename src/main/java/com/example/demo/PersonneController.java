package com.example.demo;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class PersonneController {

    @Autowired
    AnnuairePersonneService annuairePersonneService;


    @GetMapping("personnes")
    public List<Personne> getPersonnes(){

        return annuairePersonneService.getPersonnes();
    }

    @PostMapping("personnes")
    public Personne addPersonne(@RequestBody Personne newPersonne){
        annuairePersonneService.addPersonne(newPersonne);
        return newPersonne;
    }

    @GetMapping("personnes/{id}")
    public Personne getPersonne(@PathVariable("id") Integer id){
        for(Personne p : annuairePersonneService.getPersonnes()){
            if(p.getId().equals(id))
                return p;
        }
        return null;
    }

    @PutMapping("personnes/{id}")
    public void updatePersonne(@RequestBody Personne newData, @PathVariable("id") Integer id){
        int index = 0;
        while(index < annuairePersonneService.getPersonnes().size() && !annuairePersonneService.getPersonnes().get(index).getId().equals(id))
            index++;
        if(index < annuairePersonneService.getPersonnes().size())
            annuairePersonneService.getPersonnes().set(index,newData);
    }

    @DeleteMapping("personnes/{id}")
    public void delete(@PathVariable("id") Integer id){
        int index = 0;
        while(index < annuairePersonneService.getPersonnes().size() && !annuairePersonneService.getPersonnes().get(index).getId().equals(id))
            index++;
        if(index < annuairePersonneService.getPersonnes().size())
            annuairePersonneService.getPersonnes().remove(index);
    }
}
