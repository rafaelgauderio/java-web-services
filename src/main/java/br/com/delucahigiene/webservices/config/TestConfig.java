package br.com.delucahigiene.webservices.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.delucahigiene.webservices.entities.Order;
import br.com.delucahigiene.webservices.entities.User;
import br.com.delucahigiene.webservices.entities.enums.OrderStatus;
import br.com.delucahigiene.webservices.repositories.OrderRepository;
import br.com.delucahigiene.webservices.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null,"Rafael De Luca", "rafael@gmail.com","99999999","123456");
		User u2 = new User(null,"Joana da Silva", "joana@gmail.com","99999988","123456");
		User u3 = new User(null,"Felix da Silva", "felix@gmail.com","96999988","123456");
		
		Order o1 = new Order(null, Instant.parse("2020-06-25T20:54:07Z"), OrderStatus.DELIVERED, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PACKING, u2);
		Order o3 = new Order(null, Instant.parse("2021-07-22T14:21:22Z"), OrderStatus.WAITING_PAYMENT, u3);
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}

}
