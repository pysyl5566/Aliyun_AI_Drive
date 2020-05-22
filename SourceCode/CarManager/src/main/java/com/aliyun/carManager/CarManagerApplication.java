package com.aliyun.carManager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.aliyun.carManager.dao")
@ComponentScan(basePackages = {"com.aliyun.carManager.controller","com.aliyun.carManager.imp","com.aliyun.carManager.interceptor","com.aliyun.carManager.webconfig"})
@SpringBootApplication
public class CarManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarManagerApplication.class, args);
	}

}
