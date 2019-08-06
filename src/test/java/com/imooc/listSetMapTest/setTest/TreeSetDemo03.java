package com.imooc.listSetMapTest.setTest;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo03 {

	public static void main(String[] args) {
		// 如果一个方法的参数是接口，那么真正要的是接口的实现类的对象		
		// 而匿名内部类就可以实现这个东西		
		TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {			
			@Override			
			public int compare(Student s1, Student s2) {				
				// 姓名长度				
				int num = s2.getName().length() - s1.getName().length();				
				// 姓名内容				
				int num2 = num == 0 ? s2.getName().compareTo(s1.getName()): num;				
				// 年龄				
				int num3 = num2 == 0 ? s2.getAge() - s1.getAge() : num2;				
				return num3;			
				}		
			}); 		
		// 创建元素		
		Student s1 = new Student("linqingxia", 27);		
		Student s2 = new Student("zhangguorong", 29);		
		Student s3 = new Student("wanglihong", 23);		
		Student s4 = new Student("linqingxia", 27);		
		Student s5 = new Student("liushishi", 22);		
		Student s6 = new Student("wuqilong", 40);		
		Student s7 = new Student("fengqingy", 22);		
		Student s8 = new Student("linqingxia", 29); 		
		// 添加元素		
		ts.add(s1);		
		ts.add(s2);		
		ts.add(s3);		
		ts.add(s4);		
		ts.add(s5);		
		ts.add(s6);		
		ts.add(s7);		
		ts.add(s8); 		
		// 遍历		
		System.out.println("TreeSet比較器排序法。。。");
		for (Student s : ts) {			
			System.out.println(s.getName() + "---" + s.getAge());		
			}
		}

	}

