package Grupo5.SalUMAble.CONTROLLERS;

import Grupo5.SalUMAble.MODEL.*;
import Grupo5.SalUMAble.SERVICE.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorDoctor {
	@Autowired
	UserService userService;

	

	@PostMapping("/doctor/liberarPaciente/{id}") 
	public String liberarPaciente(@PathVariable("id") Integer id, Model model) {
		
		UsuarioDoctor d = UsuarioAdministrador.getDoctor(id);		
		UsuarioPaciente p = d.getPacienteActual();
		
		d.liberarPaciente();
				
		userService.save(d);
		userService.save(p);
	
		
		return "redirect:/doctor";
	}
	
	
	
	@PostMapping("/doctor/liberarConsulta/{id}") 
	public String liberarConsulta(@PathVariable("id") Integer id, Model model) {
		
		UsuarioDoctor d = UsuarioAdministrador.getDoctor(id);		
	
		d.liberarConsulta();
				
		userService.save(d);
	
		
		return "redirect:/doctor";
	}
	
	@RequestMapping("/doctor/asignarTratamiento/{id}")
	public String asignarTratamiento(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("idDoctor", userService.getById(id).getId());
		model.addAttribute("tratamiento", new String());
		return "doctor/asignarTratamiento";
	}
	
	@RequestMapping("/doctor/asignarTrat/{idDoctor}") 
	public String tratamiento(@RequestParam(value = "tratamiento", required = true) String tratamiento,
			@PathVariable("idDoctor") int idDoctor) {
		
		UsuarioDoctor d = UsuarioAdministrador.getDoctor(idDoctor);		
	
		d.setTratamiento(tratamiento);
		UsuarioPaciente p = d.getPacienteActual();
		
		userService.save(p);
		userService.save(d);
	
		
		return "redirect:/doctor";
	}
	
}
