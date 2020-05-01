package edu.miu.cs.cs425.fsap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs.cs425.fsap.model.Faculty;
import edu.miu.cs.cs425.fsap.service.FacultyService;

import java.util.List;

@Controller
@RequestMapping(value = {"/fsap/faculty"})
public class FacultyController {

    private FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listfacultys() {
        ModelAndView modelAndView = new ModelAndView();
        List<Faculty> faculties = facultyService.getAllFaculties();
        modelAndView.addObject("faculties", faculties);
        modelAndView.setViewName("faculty/list");
        return modelAndView;
    }

}
