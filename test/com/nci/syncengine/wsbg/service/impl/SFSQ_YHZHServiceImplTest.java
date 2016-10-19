package com.nci.syncengine.wsbg.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nci.syncengine.wsbg.entity.SFSQ_YHZH;
import com.nci.syncengine.wsbg.service.SFSQ_YHZHService;

@RunWith(SpringJUnit4ClassRunner.class)
// 用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath:config/application-context.xml" })
// 用于指定配置文件所在的位置
public class SFSQ_YHZHServiceImplTest {

	@Autowired
	private SFSQ_YHZHService SFSQ_YHZHService;

	@Test
	public void testFindAll() {
		List<SFSQ_YHZH> list = SFSQ_YHZHService.findAll();
		System.out.println(list.size());
	}

	@Test
	public void testAdd() {
		SFSQ_YHZH entity = new SFSQ_YHZH();
		entity.setID("test");
		entity.setYHBH("test");
		entity.setXM("test");
		entity.setQSL(0);
		entity.setCYQSL(0);
		entity.setQCYS(0);
		entity.setTXWJDX(0);
		boolean flag = SFSQ_YHZHService.addSFSQ_YHZH(entity);
		System.out.println(flag);
	}
	
	@Test
	public void testNewYHBH() {
		System.out.println(SFSQ_YHZHService.newYHBH());
	}
}
