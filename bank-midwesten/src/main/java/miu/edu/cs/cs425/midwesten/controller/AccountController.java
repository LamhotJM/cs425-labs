package miu.edu.cs.cs425.midwesten.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import miu.edu.cs.cs425.midwesten.model.Account;
import miu.edu.cs.cs425.midwesten.service.AccountService;
import miu.edu.cs.cs425.midwesten.service.AccounttypeService;
import miu.edu.cs.cs425.midwesten.service.CustomerService;



@Controller
public class AccountController {
	private AccountService accountService;
	private CustomerService customerService;
	private AccounttypeService accounttypeService;
	
	

	public AccountController(AccountService accountService, CustomerService customerService,
			AccounttypeService accounttypeService) {
		this.accountService = accountService;
		this.customerService = customerService;
		this.accounttypeService = accounttypeService;
	}

	@GetMapping(value = "/bank/account/list")
	public ModelAndView listProducts() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("accounts", accountService.getAllAccount());
		mav.addObject("net", accountService.calcNetLiquidity());
		mav.setViewName("account/list");
		return mav;		
	}
	
	@GetMapping(value = "/bank/account/new")
	public String newSupplier(Model model) {
		model.addAttribute("customers",customerService.getAllCustomers());
		model.addAttribute("typeofaccounts",accounttypeService.getAll());
		model.addAttribute("account", new Account());
		return "account/new";
	}
	
	
	@PostMapping(value = {"/bank/account/new"})
    public String addNewBook(@Valid @ModelAttribute("account") Account account,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	  model.addAttribute("errors", bindingResult.getAllErrors());
        	  model.addAttribute("customers",customerService.getAllCustomers());
        	  model.addAttribute("typeofaccounts",accounttypeService.getAll());
            return "account/new";
        }
        account = accountService.addAccount(account);
        return "redirect:/bank/account/list";
    }
}
