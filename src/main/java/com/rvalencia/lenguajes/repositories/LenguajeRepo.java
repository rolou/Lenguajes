package com.rvalencia.lenguajes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rvalencia.lenguajes.models.Lenguaje;

@Repository
public interface LenguajeRepo extends CrudRepository<Lenguaje, Long>{
	
	List<Lenguaje> findAll();
	List<Lenguaje> findAllByCreador(String creador);
}
