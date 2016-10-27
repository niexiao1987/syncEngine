package com.nci.syncengine.wsbg.dao;

import com.nci.syncengine.base.dao.BaseDao;
import com.nci.syncengine.wsbg.entity.SWGL_TZFJ;

public interface SWGL_TZFJDao extends BaseDao<SWGL_TZFJ, String> {

	public SWGL_TZFJ findBySWGL_TZTGId(String sWGL_TZTGId);

}
