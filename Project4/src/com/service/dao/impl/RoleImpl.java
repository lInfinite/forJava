package com.service.dao.impl;


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
	public Role role(long id) {
		return (Role)base.object(Role.class, id);
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
