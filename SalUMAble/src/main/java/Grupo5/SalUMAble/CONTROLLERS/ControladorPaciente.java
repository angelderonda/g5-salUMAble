package Grupo5.SalUMAble.CONTROLLERS;

import Grupo5.SalUMAble.MODEL.*;
import Grupo5.SalUMAble.SERVICE.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorPaciente {
	@Autowired
	UserService userService;

	
	@RequestMapping("/paciente/estado/{pos}")
	public String verPosicionCola(@PathVariable("pos") Integer pos,Model model) {
		model.addAttribute("pos", pos+1);
		return "paciente/verPosCola";
	}
	
	@RequestMapping("/paciente/tratamiento/{tratamiento}")
	public String verTratamiento(@PathVariable("tratamiento")String trat,Model model) {
		model.addAttribute("trat", trat);
		return "paciente/verTratamiento";
	}
	
	@RequestMapping("/paciente/infodoc/{id}")
	public String verInfoDoctor(@PathVariable("id") String username,Model model) {
		Optional<Usuario> paciente = userService.getByUsername(username);
		UsuarioPaciente p = (UsuarioPaciente) paciente.get();
		UsuarioDoctor d = p.getDoctorAsignado();
		model.addAttribute("nombreDoctor", p.getDoctorAsignado().getNombre());
		model.addAttribute("apellidosDoctor", p.getDoctorAsignado().getApellidos());
		model.addAttribute("salaDoctor", p.getDoctorAsignado().getSala());
		return "paciente/verInfoDoctor";
	}
	
	
}
