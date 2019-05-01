package com.ShaoShuai.example.demo.a01.a01_03.a01_03_03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置类
 * @author ShaoShuai
 *
 */
@Configuration
@ComponentScan("com.ShaoShuai.example.demo.a01.a01_03.a01_03_03")
@EnableAspectJAutoProxy//使用@EnableAspectJAutoProxy注解开启Spring对AspectJ的支持
public class AopConfig {
	
}
