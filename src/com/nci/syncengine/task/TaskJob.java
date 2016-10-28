package com.nci.syncengine.task;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.axis.AxisFault;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jeaw.webservice.client.ParamsMap;
import com.jeaw.webservice.client.WebServiceClientException;
import com.jeaw.webservice.http.client.CommonHttpWebServiceClient;
import com.jeaw.webservice.http.client.SyncAppUserMapHttpWebServiceClient;
import com.nci.syncengine.util.EncryptHelper;
import com.nci.syncengine.util.PropUtil;
import com.nci.syncengine.wsbg.engine.DBSXEngine;
import com.nci.syncengine.wsbg.engine.TZTGEngine;
import com.nci.syncengine.wsbg.entity.DBZHJC_DBSX;
import com.nci.syncengine.wsbg.entity.DateVersion;
import com.nci.syncengine.wsbg.entity.SFSQ_YHZH;
import com.nci.syncengine.wsbg.entity.SWGL_TZTG;
import com.nci.syncengine.wsbg.entity.TBXX_TBRW;
import com.nci.syncengine.wsbg.entity.WebServiceUser;
import com.nci.syncengine.wsbg.service.DBZHJC_DBSXService;
import com.nci.syncengine.wsbg.service.DateVersionService;
import com.nci.syncengine.wsbg.service.SFSQ_YHZHService;
import com.nci.syncengine.wsbg.service.SWGL_TZTGService;

@Component("taskJob")
public class TaskJob {
	List<WebServiceUser> userList = new ArrayList<WebServiceUser>();
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
	@Autowired
	private SFSQ_YHZHService SFSQ_YHZHService;

	
	public void syncUser(){
		System.out.println("同步用户开始·········");
		try {
			webServiceUserAdd();
		} catch (WebServiceClientException e) {
			System.out.println("网络异常····");
		} catch (Exception e) {
			System.out.println("发生错误···");
			e.printStackTrace();
		}
		System.out.println("同步用户结束·········");
	}
	
	public void syncDbsxAndTztg(){
		System.out.println("同步通知公告待办事项开始······");
		saveToMenhu();
		System.out.println("同步通知公告待办事项结束······");
		
	}
	
	public void test(){
		System.out.println("test开始······");
		System.out.println("test结束······");
	}
	
	
	/**
	 * 获取数据库中的dateVersion,根据dateVersion获得同步任务List，并更新dataversion
	 * 
	 * @return List<TBXX_TBRW>
	 */

