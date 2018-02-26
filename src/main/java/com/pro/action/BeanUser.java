package com.pro.action;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.pro.bean.HelloWorld2;

/**
 * spring 中 Bean 的3种使用方式
 * @author hqLin
 * @date 2018年1月30日 上午11:37:52
 */
public class BeanUser {
	
	public static void main(String[] args) {
//		BeanUserMethod1();
				
//		BeanUserMethod2();
		
		BeanUserMethod3();
	}

	/**
	 * 方式一，使用 BeanWrapper
	 * 
	 * @return void
	 */
	public static void BeanUserMethod1 () {
		HelloWorld2 helloWorld = new HelloWorld2();
		BeanWrapper bw = new BeanWrapperImpl(helloWorld);
		bw.setPropertyValue("msg", "HelloWorld(BeanWrapper)");
		System.out.println(bw.getPropertyValue("msg"));
	}
	
	/**
	 * 方式二 使用 BeanFactory
	 * 
	 * @return void
	 */
	@SuppressWarnings("resource")
	public static void BeanUserMethod2 () {
//		ClassPathXmlApplicationContext 取路径是从src/main/java 开始的, 
//		所以如果要读文件，要放到src/main/java 底下,也可以放到src/main/resources底下
		
		//两种读文件的方法
		//1.取 WebContent/config 底下
		BeanFactory factory = new ClassPathXmlApplicationContext("file:WebContent/config/config.xml");
		
		//2.取 src/main/resources 底下
//		BeanFactory factory = new ClassPathXmlApplicationContext("config.xml");
		HelloWorld2 helloWorld = (HelloWorld2) factory.getBean("HelloWorld1");
		System.out.println(helloWorld.getMsg());
	}
	
	/**
	 * 方式三，使用 ApplicationContext
	 * 
	 * @return void
	 */
	@SuppressWarnings("resource")
	public static void BeanUserMethod3 () {
		ApplicationContext actx = new FileSystemXmlApplicationContext("/WebContent/config/config.xml");
//		ApplicationContext actx = new FileSystemXmlApplicationContext("/src/main/resources/config.xml");
		HelloWorld2 helloWorld = (HelloWorld2) actx.getBean("HelloWorld1");
		System.out.println(helloWorld.getMsg());
	}
}
