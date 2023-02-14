package com.saksoft.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saksoft.crud.entity.User;

@Repository
public interface CrudRepo extends JpaRepository<User, Long>{

}
