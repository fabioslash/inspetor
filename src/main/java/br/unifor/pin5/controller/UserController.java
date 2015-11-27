package br.unifor.pin5.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unifor.pin5.entity.Obra;
import br.unifor.pin5.service.ObraService;
import br.unifor.pin5.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ObraService obraService;


	@ModelAttribute("obra")
	public Obra constructObra() {
		return new Obra();
	}

	

	
	/*@RequestMapping("/register")
	public String showRegister(){
		return "user-register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/register.html?success=true";
	}
	*/
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithObras(name));
		return "account";

	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
    public String doAddObra(@ModelAttribute("obra") Obra obra, Principal principal ){
		String name = principal.getName();
		obraService.save(obra, name);
		return "redirect:/account.html";
	  	
	} 
	
	
	@RequestMapping(value = "/listaobras", method = RequestMethod.GET)
	@ResponseBody
	public List<Obra> listaobras(){
		return obraService.findAll() ;
	}
	
	
	
}
