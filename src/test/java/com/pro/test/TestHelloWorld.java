package com.pro.test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.pro.action.Log;
import com.pro.bean.HelloWorld;
import com.pro.bean.HelloWorld2;
import com.pro.bean.HelloWorld3;
import com.pro.bean.HelloWorldForCollection;
import com.pro.bean.SayHello;
import com.pro.service.Hello;

/**
 * 测试使用 spring 的配置获取 Bean
 * @author hqLin
 * @date 2017年12月13日
 */
public class TestHelloWorld {

	private static ApplicationContext actx;

	public static void main(String[] args) {
		//通过ApplicationContext来获取spring的配置文件
		actx = new FileSystemXmlApplicationContext("WebContent/config/config.xml");
		
		//最基本获取bean
//		getBeanContext();
		
		//多态测试
//		getBeanContext2();
		
		//通过构造函数进行注入
//		getBeanContext3();
		
		//set注入方式测试
//		getBeanContext4();
		
		//单例测试
//		singletonTest();
		
		//bean 初始化测试
//		getBeanContext5();
		
		//bean 初始化测试(实现 InitializingBean 接口)
//		getBeanContext6();
		
		//自动装配测试
//		getBeanContext7();
		
		//bean中集合元素测试
//		getBeanContext8();
		
		//国际化测试
		messageTest();
		
		//获取文件测试
//		getFilet();
		
		//事件传递测试
//		logTest();
	}
	
	/**
	 * 测试获取bean的内容
	 * 
	 * @return void
	 */
	public static void getBeanContext() {
		System.out.println("--- getBeanContext ---");
		HelloWorld2 helloWorld = (HelloWorld2) actx.getBean("HelloWorld1");
		System.out.println(helloWorld.getMsg());
	}
	
	/**
	 * 测试获取bean的内容，多态注入，分别获取中文或英文
	 * 
	 * @return void
	 */
	public static void getBeanContext2() {
		System.out.println("--- getBeanContext2 ---");
		Hello hello = (Hello) actx.getBean("Hello");
		Hello hello2 = (Hello) actx.getBean("EnHello");
//		System.out.println(hello.doSalutation());
		System.out.println(hello2.doSalutation());
		
		/**
		 * 实现控制反转(IoC)(实现必须依赖抽象,而不是抽象依赖实现)
		 * (核心思想：面向接口编程)
		 */
		SayHello sayHello = new SayHello(hello);
		System.out.println(sayHello.doSalutation());
	}
	
	/**
	 * 测试获取bean的内容，通过构造函数进行注入
	 * 	使用构造注入或set注入的区别在于对象建立时就准备好所有资源，或是在对象建立好后
	 * 
	 * @return void
	 */
	public static void getBeanContext3() {
		System.out.println("--- getBeanContext3 ---");
		
		//通过 Bean 的 id 来获取 Bean
		HelloWorld helloWorld = (HelloWorld) actx.getBean("HelloWorld");
		
		System.out.println("helloWorld.getMsg()：" + helloWorld.getMsg());
		System.out.println("helloWorld.getTxt()：" + helloWorld.getTxt());
	}
	
	/**
	 * set注入方式测试
	 * 
	 * @return void
	 */
	public static void getBeanContext4() {
		System.out.println("--- getBeanContext4 ---");
		HelloWorld2 helloWorld = (HelloWorld2) actx.getBean("HelloWorld2");
		System.out.println(helloWorld.getDate() + " -- " + helloWorld.getMsg());
	}
	
	/**
	 * bean 初始化通过初始化方法实现测试
	 * 
	 * @return void
	 */
	public static void getBeanContext5() {
		System.out.println("--- getBeanContext5 ---");
		HelloWorld2 helloWorld = (HelloWorld2) actx.getBean("HelloWorld3");
		System.out.println(helloWorld.getDate() + " -- " + helloWorld.getMsg());
		helloWorld.cleanup();
	}
	
	/**
	 * bean 初始化通过实现 InitializingBean 接口
	 * 
	 * @return void
	 */
	public static void getBeanContext6() {
		System.out.println("--- getBeanContext6 ---");
		HelloWorld3 helloWorld = (HelloWorld3) actx.getBean("HelloWorld4");
		System.out.println(helloWorld.getDate() + " -- " + helloWorld.getMsg());
		helloWorld.destroy();
	}
	
	/**
	 * 自动装配测试
	 * 
	 * @return void
	 */
	public static void getBeanContext7() {
		System.out.println("--- getBeanContext7 ---");
		
		//通过 Bean 的 id 来获取 Bean
		HelloWorld helloWorld = (HelloWorld) actx.getBean("HelloWorld5");
		
		System.out.println("helloWorld.getMsg()：" + helloWorld.getMsg());
		System.out.println("helloWorld.getTxt()：" + helloWorld.getTxt());
	}
	
	/**
	 * bean中集合元素测试
	 * 
	 * @return void
	 */
	public static void getBeanContext8() {
		System.out.println("--- getBeanForCollection ---");
		
		//通过 Bean 的 id 来获取 Bean
		HelloWorldForCollection helloWorld = (HelloWorldForCollection) actx.getBean("HelloWorldForCollection");
		
		System.out.println("List类型：" + helloWorld.getMsg());
		System.out.println("Set类型：" + helloWorld.getDat());
		System.out.println("Map类型：" + helloWorld.getMap());
		System.out.println("Properties类型：" + helloWorld.getPro());
	}
	
	/**
	 * 单例测试
	 * 	第一个对象改变了bean的值，第二个对象取到的就是改变后的值
	 * @return void
	 */
	public static void singletonTest() {
		System.out.println("--- singletonTest ---");
		HelloWorld2 helloWorld = (HelloWorld2) actx.getBean("HelloWorld1");
		System.out.println(helloWorld.getMsg());
		helloWorld.setMsg("更改bean的值");
		
		HelloWorld2 helloWorld2 = (HelloWorld2) actx.getBean("HelloWorld1");
		System.out.println(helloWorld2.getMsg());
		
		//xml中的bean默认是单例，直接new一个就是新的，不是取xml
		HelloWorld2 helloWorld3 = new HelloWorld2();
		System.out.println("helloWorld3:" + helloWorld3.getMsg());
	}
	
	/**
	 * 获取国际化
	 * 
	 * @return void
	 */
	public static void messageTest() {
		//设定当前时间
		Object[] objs = new Object[]{ "HelloMyFriend", Calendar.getInstance().getTime() };
		
		//国际化支持
		String msg = actx.getMessage("HelloWorld", objs, Locale.CHINA);
		System.out.println(msg);
	}
	
	/**
	 * 从ApplicationContext 获取文件
	 * 
	 * @return void
	 */
	public static void getFilet() {
		Resource resource = actx.getResource("classpath:message/messages.properties");
		try {
			
			//判断文件是否存在
			if (resource.exists()) {
				
				//获取文件
				File file = resource.getFile();
				System.out.println(file.length());				
			} else {
				System.out.println("文件不存在");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 事件传递
	 * 
	 * @return void
	 */
	public static void logTest() {
		Log log = (Log) actx.getBean("log");
		log.log("gf");
	}
}