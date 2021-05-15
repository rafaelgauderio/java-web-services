package br.com.delucahigiene.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delucahigiene.webservices.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	

}
