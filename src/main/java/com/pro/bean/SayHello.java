package com.pro.bean;

import com.pro.service.Hello;

public class SayHello {

	private Hello hello;	//Hello接口
	
	public SayHello(Hello hello) {
		this.hello = hello;
	}

	public Hello getHello() {
		return hello;
	}

	public void setHello(Hello hello) {
		this.hello = hello;
	}
	
	//调用接口方法
	public String doSalutation(){
		
		return hello.doSalutation();
	}
}
