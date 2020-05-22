package com.aliyun.carManager.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyun.carManager.pojo.Account;
import com.aliyun.carManager.pojo.Status;
import com.aliyun.carManager.service.AccountService;

@Controller
public class LoginController {
	@Autowired
	private AccountService accountService;
	private Status status = new Status();
	
	@RequestMapping(method=RequestMethod.POST,value="/login")
	@ResponseBody
	public Status login(HttpServletRequest request,@RequestBody Account account) {
		System.out.println("POST");
		System.out.println("用户名：" + account.getUsername() + "密码：" + account.getPassword());
		if (accountService.login(account)) {
			status.setSuccess(true);
			request.getSession().setAttribute("loginAccount",account);
		}else {
			status.setSuccess(false);
		}
		return status;
	}

	@RequestMapping(method=RequestMethod.POST,value="/reg")
	@ResponseBody
	public Status reg(HttpServletRequest request,@RequestBody Account account) {
		System.out.println("POST");
		System.out.println("用户名：" + account.getUsername() + "密码：" + account.getPassword());
		if (accountService.reg(account)) {
			status.setSuccess(true);
			request.getSession().setAttribute("loginAccount",account);
		}else {
			status.setSuccess(false);
		}
		return status;
	}

//	@RequestMapping(method=RequestMethod.GET,value="/index.html")
//	public String index() {
//		System.out.println("GET");
//		return "main";
//	}
}
