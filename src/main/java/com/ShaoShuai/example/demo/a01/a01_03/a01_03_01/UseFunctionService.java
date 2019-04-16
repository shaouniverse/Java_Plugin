package com.ShaoShuai.example.demo.a01.a01_03.a01_03_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 使用@Service注解声明当前UseFunctionService类是Spring管理的一个Bean
 * @author ShaoShuai
 *
 */
@Service
public class UseFunctionService {
	/*
	 * 使用@Autowired 将FunctionService的实体注入到UseFunctionService中，
	 * 让UseFunctionService具备FunctionService的功能，此处使用JSR-330的@Inject注解或这JSR-250的@Resource注解是等效的
	 */
	@Autowired
	FunctionService functionServiec;
	
	public String SayHello(String word) {
		return functionServiec.sayHello(word);
	}
}
