package br.com.delucahigiene.webservices.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.delucahigiene.webservices.entities.Product;


public interface ProductRepository extends JpaRepository<Product,Long> {
	
	

}
