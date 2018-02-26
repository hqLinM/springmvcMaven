package com.pro.bean;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 实现 InitializingBean 接口
 * @author hqLin
 * @date 2018年1月30日 上午11:21:15
 */
public class HelloWorld3 implements InitializingBean, DisposableBean {
	private String msg;
	private Date date;

	/**
	 * 初始化方法
	 * 
	 * @return void
	 */
	public void afterPropertiesSet () {
		this.msg = "Hello world(实现 InitializingBean 接口)";
		this.date = new Date();
	}
	
	/**
	 * 销毁方法
	 * 
	 * @return void
	 */
	public void destroy () {
		this.msg = "";
		this.date = null;
		System.out.println("HelloWorld3类，您销毁了msg：" + this.msg + "和date：" + this.date);
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
