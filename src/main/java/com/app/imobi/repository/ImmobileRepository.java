package com.app.imobi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.imobi.model.Immobile;
import com.app.imobi.model.Proprietor;

public interface ImmobileRepository extends JpaRepository<Immobile, String> {
	Iterable<Immobile> findByProprietor(Proprietor proprietor);
	Immobile findById(long id);
}
