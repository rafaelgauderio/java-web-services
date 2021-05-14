package br.com.delucahigiene.webservices.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.delucahigiene.webservices.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {	
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User user = new User(1L, "Rafael", "rafael@gmaill", "999929292", "123456");
		return ResponseEntity.ok().body(user);
		
	}
	
}
