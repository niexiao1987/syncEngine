package com.nci.syncengine.wsbg.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nci.syncengine.base.service.impl.BaseServiceImpl;
import com.nci.syncengine.wsbg.dao.SWGL_TZTGDao;
import com.nci.syncengine.wsbg.entity.SWGL_TZTG;
import com.nci.syncengine.wsbg.service.SWGL_TZTGService;
@Service
public class SWGL_TZTGServiceImpl extends BaseServiceImpl<SWGL_TZTG, String> implements
		SWGL_TZTGService {

	@Autowired
	protected void setSWGL_TZTGDao(SWGL_TZTGDao SWGL_TZTGDao) {
		setBaseDao(SWGL_TZTGDao);
	}

	protected SWGL_TZTGDao getSWGL_TZTGDao() {
		return (SWGL_TZTGDao) this.baseDao;
	}

}
