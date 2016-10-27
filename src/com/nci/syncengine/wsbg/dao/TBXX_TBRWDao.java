package com.nci.syncengine.wsbg.dao;

import java.util.List;

import com.nci.syncengine.base.dao.BaseDao;
import com.nci.syncengine.wsbg.entity.TBXX_TBRW;

public interface TBXX_TBRWDao extends BaseDao<TBXX_TBRW, Integer> {

	List<TBXX_TBRW> findByDataVersion(Long dataVersion);

	List<TBXX_TBRW> findByZt(String zt);

	void changeZT(String zt);

}
