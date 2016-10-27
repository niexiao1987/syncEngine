package com.nci.syncengine.wsbg.service;

import com.nci.syncengine.base.service.BaseService;
import com.nci.syncengine.wsbg.entity.SWGL_TZFJ;

public interface SWGL_TZFJService extends BaseService<SWGL_TZFJ, String> {
	public SWGL_TZFJ getBySWGL_TZFJId(String SWGL_TZTGId);
}
