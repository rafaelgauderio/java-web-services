package br.com.delucahigiene.webservices.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.delucahigiene.webservices.entities.Category;
import br.com.delucahigiene.webservices.entities.Order;
import br.com.delucahigiene.webservices.entities.OrderItem;
import br.com.delucahigiene.webservices.entities.Payment;
import br.com.delucahigiene.webservices.entities.Product;
import br.com.delucahigiene.webservices.entities.User;
import br.com.delucahigiene.webservices.entities.enums.OrderStatus;
import br.com.delucahigiene.webservices.repositories.CategoryRepository;
import br.com.delucahigiene.webservices.repositories.OrderItemRepository;
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

	@Autowired
	private OrderItemRepository orderItemRepository;
	
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
		Product p6 = new Product(null, "Toilet Paper", "Interleaved Toilet Paper - Box with 50 bales", 150.80, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
		
		p1.getCategories().add(cat3);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat2);
		p4.getCategories().add(cat2);
		p5.getCategories().add(cat2);
		p6.getCategories().add(cat1);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));		
		

		User u1 = new User(null,"Rafael De Luca", "rafael@gmail.com","99999999","123456");
		User u2 = new User(null,"Joana da Silva", "joana@gmail.com","99999988","123456");
		User u3 = new User(null,"Felix da Silva", "felix@gmail.com","96999988","123456");
		
		Order o1 = new Order(null, Instant.parse("2020-06-25T20:54:07Z"), OrderStatus.DELIVERED, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PACKING, u2);
		Order o3 = new Order(null, Instant.parse("2021-03-22T14:21:22Z"), OrderStatus.WAITING_PAYMENT, u3);
		Order o4 = new Order(null, Instant.parse("2021-04-13T15:30:20Z"), OrderStatus.PAID, u1);
		
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		OrderItem oi5 = new OrderItem(o4,p6, 3, p6.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4,oi5));	
		
		Payment pay1 = new Payment(null, Instant.parse("2021-04-13T15:30:20Z"), o4);
		o4.setPayment(pay1);
		
		orderRepository.save(o4);		
		
		
	}

}
