package miu.edu.cs.cs425.midwesten.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import miu.edu.cs.cs425.midwesten.service.CustomerService;
import miu.edu.cs.cs425.midwesten.model.Customer;
import miu.edu.cs.cs425.midwesten.repository.*;

@Transactional
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository CustomerRepository;
	
	

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return CustomerRepository.findAll();
	}

	@Override
	public Customer save(Customer studentRegistration) {
		// TODO Auto-generated method stub
		return CustomerRepository.save(studentRegistration);
	}

	@Override
	public Customer findOne(Integer id) {
		// TODO Auto-generated method stub
		return CustomerRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		CustomerRepository.deleteById(id);
		
	}

}
