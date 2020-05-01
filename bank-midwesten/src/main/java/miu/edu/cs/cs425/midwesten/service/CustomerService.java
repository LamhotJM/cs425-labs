package miu.edu.cs.cs425.midwesten.service;

import java.util.List;

import miu.edu.cs.cs425.midwesten.model.Customer;



public interface CustomerService {
	public abstract List<Customer> getAllCustomers();
	public abstract Customer addCustomer(Customer customer);
}
