package com.constq.demo.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Factory {
	public static String getRandom(){
		Date date = new Date();
		DateFormat formate = new SimpleDateFormat("yyyyMMdd");
		return formate.format(date)+date.getTime();
	}
}
