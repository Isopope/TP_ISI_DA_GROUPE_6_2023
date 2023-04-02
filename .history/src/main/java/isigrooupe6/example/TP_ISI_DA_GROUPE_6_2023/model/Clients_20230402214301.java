package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
//import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "Clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"comptes"})
public class Clients {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String adresse;
    private String telephone;
    private String courriel;
    private String nationalite;
    private LocalDate date_naissance;
    @OneToMany(mappedBy = "proprietaire")
   private List<Comptes> comptes;

}
