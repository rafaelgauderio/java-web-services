package br.com.delucahigiene.webservices.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.delucahigiene.webservices.entities.Category;


public interface CategoryRepository extends JpaRepository<Category,Long> {
	
	

}
