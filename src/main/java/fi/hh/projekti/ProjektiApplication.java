package fi.hh.projekti;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.projekti.domain.Projekti;
import fi.hh.projekti.domain.ProjektiRepository;
import fi.hh.projekti.domain.User;
import fi.hh.projekti.domain.UserRepository;


@SpringBootApplication
public class ProjektiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektiApplication.class, args);
	}

	// Commandline runner
	
	@Bean
	public CommandLineRunner demo(ProjektiRepository prepository, UserRepository urepository) {
		return(args) -> {

			
			prepository.save(new Projekti("Voita", "500 grammaa", "3,50 euroa"));
			prepository.save(new Projekti("Maitoa", "3 litraa", "2 euroa per tlk"));
			prepository.save(new Projekti("Leipää", "1 kpl", "3 euroa"));

			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			
		};
	}
	
}
