package Grupo5.SalUMAble.CONTROLLERS;

import Grupo5.SalUMAble.MODEL.*;
import Grupo5.SalUMAble.SERVICE.UserService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ControladorAdmin{

	private UserService userService;
	
	@RequestMapping(value = "/admin/registrar_paciente", method = RequestMethod.GET)
	public ModelAndView registrar_paciente() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/registrar_paciente"); 
		modelAndView.addObject("UsuarioPaciente", new UsuarioPaciente());
		return modelAndView;
	}
	
	@PostMapping("@{/admin/registrar_paciente/save}")
	public String savePaciente(UsuarioPaciente p) {
		p.setUserName(p.getDNI());
		p.setPassword("paciente");
		userService.save(p);
		return "/admin";
	}
	
	@RequestMapping(value = "/admin/registrar_doctor", method = RequestMethod.GET)
	public ModelAndView registrar_doctor() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/registrar_doctor"); 
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/admin/asignar_doctor", method = RequestMethod.GET)
	public ModelAndView asignar_doctor() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/asignar_doctor"); 
		
		//falta mostrar listas		
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	
	
	
}
