package com.imooc.reflection;

public class Student extends Person {

	private String info;
	
	public String grade;
	
	public int chineseMark;
	
	private static final String hobby = "play basketball";

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getChineseMark() {
		return chineseMark;
	}

	public void setChineseMark(int chineseMark) {
		this.chineseMark = chineseMark;
	}
	
	public void run() {
		System.out.println("调用Student类的run方法");
	}
	
	public void speak(int age,String name) {
		System.out.println("调用Student类的speak方法");
		System.out.println("age-->"+age+" name--->"+name);
	}
	
	
	public static Integer demo(String s) {
		System.out.println("成功調用靜態方法demo()"+s);
		Integer ss = 1 ;
		return ss;
	}
}
