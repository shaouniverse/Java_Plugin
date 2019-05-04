package com.ShaoShuai.example.demo.a02.a02_04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		  AnnotationConfigApplicationContext context =  
				  new AnnotationConfigApplicationContext();
		  
		  context.getEnvironment().setActiveProfiles("prod"); //1
		  context.register(ProfileConfig.class);//2  后注册Bean配置类,不然会报Bean未定义的错误
		  context.refresh(); //3
		  
	      DemoBean demoBean = context.getBean(DemoBean.class);
	      
	      System.out.println(demoBean.getContent());
	      
	      context.close();
	}
}
