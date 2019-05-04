package com.ShaoShuai.example.demo.a02.a02_03;

public class BeanWayService {
	public void init() {
		System.out.println("@Bean-init-method");
	}
	public BeanWayService() {
		super();
		System.out.println("初始化构造函数-BeanWayService");
	}
	public void destroy() {
		System.out.println("@Bean-destory-method");
	}
}
