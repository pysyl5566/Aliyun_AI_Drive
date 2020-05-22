package com.aliyun.carManager.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.carManager.dao.UserDao;
import com.aliyun.carManager.pojo.User;
import com.aliyun.carManager.service.UserService;

import javax.annotation.Resource;

@Service
public class IUserService implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public List<User> selectUsers() {
		return userDao.selectUsers();
	}

}
