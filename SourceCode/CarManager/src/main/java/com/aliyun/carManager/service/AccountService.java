package com.aliyun.carManager.service;

import java.util.List;

import com.aliyun.carManager.pojo.Account;

public interface AccountService {
	public boolean reg(Account account);
	public boolean login(Account account);
	public List<Account> selectAccounts();
}
