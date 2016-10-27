package com.nci.syncengine.wsbg.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nci.syncengine.base.dao.impl.BaseDaoImpl;
import com.nci.syncengine.wsbg.dao.SFSQ_YHZHDao;
import com.nci.syncengine.wsbg.entity.SFSQ_YHZH;

@Repository
public class SFSQ_YHZHDaoImpl extends BaseDaoImpl<SFSQ_YHZH, String> implements
		SFSQ_YHZHDao {

	@Override
	protected Class<SFSQ_YHZH> getEntityClass() {
		// TODO Auto-generated method stub
		return SFSQ_YHZH.class;
	}

	@Override
	public List<SFSQ_YHZH> findAll() {
		// TODO Auto-generated method stub
		String hql = "from SFSQ_YHZH";
		List<SFSQ_YHZH> items = this.queryByHql(hql, null);
		return items;
	}

	@Override
	public SFSQ_YHZH addSFSQ_YHZH(SFSQ_YHZH entity) {
		return super.save(entity);
	}

	@Override
	public String newYHBH() {
		String hql = "select  YHBH from SFSQ_YHZH  order by YHBH desc";
		// String sql = "select count(*) from SFSQ_YHZH ";
		List list = this.queryByHql(hql, null, 0, 1);
		if (list != null && list.size() == 1) {
			return list.get(0).toString();
		}

		// String hql = "from SFSQ_YHZH as e worder by YHBH desc";
		// List<SFSQ_YHZH> items = this.queryByHql(hql, null);
		// if(items.size()==1){
		// return items.get(0).toString();
		// }
		return null;
	}

	@Override
	public void batchMarkDelete(String[] items) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean findByYHZH(String yHZH) {
		String hql = "select count(*) from SFSQ_YHZH where YHZH = '"+yHZH+"'";
	
		List list = this.queryByHql(hql,null);
		if(list.size()>0&&(long)list.get(0)>0){
			return true;
		}
		return false;
	}

	@Override
	public void deleteByYHZH(String yHZH) {
		String hql = "delete SFSQ_YHZH where YHZH = '"+yHZH+"'";
		this.executeHql(hql, null);
	}

	@Override
	public SFSQ_YHZH findByYHBH(String yHBH) {
		String hql = "from SFSQ_YHZH where YHBH = '"+yHBH+"'";
		List<SFSQ_YHZH> list = this.queryByHql(hql, null);
		if(list!=null&&list.size()>0){
			return  list.get(0);
		}
		return null;
	}

}
