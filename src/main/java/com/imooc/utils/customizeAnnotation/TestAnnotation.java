package com.imooc.utils.customizeAnnotation;

import java.lang.reflect.Method;

public class TestAnnotation {

	public static void main(String[] args) {
		try {
            //获取Student的Class对象
            Class stuClass = Class.forName("pojos.Student");

            //说明一下，这里形参不能写成Integer.class，应写为int.class
            Method stuMethod = stuClass.getMethod("study",int.class);

            if(stuMethod.isAnnotationPresent(CherryAnnotation.class)){
                System.out.println("Student类上配置了CherryAnnotation注解！");
                //获取该元素上指定类型的注解
                CherryAnnotation cherryAnnotation = stuMethod.getAnnotation(CherryAnnotation.class);
                System.out.println("name: " + cherryAnnotation.name() + ", age: " + cherryAnnotation.age()
                    + ", score: " + cherryAnnotation.score()[0]);
            }else{
                System.out.println("Student类上没有配置CherryAnnotation注解！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

	}

}
