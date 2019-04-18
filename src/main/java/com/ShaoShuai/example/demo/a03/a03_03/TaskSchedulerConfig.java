package com.ShaoShuai.example.demo.a03.a03_03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.ShaoShuai.example.demo.a03.a03_03")
@EnableScheduling
//通过@EnableScheduling注解开启对计划任务的支持
public class TaskSchedulerConfig {

}
