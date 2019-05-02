package com.ShaoShuai.example.demo.a02.a02_02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		 AnnotationConfigApplicationContext context =
	                new AnnotationConfigApplicationContext(ElConfig.class);
		 
		 ElConfig resourceService = context.getBean(ElConfig.class);
		 
		 resourceService.outputResource();
		 
		 context.close();
	}
}
