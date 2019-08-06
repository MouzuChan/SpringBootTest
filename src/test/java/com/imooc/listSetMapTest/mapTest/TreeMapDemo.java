package com.imooc.listSetMapTest.mapTest;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapDemo {
	

	/*
	 * 一、TreeMap

		TreeMap 默认排序规则：按照key的字典顺序来排序（升序）
		
		当然，也可以自定义排序规则：要实现Comparator接口。
	 * 
	 * 二、扩展：字典顺序

	1、排序规则

	 两个字符串 s1, s2比较

	（1）、如果s1和s2是父子串关系，则 子串 < 父串

	（2）、如果非为父子串关系， 则从第一个非相同字符来比较。

	　　　  例子 s1 = "ab", s2 = "ac"    这种情况算法规则是从第二个字符开始比较，由于'b' < 'c' 所以  "ab" < "ac"

	（3）、字符间的比较，是按照字符的字节码（ascii）来比较

	2、  compareTo 实现机制：对于字符串来说，字典排序规则；对于数字来说，直接按照大小排序*/
	
	
	public static void main(String[] args) {
		System.out.println("---------------- 默认 排序结果-----------------");
        createDefaultSortTreeMap();
        System.out.println("---------------- 自定义 排序结果-----------------");
        createDefinitionSortTreeMap();
	}
	
	public static void createDefaultSortTreeMap() {
        TreeMap<String, String> map = new TreeMap<String, String>();
        
        init(map);
        print(map);
    }
	
	 public static void createDefinitionSortTreeMap() {
	        
	        TreeMap<String, String> map = new TreeMap<String, String>(new Comparator<String>() {

	            @Override
	            public int compare(String o1, String o2) {
	                    return o2.compareTo(o1);
	            }
	            
	        });
	        
	        init(map);
	        print(map);
	    }
	 
	 public static void init(Map<String, String> map) {
	        map.put("c", "1");
	        map.put("a", "1");
	        map.put("bb", "1");
	        map.put("b", "1");
	    }
	 
	 public static void print(Map<String, String> map) {
	        Iterator<Entry<String, String>> it = map.entrySet().iterator();
	        while(it.hasNext()) {
	            Entry<String, String> entry = it.next();
	            System.out.println(entry.getKey() + " : " + entry.getValue());
	        }
	    }
	
}
