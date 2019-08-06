package com.imooc.utils.customizeAnnotation;

import java.lang.reflect.Field;

public class FruitRunAnnotation {

	public static void main(String[] args) {
		String strFruitName=" 水果名称：";
		try {
			Field[] fields = Apple.class.getDeclaredFields();
			 for(Field field :fields){
				 if(field.isAnnotationPresent(FruitName.class)){
					 FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
					 strFruitName=strFruitName+fruitName.value();
					 System.out.println(strFruitName);
				 }
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
