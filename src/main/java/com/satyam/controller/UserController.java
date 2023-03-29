package com.satyam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.satyam.entity.User;
import com.satyam.services.UserServices;

@Controller
public class UserController {
	
	
	@Autowired
	private UserServices userService;
	
	
	//get all users
		@GetMapping("/users")
		public ResponseEntity<List<User>>  getUsers()
		{
			
			
		     List <User> list =userService.getAllUsers();
		    if(list.size()<=0)
		    {
		    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		    }
		    
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
		
		//single user
		@GetMapping("/users/{id}")
		public ResponseEntity<User> getBook(@PathVariable("id") int id) 
		{
			User user = this.userService.getUserById(id);
			if(user == null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(user)); 
		}
		
		
		//post single book
		@PostMapping("/users")
		public ResponseEntity<User> addBook(@RequestBody User user)
		{
			User b= null;
			try {
				b= this.userService.addUser(user);
				return ResponseEntity.status(HttpStatus.CREATED).build();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		
		}
		
		//delete user
		@DeleteMapping("/users/{user_id}")
		public ResponseEntity<Void> deleteBook(@PathVariable("user_id") int uid)
		{
			
			try {
				 this.userService.deleteBook(uid);
				 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		
		//update user 
		@PutMapping("/users/{user_id}")
		public ResponseEntity<User> updateBook(@RequestBody User user, @PathVariable("user_id") int userId)
		{
			
			try {
				this.userService.updateBook(user,userId);
				 return ResponseEntity.ok().body(user);
				 
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			 
		}

	
	
}
