package com.ShaoShuai.example.demo.a03.a03_02;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
/**
 * 利用@EnableAsync注解开启异步任务支持
 * 配置类实现AsyncConfigurer接口并重写getAsyncExecutor方法，
 * 并返回一个ThreadPollTaskExecutor,这样可以获得一个基于线程池TaskExecutor
 * @author ShaoShuai
 *
 */
@Configuration
@ComponentScan("com.ShaoShuai.example.demo.a03.a03_02")
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {

	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setQueueCapacity(25);
		taskExecutor.initialize();
		return taskExecutor;
	}
	
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}
}
