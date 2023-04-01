package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Services;

import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Repositories.ClientsRepository;
import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ClientsService {
    @Autowired
    ClientsRepository cr;

    public List<Clients> showClients(){

        return null;
    }

    public Clients saveClients(Clients clients){

        return clients;
    }

    public void deleteClients(Integer id){


    }

    public Clients findOneClients(Integer id){

        return null;
    }
}
