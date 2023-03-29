package com.satyam.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.satyam.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findById(int id);
	

}
