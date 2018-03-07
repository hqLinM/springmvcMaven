package com.pro.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@SuppressWarnings("rawtypes")
public class LogListener implements ApplicationListener {

	//ApplicationContext 会在发布 LogEvent 事件时通知 LogListener
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof LogEvent) {
			//设定时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			format.setLenient(false);
			String currentDate = format.format(new Date());
			System.out.println("输出时间：" + currentDate + "，输出内容：" + event.toString());
		}
		
	}
}
