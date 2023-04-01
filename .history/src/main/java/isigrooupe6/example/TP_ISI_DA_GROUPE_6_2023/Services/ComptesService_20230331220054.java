package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Services;

import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Repositories.ComptesRepository;
import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model.Comptes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComptesService {
    @Autowired
    ComptesRepository cr;

    public List<Comptes> showComptes(){

        return null;
    }

    public Comptes saveComptes(Comptes comptes){

        return comptes;
    }

    public void deleteComptes(Integer id){

    }

    public Comptes findOneComptes(Integer id){

        return null;
    }
}
