package com.service.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.BaseDao;
import com.entity.CreateClinet;
import com.service.dao.CreateClinetDao;
import com.util.Util;

public class CreateClinetImpl implements CreateClinetDao {
    
	private BaseDao base;
	
	
	


	@Override
	public CreateClinet createClinet(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

	public BaseDao getBase() {
		return base;
	}

	public void setBase(BaseDao base) {
		this.base = base;
	}

}
