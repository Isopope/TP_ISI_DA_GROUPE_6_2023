package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Services;

import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Repositories.ComptesRepository;
import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model.Comptes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ComptesService {
    @Autowired
    ComptesRepository cr;

    //Méthode de génération aléatoire du numéro de compte
    public String generateUniqueRandomString(int length) {
        String randomString = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        return randomString.substring(0, length);
      }

    public List<Comptes> showComptes(){

        return null;
    }

    public Comptes saveComptes(Comptes comptes){
        String generated = generateUniqueRandomString(5);
        comptes.setCompte_numero(generated + LocalDate.now().getYear());

        return cr.save(comptes);
    }

    public void deleteComptes(Integer id){

    }

    public Comptes findOneComptes(Integer id){

        return null;
    }
}
