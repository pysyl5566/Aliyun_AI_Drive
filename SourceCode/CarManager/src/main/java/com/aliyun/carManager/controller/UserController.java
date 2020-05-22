package com.aliyun.carManager.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.aliyun.carManager.pojo.*;
import com.aliyun.carManager.service.OCRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;

import com.aliyun.carManager.dao.UserDao;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {
	@Resource
	private UserDao userDao;

	@Resource
	private OCRService ocrService;
	
	@RequestMapping(method=RequestMethod.GET,value="/user/list")
	@ResponseBody
	public DataTables list(HttpServletRequest request) {
		System.out.println("获取所有会员");
		DataTables tables = new DataTables();
		tables.setData(userDao.selectUsers());
		return tables;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/user/info")
	@ResponseBody
	public DataTables info(HttpServletRequest request,User user) {
		System.out.println("获取单个会员");
		DataTables tables = new DataTables();
//		tables.setData(userDao.selectUserById(user));
		tables.setData(userDao.selectUserByCondition(user));
		return tables;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/user/child")
	@ResponseBody
	public UserEcharts child(HttpServletRequest request,User user) {
		System.out.println("获取下级会员");
		System.out.println(user.getUid());
		
//		user = userDao.selectUserById(user);
		user = userDao.selectUserByCondition(user);
		
		UserEcharts userEcharts = new UserEcharts();
		userEcharts.setName(user.getName());
		userEcharts.setValue(String.valueOf(user.getUid()));
		
		List<User> list = userDao.selectUserChildByParentId(user);
		
		if (list.size() != 0) {
			List<UserEcharts> userEchartsList = new ArrayList<UserEcharts>();
			for (User u : list) {
				UserEcharts ue = new UserEcharts();
				ue.setName(u.getName());
				ue.setValue(String.valueOf(u.getUid()));
				
				System.out.println("name:" + u.getName());
				
				userEchartsList.add(ue);
				userEchartsList.get(userEchartsList.size() - 1).setChildren(hasChilds(u));
			}
			userEcharts.setChildren(userEchartsList);
		}
		
		return userEcharts;
	}
	
	private Object hasChilds(User user) {
		List<User> users = userDao.selectUserChildByParentId(user);
		List<UserEcharts> userEchartsList = new ArrayList<UserEcharts>();
		if (users.size() != 0) {
			for (User u : users) {
				System.out.println("name:" + u.getName());
				UserEcharts ue = new UserEcharts();
				ue.setName(u.getName());
				ue.setValue(String.valueOf(u.getUid()));
				
				userEchartsList.add(ue);
				userEchartsList.get(userEchartsList.size() - 1).setChildren(hasChilds(u));
			}
		}else {
			return null;
		}
		return userEchartsList;
	}

	@RequestMapping(method=RequestMethod.POST,value="/user/update")
	@ResponseBody
	public Status update(HttpServletRequest request,User user) {
		DataTables tables = new DataTables();
		Status status = new Status();
		if (user.getUid() == null) {
			System.out.println("添加单个会员");
			System.out.println(user.getName());
			if (userDao.addUser(user) == 1) {
				status.setSuccess(true);
				return status;
			} else {
				status.setSuccess(false);
				return status;
			}
		} else {
			System.out.println("更新单个会员");
			if (userDao.updateUser(user) == 1) {
				status.setSuccess(true);
				return status;
			} else {
				status.setSuccess(false);
				return status;
			}
		}
	}

	@GetMapping("/user/getIdCardInfo")
	@ResponseBody
	public Object uploadIdCard(User user) throws Exception {
		RecognizeStatus status = new RecognizeStatus();
		System.out.println("UserID:" + user.getUid());
		user = userDao.selectUserByCondition(user);
		if ("".equals(user.getIdCardImg())) {
			status.setData(false);
			return status;
		}

		String filePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath() + "/idCard/images/" + user.getIdCardImg();
		File file = new File(filePath);

		if (!file.exists()) {
			status.setData(false);
			return status;
		}

		/*if (user.getUid() == null) {
			saveFile = new File(filePath + idCardImg + fileName.substring(fileName.lastIndexOf("."),fileName.length()));
		} else {
			user.setIdCardImg(user.getUid().toString() + fileName.substring(fileName.lastIndexOf("."),fileName.length()));
			userDao.updateUserIdCardImg(user);
			saveFile = new File(filePath + user.getUid().toString() + fileName.substring(fileName.lastIndexOf("."),fileName.length()));
		}

		try {
			file.transferTo(saveFile);
			System.out.println("上传成功！");
		} catch (IOException e) {
			System.out.println(e.toString());
		}*/
		return ocrService.getIdCardInfo(file);
	}
}
