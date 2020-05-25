package Grupo5.SalUMAble.CONTROLLERS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.*;

@Controller
public class UsuarioDoctorController extends Controlador{
	
	@RequestMapping("/index")
	public String indexDoctor(){
		return "/indexDoctor";
	}
	
	
	@RequestMapping("/index/tratamiento")
	public static String rellenarTratamiento() {
		return "/index/tratamiento";
	}

}
