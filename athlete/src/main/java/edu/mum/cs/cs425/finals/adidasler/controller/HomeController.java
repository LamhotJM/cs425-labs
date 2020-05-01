package edu.mum.cs.cs425.finals.adidasler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping(value= {"/", "/adidasler", "/adidasler/home"})
	public String home() {
		return "home/index";
	}
}