package com.nci.syncengine.wsbg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nci.syncengine.base.service.impl.BaseServiceImpl;
import com.nci.syncengine.wsbg.dao.SFSQ_YHZHDao;
import com.nci.syncengine.wsbg.entity.SFSQ_YHZH;
import com.nci.syncengine.wsbg.service.SFSQ_YHZHService;

@Service
public class SFSQ_YHZHServiceImpl extends BaseServiceImpl<SFSQ_YHZH, String>
		implements SFSQ_YHZHService {

	@Autowired
	protected void setSFSQ_YHZHDao(SFSQ_YHZHDao SFSQ_YHZHDao) {
		setBaseDao(SFSQ_YHZHDao);
	}

	protected SFSQ_YHZHDao getSFSQ_YHZHDao() {
		return (SFSQ_YHZHDao) this.baseDao;
	}

	@Override
	public List<SFSQ_YHZH> findAll() {
		// TODO Auto-generated method stub
		return getSFSQ_YHZHDao().findAll();
	}
	
	@Override
	public String  newYHBH() {
		// TODO Auto-generated method stub
		int defaultLength = 8;
		String rybm = getSFSQ_YHZHDao().newYHBH();
		rybm = String.valueOf((Integer.parseInt(rybm)+1));
		int length = rybm.length();
		//如果数据库获取的人员编码<8位，则在前面补0
		if(length<defaultLength){
			StringBuffer zero = new StringBuffer();
			for(int i = 0;i<defaultLength-length;i++){
				zero.append("0");
			}
			return zero.toString()+rybm;
		}
		return rybm;
	}

	@Override
	public boolean addSFSQ_YHZH(SFSQ_YHZH entity) {
		if(!isExitByYHZH(entity.getYHZH())){
			return getSFSQ_YHZHDao().addSFSQ_YHZH(entity) != null;
		}else{
			return false;
		}
	}
	
	
	public boolean isExitByYHZH(String YHZH){
		return getSFSQ_YHZHDao().findByYHZH(YHZH);

	}

	@Override
	public void delByYHZH(String YHZH) {
		 getSFSQ_YHZHDao().deleteByYHZH(YHZH);
	}
}
