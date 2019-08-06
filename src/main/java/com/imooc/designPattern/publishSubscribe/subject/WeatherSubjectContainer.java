package com.imooc.designPattern.publishSubscribe.subject;

import com.imooc.designPattern.publishSubscribe.core.Subject;

public class WeatherSubjectContainer extends Subject {
	
	private static WeatherSubjectContainer weatherInstance = new WeatherSubjectContainer();
	
	public static WeatherSubjectContainer getInstance() {
		return weatherInstance;
	}
}
