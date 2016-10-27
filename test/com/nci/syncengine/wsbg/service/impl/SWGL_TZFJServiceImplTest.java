package com.nci.syncengine.wsbg.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nci.syncengine.wsbg.entity.SWGL_TZFJ;

@RunWith(SpringJUnit4ClassRunner.class)
//用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath:config/application-context.xml" })
//用于指定配置文件所在的位置
public class SWGL_TZFJServiceImplTest {
	@Autowired
	private com.nci.syncengine.wsbg.service.SWGL_TZFJService SWGL_TZFJService;
	
	@Test
	public void getById(){
		SWGL_TZFJ a =SWGL_TZFJService.findById("004190575CA94019B1CB8674B70CF3EB");
		System.out.println(a);
	}
	
	@Test
	public void getBySWGL_TZTGId(){
		SWGL_TZFJ a =SWGL_TZFJService.getBySWGL_TZFJId("D41D2C8BC4054CAF98D47D92154AEE5C");
		System.out.println(a);
	}
}
