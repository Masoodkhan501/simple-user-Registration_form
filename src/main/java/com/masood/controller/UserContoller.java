package com.masood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.masood.model.User;
import com.masood.service.UserService;

@Controller("uc")
public class UserContoller 
{
	@Autowired
	private UserService us;
	
	@GetMapping("/register/user")
	public String newUser(Model model)
	{
		User u = new User();
		model.addAttribute("user", u);
		return "index";
	}
	
	@PostMapping("/save/register")
	public String saveUser(@ModelAttribute("user") User u,Model model)
	{
		us.saveUser(u);
		model.addAttribute("user", u);
		return "redirect:/users";
	}
	
	@GetMapping("/users")
	public String userOperation(Model model)
	{
		List<User> allUsers = us.getAllUser();
		model.addAttribute("allusers", allUsers);
		return "users";
	}
	
	@GetMapping("/delete/user/{id}")
	public String deleteUser(@PathVariable Long id)
	{
		us.deletebyId(id);
		return "redirect:/users";
	}
	
	@GetMapping("/edit/user/{id}")
	public String editUser(@PathVariable Long id, Model model)
	{
		User u = us.getUsergetId(id);
		model.addAttribute("user", u);
		return  "redirect:/register/user";
	}
}
