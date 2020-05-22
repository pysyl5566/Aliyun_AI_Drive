package com.aliyun.carManager.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class UserEcharts {
	private String name;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String value;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Object children;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Object getChildren() {
		return children;
	}
	public void setChildren(Object children) {
		this.children = children;
	}
	public UserEcharts() {
	}
}
