package Grupo5.SalUMAble.CONTROLLERS;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Grupo5.SalUMAble.MODEL.Usuario;
import Grupo5.SalUMAble.MODEL.UsuarioAdministrador;
import Grupo5.SalUMAble.MODEL.UsuarioDoctor;
import Grupo5.SalUMAble.MODEL.UsuarioPaciente;
import Grupo5.SalUMAble.SERVICE.UserService;

@Controller
public class HomeResource {

	@Autowired
	private UserService usuario;

	@RequestMapping("/login")
	public String login(Model model) {
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
		// model.addAttribute("mapa", UsuarioAdministrador.getMap());
		return "admin";
	}

	@RequestMapping("/doctor")
	public String doctor(Model model) {
		List<Usuario> lista = usuario.listaUsuario();
		UsuarioAdministrador.inicializaListas(lista);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			 username = ((UserDetails) principal).getUsername();
		} else {
			 username = principal.toString();
		}
		
		Optional<Usuario> doctor = usuario.getByUsername(username);	
		UsuarioDoctor d = (UsuarioDoctor) doctor.get();
		
		model.addAttribute("idDoctor",d.getId());
		model.addAttribute("nombreDoctor",d.getNombre());		
		model.addAttribute("apellidosDoctor",d.getApellidos());
		model.addAttribute("tienePaciente",d.isPacienteAsignado());
		model.addAttribute("disponible",d.isDisponibilidad());
		
		if(d.isPacienteAsignado() && d.getPacienteActual() != null) {
			model.addAttribute("nombrePaciente", d.getPacienteActual().getNombre());		
			model.addAttribute("apellidosPaciente",d.getPacienteActual().getApellidos());
		}
		
		
		return "doctor";
	}

	@RequestMapping("/paciente")
	public String paciente(Model model) {
		List<Usuario> lista = usuario.listaUsuario();
		UsuarioAdministrador.inicializaListas(lista);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			 username = ((UserDetails) principal).getUsername();
		} else {
			 username = principal.toString();
		}
		
		Optional<Usuario> paciente = usuario.getByUsername(username);		
		
		UsuarioPaciente p = (UsuarioPaciente) paciente.get();
		
		model.addAttribute("usernamePaciente", p.getUserName());
		model.addAttribute("idPaciente", p.getId());
		model.addAttribute("nombrePaciente", p.getNombre());
		model.addAttribute("apellidosPaciente", p.getApellidos());
		
		if(p.getTratamiento() != null) {
			model.addAttribute("tratamientoPaciente", p.getTratamiento());
		}else {
			model.addAttribute("tratamientoPaciente", "No te han dejado un tratamiento.");
		}
		
		model.addAttribute("estadoPaciente", p.getEstado().toString());
		model.addAttribute("estadoCola", p.verPosicionEnCola());
		
		
		return "paciente";
	}
}
