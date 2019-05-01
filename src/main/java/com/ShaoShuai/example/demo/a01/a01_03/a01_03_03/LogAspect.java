package com.ShaoShuai.example.demo.a01.a01_03.a01_03_03;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect//通过@Aspect注解声明一个切面
@Component//@Component让此切面成为Spring容器管理的Bean
public class LogAspect {
	@Pointcut("@annotation(com.ShaoShuai.example.demo.a01.a01_03.a01_03_03.Action)")//通过@PointCut注解声明切点
	public void annotationPointCut() {};
	
	@After("annotationPointCut()")//通过@After注解声明一个建言，并使用@PointCut定义的切点
	public void annotationPonintCut(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);//通过反射可获得注解上的属性，然后做日志记录相关的操作，下面的相同
		System.out.println("注解式拦截" + action.name());
		
	}
	
	@Before("execution(* com.ShaoShuai.example.demo.a01.a01_03.a01_03_03.DemoMethodService.*(..))")//通过@Before注解声明一个建言，此建言直接使用拦截规则作为参数
	public void before (JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法规则式拦截" + method.getName());
	}
	
}
