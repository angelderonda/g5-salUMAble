package Grupo5.SalUMAble.CONTROLLERS;

import Grupo5.SalUMAble.MODEL.*;
import Grupo5.SalUMAble.SERVICE.UserService;


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
		model.addAttribute("pos", pos);
		return "paciente/verPosCola";
	}
	
	@RequestMapping("/paciente/tratamiento/{tratamiento}")
	public String verTratamiento(@PathVariable("tratamiento")String trat,Model model) {
		model.addAttribute("trat", trat);
		return "paciente/verTratamiento";
	}
	
	
}
