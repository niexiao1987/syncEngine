package com.nci.syncengine.wsbg.dao.impl;


import org.springframework.stereotype.Repository;

import com.nci.syncengine.base.dao.impl.BaseDaoImpl;
import com.nci.syncengine.wsbg.dao.SWGL_TZTGDao;
import com.nci.syncengine.wsbg.entity.SWGL_TZTG;
@Repository
public class SWGL_TZTGDaoImpl extends BaseDaoImpl<SWGL_TZTG, String> implements
		SWGL_TZTGDao {

	@Override
	public void batchMarkDelete(String[] items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Class<SWGL_TZTG> getEntityClass() {
		return SWGL_TZTG.class;
	}



}
