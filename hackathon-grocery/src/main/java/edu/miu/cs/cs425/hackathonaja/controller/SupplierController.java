package edu.miu.cs.cs425.hackathonaja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs.cs425.hackathonaja.model.Supplier;
import edu.miu.cs.cs425.hackathonaja.service.SupplierService;

import java.util.List;

@Controller
@RequestMapping(value = {"/srm4gdm/supplier"})
public class SupplierController {

    private SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listSuppliers() {
        ModelAndView modelAndView = new ModelAndView();
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.setViewName("supplier/list");
        return modelAndView;
    }

}
