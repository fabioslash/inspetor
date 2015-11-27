package br.unifor.pin5.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unifor.pin5.entity.User;
import br.unifor.pin5.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	
	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User construct() {
		return new User();

	}
	
	@RequestMapping
	public String showRegistrer() {
		return "user-register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doRegistrer(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()){
			
			return "user-register";
		}
		
		userService.save(user);
		return "redirect:/register.html?success=true";

	}
	
	
	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String username){
	  Boolean available = userService.findOne(username) == null;
	  return available.toString();
	}

	
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	@ResponseBody
	public List<User> lista(){
		return userService.findAll();
	}
	
	
	@RequestMapping(value = "/usuarioadmin", method = RequestMethod.GET)
	@ResponseBody
	public User usuarioadmin(){
		return userService.findOne("admin");
	}
	
	
}
