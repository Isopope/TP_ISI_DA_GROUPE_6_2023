package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Services;

import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Repositories.ClientsRepository;
import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service

public class ClientsService {
    @Autowired
    ClientsRepository cr;

    public List<Clients> showClients(){

        return cr.findAll();
    }

    public Clients saveClients(Clients clients){

        return cr.save(clients);
<<<<<<< HEAD
    }
    
    public ResponseEntity<Clients> updateClients(@PathVariable Integer id, @RequestBody Clients newClient){
        Optional<Clients> clients = cr.findById(id);
        if (!clients.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Clients oldClients = clients.get();
        oldClients.setNom(newClient.getNom());
        oldClients.setPrenom(newClient.getPrenom());
        oldClients.setSexe(newClient.getSexe());
        oldClients.setAdresse(newClient.getAdresse());
        oldClients.setTelephone(newClient.getTelephone());
        oldClients.setCourriel(newClient.getCourriel());
        oldClients.setNationalite(newClient.getNationalite());
        oldClients.setDate_naissance(newClient.getDate_naissance());
        
        Clients updateClient = cr.save(oldClients);

        return ResponseEntity.ok(updateClient);
=======
>>>>>>> humbert
    }

    public void deleteClients(Integer id){
        cr.deleteById(id);
    }

    public Clients findOneClients(Integer id){

        return cr.findById(id).get();
    }
}
