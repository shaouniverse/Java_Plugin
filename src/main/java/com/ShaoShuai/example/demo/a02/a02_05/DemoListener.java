package com.ShaoShuai.example.demo.a02.a02_05;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
/**
 * 事件监听器
 * 实现ApplicationListener接口，并指定监听的事件类型。
 * 使用onApplicationEvent方法对消息进行接受处理
 * @author ShaoShuai
 *
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

	public void onApplicationEvent(DemoEvent event) {
		
		String msg = event.getMsg();
		
		System.out.println("我（bean-demoListener）接受到了bean-demoPublisher发布的消息：" + msg);

	}

}
