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
	private Util util;
	
	@Override
	public List<CreateClinet> query() {
		return base.query("CreateClinet");
	}

	@Override
	public List<CreateClinet> query(int page) {
		return base.query("CreateClinet", page, 5);
	}
	
	@Override
	public List<CreateClinet> query(CreateClinet create_clinet) {
		Map<String, Object> value;
			try {
				value = util.getValue(create_clinet);
				return base.query("CreateClinet", value);
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
	public List<CreateClinet> query(CreateClinet create_clinet, int page) {
		Map<String, Object> value;
			try {
				value = util.getValue(create_clinet);
				return base.query("CreateClinet", value, page, 5);
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
	public CreateClinet createClinet(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	public Util getUtil() {
		return util;
	}

	public void setUtil(Util util) {
		this.util = util;
	}

	public BaseDao getBase() {
		return base;
	}

	public void setBase(BaseDao base) {
		this.base = base;
	}

}
