package com.ShaoShuai.example.demo.a02.a02_05;

import org.springframework.context.ApplicationEvent;
/**
 * 自定义事件
 * @author ShaoShuai
 *
 */
public class DemoEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private String msg;
	
	public DemoEvent(Object source,String msg) {
		super(source);
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
