package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Persona;
import com.example.demo.repo.IPersonaRepo;


@Controller
public class DemoController {

	@Autowired
	private IPersonaRepo repo;
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
		Persona persona = new Persona();
		persona.setIdPersona(1);
		persona.setNombre("Bellicose");
		repo.save(persona);
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/listar")
	public String greeting(Model model){
		ArrayList<Persona> personas = (ArrayList<Persona>) repo.findAll();
		model.addAttribute("personas", personas);
		return "greeting";
	}
}
