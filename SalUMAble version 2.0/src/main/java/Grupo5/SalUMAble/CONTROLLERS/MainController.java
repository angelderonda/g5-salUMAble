package Grupo5.SalUMAble.CONTROLLERS;

import Grupo5.SalUMAble.MODEL.*;
import Grupo5.SalUMAble.SERVICE.UserService;

import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
public class MainController {
	@Autowired // This means to get the bean called userRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	
//	@PostMapping(path = "/add") // Map ONLY POST Requests
//	public @ResponseBody String addNewUser(@RequestParam String userName, @RequestParam String password,
//			@RequestParam String roles) {
//		// @ResponseBody means the returned String is the response, not a view name
//		// @RequestParam means it is a parameter from the GET or POST request
//		String reply = "Problem";
//
//		if (roles.equalsIgnoreCase("admin")) {
//			UsuarioAdministrador n = new UsuarioAdministrador();
//			n.setUserName(userName);
//			n.setPassword(password);
//			n.setRoles("ROLE_ADMIN, ROLE_USER");
//			userRepository.save(n);
//			reply = "Saved";
//		} else if (roles.equalsIgnoreCase("doctor")) {
//			UsuarioDoctor n = new UsuarioDoctor();
//			n.setUserName(userName);
//			n.setPassword(password);
//			n.setRoles("ROLE_DOCTOR, ROLE_USER");
//			userRepository.save(n);
//			reply = "Saved";
//		} else if (roles.equalsIgnoreCase("patient")) {
//			UsuarioPaciente n = new UsuarioPaciente();
//			n.setUserName(userName);
//			n.setPassword(password);
//			n.setRoles("ROLE_PATIENT, ROLE_USER");
//			userRepository.save(n);
//			reply = "Saved";
//		}
//		return reply;
//	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Usuario> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
//	@GetMapping(path = "/admin/registrar_paciente") // Map ONLY POST Requests
//	public @ResponseBody String addPaciente(Model model) {
//		model.addAttribute("UsuarioPaciente", new UsuarioPaciente());
//		return "admin/registrar_paciente";
//	}
	
//	@PostMapping("/admin/registrar_paciente/save")
//	public String savePaciente(UsuarioPaciente p) {
//		userService.save(p);
//		return "redirect:/admin";
//	}

//	@GetMapping(path = "/index") // Map ONLY POST Requests
//	public String login(@RequestParam(name = "ID", required=true) String ID // Tiene en cuenta las mayúsculas
//			, @RequestParam(name = "Password", required=true) String password, Model model) {
//		
//		// @ResponseBody means the returned String is the response, not a view name
//		// @RequestParam means it is a parameter from the GET or POST request
//		
//		model.addAttribute("ID", ID);
//		model.addAttribute("Password", password);
//
//		if (ID.equals("admin") && password.equals("admin")) {
//			return "redirect:/paginaAdmin";
//		}
//
//		String reply = "/login"; // En caso de fallar vuelve a mandar a la misma pagina
//
//		List<Usuario> lista = servicioUsuario.listaUsuario();
//
//		Iterator<Usuario> it = lista.iterator();
//		boolean found = false;
//		Usuario user = null;
//
//		while (it.hasNext() && !found) {
//			user = it.next();
//			if (user.getId().equals(ID) && user.getPassword().equals(password))
//				found = true;
//		}
//
//		if (found) {
//
//			if (user.getTipo() == 'P')
//				reply = "/login/paginaPaciente";
//			else
//				reply = "/login/paginaDoctor";
//
//		}
//
//		return "redirect:" + reply;
//	}

}