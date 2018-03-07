package com.pro.action;

import org.springframework.context.ApplicationEvent;

//LogEvent 类就是通过 ApplicationContext 被发布出去的
@SuppressWarnings("serial")
public class LogEvent extends ApplicationEvent {

	public LogEvent(Object msg) {
		super(msg);
	}
}
