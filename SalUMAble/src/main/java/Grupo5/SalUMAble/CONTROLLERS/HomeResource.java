package Grupo5.SalUMAble.CONTROLLERS;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeResource {

	@RequestMapping("/login")
    public String login(Model model)
    {
        return "login";
    }
	
	@RequestMapping("/")
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping("/admin")
	public String admin(Model model) {
		return "admin";
	}
	
	@RequestMapping("/doctor")
	public String doctor(Model model) {
		return "doctor";
	}
	
	@RequestMapping("/paciente")
	public String paciente(Model model) {
		return "paciente";
	}
}
