package com.ShaoShuai.example.demo.a03.a03_04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConditionConifg.class);
		
		ListService listService = context.getBean(ListService.class);
		
		
		System.out.println(context.getEnvironment().getProperty("os.name") 
				+ "系统下的列表命令为: " 
				+ listService.showListCmd());
		
		context.close();
	}
}
