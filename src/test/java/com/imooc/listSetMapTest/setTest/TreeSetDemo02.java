package com.imooc.listSetMapTest.setTest;

import java.util.TreeSet;

public class TreeSetDemo02 {

	public static void main(String[] args) {
		
		/**
		 * 比較器排序法
		 * 1.單獨創建一個比較器類，這裡以MyComparator為例，並且要讓其繼承Compartor<T>接口
		 * 2.重寫Comparator接口中的Compare方法，比較用來排序的兩個參數
		 * 3.在TreeSet的構造方法中指定自定義的構造器
		 */
		//创建集合对象		
		//TreeSet(Comparator<? super E> comparator) 构造一个新的空 TreeSet，它根据指定比较器进行排序。		
		TreeSet<Student2> ts=new TreeSet<Student2>(new MyComparator()); 		
		//创建元素对象		
		Student2 s1=new Student2("zhangsan",20);		
		Student2 s2=new Student2("lis",22);		
		Student2 s3=new Student2("wangwu",24);		
		Student2 s4=new Student2("chenliu",26);		
		Student2 s5=new Student2("zhangsan",22);		
		Student2 s6=new Student2("qianqi",24);				
		//将元素对象添加到集合对象中		
		ts.add(s1);		
		ts.add(s2);		
		ts.add(s3);		
		ts.add(s4);		
		ts.add(s5);		
		ts.add(s6);				
		//遍历		
		for(Student2 s:ts){			
			System.out.println(s.getName()+"-----------"+s.getAge());		
		}


	}

}
