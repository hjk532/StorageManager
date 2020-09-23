package com.hjk532.spring.control.convert;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;

public class DateFormat implements Converter<String, Date>{

	@Override
	public Date convert(String arg0){
		if(arg0!="" & arg0!=null) {
			//将String 日期串转成sql.Date格式： yyyy-mm-dd
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			try {
				return new Date(simpleDateFormat.parse(arg0).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		//若参数绑定失败则返回空
		return null;
	}
	
}
