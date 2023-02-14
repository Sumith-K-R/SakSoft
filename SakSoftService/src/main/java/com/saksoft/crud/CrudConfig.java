package com.saksoft.crud;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.saksoft.crud.entity.User;
import com.saksoft.crud.repo.CrudRepo;

@Configuration
public class CrudConfig {

	@Autowired
	CrudRepo repo;
	@PostConstruct
	public void insertDefaultUser() {
		List<User> lstuser= Arrays.asList(new User(1L,"Raj","Verma","raj.verma@imagine.com",35),
				new User(2L,"Vaibhav","Telang","v.telang@futureready.com",29),
				new User(3L,"Ketan","Bahadur","k.bahadur@infonext.com",32),
				new User(4L,"Abhishek","Raj","abhi.raj@softsol.com",30));
		repo.saveAll(lstuser);
	}
}
