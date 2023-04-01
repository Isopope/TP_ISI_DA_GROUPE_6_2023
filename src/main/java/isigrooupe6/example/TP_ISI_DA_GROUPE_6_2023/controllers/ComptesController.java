package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Services.ComptesService;
import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model.Comptes;

@RestController
public class ComptesController {
    @Autowired
    ComptesService cs;

    @PostMapping("/ajouterComptes")
    //@ResponseBody
    public Comptes saveCompte(@RequestBody  Comptes comptes){
        return cs.saveComptes(comptes);

    }

    @GetMapping("/listeComptes")
    //@ResponseBody
    public List<Comptes> showComptes(){
        return cs.showComptes();
    }

    @DeleteMapping("/deleteComptes/{id}")
    //@ResponseBody
    public void deleteComptes(@PathVariable Integer id){
        cs.deleteComptes(id);
    }

    @PutMapping("updateComptes/{id}")
    //@ResponseBody
    public Comptes updateComptes(@PathVariable Integer id, @RequestBody Comptes comptes){
        comptes.setId(id);
        return cs.saveComptes(comptes);
    }

}
