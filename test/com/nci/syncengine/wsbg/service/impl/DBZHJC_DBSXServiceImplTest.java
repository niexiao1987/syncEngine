package com.nci.syncengine.wsbg.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nci.syncengine.wsbg.dao.DBZHJC_DBSXDao;
import com.nci.syncengine.wsbg.entity.DBZHJC_DBSX;

@RunWith(SpringJUnit4ClassRunner.class)
//用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath:config/application-context.xml" })
//用于指定配置文件所在的位置
public class DBZHJC_DBSXServiceImplTest {
	@Autowired
	private DBZHJC_DBSXDao DBDBZHJC_DBSXDao;
	
	@Test
	public void getById(){
		DBZHJC_DBSX a = DBDBZHJC_DBSXDao.findById("00004F1CCBE1438085E60B3C10BFBA03");
		System.out.println(a);
	}
}
