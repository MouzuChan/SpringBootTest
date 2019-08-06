package com.imooc.designPattern.publishSubscribe.subject;

import com.imooc.designPattern.publishSubscribe.core.Subject;

public class CarSubjectContainer extends Subject {

	private static CarSubjectContainer carSubject = new CarSubjectContainer();
	
	public static CarSubjectContainer getInstance() {
		return carSubject;
	}
}
