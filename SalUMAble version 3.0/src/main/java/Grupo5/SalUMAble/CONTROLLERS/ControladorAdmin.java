package Grupo5.SalUMAble.CONTROLLERS;
import Grupo5.SalUMAble.MODEL.UsuarioDoctor;
import Grupo5.SalUMAble.MODEL.UsuarioPaciente;
import Grupo5.SalUMAble.SERVICE.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorAdmin{
	
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
		p.setPassword("fecha");
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
		userService.save(d);
		return "redirect:/admin";
	}

	
	
	@RequestMapping("/admin/asignar_doctor")
	public String asignar_doctor(Model model) {
		return "admin/asignar_doctor";
		//falta mostrar listas		
	}
	
	
	
	
	
	
	
	
	
	
	
}
