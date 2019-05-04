package com.ShaoShuai.example.demo.a02.a02_05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
/**
 * 事件发布类
 * @author ShaoShuai
 *
 */
@Component
public class DemoPublisher {
	//注入ApplicationContext用来发布事件
	@Autowired
	ApplicationContext applicationContext;
	
	public void publish(String msg) {
		//使用ApplicationContext的publishEvent方法来发布
		applicationContext.publishEvent(new DemoEvent(this, msg));
	}
	
}
