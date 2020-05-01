package edu.miu.cs.cs425.fsap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs.cs425.fsap.model.Student;
import edu.miu.cs.cs425.fsap.model.Faculty;
import edu.miu.cs.cs425.fsap.service.StudentService;
import edu.miu.cs.cs425.fsap.service.FacultyService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/fsap/student"})
public class StudentController {

    private StudentService studentService;
    private FacultyService facultyService;

    @Autowired
    public StudentController(StudentService studentService, FacultyService facultyService) {
        this.studentService = studentService;
        this.facultyService = facultyService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView liststudents() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getAllStudents();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewstudentForm(Model model) {
        model.addAttribute("student", new Student());
        List<Faculty> faculties = facultyService.getAllFaculties();
        model.addAttribute("faculties", faculties);
        return "student/new";
    }

    @PostMapping(value = {"/new"})
    public String addNewstudent(@Valid @ModelAttribute("student")Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<Faculty> faculties = facultyService.getAllFaculties();
            model.addAttribute("faculties", faculties);
            model.addAttribute("student", student);
            return "student/new";
        }
        studentService.saveStudent(student);
        return "redirect:/fsap/student/list";
    }

    @GetMapping(value = {"/edit/{studentId}"})
    public String displayEditstudentForm(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if(student != null) {
            model.addAttribute("student", student);
            List<Faculty> faculties = facultyService.getAllFaculties();
            model.addAttribute("faculties", faculties);
            return "student/edit";
        }
        return "student/list";
    }

    @PostMapping(value = {"/update"})
    public String updateEditedstudent(@Valid @ModelAttribute("student")Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<Faculty> faculties = facultyService.getAllFaculties();
            model.addAttribute("suppliers", faculties);
            model.addAttribute("student", student);
            return "student/edit";
        }
        studentService.saveStudent(student);
        return "redirect:/fsap/student/list";
    }

}
