package miu.edu.cs.cs425.midwesten.service;

import java.util.List;

import miu.edu.cs.cs425.midwesten.model.Customer;


public interface CustomerService {
	
	List<Customer> findAll();
	Customer save(Customer produt);
	Customer findOne(Integer id);
	void delete(Integer id);
	

}
