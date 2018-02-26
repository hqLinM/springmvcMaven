package com.pro.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 集合类型类
 * @author hqLin
 * @date 2018年1月19日 下午3:53:08
 */
public class HelloWorldForCollection {
	
	private List<String> msg;
	private Set<String> dat;
	private Map<String, Object> map;
	private Properties pro;

	public List<String> getMsg() {
		return msg;
	}

	public void setMsg(List<String> msg) {
		this.msg = msg;
	}

	public Set<String> getDat() {
		return dat;
	}

	public void setDat(Set<String> dat) {
		this.dat = dat;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Properties getPro() {
		return pro;
	}

	public void setPro(Properties pro) {
		this.pro = pro;
	}
}