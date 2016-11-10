package com.nci.syncengine.wsbg.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jeaw.webservice.client.ParamsMap;
import com.jeaw.webservice.client.WebServiceClientException;
import com.jeaw.webservice.http.client.CommonHttpWebServiceClient;
import com.jeaw.webservice.http.client.SyncAppUserMapHttpWebServiceClient;
import com.nci.syncengine.util.PropUtil;
import com.nci.syncengine.wsbg.entity.DateVersion;
import com.nci.syncengine.wsbg.entity.SFSQ_YHZH;
import com.nci.syncengine.wsbg.entity.WebServiceUser;
import com.nci.syncengine.wsbg.service.DateVersionService;
import com.nci.syncengine.wsbg.service.SFSQ_YHZHService;

@RunWith(SpringJUnit4ClassRunner.class)
// 用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath:config/application-context.xml" })
// 用于指定配置文件所在的位置
public class SFSQ_YHZHServiceImplTest {
	List<WebServiceUser> userList = new ArrayList<WebServiceUser>();
	@Autowired
	private SFSQ_YHZHService SFSQ_YHZHService;
	
	@Autowired
	private DateVersionService dateVersionService;

	@Test
	public void getByYHBH(){
		SFSQ_YHZH yh = SFSQ_YHZHService.getByYHBH("00001101");
		System.out.println(yh);
	}
	
	@Test
	public void testFindAll() {
		List<SFSQ_YHZH> list = SFSQ_YHZHService.findAll();
		System.out.println(list.size());
	}

	@Test
	public void testAdd() {
		SFSQ_YHZH entity = new SFSQ_YHZH();
		String id = UUID.randomUUID().toString().replace("-", "");
		String yhbh = SFSQ_YHZHService.newYHBH();
		String name = "zhengpp";
		String password = "123";
		entity.init();
		entity.setID(id);
		entity.setYHBH(yhbh);
		entity.setXM(name);
		//entity.setMM(EncryptHelper.encryptPwd(password));
		entity.setMM("SlwK");
		entity.setYHZH(name);
		
		System.out.println(entity);
		
		
		boolean flag = SFSQ_YHZHService.addSFSQ_YHZH(entity);
		System.out.println(flag);
	}
	
	@Test
	public void testNewYHBH() {
		System.out.println(SFSQ_YHZHService.newYHBH());
	}
	
	@Test
	public void webServiceAdd() throws WebServiceClientException, Exception{	
		
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
			//entity.setMM(EncryptHelper.encryptPwd(userPwd));//加密算法需要签名
			entity.setMM("SlwK");//123加密后的字符串
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
	

	
	@Test
	public void exitByYHZH(){
		System.out.println(SFSQ_YHZHService.isExitByYHZH("zhengpp"));
	}
	
	
	public  List<WebServiceUser> getUserList(CommonHttpWebServiceClient client ,int currPage,Long dataVersion) throws Exception{

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

	public void addUserMap(List<WebServiceUser> userList) throws WebServiceClientException{
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
