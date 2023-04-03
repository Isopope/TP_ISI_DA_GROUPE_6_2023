package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Comptes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comptes {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String compte_numero;
	private String type_compte;
    private LocalDate date_creation;
    private double solde_compte;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients proprietaire;

}
