package com.ShaoShuai.example.demo.a02.a02_01.a02_01_02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
	
		DemoPrototypeService prototype1 = context.getBean(DemoPrototypeService.class);
		DemoPrototypeService prototype2 = context.getBean(DemoPrototypeService.class);
		
		DemoSingletonService single1 = context.getBean(DemoSingletonService.class);
		DemoSingletonService single2 = context.getBean(DemoSingletonService.class);
		
		System.out.println("prototype1 和 prototype2    " + prototype1.equals(prototype2) );
		System.out.println("single1 和 single2    " + single1.equals(single2));
		
		context.close();
	}
}
