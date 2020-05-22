package com.aliyun.carManager.dao;

import java.util.List;

import com.aliyun.carManager.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.aliyun.carManager.pojo.Account;

@Mapper
public interface AccountDao {
	@Select("SELECT * FROM ACCOUNT WHERE USERNAME=#{username} AND PASSWORD=#{password}")
	Account selectUserByUsernameAndPassWord(Account account);

	@Select("SELECT * FROM ACCOUNT")
	List<Account> selectAccounts();
	
	@Select("SELECT * FROM ACCOUNT WHERE id=#{aid}")
	Account selectAccountById(int aid);

	@Select("SELECT * FROM ACCOUNT WHERE USERNAME=#{username}")
	Account selectAccountByUserName(Account account);

	@Insert("INSERT INTO ACCOUNT(USERNAME,PASSWORD) VALUES(#{username},#{password})")
	int regAccount(Account account);
}
