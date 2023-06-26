package com.rvalencia.lenguajes.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rvalencia.lenguajes.models.Lenguaje;
import com.rvalencia.lenguajes.services.LenguajeService;

import jakarta.validation.Valid;

@Controller
public class LenguajeController {

	private final LenguajeService lenguajeService;
	
	public LenguajeController(LenguajeService lenguajeService) {
		this.lenguajeService = lenguajeService;
	}
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Lenguaje> list = lenguajeService.findAll();
		model.addAttribute("list", list);
		return "dashboard.jsp";
	}
	
	@GetMapping("/lenguajes/new")
	public String formSong(@ModelAttribute("Lenguaje") Lenguaje lenguaje) {
		return "new.jsp";
	}
	
	@PostMapping("/dashboard")
	public String nuevLenguaje(
			@Valid 
			@ModelAttribute("Lenguaje") Lenguaje lenguaje, 
			BindingResult result
			) {
		if(result.hasErrors()) {
				return "new.jsp";
		}else {
			lenguajeService.create(lenguaje);
			return "redirect:/dashboard";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		lenguajeService.deleteLenguaje(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/lenguajes/{id}")
	public String showLenguajeDetail(
			@PathVariable("id") Long id,
			Model model
			) {
		Lenguaje lenguaje = lenguajeService.findById(id);
		if (lenguaje != null) {
			model.addAttribute("lenguaje", lenguaje);
			return "detail.jsp";
		} else {
			return "redirect:/dashboard";
		}
	}
	
}
