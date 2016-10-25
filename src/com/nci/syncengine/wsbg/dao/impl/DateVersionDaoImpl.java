package com.nci.syncengine.wsbg.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nci.syncengine.base.dao.impl.BaseDaoImpl;
import com.nci.syncengine.wsbg.dao.DateVersionDao;
import com.nci.syncengine.wsbg.entity.DateVersion;
@Repository
public class DateVersionDaoImpl extends BaseDaoImpl<DateVersion, String> implements
		DateVersionDao {

	@Override
	public void batchMarkDelete(String[] items) {
		
	}

	@Override
	protected Class<DateVersion> getEntityClass() {
		return DateVersion.class;
	}



}
