package com.example.demo.controller;

import com.example.demo.service.AnnuairePersonneService;
import com.example.demo.modele.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Stack;

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
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        int index = 0;
        while(index < annuairePersonneService.getPersonnes().size() && !annuairePersonneService.getPersonnes().get(index).getId().equals(id))
            index++;
        if(index < annuairePersonneService.getPersonnes().size()) {
            annuairePersonneService.getPersonnes().remove(index);
            return ResponseEntity.ok("OK");
        }
        else {
            return ResponseEntity.status(404).body("Id non trouvé");
        }
    }
}
