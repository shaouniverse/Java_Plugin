package com.ShaoShuai.example.demo.a01.a01_03.a01_03_03;

import org.springframework.stereotype.Service;
/**
 * 使用注解的拦截类
 * @author ShaoShuai
 *
 */
@Service
public class DemoAnnotationService {
	@Action(name="注解式拦截的add操作")
	public void add() {
		System.out.println("123");
	}
}
