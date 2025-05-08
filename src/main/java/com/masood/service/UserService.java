package com.masood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masood.model.User;
import com.masood.repository.userRepository;
@Service("us")
public class UserService implements UserServiceInterface
{
	@Autowired
	private userRepository ur;
	
	public User saveUser(User user) 
	{
		return ur.save(user);
	}

	public List<User> getAllUser() 
	{
		
		return ur.findAll();
	}

	public User getUsergetId(Long id)
	{
		Optional<User> optional=ur.findById(id);
		return optional.orElse(null);
	}

	public void deletebyId(Long id)
	{
		ur.deleteById(id);
	}

}
