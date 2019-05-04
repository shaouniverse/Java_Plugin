package com.ShaoShuai.example.demo.a03.a03_05;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration //1 元注解
@ComponentScan //2 元注解
public @interface WiselyConfiguration {
	String[] value() default {}; //3 覆盖value参数
}
