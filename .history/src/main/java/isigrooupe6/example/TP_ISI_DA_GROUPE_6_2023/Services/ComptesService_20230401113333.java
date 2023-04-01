package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Services;

import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Repositories.ComptesRepository;
import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model.Comptes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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
        comptes.setSolde_compte(0.0);

        return cr.save(comptes);
    }

    public ResponseEntity<Comptes> updateClients(@PathVariable Integer id, @RequestBody Comptes newComptes){
        Optional<Comptes> comptes = cr.findById(id);
        if (!comptes.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Comptes oldComptes = comptes.get();
    }
    public void deleteComptes(Integer id){

    }

    public Comptes findOneComptes(Integer id){

        return null;
    }
}
