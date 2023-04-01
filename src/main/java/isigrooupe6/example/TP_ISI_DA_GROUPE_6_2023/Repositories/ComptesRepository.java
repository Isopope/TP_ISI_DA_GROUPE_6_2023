package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Repositories;

import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model.Comptes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ComptesRepository extends JpaRepository<Comptes,Integer> {
}
