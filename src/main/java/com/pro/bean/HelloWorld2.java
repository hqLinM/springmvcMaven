package com.pro.bean;

import java.util.Date;

/**
 * Set方式
 * @author hqLin
 * @date 2018年1月19日 下午3:53:08
 */
public class HelloWorld2 {
	private String msg;
	private Date date;

	/**
	 * 初始化方法
	 * 
	 * @return void
	 */
	public void init () {
		this.msg = "Hello world(init方法赋值)";
		this.date = new Date();
	}
	
	/**
	 * 销毁方法
	 * 
	 * @return void
	 */
	public void cleanup () {
		this.msg = "";
		this.date = null;
		System.out.println("HelloWorld2类，您销毁了msg：" + this.msg + "和date：" + this.date);
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
