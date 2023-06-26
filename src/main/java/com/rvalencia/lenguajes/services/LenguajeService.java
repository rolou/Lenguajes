package com.rvalencia.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rvalencia.lenguajes.models.Lenguaje;
import com.rvalencia.lenguajes.repositories.LenguajeRepo;

@Service
public class LenguajeService {


	private final LenguajeRepo lenguajeRepo;
	
	public LenguajeService(LenguajeRepo lenguajeRepo) {
		this.lenguajeRepo = lenguajeRepo;
	}
	
	public List<Lenguaje> findAll() {
		return lenguajeRepo.findAll();
	}
	
	public void create(Lenguaje lenguaje){
		lenguajeRepo.save(lenguaje);
	}
	
	public void deleteLenguaje(Long id) {
		lenguajeRepo.deleteById(id);
	}
	
	public Lenguaje findById(Long id) {
		Optional<Lenguaje> optionalLenguaje = lenguajeRepo.findById(id);
		if (optionalLenguaje.isPresent()) {
			return optionalLenguaje.get();
		} else {
			return null;
		}
	}
	
	public List<Lenguaje> findAllByCreador(String creador) {
		List<Lenguaje> lenguajes = lenguajeRepo.findAllByCreador(creador);
		if (lenguajes.isEmpty()) {
			return null;
		} else {
			return lenguajes;
		}
	}
}
