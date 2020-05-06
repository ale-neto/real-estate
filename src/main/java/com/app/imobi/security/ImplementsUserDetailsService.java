package com.app.imobi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.app.imobi.model.Users;
import com.app.imobi.repository.UsersRepository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		Users users =  usersRepository.findByLogin(login);
		if(users == null){
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		return users;
	}

}
