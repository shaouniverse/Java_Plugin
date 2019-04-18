package com.ShaoShuai.example.demo.a01.a01_03.a01_03_01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//声明当前类是一个配置类
@ComponentScan("com.ShaoShuai.example.demo.a01.a01_03.a01_03_01")
//自动扫描包名下的所使用@Service、@Component、@Repository和@Controller的类，并注册为Bean
public class DiConfig {

}
