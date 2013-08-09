package com.service.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.BaseDao;
import com.entity.SellChance;
import com.service.dao.SellDao;
import com.util.Util;

public class SellImpl implements SellDao {
	
    private BaseDao base;
    private Util util;
    
    @Override
	public List<SellChance> query() {
			return base.query("SellChance");
	}
	
	@Override
	public List<SellChance> query(int page) {
			return base.query("SellChance", page, 5);
	}
	
	@Override
	public List<SellChance> query(SellChance sell_chance) {
			Map<String, Object> value;
			try {
				value = util.getValue(sell_chance);
				return base.query("SellChance", value);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	@Override
	public List<SellChance> query(SellChance sell_chance, int page) {

		Map<String, Object> value;
		try {
			value = util.getValue(sell_chance);
			return base.query("SellChance", value, page, 5);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SellChance sellChance(long id) {
		return (SellChance)base.object("SellChance", id);
	}

	
	
	
	public BaseDao getBase() {
		return base;
	}

	public void setBase(BaseDao base) {
		this.base = base;
	}

	public Util getUtil() {
		return util;
	}

	public void setUtil(Util util) {
		this.util = util;
	}
	
	
}
