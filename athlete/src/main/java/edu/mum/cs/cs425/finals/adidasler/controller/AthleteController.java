package edu.mum.cs.cs425.finals.adidasler.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.finals.adidasler.service.AthleteService;
import edu.mum.cs.cs425.finals.adidasler.model.Athlete;

@Controller
public class AthleteController {
	private AthleteService service;
	

	public AthleteController(AthleteService service) {
		this.service = service;
	}

	@GetMapping(value = "/adidasler/athlete/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("athletes", service.getAllAthletes());
		mav.setViewName("athlete/list");
		return mav;		
	}
	
	@GetMapping(value = "/adidasler/elite/list")
	public ModelAndView listElite() {
		ModelAndView mav = new ModelAndView();
		
		String date = "2019-10-19";		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		
		mav.addObject("athletes", service.getElite(localDate));
		mav.setViewName("athlete/elitelist");
		return mav;		
	}
	
	@GetMapping(value = "/adidasler/athlete/new")
	public String newSupplier(Model model) {
		model.addAttribute("athlete", new Athlete());
		return "athlete/new";
	}
	
	
	@PostMapping(value = {"/adidasler/athlete/new"})
    public String addNewBook(@Valid @ModelAttribute("athlete") Athlete athlete,
                                     BindingResult bindingResult, Model model) {
		System.out.println(athlete);
        if (bindingResult.hasErrors()) {
        	  model.addAttribute("errors", bindingResult.getAllErrors());
            return "athlete/new";
        }
        athlete = service.addAthlete(athlete);
        return "redirect:/adidasler/athlete/list";
    }
}
