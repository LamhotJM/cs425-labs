package miu.edu.cs.cs425.midwesten.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import miu.edu.cs.cs425.midwesten.model.Account;
import miu.edu.cs.cs425.midwesten.repository.AccountRepository;
import miu.edu.cs.cs425.midwesten.service.AccountService;



@Service
public class AccountServiceImp implements AccountService{

	private AccountRepository repo;
	
	@Autowired
	public AccountServiceImp(AccountRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Account> getAllAccount() {
		return repo.findAll(Sort.by("accountNumber"));
	}

	@Override
	public Account addAccount(Account account) {
		return repo.save(account);
	}
	
	@Override
	public Double calcNetLiquidity() {
		List<Account> accounts = repo.findAll();
		Double net = 0d;
	    for (Account account : accounts) {
			if(account.getAccounttype().getAccountTypeName().equalsIgnoreCase("Loan")) {
				net = net - account.getBalance();
			}else {
				net = net + account.getBalance();
			}
		}
		return net;
	}
}
