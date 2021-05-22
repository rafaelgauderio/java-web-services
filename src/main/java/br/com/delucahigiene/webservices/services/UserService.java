package br.com.delucahigiene.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.delucahigiene.webservices.entities.User;
import br.com.delucahigiene.webservices.repositories.UserRepository;
import br.com.delucahigiene.webservices.services.exception.DatabaseException;
import br.com.delucahigiene.webservices.services.exception.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} 
		catch (EmptyResultDataAccessException error) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException error){
			throw new DatabaseException(error.getMessage());
		}
	}
	
	
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setphone(obj.getphone());
	}
	

	
	

}
