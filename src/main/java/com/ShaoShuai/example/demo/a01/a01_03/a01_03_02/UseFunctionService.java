package com.ShaoShuai.example.demo.a01.a01_03.a01_03_02;

public class UseFunctionService {

	FunctionService functionService;
	
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}
	
	public String SayHello(String word) {
		return functionService.sayHello(word);
	}
}
