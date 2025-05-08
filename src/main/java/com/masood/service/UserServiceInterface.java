package com.masood.service;

import java.util.List;

import com.masood.model.User;

public interface UserServiceInterface 
{
	public User saveUser(User user);
	public List<User> getAllUser();
	public User getUsergetId(Long id);
	public void deletebyId(Long id);
}
