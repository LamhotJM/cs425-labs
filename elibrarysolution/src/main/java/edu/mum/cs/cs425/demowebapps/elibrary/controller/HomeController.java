/**
 * HomeController.java
 *
 * @author O. Kalu
 */
package edu.mum.cs.cs425.demowebapps.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "elibrary", "elibrary/home", "home"})
    public String displayHomePage() {
        return "home/index";
    }

    @GetMapping(value = {"elibrary/about", "about"})
    public String displayAboutPage() {
        return "home/about";
    }
}
