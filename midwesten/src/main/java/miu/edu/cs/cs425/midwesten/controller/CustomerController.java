package miu.edu.cs.cs425.midwesten.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import miu.edu.cs.cs425.midwesten.model.Account;
import miu.edu.cs.cs425.midwesten.model.Customer;
import miu.edu.cs.cs425.midwesten.service.AccountService;
import miu.edu.cs.cs425.midwesten.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService CustomerService;
	@Autowired
	private AccountService AccountService;
                             
	@RequestMapping(value = "/midwesten/secured/customer/list", method = RequestMethod.GET)
	public ModelAndView Customers() {
		List<Customer> Customers = CustomerService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("customers", Customers);// set the attributes to view files
		modelAndView.setViewName("customer/list");
		return modelAndView;
	}
	
	
    @GetMapping(value = {"midwesten/secured/customer/new"})
    public String displayNewCustomerForm(Model model) {
    	List<Account> Accounts = AccountService.findAll();
		model.addAttribute("Accounts", Accounts);
        model.addAttribute("customer", new Customer());
        return "customer/new";
    }

    @PostMapping(value = {"midwesten/secured/customer/new"})
    public String addNewBook(@Valid @ModelAttribute("customer") Customer Customer,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	List<Account> Accounts = AccountService.findAll();
    		model.addAttribute("Accounts", Accounts);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "customer/new";
        }
        
        
        Customer = CustomerService.save(Customer);
        return "redirect:/midwesten/secured/customer/list";
    }

	@GetMapping(value = { "midwesten/secured/customer/edit/{customerId}" })
	public String editCustomer(@PathVariable Integer CustomerId, Model model) {
		Customer Customer = CustomerService.findOne((CustomerId));
		if (Customer != null) {
			List<Account> Accounts = AccountService.findAll();
    		model.addAttribute("Accounts", Accounts);
			model.addAttribute("customer", Customer);
			return "customer/edit";
		}
		return "customer/list";
	}

	@PostMapping(value = { "/midwesten/secured/customer/edit" })
	public String updateCustomer(@Valid @ModelAttribute("customer") Customer Customer, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			List<Account> Accounts = AccountService.findAll();
    		model.addAttribute("Accounts", Accounts);
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "customer/edit";
		}
		Customer = CustomerService.save(Customer);
		return "redirect:/midwesten/secured/customer/list";
	}

	@RequestMapping(value = "/midwesten/secured/customer/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id, Model model) {
		CustomerService.delete(id);
		return "redirect:/midwesten/secured/customer/list";
	}

}
