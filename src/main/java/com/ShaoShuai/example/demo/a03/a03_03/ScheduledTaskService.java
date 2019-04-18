package com.ShaoShuai.example.demo.a03.a03_03;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
/**
 * 通过@Scheduled声明该方法是一个计划任务，使用fixedRate属性每阁固定时间执行。
 *	使用cron属性可按照指定时间执行，crom是UNIX和类UNix（Linux）系统下的定时任务
 * @author ShaoShuai
 *
 */
@Service
public class ScheduledTaskService {

	private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		System.out.println("每隔五秒执行一次" + dataFormat.format(new Date()));
	}
	
	@Scheduled(cron = "0 27 17 ? * *")
	public void fixTimeExecution() {
		System.out.println("在指定时间 " + dataFormat.format(new Date()) + "执行" );
	}
}
