package com.aliyun.carManager.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.*;

import com.aliyun.carManager.pojo.Account;
import com.aliyun.carManager.pojo.User;

@Mapper
public interface UserDao {
	@Select("SELECT * FROM USER")
	@ResultMap("user")
	List<User> selectUsers();
	
	@Select("SELECT * FROM USER WHERE UID=#{uid}")
	@Results(id="user",value={
			@Result(id=true,property="uid",column="uid"),
			@Result(property="name",column="name"),
			@Result(property="sex",column="sex"),
			@Result(property="age",column="age"),
			@Result(property="tel",column="tel"),
			@Result(property="address",column="address"),
			@Result(property="email",column="email"),
			@Result(property="account",column="aid",javaType=Account.class,one=@One(select="com.aliyun.carManager.dao.AccountDao.selectAccountById")),
			@Result(property="parent",column="parent",javaType=User.class,one=@One(select="com.aliyun.carManager.dao.UserDao.selectUserByCondition")),
			@Result(property="regTime",column="regTime",javaType=Date.class),
			@Result(property="status",column="status"),
			@Result(property="remark",column="remark"),
			@Result(property="idCardImg",column="idCardImg")
		})
	User selectUserByCondition(User user);
	
	@Select("SELECT * FROM USER WHERE parent=#{uid}")
	@ResultMap("user")
	List<User> selectUserChildByParentId(User parent);

	//@Insert("<script>INSERT INTO USER(name,sex,tel,email,remark<IF TEST='idCardImg = \"\"’'>,idCardImg</IF>) VALUES(#{name},#{sex},#{tel},#{email},#{remark}<IF TEST='idCardImg = \"\"'>,#{idCardImg}</IF>)</script>")
	@InsertProvider(type = com.aliyun.carManager.mybatis.provider.InsertProvider.class,method = "addUser")
	int addUser(User user);

	@Update("UPDATE USER SET NAME=#{name},SEX=#{sex},TEL=#{tel},EMAIL=#{email},REMARK=#{remark},PARENT=#{parent.uid} WHERE UID=#{uid}")
	int updateUser(User user);

	@Update("UPDATE USER SET IDCARDIMG=#{idCardImg} WHERE UID=#{uid}")
	int updateUserIdCardImg(User user);
}
