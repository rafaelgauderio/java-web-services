package br.com.delucahigiene.webservices.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.delucahigiene.webservices.entities.Category;
import br.com.delucahigiene.webservices.entities.Order;
import br.com.delucahigiene.webservices.entities.Product;
import br.com.delucahigiene.webservices.entities.User;
import br.com.delucahigiene.webservices.entities.enums.OrderStatus;
import br.com.delucahigiene.webservices.repositories.CategoryRepository;
import br.com.delucahigiene.webservices.repositories.OrderRepository;
import br.com.delucahigiene.webservices.repositories.ProductRepository;
import br.com.delucahigiene.webservices.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Disposable");
		Category cat2 = new Category(null, "Sanitizers");
		Category cat3 = new Category(null, "Cosmetics");
		Category cat4 = new Category(null, "Doser");
		Category cat5 = new Category(null, "Thinners");
		
		Product p1 = new Product(null, "Liquid Soap fennel", "Liquid Soap  fragrance fennel - 5 liter gallon", 80.5, "");
		Product p2 = new Product(null, "Lavander Liquid Soap", "Lavander Fragrance Liquid Soap - 5 liter gallon", 90.0, "");
		Product p3 = new Product(null, "Alcohol gel","Alcohol gel - 800 ml refil" ,35.0, "");
		Product p4 = new Product(null, "Detergent","Hospital Detergent - 5 liter gallon", 200.0, "");
		Product p5 = new Product(null, "Dishwasher","Dishwasher Apple Fragrance - 5 liter gallon", 70.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

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
