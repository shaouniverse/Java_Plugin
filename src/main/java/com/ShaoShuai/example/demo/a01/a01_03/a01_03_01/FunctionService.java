package com.ShaoShuai.example.demo.a01.a01_03.a01_03_01;

import org.springframework.stereotype.Service;

@Service
/**
 * 使用@Service注解声明当前FunctionService类是Spring管理的一个Bean.其中，
 * 使用@Component、@Service、@Repository和@Controller 是等效的，可根据需要选用
 * component组成   repository仓库
 * @author ShaoShuai
 *
 */

public class FunctionService {
	public String sayHello(String word) {
		return "Hello " + word +" !";
	}
}
