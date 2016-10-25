package com.nci.syncengine.wsbg.service.impl;

import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath:config/application-context.xml" })
//用于指定配置文件所在的位置
public class TBXX_TBRWServiceImplTest {
	@Autowired
	private  com.nci.syncengine.wsbg.service.TBXX_TBRWService TBXX_TBRWService;
	@Test
	public void getById(){
		System.out.println(TBXX_TBRWService.findById(1));
	}
	
	
	@Test
	public void task(){
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("---22---");
				
			}
		};
		
		Timer timer = new Timer();
		long delay = 0;
		long intevalPeriod = 1*1000;
		timer.scheduleAtFixedRate(timerTask, delay, intevalPeriod);
		
	}
	

}
