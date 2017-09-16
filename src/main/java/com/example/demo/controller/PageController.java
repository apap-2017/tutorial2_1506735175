package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
	
	@RequestMapping("/greetings")
	public String greeting (@RequestParam(value="name", required=false, defaultValue="dunia") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping(value = {"/greeting", "/greeting/{name}"})
	public String greetingPath (@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String perkalian (
			@RequestParam(value="a", defaultValue="0" ) int number1, 
			@RequestParam(value="b", defaultValue="0" ) int number2, 
			Model model) {

		int result1 =  number1 * number2;
		model.addAttribute("a", number1);
		model.addAttribute("b", number2);
		model.addAttribute("result", result1);
				
		return "multiplication";
	}
	
}
