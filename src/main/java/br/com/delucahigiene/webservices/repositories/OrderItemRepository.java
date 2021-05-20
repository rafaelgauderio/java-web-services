package br.com.delucahigiene.webservices.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.delucahigiene.webservices.entities.OrderItem;
import br.com.delucahigiene.webservices.entities.pk.OrderItemPK;


public interface OrderItemRepository extends JpaRepository<OrderItem,OrderItemPK> {
	
	

}
