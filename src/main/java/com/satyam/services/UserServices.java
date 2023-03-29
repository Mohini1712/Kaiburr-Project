package com.satyam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyam.dao.UserRepository;
import com.satyam.entity.User;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userrepo;
	
	
	public List<User> getAllUsers()
	{
		List<User> list =(List<User>)this.userrepo.findAll();
		return list;
		
		
	}
	
		//get user by id
		public User getUserById(int id)
		
		{
			User user= null;
			try {
				
				
		//	user= list.stream().filter(e->e.getId()==id).findFirst().get();
			this.userrepo.findById(id);
			
			}catch (Exception e) {

	           e.printStackTrace();  
			}
			return user;
		}
		
		
		//adding user
		public User addUser(User b)
		{
			User result = (User) userrepo.save(b);
			return result;
		}
	
		
	
		//delete user
	public void deleteBook(int bid)
{
		
	     userrepo.deleteById(bid);
		
		
			
	}
		
		//update 
		public void updateBook(User user ,int user_id)
	{
			
			
		user.setId(user_id);
		userrepo.save(user);
	
				
		}
	
	

}
