package com.nci.syncengine.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskJob")
public class TaskJob {
	@Scheduled(cron = "0 0 3 * * ?")
	public void syncUser(){
		
	}
}
