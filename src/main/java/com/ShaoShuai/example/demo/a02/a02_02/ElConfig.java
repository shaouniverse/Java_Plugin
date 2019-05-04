package com.ShaoShuai.example.demo.a02.a02_02;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.ShaoShuai.example.demo.a02.a02_02")
@PropertySource("classpath:com/ShaoShuai/example/demo/a02/a02_02/test.properties")
public class ElConfig {
	
	@Value("I Love You")
	private String normal;//注入普通字符串
	
	@Value("#{systemProperties['os.name']}")
	private String osName;//注入操作系统属性
	
	@Value("#{ T(java.lang.Math).random() * 100.0 }")
	private double randomNumber;//注入表达式结果
	
	@Value("#{demoService.another}") 
	private String fromAnother;//注入其他Bean属性

	@Value("classpath:com/ShaoShuai/example/demo/a02/a02_02/test.txt") 
	private Resource testFile;//注入文件资源

	@Value("http://www.baidu.com") 
	private Resource testUrl;//注入网址资源

	@Value("${book.name}") 
	private String bookName;//注入配置文件

	@Autowired
	private Environment environment; //注入配置文件
	
/*	@Bean//注入配置文件
	public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
		return new PropertySourcesPlaceholderConfigurer();
	}*/ //不太明白没用啊
	
	public void outputResource() {
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(fromAnother);
			
			System.out.println(IOUtils.toString(testFile.getInputStream(),"UTF-8"));
			System.out.println(IOUtils.toString(testUrl.getInputStream(),"UTF-8"));
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
