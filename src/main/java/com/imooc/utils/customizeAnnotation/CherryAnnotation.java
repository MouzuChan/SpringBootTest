package com.imooc.utils.customizeAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface CherryAnnotation {

	/**
	 * 
	 * <br>
	 * 适用场景:	<br>
	 * 调用方式:	<br>
	 * 业务逻辑说明<br>
	 * 			1)访问修饰符必须为public，不写默认为public；
				2)该元素的类型只能是基本数据类型、String、Class、枚举类型、注解类型（体现了注解的嵌套效果）以及上述类型的一位数组；
				3)该元素的名称一般定义为名词，如果注解中只有一个元素，请把名字起为value（后面使用会带来便利操作）；
				4)()不是定义方法参数的地方，也不能在括号中定义任何参数，仅仅只是一个特殊的语法；
				5)default代表默认值，值必须和第2点定义的类型一致；
				6)如果没有默认值，代表后续使用注解时必须给该类型元素赋值。
	 *
	 * @return
	 * @autho chenzhiguan
	 * @time 2019年7月16日 下午11:15:32
	 */
	public String name();
	int age() default 18;
	int[] score();
	
}
