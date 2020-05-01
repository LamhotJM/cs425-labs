package miu.edu.cs.cs425.midwesten.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import miu.edu.cs.cs425.midwesten.model.Customer;
import miu.edu.cs.cs425.midwesten.repository.CustomerRepository;
import miu.edu.cs.cs425.midwesten.service.CustomerService;



@Service
public class CustomerServiceImp implements CustomerService{
	private CustomerRepository repo;

	@Autowired
	public CustomerServiceImp(CustomerRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll(Sort.by("lastName").ascending());
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return repo.save(customer);
	}
	
	
}
