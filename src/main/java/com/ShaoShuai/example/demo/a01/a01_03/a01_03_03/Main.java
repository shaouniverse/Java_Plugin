package com.ShaoShuai.example.demo.a01.a01_03.a01_03_03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
		DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
		
		demoAnnotationService.add();
		demoMethodService.add();
		context.close();
	}
}
