package miu.edu.cs.cs425.midwesten.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import miu.edu.cs.cs425.midwesten.model.Accounttype;
import miu.edu.cs.cs425.midwesten.repository.AccountRepository;
import miu.edu.cs.cs425.midwesten.repository.AccounttypeRepository;
import miu.edu.cs.cs425.midwesten.service.AccounttypeService;



@Service
public class AccounttypeServiceImp implements AccounttypeService{

	private AccounttypeRepository repo;
	private AccountRepository accRepo;
	
	public AccounttypeServiceImp(AccounttypeRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Accounttype> getAll() {
		return repo.findAll();
	}

	

	
}
