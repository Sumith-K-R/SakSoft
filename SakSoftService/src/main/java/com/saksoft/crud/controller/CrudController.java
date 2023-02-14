package com.saksoft.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saksoft.crud.Service.CrudService;
import com.saksoft.crud.entity.User;
import com.saksoft.crud.model.UserNotFoundException;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Validated
@RestController
public class CrudController {

	@Autowired
	CrudService service;
	
	@PostMapping("/add")
	public ResponseEntity<Object> accept(@Valid @RequestBody User user){
		
		log.info("Inside /add");
		this.service.saveUser(user);
		
		return new ResponseEntity<Object>(user, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/addAll")
	public ResponseEntity<Object> saveAll(@Valid @RequestBody List<User> user){
		
		log.info("Inside addAll");
		this.service.saveAll(user);
		
		return new ResponseEntity<Object>(user, HttpStatus.CREATED);
		
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> get(@PathVariable Long id){
		
		log.info("Inside get");
		User user = this.service.get(id);
		
		return new ResponseEntity<Object>(user, HttpStatus.OK);
		
	}
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAll(){
		
		log.info("Inside getAll");
		List<User> user = this.service.getAll();
		
		return new ResponseEntity<Object>(user, HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) throws UserNotFoundException{
		
		log.info("Inside delete");
		boolean delete = this.service.delete(id);
		if(!delete)
			throw new UserNotFoundException("User Not FOund");
		
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteAll")
	public ResponseEntity<Object> deleteAll(){
		
		log.info("Inside deleteAll");
		this.service.deleteAll();
		
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@Valid @RequestBody User user) throws UserNotFoundException{
		
		log.info("Inside /update");
		boolean update = this.service.update(user);
		if(!update)
			throw new UserNotFoundException("User Not FOund");
		
		return new ResponseEntity<Object>(user, HttpStatus.OK);
		
	}
}
