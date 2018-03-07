package com.pro.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Log implements ApplicationContextAware {
	
	//设定变量 applicationContext
	private ApplicationContext applicationContext;

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	//设定变量 applicationContext 的set方法
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	public int log(String log) {
		LogEvent event = new LogEvent(log);
		this.applicationContext.publishEvent(event);
		
		return 0;
	} 
}