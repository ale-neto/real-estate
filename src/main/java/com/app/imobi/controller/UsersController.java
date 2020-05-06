package com.app.imobi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.imobi.model.Users;
import com.app.imobi.repository.UsersRepository;

@Controller
public class UsersController {

	@Autowired
	UsersRepository usersRepository;
	
	@RequestMapping(value="/login")
	public String login(){
		return "login/login";
	}
	
	@RequestMapping(value="/createUser", method=RequestMethod.GET)
	public String createUser(){
		return "login/create";
	}
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	public String createUser(Users users){
		users.setPasswordUser(new BCryptPasswordEncoder().encode(users.getPasswordUser()));
		usersRepository.save(users);
		return "redirect:/login";
	}
}
