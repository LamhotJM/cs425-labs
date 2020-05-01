package miu.edu.cs.cs425.midwesten.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import miu.edu.cs.cs425.midwesten.model.Account;
import miu.edu.cs.cs425.midwesten.repository.*;
import miu.edu.cs.cs425.midwesten.service.AccountService;


@Transactional
@Service("AccountService")
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository AccountRepository;
	
	

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return AccountRepository.findAll();
	}

	@Override
	public Account save(Account studentRegistration) {
		// TODO Auto-generated method stub
		return AccountRepository.save(studentRegistration);
	}

	@Override
	public Account findOne(Long id) {
		// TODO Auto-generated method stub
		return AccountRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		AccountRepository.deleteById(id);
		
	}

}
