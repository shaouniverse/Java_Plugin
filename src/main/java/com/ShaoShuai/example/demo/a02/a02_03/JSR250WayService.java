package com.ShaoShuai.example.demo.a02.a02_03;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {
	@PostConstruct//@PostConstruct,在构造函数执行完后执行
	public void init() {
		System.out.println("jsr250-init-method");
	}
	public JSR250WayService() {
		super();
		System.out.println("初始化构造函数-JSR250WayService");
	}
	@PreDestroy//@PreDestroy,在Bean 销毁之前执行
	public void destroy() {
		System.out.println("jsr250-destory-method");
	}
}
