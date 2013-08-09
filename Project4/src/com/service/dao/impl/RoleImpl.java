package com.service.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.dao.BaseDao;
import com.entity.Role;
import com.service.dao.RoleDao;
import com.util.Util;

public class RoleImpl implements RoleDao {
    
	private BaseDao base;
    private Util util;
	@Override
	public List<Role> query() {
		return base.query("Role");
	}

	@Override
	public List<Role> query(int page) {
		return base.query("Role", page, 5);
	}	
	
	@Override
    public List<Role> query(Role role){
		Map<String, Object> value;
		try {
			value = util.getValue(role);
			return base.query("Role", value);
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
	public List<Role> query(Role role, int page) {
		Map<String, Object> value;
		try {
			value = util.getValue(role);
			return base.query("Role", value, page, 5);
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
	public Role role(long id) {
		return (Role)base.object("Role", id);
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
