package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.controllers;

import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Services.ClientsService;
import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/Clients")
public class ClientsController {
    @Autowired
    ClientsService cs;

    @PostMapping("/ajouterClients")
    //@ResponseBody
    public Clients saveClients(@RequestBody  Clients client){
        return cs.saveClients(client);

    }

    @GetMapping("/listeClients")
    //@ResponseBody
    public List<Clients> showClients(){
        return cs.showClients();
    }

    @DeleteMapping("/deleteClients/{id}")
    //@ResponseBody
    public void deleteClients(@PathVariable Integer id){
        cs.deleteClients(id);
    }

    @PutMapping("updateClients/{id}")
    //@ResponseBody
    public Clients updateClients(@PathVariable Integer id, @RequestBody Clients clients){
        clients.setId(id);
        return cs.saveClients(clients);
    }
}
