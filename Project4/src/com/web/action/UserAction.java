package com.web.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.dao.BaseDao;
import com.entity.Role;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.dao.UserDao;
import com.util.Page;

public class UserAction extends ActionSupport implements SessionAware{
    private User user;
    private Map<String, Object> session;
    private UserDao user_dao;
    private BaseDao base;
    
    private List<Role> role_list;
    private Page page;
    
    public String createUser(){
    	return "init_user";
    }
    
    public String role_manage(){
    	role_list = base.query("Role", page.getPage(), 5);
    	return "init_role";
    }
    
    
    public String login(){
    	if(user_dao.user(user)!=null){
    		//以有用户 返回重新注册
    	    return "";
    	}else{
    		//成功注册
    		base.add(user);
    		return "";
    	}
    }
    
    public String logon(){
    	//User u = user_dao.user(user);
    	if(user!=null){
    		//session.put("user", u);
    		return "index";
    	}else{
    		//木该有户返回登录
    		return "";
    	}
    }
    
   
    
    
    
    @Override
    public void setSession(Map<String, Object> session) {
    	this.session = session;
    }
    
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserDao getUser_dao() {
		return user_dao;
	}
	public void setUser_dao(UserDao user_dao) {
		this.user_dao = user_dao;
	}
	public BaseDao getBase() {
		return base;
	}
	public void setBase(BaseDao base) {
		this.base = base;
	}

	public List<Role> getRole_list() {
		return role_list;
	}

	public void setRole_list(List<Role> role_list) {
		this.role_list = role_list;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}


    
}
