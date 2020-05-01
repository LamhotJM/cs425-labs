package miu.edu.cs.cs425.midwesten.service;

import java.util.List;

import miu.edu.cs.cs425.midwesten.model.Account;
import miu.edu.cs.cs425.midwesten.model.Customer;

public interface AccountService {
	
	List<Account> findAll();
	Account save(Account produt);
	Account findOne(Long id);
	void delete(Long id);
	

}
