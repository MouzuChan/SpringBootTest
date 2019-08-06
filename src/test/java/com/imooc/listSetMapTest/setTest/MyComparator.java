package com.imooc.listSetMapTest.setTest;

import java.util.Comparator;

public class MyComparator implements Comparator<Student2> {

	@Override
	public int compare(Student2 s1, Student2 s2) {
		// 姓名长度		
		int num = s1.getName().length() - s2.getName().length();		
		// 姓名内容		
		int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;		
		// 年龄		
		int num3 = num2 == 0 ? s1.getAge() - s2.getAge() : num2;		
		return num3;

	}


}
