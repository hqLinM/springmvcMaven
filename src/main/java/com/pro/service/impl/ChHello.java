package com.pro.service.impl;

import com.pro.service.Hello;

public class ChHello implements Hello{

	public String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String doSalutation() {
		
		return "你好" + this.msg;
	}
}
