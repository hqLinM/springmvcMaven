package com.pro.test;

import com.pro.action.TimeBook;

public class AopTest {

	public static void main(String[] args) {
		TimeBook timeBook = new TimeBook();
		timeBook.doAuditing("小茂");
	}

}
