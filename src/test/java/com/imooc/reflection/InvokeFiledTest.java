package com.imooc.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeFiledTest {

	/**
     * 获取字段方法和前面获取构造器和方法大同小异。getFileds():获取所有Public修饰的字段以及继承自父类的字段   规则与获取构造和方法大同小异
     * @param args
     * @throws Exception
     */

	public static void main(String[] args) {
		
		 Class claz = Student.class;
//		 Class claz1=Class.forName("com.imooc.reflection.Student");

		 System.out.println("-------------》获取所有的public和继承的public字段");
		 Field[] fields = claz.getFields();
		 for(Field field : fields) {
			 System.out.println(field);
		 }
		 
		 System.out.println("-------------》获取所有的字段包括public和private,但不包括继承的字段：");
		 Field[] fieldDecrs = claz.getDeclaredFields();
		 for(Field fieldDecr : fieldDecrs) {
			 System.out.println(fieldDecr);
		 }
		 
		 System.out.println("-------------》获取指定名称的public字段：");
		 Field namePublicField = null;
		 try {
			 namePublicField = claz.getField("grade");
			 System.out.println(namePublicField);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		 
		 System.out.println("-------------》获取指定名称的private字段：");
		 Field namePrivateField = null;
		 try {
			 namePrivateField = claz.getDeclaredField("info");
			 System.out.println(namePrivateField);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();//在控制台打印出异常种类、错误信息和出错位置等
		}
		 
		 
		 
		 /**
	       *为字段设值：setxxx(obj,基本类型数据)基本类型字段设值；  set(obj,引用类型数据)  引用类型设值 obj为字段所在底层对象 如果是静态字段则obj可以为NULL
	       */
		 /*给字段设置值*/
		 System.out.println("-------------》给public字段设置值：");
		 try {
			 Object newInstance = claz.newInstance();
			 namePublicField.set(newInstance, "七年级");
			 System.out.println(namePublicField.get(newInstance));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}catch(InstantiationException e) {
			e.printStackTrace();
		}
		 
		//给私有字段设置
		 System.out.println("-------------》给private字段设置值：");
		 try {
			 Object newInstance2 = claz.newInstance();
			 namePrivateField.setAccessible(true);
			 namePrivateField.set(newInstance2, "个人资料保密");
			 System.out.println(namePrivateField.get(newInstance2));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}catch(InstantiationException e) {
			e.printStackTrace();
		}
		
		 
		 /**
		  * 获取字段值 ：getxxx(obj) get(obj) 如果字段为static修饰则obj可以为null
		  */
		
		 //获取私有静态字段的值
		Field staticField = null;
		 try {
			 staticField = claz.getDeclaredField("hobby");
			 staticField.setAccessible(true);
			 System.out.println(staticField.get(null)+"******私有靜態引用類型");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}catch(IllegalAccessException e) {
			e.printStackTrace();
		}
		 
		
		 //调用Student类的run方法
		 Method methodRun = null;
		 Method methodSpeak = null;
		 Method methodStatic = null;
		 try {
			 methodRun = claz.getMethod("run");
			 methodRun.invoke(claz.newInstance());
			 
			 methodSpeak = claz.getMethod("speak", int.class, String.class);
			 methodSpeak.invoke(claz.newInstance(), 22, "KOBE");
			 
			 /*methodStatic = claz.getMethod("demo", new Class[] {String.class});
			 String result = methodStatic.invoke(null, new Object[] {"The Lakers Is Championship"}).toString();*/
			 methodStatic = claz.getMethod("demo", String.class);
			 String result = methodStatic.invoke(null, "The Lakers Is Championship").toString();
			 System.out.println("調用靜態方法返回結果為："+result);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}catch(IllegalAccessException e) {
			e.printStackTrace();
		}catch(InstantiationException e) {
			e.printStackTrace();
		}catch(InvocationTargetException e) {
			e.printStackTrace();
		}
		 
		 
	}
	
	
	

}
