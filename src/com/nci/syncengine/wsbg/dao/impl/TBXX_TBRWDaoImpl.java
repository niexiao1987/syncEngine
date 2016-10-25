package com.nci.syncengine.wsbg.dao.impl;

import org.springframework.stereotype.Repository;

import com.nci.syncengine.base.dao.impl.BaseDaoImpl;
import com.nci.syncengine.wsbg.dao.TBXX_TBRWDao;
import com.nci.syncengine.wsbg.entity.TBXX_TBRW;
@Repository
public class TBXX_TBRWDaoImpl extends BaseDaoImpl<TBXX_TBRW, Integer> implements
		TBXX_TBRWDao {

	@Override
	public void batchMarkDelete(Integer[] items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Class<TBXX_TBRW> getEntityClass() {
		return TBXX_TBRW.class;
	}

}
