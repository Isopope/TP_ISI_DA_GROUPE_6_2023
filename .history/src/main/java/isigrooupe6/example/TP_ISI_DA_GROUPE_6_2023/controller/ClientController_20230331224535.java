package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Services.ClientsService;
import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model.Clients;

public class ClientController {
    @Autowired
    ClientsService cs;

    @PostMapping("clients")
    public Clients saveClients(@RequestBody Clients clients) {
        return cs.saveClients(clients);
    }

    @PutMapping("clients/{id}")
    public Clients updateEmployee(@PathVariable Integer id, @RequestBody Clients clients) {
        clients.setId(id);
        return cs.saveClients(clients);
    }
}
