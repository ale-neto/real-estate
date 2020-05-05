package com.app.imobi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.imobi.model.Proprietor;

public interface ProprietorRepository extends JpaRepository<Proprietor, String> {
	Proprietor findById(long id);
}
