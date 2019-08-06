package com.imooc.interviewDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnNumberTOArabiaNumerals {

	public static void main(String[] args) {
		String[] a={"zero","one","two", "three","four", "five","six","seven","eight","nine"};
	    //测试数字 zerofourzerothreefourfive
		Scanner input=new Scanner(System.in);
	    System.out.println("请输入英文数字,输入完之后请按回车键！"); 
	    System.out.println("测试数字为zerofourzerothreefourfive");
	    String str=input.next();
	    String c=str;//这是输入的英文数字
	    String cCopy=str;//这是复制的输入的英文数字
	    List<String> list=new ArrayList<String>();
	    int count=0;
	    for (int i = 0; i < str.length(); i++) {
		    for (int j= 0; j < a.length; j++) {
			  if(cCopy.startsWith(a[j])){
			   count++;
			   cCopy=cCopy.substring(a[j].length(), cCopy.length());
			   break;
			  }
		  }
	  	}
	    
	    //count为c的个数,将c中的数存入到list集合中去;
	    for (int i = 0; i < count; i++) {
			for (int j = 0; j < a.length; j++) {
				if(c.startsWith(a[j])){
		  	       list.add(a[j]);
			       c=c.substring(a[j].length(), c.length());
		 	       break;
			 	}
			}
		}
	    
	    //list集合的数和数组a进行判断，找出下标;
	    System.out.print("你输入的英文数字为:");
	    for (int i = 0; i < list.size(); i++) {
	    	System.out.print(list.get(i));
	    }
	    
	    System.out.println();
	    System.out.print("英文转换为阿拉伯数字为:");
	    for (int i = 0; i < list.size(); i++) {
		    for (int j = 0; j < a.length; j++) {
				if(list.get(i).equals(a[j])){
					System.out.print(j);
				}
			}
		}
	    
	}
	
	
	

}
