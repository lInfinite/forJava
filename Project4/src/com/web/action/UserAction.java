package com.web.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.dao.BaseDao;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.dao.UserDao;

public class UserAction extends ActionSupport implements SessionAware{
    private User user;
    private Map<String, Object> session;
    private UserDao user_dao;
    private BaseDao base;
    
    public String login(){
    	if(user_dao.user(user)!=null){
    		//�����û� ��������ע��
    	    return "";
    	}else{
    		//�ɹ�ע��
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
    		//ľ���л����ص�¼
    		return "";
    	}
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

    
    
}
