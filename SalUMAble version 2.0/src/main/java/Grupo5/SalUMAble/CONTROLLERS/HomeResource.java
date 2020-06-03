package Grupo5.SalUMAble.CONTROLLERS;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeResource {

	@GetMapping("/login")
    public String register()
    {
        return "login";
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home"); // resources/template/home.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin"); // resources/template/admin.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/doctor", method = RequestMethod.GET)
	public ModelAndView doctor() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("doctor"); // resources/template/doctor.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/paciente", method = RequestMethod.GET)
	public ModelAndView paciente() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("paciente"); // resources/template/doctor.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error"); // resources/template/doctor.html
		return modelAndView;
	}
}
