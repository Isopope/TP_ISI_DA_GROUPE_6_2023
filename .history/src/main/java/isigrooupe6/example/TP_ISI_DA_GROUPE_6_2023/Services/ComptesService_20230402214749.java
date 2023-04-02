package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Services;

import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Repositories.ComptesRepository;
//import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model.Clients;
import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model.Comptes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;

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

        return cr.findAll();
    }

    public Comptes saveComptes(Comptes comptes){
        String generated = generateUniqueRandomString(5);
        comptes.setCompte_numero(generated + LocalDate.now().getYear());
        comptes.setSolde_compte(0.0);

        return cr.save(comptes);
    }
    public ResponseEntity<Comptes> versementMontant(@PathVariable Integer id, @RequestBody Comptes newComptes){
        Optional<Comptes> comptes = cr.findById(id);
        if (!comptes.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Comptes oldComptes = comptes.get();
        oldComptes.setSolde_compte(oldComptes.getSolde_compte()+ newComptes.getSolde_compte());

        Comptes versementMontant = cr.save(oldComptes);
        return ResponseEntity.ok(versementMontant);
    }

    public void virementComptes(int numero_source,int numero_destination,double montant){
        Comptes source= findOneComptes(numero_source);
        Comptes destination=findOneComptes(numero_destination);
        if(source==null || destination==null){
            ResponseEntity.badRequest().body("comptes inexistant.");

        }
        if(source.getSolde_compte()<montant){
            ResponseEntity.badRequest().body("Solde insuffisant.");
        }else{
            source.setSolde_compte(source.getSolde_compte()-montant);
            destination.setSolde_compte(destination.getSolde_compte()+montant);
            cr.save(source);
            cr.save(destination);
        }
        ResponseEntity.ok("oeration effectué avec succes");


    }

    public ResponseEntity<Comptes> retraitMontant(@PathVariable Integer id, @RequestBody Comptes newComptes){
        Optional<Comptes> comptes = cr.findById(id);
        if (!comptes.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Comptes oldComptes = comptes.get();
        double montant=newComptes.getSolde_compte();
        if(oldComptes.getSolde_compte()< montant|| montant<0.0){
            return ResponseEntity.notFound().build();
        }else{
            oldComptes.setSolde_compte(oldComptes.getSolde_compte()-newComptes.getSolde_compte());
            Comptes retraitMontant = cr.save(oldComptes);
            return ResponseEntity.ok(retraitMontant);
        }

    }
    public ResponseEntity<Comptes> updateComptes(@PathVariable Integer id, @RequestBody Comptes newComptes){
        Optional<Comptes> comptes = cr.findById(id);
        if (!comptes.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Comptes oldComptes = comptes.get();
        oldComptes.setType_compte(newComptes.getType_compte());
        oldComptes.setSolde_compte(newComptes.getSolde_compte());

        Comptes updateComptes = cr.save(oldComptes);
        return ResponseEntity.ok(updateComptes);
    }


    public void deleteComptes(Integer id){
        cr.deleteById(id);

    }

    public Comptes findOneComptes(Integer id){

        return cr.findById(id).get();
    }


}
