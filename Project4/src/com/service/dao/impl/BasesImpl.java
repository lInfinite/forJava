package com.service.dao.impl;

import java.util.List;
import java.util.Map;

import com.entity.ClintLevel;
import com.service.dao.BasesDao;
import com.dao.BaseDao;

public class BasesImpl implements BasesDao {
    
	private BaseDao base;
	
	
	@Override
	public ClintLevel clint_level(Long id) {
		return (ClintLevel)base.object(ClintLevel.class, id);
	}


	public BaseDao getBase() {
		return base;
	}


	public void setBase(BaseDao base) {
		this.base = base;
	}
	
	
}
