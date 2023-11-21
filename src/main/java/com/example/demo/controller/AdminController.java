package com.example.demo.controller;

import com.example.demo.service.AnnuairePersonneService;
import com.example.demo.modele.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AnnuairePersonneService annuairePersonneService;

    @GetMapping("personnes")
    public List<Personne> getPersonnes(){
        return annuairePersonneService.getPersonnes();
    }
}
