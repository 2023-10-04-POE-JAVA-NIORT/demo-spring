package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnuairePersonneService {

    private List<Personne> personnes = new ArrayList<>();
    private int idCount = 0;

    public void addPersonne(Personne newPersonne){

        idCount++;
        newPersonne.setId(idCount);
        personnes.add(newPersonne);
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }
}
