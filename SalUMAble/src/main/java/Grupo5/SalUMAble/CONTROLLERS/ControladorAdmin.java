package Grupo5.SalUMAble.CONTROLLERS;

import Grupo5.SalUMAble.MODEL.*;
import Grupo5.SalUMAble.SERVICE.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorAdmin {
	@Autowired
	UserService userService;

	@RequestMapping("/admin/registrar_paciente")
	public String registrar_paciente(Model model) {
		model.addAttribute("usuariopaciente", new UsuarioPaciente());
		return "admin/registrar_paciente";
	}

	@PostMapping("/admin/savePaciente")
	public String savePaciente(UsuarioPaciente p) {
		p.setUserName(p.getDNI());
		p.setPassword(p.getPassword());
		
		
		
		userService.save(p);
		
		
		return "redirect:/admin";
	}

	@RequestMapping("/admin/registrar_doctor")
	public String registrar_doctor(Model model) {
		model.addAttribute("usuariodoctor", new UsuarioDoctor());
		return "admin/registrar_doctor";
	}

	@PostMapping("/admin/saveDoctor")
	public String saveDoctor(UsuarioDoctor d) {
		d.setUserName(d.getDNI());
		d.setVisibilidad(d.isVisibilidad());
		userService.save(d);
		return "redirect:/admin";
	}

	@RequestMapping("/admin/asignar_doctor")
	public String asignar_doctor(Model model) {
		for (RamaMedica rama : RamaMedica.values()) {
			model.addAttribute(rama.toString(), UsuarioAdministrador.getListaDoctores(rama));
			model.addAttribute(rama.toString()+"vacia", UsuarioAdministrador.colaPacientesVacia(rama));
		}
		
		return "admin/asignar_doctor";
	}

	@PostMapping("/admin/asignar/{id}") 
	public String asignarDoctor(@PathVariable("id") Integer id, Model model) {
		
		String reply = "redirect:/admin";

		UsuarioDoctor d = UsuarioAdministrador.getDoctor(id);
		if(!UsuarioAdministrador.colaPacientesVacia(d.getRama())) {
			UsuarioPaciente p = UsuarioAdministrador.getMap().get(d.getRama()).obtenPaciente();
			UsuarioAdministrador.AsignarDoctor(d);
			userService.save(d);
			userService.save(p);
		}else {
			reply = "redirect:/admin/asignar_doctor";
		}

		return reply;
	}
}
