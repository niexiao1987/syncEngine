package com.nci.syncengine.wsbg.dao.impl;

import org.springframework.stereotype.Repository;

import com.nci.syncengine.base.dao.impl.BaseDaoImpl;
import com.nci.syncengine.wsbg.dao.DBZHJC_DBSXDao;
import com.nci.syncengine.wsbg.entity.DBZHJC_DBSX;

@Repository
public class DBZHJC_DBSXDaoImpl extends BaseDaoImpl<DBZHJC_DBSX, String> implements DBZHJC_DBSXDao{

	
	
	
	
	
	
	
	
	
	@Override
	public void batchMarkDelete(String[] items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Class<DBZHJC_DBSX> getEntityClass() {
		return DBZHJC_DBSX.class;
	}

}
