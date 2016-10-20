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
import com.nci.syncengine.util.EncryptHelper;
import com.nci.syncengine.util.PropUtil;
import com.nci.syncengine.wsbg.entity.SFSQ_YHZH;
import com.nci.syncengine.wsbg.entity.WebServiceUser;
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
		String id = UUID.randomUUID().toString().replace("-", "");
		String yhbh = SFSQ_YHZHService.newYHBH();
		String name = "zhengpp";
		String password = "123";
		entity.init();
		entity.setID(id);
		entity.setYHBH(yhbh);
		entity.setXM(name);
		entity.setMM(EncryptHelper.encryptPwd(password));
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
		List<WebServiceUser> userList = getUserList(client,currPage);
		for(WebServiceUser user : userList){
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
			System.out.println(flag);
		}
		
		
		
		
	}
	

	
	@Test
	public void exitByYHZH(){
		System.out.println(SFSQ_YHZHService.isExitByYHZH("zhengpp"));
	}
	
	
	public static List<WebServiceUser> getUserList(CommonHttpWebServiceClient client ,int currPage) throws Exception{
		List<WebServiceUser> userList = new ArrayList<WebServiceUser>();
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PAGE",currPage);
		map.put("PAGESIZE", 20);
		map.put("USERTYPE", "00");
		
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
				userList.add(user);
			}
			if(currPage<totalPageCount){
				getUserList(client,++currPage);
			}
		}else{
			throw new Exception("获取数据失败");
		}
		
		return userList;
	}

	
}
