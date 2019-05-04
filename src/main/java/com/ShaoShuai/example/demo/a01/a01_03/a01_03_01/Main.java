package com.ShaoShuai.example.demo.a01.a01_03.a01_03_01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		//使用AnnotationConfigApplicationContext作为Spring 容器，接受输入一个配置类作为参数
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
		UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
		System.out.println(useFunctionService.SayHello("word"));
		context.close();
	}
}
