package com.web.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dao.BaseDao;
import com.dao.impl.BaseImpl;
import com.entity.Manage;
import com.entity.Role;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.dao.UserDao;
import com.service.dao.impl.UserImpl;
import com.util.Page;

public class UserAction extends ActionSupport implements SessionAware{
	private ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
    private User user;
    private Role role;
    private Map<String, Object> session;
    private UserDao user_dao = (UserImpl)context.getBean("UserImpl");
    private BaseDao base = (BaseImpl)context.getBean("BaseImpl");
    private Page page = null;
    private List<User> user_list = null;
    private List<Role> role_list = null;
    
    public String user_manage(){
    	page = (Page)context.getBean("Page");
    	user_list = base.query("User", page.getPage(), 5);
    	return "privilege_user.jsp";
    }
    
    public String role_manage(){
    	page = (Page)context.getBean("Page");
    	role_list = base.query("Role", page.getPage(), 5);
    	return "privilege_role.jsp";
    }
    
    public String add_use(){
    	page = (Page)context.getBean("Page");
    	role_list = base.query("Role", page.getPage(), 5);
    	return "privilege_user_create.jsp";
    }
    
    public String add_role(){
    	return "privilege_role_create.html";
    }
    
    public String addRole(){
    	return "privilege_role.jsp";
    }
    
    public String addUser(){
    	base.add(user);
    	return "privilege_user.jsp";
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
    		return "login.html";
    	}
    }
    
    
    
    
    
    public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

    
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	public List<User> getUser_list() {
		return user_list;
	}

	public void setUser_list(List<User> user_list) {
		this.user_list = user_list;
	}

	public List<Role> getRole_list() {
		return role_list;
	}

	public void setRole_list(List<Role> role_list) {
		this.role_list = role_list;
	}



	
	@Override
    public void setSession(Map<String, Object> session) {
    	this.session = session;
    }
    
}
