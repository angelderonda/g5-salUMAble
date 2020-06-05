package Grupo5.SalUMAble.CONTROLLERS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Grupo5.SalUMAble.MODEL.Usuario;
import Grupo5.SalUMAble.MODEL.UsuarioAdministrador;
import Grupo5.SalUMAble.SERVICE.UserService;

@Controller
public class HomeResource {

	@Autowired
	private UserService usuario;
	
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
		List<Usuario> lista = usuario.listaUsuario();
		UsuarioAdministrador.inicializaListas(lista);
		//model.addAttribute("mapa", UsuarioAdministrador.getMap());		
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
