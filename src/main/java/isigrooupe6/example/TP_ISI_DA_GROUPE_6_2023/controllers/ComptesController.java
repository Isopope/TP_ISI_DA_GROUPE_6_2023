package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.controllers;

import java.util.List;

import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Repositories.ComptesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Services.ComptesService;
import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model.Comptes;

@RestController
public class ComptesController {
    @Autowired
    ComptesService cs;
    @Autowired
    ComptesRepository cr;

    @PostMapping("/ajouterComptes")
    public Comptes saveCompte(@RequestBody  Comptes comptes){
        return cs.saveComptes(comptes);

    }

    @GetMapping("/listeComptes")
    public List<Comptes> showComptes(){
        return cs.showComptes();
    }

    @DeleteMapping("/deleteComptes/{id}")
    public void deleteComptes(@PathVariable Integer id){
        cs.deleteComptes(id);
    }

    @PutMapping("updateComptes/{id}")
    public Comptes updateComptes(@PathVariable Integer id, @RequestBody Comptes comptes){
        comptes.setId(id);
        return cs.updateComptes(id, comptes).getBody();
    }
    @PutMapping("versementComptes/{id}")
    public Comptes versementComptes(@PathVariable Integer id,@RequestBody Comptes comptes){
        comptes.setId(id);
        return cs.versementMontant(id,comptes).getBody();
    }

    @PutMapping("retraitComptes/{id}")
    public Comptes retraitComptes(@PathVariable Integer id,@RequestBody Comptes comptes){
        comptes.setId(id);
        return cs.retraitMontant(id,comptes).getBody();
    }
    @PutMapping("virementComptes")
    public void virementComptes(@RequestParam("source") int source, @RequestParam("destination") int destination, @RequestParam("montant") double montant){
       cs.virementComptes(source, destination, montant);
    }


}
