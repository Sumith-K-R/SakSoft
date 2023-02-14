package com.saksoft.crud.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.saksoft.crud.entity.User;
import com.saksoft.crud.model.UserNotFoundException;
import com.saksoft.crud.repo.CrudRepo;

@Service
@Transactional
public class CrudService {

	@Autowired
	CrudRepo repo;
	
	public void saveUser(User user) {
		this.repo.save(user);
	}

	public void saveAll(@Valid List<User> user) {
		repo.saveAll(user);
	}
	
	public User get(Long id) {
		 Optional<User> findById = this.repo.findById(id);
		 return findById.get();
	}
	
	public List<User> getAll() {
		return this.repo.findAll();
	}
	public boolean update(User user) {

		
		 Optional<User> findById = this.repo.findById(user.getId());
		 if(findById.isPresent()) {
			 this.repo.save(user);
			 return true;
		 }else {
			 return false;
		 }
		 
	}
	public boolean delete(Long id) {
		Optional<User> findById = this.repo.findById(id);
		if(findById.isPresent()) {
			 this.repo.deleteById(id);
			 return true;
		 }
		else
			return false;
	}
	public void deleteAll() {
		 this.repo.deleteAll();
	}
	
	
}
