package com.nci.syncengine.wsbg.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.nci.syncengine.base.dao.impl.BaseDaoImpl;
import com.nci.syncengine.wsbg.dao.SWGL_TZFJDao;
import com.nci.syncengine.wsbg.entity.SWGL_TZFJ;
@Repository
public class SWGL_TZFJDaoImpl extends BaseDaoImpl<SWGL_TZFJ, String> implements
		SWGL_TZFJDao {

	@Override
	public void batchMarkDelete(String[] items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Class<SWGL_TZFJ> getEntityClass() {
		return SWGL_TZFJ.class;
	}

	@Override
	public SWGL_TZFJ findBySWGL_TZTGId(String sWGL_TZTGId) {
		String hql = " FROM SWGL_TZFJ where TZID = '"+sWGL_TZTGId+"'";
		List list = this.queryByHql(hql, null);
		if(list!=null&&list.size()>0){
			return (SWGL_TZFJ) list.get(0);
		}
		return null;
	}

	

}
