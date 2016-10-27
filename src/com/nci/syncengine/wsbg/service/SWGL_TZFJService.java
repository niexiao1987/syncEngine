package com.nci.syncengine.wsbg.service;

import java.util.List;

import com.nci.syncengine.base.service.BaseService;
import com.nci.syncengine.wsbg.entity.SWGL_TZFJ;

public interface SWGL_TZFJService extends BaseService<SWGL_TZFJ, String> {
	public List<SWGL_TZFJ> getBySWGL_TZTGId(String SWGL_TZTGId);
}
