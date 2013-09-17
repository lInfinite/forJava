package service.dao.impl;

import java.util.List;

import dao.BaseDao;
import entity.User;
import service.dao.UserServiceDao;

public class UserServiceImpl implements UserServiceDao{
	
	
    private BaseDao base;
    
    
	@Override
	public boolean hasUserName(User u) {
		User user = new User();
		user.setName(u.getName());
		List<User> list = base.query("User", user, null);
		return list.size()==1;
	}

	@Override
	public boolean hasUser(User u) {
		List<User> list = base.query("User", u, null);
		return list.size()==1;
	}

	public BaseDao getBase() {
		return base;
	}

	public void setBase(BaseDao base) {
		this.base = base;
	}
    
	
	
}
