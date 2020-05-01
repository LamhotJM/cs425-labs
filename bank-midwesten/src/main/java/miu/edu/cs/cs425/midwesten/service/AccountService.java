package miu.edu.cs.cs425.midwesten.service;

import java.util.List;

import miu.edu.cs.cs425.midwesten.model.Account;


public interface AccountService {
	public abstract List<Account> getAllAccount();
	public abstract Account addAccount(Account account);
	public abstract Double calcNetLiquidity();
}
