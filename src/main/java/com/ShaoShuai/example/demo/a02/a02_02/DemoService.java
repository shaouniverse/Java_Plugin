package com.ShaoShuai.example.demo.a02.a02_02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
/**
 * 被注入的Bean
 * @author ShaoShuai
 *
 */
@Service
public class DemoService {
	@Value("其他类的属性")
	private String another;

	public String getAnother() {
		return another;
	}

	public void setAnother(String another) {
		this.another = another;
	}
	
}
