package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model;

import java.time.LocalDate;

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
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
    @GeneratedValue(strategy=GenerationType.IDENTITY)
>>>>>>> humbert
    private int id;
    private String compte_numero;
	private String type_compte;
    private LocalDate date_creation;
    private double solde_compte;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients proprietaire;

}
