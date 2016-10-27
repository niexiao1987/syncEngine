package com.nci.syncengine.wsbg.service.impl;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nci.syncengine.wsbg.entity.DBZHJC_DBSX;
import com.nci.syncengine.wsbg.entity.DateVersion;
import com.nci.syncengine.wsbg.entity.SFSQ_YHZH;
import com.nci.syncengine.wsbg.entity.SWGL_TZFJ;
import com.nci.syncengine.wsbg.entity.SWGL_TZTG;
import com.nci.syncengine.wsbg.entity.TBXX_TBRW;
import com.nci.syncengine.wsbg.service.DBZHJC_DBSXService;
import com.nci.syncengine.wsbg.service.DateVersionService;
import com.nci.syncengine.wsbg.service.SWGL_TZTGService;

@RunWith(SpringJUnit4ClassRunner.class)
//用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath:config/application-context.xml" })
//用于指定配置文件所在的位置
public class TBXX_TBRWServiceImplTest {
	private static final String BMTZTG = "SWGL_TZTG";
	private static final String BMDBSX = "DBZHJC_DBSX";
	@Autowired
	private  com.nci.syncengine.wsbg.service.TBXX_TBRWService TBXX_TBRWService;
	@Autowired
	private DateVersionService dateVersionService;
	@Autowired
	private SWGL_TZTGService SWGL_TZTGService;
	@Autowired
	private DBZHJC_DBSXService DBZHJC_DBSXService;
	@Autowired
	private com.nci.syncengine.wsbg.service.SWGL_TZFJService SWGL_TZFJService;
	@Test
	public void getById(){
		System.out.println(TBXX_TBRWService.findById(1));
	}
	
	@Test
	public void addDataVersion(){
		DateVersion dateVersion = new DateVersion();
		dateVersion.setYwCode(TBXX_TBRW.class.getName());
		dateVersionService.save(dateVersion);
	}
	
	@Test
	public void getDataVersion(){
		DateVersion a = dateVersionService.findById(TBXX_TBRW.class.getName());
		System.out.println(a);
	}
	
	@Test
	public void updateDataVersion(){
		DateVersion a = dateVersionService.findById(TBXX_TBRW.class.getName());
		a.setDataversion(0L);
		dateVersionService.update(a);
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
		long intevalPeriod = 5*1000;
		timer.scheduleAtFixedRate(timerTask, delay, intevalPeriod);
		
	}
	
	
	
	/**
	 * 获取数据库中的dateVersion,根据dateVersion获得同步任务List，并更新dataversion
	 * @return List<TBXX_TBRW>
	 */
	@Test
	public void getByDataVersion(){
		DateVersion a = dateVersionService.findById(TBXX_TBRW.class.getName());
		if(a==null){
			DateVersion version = new DateVersion();
			version.setYwCode(TBXX_TBRW.class.getName());
			version.setYwCode("0");
			dateVersionService.save(version);
		}
		Long dataVersion = a.getDataversion()==null?0:a.getDataversion();
		Long dv = dataVersion;
		List<TBXX_TBRW> tbrwList = TBXX_TBRWService.getByDataVersion(dataVersion);
		if(tbrwList!=null){
			for(TBXX_TBRW tbrw:tbrwList){
				System.out.println(tbrw);
				if(tbrw.getID()>dataVersion){
					dataVersion = tbrw.getID().longValue();
				}
				//获取代办事项和通知公告
				if(BMTZTG.endsWith(tbrw.getBM())){
					String tztgId = tbrw.getBID();
					SWGL_TZTG tztg = SWGL_TZTGService.findById(tztgId);
					System.out.println(tztg);
					//通知公告附件
					SWGL_TZFJ fj = SWGL_TZFJService.findById(tztgId);
					System.out.println(fj);
				}
				
				if(BMDBSX.equals(tbrw.getBM())){
					String dbsxId = tbrw.getBID();
					DBZHJC_DBSX dbsx = DBZHJC_DBSXService.findById(dbsxId);
					System.out.println(dbsx);
				}
				
			}
			
			if(dataVersion>dv){
				a.setDataversion(dataVersion);
				dateVersionService.update(a);
			}
		}
		
		
	}
}
