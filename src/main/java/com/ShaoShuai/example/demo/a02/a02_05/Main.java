package com.ShaoShuai.example.demo.a02.a02_05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(EventConfig.class);
		
		DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
		
		demoPublisher.publish("hello application event");
		
		context.close();
	}
}
