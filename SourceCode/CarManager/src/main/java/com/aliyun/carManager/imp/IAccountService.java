package com.aliyun.carManager.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.carManager.dao.AccountDao;
import com.aliyun.carManager.pojo.Account;
import com.aliyun.carManager.service.AccountService;

import javax.annotation.Resource;

@Service
public class IAccountService implements AccountService {
	@Resource
	private AccountDao accountDao;

	@Override
	public boolean reg(Account account) {
		Account existsAccount = accountDao.selectAccountByUserName(account);

		if (existsAccount != null) {
			return false;
		}

		if (accountDao.regAccount(account) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean login(Account account) {
		account = accountDao.selectUserByUsernameAndPassWord(account);
		if (account != null && account.getId() != 0 && account.getStatus() != 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Account> selectAccounts() {
		return accountDao.selectAccounts();
	}

}
