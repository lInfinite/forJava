package com.service.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.BaseDao;
import com.entity.User;
import com.service.dao.UserDao;
import com.util.Util;

public class UserImpl implements UserDao {
   
	private BaseDao base;
    private Util util;
   
    
    @Override
	public User user(User user) {
		Map<String, Object> value = new HashMap<String, Object>();
		value.put("name", user.getName());
		value.put("password", user.getPassword());
		List<User> list = base.query("User", value);
		return (User)list.get(0);
	}
    
	@Override
	public List<User> query() {
		return base.query("User");
	}

	@Override
	public List<User> query(int page) {
		return base.query("User", page, 5);
	}
	
	
	@Override
	public List<User> query(User user){
		Map<String, Object> value;
		try {
			value = util.getValue(user);
			return base.query("User", value);
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
	public List<User> query(User user, int page) {
		Map<String, Object> value;
		try {
			value = util.getValue(user);
			return base.query("User", value, page, 5);
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
	public User user(long id) {
		return (User)base.object("User", id);
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
