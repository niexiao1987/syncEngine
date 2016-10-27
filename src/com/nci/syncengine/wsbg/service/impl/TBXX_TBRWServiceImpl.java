package com.nci.syncengine.wsbg.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nci.syncengine.base.service.impl.BaseServiceImpl;
import com.nci.syncengine.wsbg.dao.SWGL_TZTGDao;
import com.nci.syncengine.wsbg.dao.TBXX_TBRWDao;
import com.nci.syncengine.wsbg.entity.TBXX_TBRW;
import com.nci.syncengine.wsbg.service.TBXX_TBRWService;
@Service
public class TBXX_TBRWServiceImpl extends BaseServiceImpl<TBXX_TBRW, Integer> implements
		TBXX_TBRWService {
	@Autowired
	protected void setTBXX_TBRWDao(TBXX_TBRWDao TBXX_TBRWDao) {
		setBaseDao(TBXX_TBRWDao);
	}

	protected TBXX_TBRWDao getTBXX_TBRWDao() {
		return (TBXX_TBRWDao) this.baseDao;
	}

	@Override
	public List<TBXX_TBRW> getByDataVersion(Long dataVersion) {
		if(dataVersion==null){
			dataVersion = 0L;
		}
		return getTBXX_TBRWDao().findByDataVersion(dataVersion);
	}
	/**
	 * 根据状态获取同步任务List，并对list按时间排序
	 * @return 同步任务list
	 * @param zt 状态
	 */
	@Override
	public List<TBXX_TBRW> getByZT(String zt) {
		List<TBXX_TBRW> list = getTBXX_TBRWDao().findByZt(zt);
		Collections.sort(list, new Comparator<TBXX_TBRW>() {

			@Override
			public int compare(TBXX_TBRW o1, TBXX_TBRW o2) {
				if(o1.getSJ().before(o2.getSJ())){
					return -1;
				}else if(o1.getSJ().equals(o2.getSJ())){
					return 0;
				}else{
					return 1;
				}
			}
		});
		return list;
	}

	@Override
	public void changeZT(String zt) {
		getTBXX_TBRWDao().changeZT(zt);
		
	}

	
}
