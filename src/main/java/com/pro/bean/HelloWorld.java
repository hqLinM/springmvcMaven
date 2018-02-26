package com.pro.bean;

/**
 * 构造方法
 * @author hqLin
 * @date 2018年1月19日 下午3:52:41
 */
public class HelloWorld {
	public String msg;
	private String txt;
//	private Date date = null;
	
	//构造方法
	public HelloWorld(String msg, String txt) {
		this.msg = msg;
		this.txt = txt;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}
}
