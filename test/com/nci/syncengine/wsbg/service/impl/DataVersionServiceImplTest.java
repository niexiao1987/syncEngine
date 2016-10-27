package com.nci.syncengine.wsbg.service.impl;

import javax.swing.JFrame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nci.syncengine.wsbg.entity.DateVersion;
import com.nci.syncengine.wsbg.entity.SFSQ_YHZH;
import com.nci.syncengine.wsbg.service.DateVersionService;

@RunWith(SpringJUnit4ClassRunner.class)
//用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath:config/application-context.xml" })
//用于指定配置文件所在的位置
public class DataVersionServiceImplTest {
	@Autowired
	private DateVersionService dateVersionService;
	@Test
	public void getDataVersionByCode(){
		DateVersion dateVersion = dateVersionService.findById("com.nci.syncengine.wsbg.entity.SFSQ_YHZH");
		System.out.println(dateVersion.getDataversion());
		if(dateVersion.getDataversion()==null){
			System.out.println("2222");
		}
	}
	
	@Test
	public void addDateVersion(){
		DateVersion dateVersion = new DateVersion();
		dateVersion.setYwCode(SFSQ_YHZH.class.getName());
		dateVersionService.save(dateVersion);
		
	}
	@Test
	public void updateDateVersion(){
		DateVersion dateVersion = dateVersionService.findById("com.nci.syncengine.wsbg.entity.SFSQ_YHZH");
		dateVersion.setDataversion(0L);
		dateVersionService.update(dateVersion);
	}

}
