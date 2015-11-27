package br.unifor.pin5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unifor.pin5.entity.User;

@Controller
public class IndexController {

	
	@RequestMapping("/index")
	public String index(){
		
		return "index";
	}
	
	
}
