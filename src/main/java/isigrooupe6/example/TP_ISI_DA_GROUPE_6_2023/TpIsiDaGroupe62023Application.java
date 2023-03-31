package isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023;

import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.Repositories.ClientsRepository;
import isigrooupe6.example.TP_ISI_DA_GROUPE_6_2023.model.Clients;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TpIsiDaGroupe62023Application {
	@Autowired
	ClientsRepository cr;

	public static void main(String[] args) {
		SpringApplication.run(TpIsiDaGroupe62023Application.class, args);
	}
	/*@Bean
	public CommandLineRunner start(){
		return args -> {
			cr.save(new Clients(1,"agoe","bp235","masculin","togolais","nkouba","humbert","masculin",LocalDate.of(2002,03,25)));
			cr.save(new Clients(2,"minamadou","bp235","masculin","togolais","nkouba","humbert","masculin",LocalDate.of(2002,03,25)));
			//cr.deleteById(1);



		};
	}*/

}
