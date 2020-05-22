package com.aliyun.carManager.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyun.carManager.pojo.DataTables;
import com.aliyun.carManager.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(method=RequestMethod.GET,value="/account/list")
	@ResponseBody
	public DataTables list(HttpServletRequest request) {
		System.out.println("获取所有帐户");
		DataTables tables = new DataTables();
		tables.setData(accountService.selectAccounts());
		return tables;
	}
}
