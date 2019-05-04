package com.ShaoShuai.example.demo.a02.a02_04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {
	@Bean
	@Profile("dev") //1
	public DemoBean devDemoBean() {
		return new DemoBean("from development profile");
	}

	@Bean
	@Profile("prod") //2
	public DemoBean prodDemoBean() {
		return new DemoBean("from production profile");
	}
}
