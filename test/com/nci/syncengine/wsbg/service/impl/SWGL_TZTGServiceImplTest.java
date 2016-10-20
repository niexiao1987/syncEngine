package com.nci.syncengine.wsbg.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nci.syncengine.wsbg.entity.SWGL_TZTG;

@RunWith(SpringJUnit4ClassRunner.class)
//用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath:config/application-context.xml" })
//用于指定配置文件所在的位置
public class SWGL_TZTGServiceImplTest {
	@Autowired
	private com.nci.syncengine.wsbg.service.SWGL_TZTGService SWGL_TZTGService;
	
	@Test
	public void findById(){
		SWGL_TZTG SWGL_TZTG =  SWGL_TZTGService.findById("009293072B5E4BF79027762ACB36C4D1");
		System.out.println(SWGL_TZTG);
	}
}
