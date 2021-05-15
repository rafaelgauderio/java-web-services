package br.com.delucahigiene.webservices.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.delucahigiene.webservices.entities.User;
import br.com.delucahigiene.webservices.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null,"Rafael De Luca", "rafael@gmail.com","99999999","123456");
		User u2 = new User(null,"Joana da Silva", "joana@gmail.com","99999988","123456");
		User u3 = new User(null,"Felix da Silva", "felix@gmail.com","96999988","123456");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
	}

}
