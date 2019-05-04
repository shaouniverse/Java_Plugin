package com.ShaoShuai.example.demo.a03.a03_05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
		
		DemoService demoService =  context.getBean(DemoService.class);
		
		demoService.outputResult();
		
		context.close();
	}
}
