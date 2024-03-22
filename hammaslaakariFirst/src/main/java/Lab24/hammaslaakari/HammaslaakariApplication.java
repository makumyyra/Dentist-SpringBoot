package Lab24.hammaslaakari;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Lab24.hammaslaakari.model.Tooth;
import Lab24.hammaslaakari.model.ToothRepository;
import Lab24.hammaslaakari.model.AppUser;
import Lab24.hammaslaakari.model.AppUserRepository;

@SpringBootApplication
public class HammaslaakariApplication {

	public static void main(String[] args) {
		SpringApplication.run(HammaslaakariApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ToothRepository toothRepository,
			AppUserRepository appUserRepository) {

		return (args) -> {
			System.out.println("your teeth");

			toothRepository.save(new Tooth("rightUp1", false));
			toothRepository.save(new Tooth("rightUp2", false));
			toothRepository.save(new Tooth("rightUp3", false));
			toothRepository.save(new Tooth("leftUp1", false));
			toothRepository.save(new Tooth("leftUp2", false));
			toothRepository.save(new Tooth("leftUp3", false));
			toothRepository.save(new Tooth("rightDown1", false));
			toothRepository.save(new Tooth("rightDown2", false));
			toothRepository.save(new Tooth("rightDown3", false));
			toothRepository.save(new Tooth("leftDown1", false));
			toothRepository.save(new Tooth("leftDown2", false));
			toothRepository.save(new Tooth("leftDown3", false));

			for (Tooth tooth : toothRepository.findAll()) {
				System.out.println(tooth.toString());
			}

			// Create users: admin/admin user/user

			AppUser user1 = new AppUser("user",
					"$2a$10$To60L.aku8gdDn8iNUE9bez7SF3QoDzgISLpAIXjCfamCbIsZG7ti", "USER");
			AppUser user2 = new AppUser("admin",
					"$2a$10$swT1C0pA70rGpfQjjT1EH.rHrSc62aPwMmhFHFwtiLNn7qvEhPhW6",
					"ADMIN");
			appUserRepository.save(user1);
			appUserRepository.save(user2);

		};
	}

}
