package com.nci.syncengine.wsbg.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.axis.AxisFault;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jeaw.webservice.client.WebServiceClientException;
import com.nci.syncengine.wsbg.engine.DBSXEngine;
import com.nci.syncengine.wsbg.engine.TZTGEngine;
import com.nci.syncengine.wsbg.entity.DBZHJC_DBSX;
import com.nci.syncengine.wsbg.entity.DateVersion;
import com.nci.syncengine.wsbg.entity.SWGL_TZTG;
import com.nci.syncengine.wsbg.entity.TBXX_TBRW;
import com.nci.syncengine.wsbg.service.DBZHJC_DBSXService;
import com.nci.syncengine.wsbg.service.DateVersionService;
import com.nci.syncengine.wsbg.service.SWGL_TZTGService;

@RunWith(SpringJUnit4ClassRunner.class)
// 用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath:config/application-context.xml" })
// 用于指定配置文件所在的位置
public class TBXX_TBRWServiceImplTest {
	private static final String BMTZTG = "SWGL_TZTG";
	private static final String BMDBSX = "DBZHJC_DBSX";
	private static final String ZT_YCK = "1"; // 已经处理的状态标识符
	private static final String ZT_WCK = "0"; // 未处理的状态标识符
	@Autowired
	private com.nci.syncengine.wsbg.service.TBXX_TBRWService TBXX_TBRWService;
	@Autowired
	private DateVersionService dateVersionService;
	@Autowired
	private SWGL_TZTGService SWGL_TZTGService;
	@Autowired
	private DBZHJC_DBSXService DBZHJC_DBSXService;
	@Autowired
	private com.nci.syncengine.wsbg.service.SWGL_TZFJService SWGL_TZFJService;
	@Autowired
	private  TZTGEngine tztgEngine;
	@Autowired
	private  DBSXEngine dbsxEngine;

	@Test
	public void getById() {
		System.out.println(TBXX_TBRWService.findById(1));
	}

	@Test
	public void addDataVersion() {
		DateVersion dateVersion = new DateVersion();
		dateVersion.setYwCode(TBXX_TBRW.class.getName());
		dateVersionService.save(dateVersion);
	}

	@Test
	public void getDataVersion() {
		DateVersion a = dateVersionService.findById(TBXX_TBRW.class.getName());
		System.out.println(a);
	}

	@Test
	public void updateDataVersion() {
		DateVersion a = dateVersionService.findById(TBXX_TBRW.class.getName());
		a.setDataversion(0L);
		dateVersionService.update(a);
	}

	/**
	 * 获取同步任务表list
	 */
	@Test
	public void getTBRWList() {
		List<TBXX_TBRW> tbrwList = TBXX_TBRWService.getByZT(ZT_WCK);
		for (int i = 0; i < tbrwList.size(); i++) {
			System.out.println(tbrwList.get(i));
		}
	}

	@Test
	public void changeZT() {
		String zt = "0";
		TBXX_TBRWService.changeZT(zt);
	}

	

	/**
	 * 获取数据库中的dateVersion,根据dateVersion获得同步任务List，并更新dataversion
	 * 
	 * @return List<TBXX_TBRW>
	 */
	@Test
	public void saveToMenhu() {
		List<TBXX_TBRW> tbrwList = TBXX_TBRWService.getByZT(ZT_WCK);
		if (tbrwList != null) {
			List<String> errorBidList = new ArrayList<String>();
			for (TBXX_TBRW tbrw : tbrwList) {
				if(errorBidList.contains(tbrw.getBID())){
					continue;
				}
				// 获取通知公告
				if (BMTZTG.endsWith(tbrw.getBM())) {
					String tztgId = tbrw.getBID();
					SWGL_TZTG tztg = SWGL_TZTGService.findById(tztgId);
					try {
						TZTGSaveOrUpdate(tbrw.getLX(), tztg);
					} catch (RemoteException e) {
						System.out.println("同步表["+tbrw.getBM()+"]的ID为["+tbrw.getBID()+"]的数据发生错误");
						errorBidList.add(tbrw.getBID());
						continue;
					}
					// 通知公告附件
					// SWGL_TZFJ fj = SWGL_TZFJService.getBySWGL_TZTGId(tztgId);

					
				}
				// 获取代办事项
				if (BMDBSX.equals(tbrw.getBM())) {
					String dbsxId = tbrw.getBID();
					DBZHJC_DBSX dbsx = DBZHJC_DBSXService.findById(dbsxId);
					try {
						DBSXSaveOrUpdate(tbrw,dbsx);
					} catch (Exception e) {
						System.out.println("同步表["+tbrw.getBM()+"]的ID为["+tbrw.getBID()+"]的数据发生错误");
						errorBidList.add(tbrw.getBID());
						continue ;
					}
				}
				
				// 已经同步到门户，将状态置为1
				tbrw.setZT(ZT_YCK);
				TBXX_TBRWService.update(tbrw);

			}

		}

	}
	

	// 根据同步任务表和通知公告的状态判断是删除还是新增，更新
	private void TZTGSaveOrUpdate(String lx, SWGL_TZTG tztg) throws AxisFault,
			RemoteException {
		System.out.println("状态:" + lx);
		// 新增
		if ("i".equals(lx)) {
			tztgEngine.saveAndPublish(tztg);
			System.out.println("insert：" + tztg);
		}
		// 删除
		if ("u".equals(lx) && "1".equals(tztg.getDeleted())) {
			tztgEngine.delete(tztg);
			System.out.println("del：" + tztg);
		}
		
		//更新
		if("u".equals(lx)&&"0".equals(tztg.getDeleted())){
			tztgEngine.saveAndPublish(tztg);
			System.out.println("update："+tztg);
		}
	}
	//根据同步任务表和代办事项的状态判断是删除还是新增，更新
	private void DBSXSaveOrUpdate(TBXX_TBRW rw,DBZHJC_DBSX  dbsx) throws AxisFault, RemoteException, WebServiceClientException{
		if("i".equals(rw.getLX())){
			dbsxEngine.addNotice(dbsx);
			System.out.println("insert:"+dbsx);
		}
		if("d".equals(rw.getLX())){
			dbsxEngine.completedNotice(rw.getBID());
			System.out.println("del:"+dbsx);
		}
	}
}
