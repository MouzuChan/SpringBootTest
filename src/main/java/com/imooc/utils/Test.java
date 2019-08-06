package com.imooc.utils;

public class Test {

	public static void main(String[] args){
		String str = "kobeBryant";
//		String subStr = str.substring(4);
		System.out.println(str);
//		System.out.println(subStr);
		System.out.println(reverse(str));
				
	}
	
	public static String reverse(String originStr) {
	      if(originStr == null || originStr.length() <= 1) 
	          return originStr;
	      return reverse(originStr.substring(1)) + originStr.charAt(0);
	  }
	
}
