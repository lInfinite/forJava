package com.service.dao.impl;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Hibernate;

import com.dao.BaseDao;
import com.entity.SellChance;
import com.service.dao.SellDao;
import com.util.Util;

public class SellImpl implements SellDao{
	
	private SellChance sell;
    private BaseDao base;
   
	@Override
	public SellChance sellChance(long id) {
		return (SellChance)base.object(SellChance.class, id);
	}

	
	
	@Override
	public List list_for_OneToMany(Set one_to_many) {
		if(one_to_many == null){
			return null;
		}
		List list = new ArrayList();
		for(Object obj : one_to_many){
			list.add(obj);
		}
		return list;
	}




	public BaseDao getBase() {
		return base;
	}

	public void setBase(BaseDao base) {
		this.base = base;
	}

	

	
	
}