	private void saveToMenhu() {
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
	
	/**
	 * 同步user
	 * @throws WebServiceClientException
	 * @throws Exception
	 */
	private void webServiceUserAdd() throws WebServiceClientException, Exception{	
		
		String wsdl = PropUtil.getProperty("service_user_wsdlAddress");
		String username = PropUtil.getProperty("service_user_username");
		String password =  PropUtil.getProperty("service_user_password");
		CommonHttpWebServiceClient client = new CommonHttpWebServiceClient(wsdl, username, password);
		
		int currPage = 1;
		//获取版本号
		DateVersion dateVersion = dateVersionService.findById("com.nci.syncengine.wsbg.entity.SFSQ_YHZH");
		if(dateVersion==null){
			DateVersion entity = new DateVersion();
			entity.setYwCode(SFSQ_YHZH.class.getName());
			dateVersion = dateVersionService.save(entity);
		}
		Long dv = dateVersion.getDataversion()==null?0:dateVersion.getDataversion();
		Long version = dv;
		//获取需要同步的user
		List<WebServiceUser> userList = getUserList(client,currPage,dv);
		List<WebServiceUser> syncSucessUser = new ArrayList<WebServiceUser>();
		for(WebServiceUser user : userList){
			if(user.getDATAVERSION()>version){
				version = user.getDATAVERSION();
			}
			SFSQ_YHZH entity = new SFSQ_YHZH();
			String id = UUID.randomUUID().toString().replace("-", "").toUpperCase();
			String yhbh = SFSQ_YHZHService.newYHBH();
			String userPwd = "123";
			entity.init();
			entity.setID(id);
			entity.setYHBH(yhbh);
			entity.setXM(user.getXM());
			entity.setMM(EncryptHelper.encryptPwd(userPwd));
			entity.setYHZH(user.getLOGINID());
			boolean flag = SFSQ_YHZHService.addSFSQ_YHZH(entity);
			//SFSQ_YHZHService.delByYHZH(entity.getYHZH());
			if(flag){
				syncSucessUser.add(user);
			}
			
			System.out.println(flag);
		}
		
		if(syncSucessUser.size()>0){
			addUserMap(syncSucessUser);
		}
		if(dv<version){
			dateVersion.setDataversion(version);
			dateVersionService.update(dateVersion);
		}
	}
	
	
	

	
	
	/**
	 * 获取需要同步的用户list
	 * @param client
	 * @param currPage
	 * @param dataVersion
	 * @return
	 * @throws Exception
	 */
	private  List<WebServiceUser> getUserList(CommonHttpWebServiceClient client ,int currPage,Long dataVersion) throws Exception{

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PAGE",currPage);
		map.put("PAGESIZE", 20);
		map.put("USERTYPE", "00");
		map.put("DATAVERSION", dataVersion);
		
		ParamsMap params = new ParamsMap();
		params.addParam(map);
		params.setResultType(ParamsMap.RETURNTYPE_JSON);
		String result = client.query(params);
		
		JSONObject jsonObject = JSONObject.fromObject(result);
		if("DAS00000".equals(jsonObject.get("code"))){
			int totalPageCount = (int)jsonObject.get("totalPageCount");
			JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("datas"));
			List<Map<String,Object>> mapList = (List)jsonArray;
			for(Map<String,Object> jsonMap : mapList){
				WebServiceUser user = new WebServiceUser();
				user.setLOGINID((String) jsonMap.get("LOGINID"));
				user.setXM((String)jsonMap.get("XM"));
				user.setDATAVERSION((Long)jsonMap.get("DATAVERSION"));
				user.setRYBH((String)jsonMap.get("RYBH"));
				userList.add(user);
				System.out.println(user);
			}
			if(currPage<totalPageCount){
				getUserList(client,++currPage,dataVersion);
			}
		}else{
			throw new Exception("获取数据失败");
		}
		
		return userList;
	}
	/**
	 * 反写用户到公共数据平台用户系统映射表，使同步下来的用户可以在门户单点登录
	 * @param userList
	 * @throws WebServiceClientException
	 */
	private void addUserMap(List<WebServiceUser> userList) throws WebServiceClientException{
		String wsdl = PropUtil.getProperty("service_app_userMap");
		String username = PropUtil.getProperty("service_app_username");
		String password = PropUtil.getProperty("service_app_password");
		SyncAppUserMapHttpWebServiceClient client = new SyncAppUserMapHttpWebServiceClient(wsdl, username, password);
		StringBuffer rybhXml = new StringBuffer();
		for(WebServiceUser user : userList){
			rybhXml.append("<RYBH>"+user.getRYBH()+"</RYBH>");
		}
		String mapDataAddXml = "<DATAS><APPSYSCODE>WSBG</APPSYSCODE>"       //
				+ "<MODE>INCREMENT</MODE><DATA><ADD>"+rybhXml.toString()    //
				+ "</ADD><DEL>"                                             //
				+ "</DEL></DATA></DATAS>";
		String mapDataDelXml = "<DATAS><APPSYSCODE>WSBG</APPSYSCODE>"  //
				+ "<MODE>INCREMENT</MODE><DATA><ADD>"                  //
				+ "</ADD><DEL>"+rybhXml.toString()                     // 
				+ "</DEL></DATA></DATAS>";
		String result =client.synchroniseMapData(mapDataAddXml);
		System.out.println(result);
	}
}
