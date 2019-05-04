package com.ShaoShuai.example.demo.a02.a02_03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * @author ShaoShuai
 *
 */

@Configuration
@ComponentScan("com.ShaoShuai.example.demo.a02.a02_03")
public class PrePostConfig {
	
	@Bean(initMethod="init",destroyMethod="destroy")//initMethod 和 destroyMethod 指定 BeanWayService 类的init 和 destroy 方法在构造之后、Bean销毁之前
	BeanWayService beanWayService() {
		return new BeanWayService();
	}
	@Bean
	JSR250WayService jsr250WayService() {
		return new JSR250WayService();
	}
}
