package com.nci.syncengine.wsbg.service;

import java.util.List;

import com.nci.syncengine.base.service.BaseService;
import com.nci.syncengine.wsbg.entity.TBXX_TBRW;

public interface TBXX_TBRWService extends BaseService<TBXX_TBRW, Integer> {

	List<TBXX_TBRW> getByDataVersion(Long dataVersion);

}
