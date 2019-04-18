package com.ShaoShuai.example.demo.a03.a03_01.a03_01_02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AwareConfig.class);
		AwareService awareService = context.getBean(AwareService.class);
		awareService.outputResult();
		
		context.close();
	}
}
