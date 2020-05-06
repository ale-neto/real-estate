package com.app.imobi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.imobi.model.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

	Users findByLogin(String login);
	
}
