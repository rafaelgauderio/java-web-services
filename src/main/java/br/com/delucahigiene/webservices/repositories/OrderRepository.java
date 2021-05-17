package br.com.delucahigiene.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delucahigiene.webservices.entities.Order;


public interface OrderRepository extends JpaRepository<Order,Long> {
	
	

}
