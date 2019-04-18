package com.ShaoShuai.example.demo.a03.a03_03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
	}
}
