package com.web.action;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Hibernate;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dao.BaseDao;
import com.dao.impl.BaseImpl;
import com.entity.Manage;
import com.entity.Role;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.dao.RoleDao;
import com.service.dao.UserDao;
import com.service.dao.impl.RoleImpl;
import com.service.dao.impl.UserImpl;
import com.util.Page;
import com.util.Util;

public class UserAction extends ActionSupport implements SessionAware{
	
	private ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private Map<String, Object> session;
	private UserDao user_dao = (UserImpl)context.getBean("UserImpl");
	private RoleDao role_dao = (RoleImpl)context.getBean("RoleImpl");
	private BaseDao base = (BaseImpl)context.getBean("BaseImpl");
	private Util util = (Util)context.getBean("Util");
	private Page page = (Page)context.getBean("Page");;
	
    private User user;
    private Role role;
    private Manage manage;
    
    private List<User> user_list = null;
    private List<Role> role_list = null;
    private String[] Manages_name;
    
    
    

    //用户登陆
    public String logon(){
    	user.setPassword(util.eccrypt(user.getPassword()));
    	User u = user_dao.user(user, true);
    	if(u!=null){
    		session.put("user", u);
    		return "index";
    	}else{
    		return "login.html";
    	}
    }
    
    
    //初始化用户管理页面
    public String user_manage(){
    	user_list = base.query("User", null, page.getPage(), 5);
    	return "privilege_user.jsp";
    }
    
    
    //初始化 用户添加页面
    public String add_user(){
    	role_list = base.query("Role");
    	return "privilege_user_create.jsp";
    }

    
    //用户注册
    public String login(){
    	if(user_dao.user(user, false)!=null){
    		this.addActionError("已有改用户名");
    	    return "privilege_user_create.jsp";
    	}else{
    		user.setPassword(util.eccrypt(user.getPassword()));
    		base.add(user);
    		return user_manage();
    	}
    } 
    
    
    //初始化 更新用户页面
    public String update_user(){
    	user = user_dao.user(user.getId());
    	role_list = base.query("Role");
    	return "privilege_user_update.jsp";
    }
    
    
    //编辑用户
    public String updateUser(){
    	user.setPassword(util.eccrypt(user.getPassword()));
    	base.update(user);
    	return user_manage();
    }
    
    
    //删除用户
    public String deleteUser(){
    	base.delete(user);
    	return user_manage();
    }
    
    
    //条件查询
    public String queryUsers(){
    	user_list = base.query("User",
			    			   util.getValue(user), 
			    			   page.getPage(),
			    			   5);
    	return "privilege_user.jsp";
    }
    
   
    /**
     * 角色
     * */
    
    
    //初始化 角色页面
    public String role_manage(){
    	role_list = base.query("Role", page.getPage(), 5);
    	return "privilege_role.jsp";
    }
    
    
    //初始化 角色添加页面
    public String add_role(){
    	return "privilege_role_create.html";
    }
    
    
    //添加角色
    public String addRole(){
    	Set<Manage> manage_set = new HashSet<Manage>();
    	if(Manages_name!=null){
	    	for(int i=0; i<Manages_name.length; i++){
	    		manage = new Manage();
	    		manage.setName(Manages_name[i]);
	    		manage_set.add(manage);
	    	}
	    	role.setManage(manage_set);
    	}
    	base.add(role);
    	return role_manage();
    }
    
    
    //删除角色
    public String deleteRole(){
    	role = role_dao.role(role.getId());
    	
    	for(User u:role.getUser()){
    		base.delete(u);
    	}
    	base.delete(role);
    	return role_manage();
    }
    
    
    //初始化编辑角色页面
    public String update_role(){
    	role = role_dao.role(role.getId());
    	return "privilege_role_update.jsp";
    }
    
    
    //编辑角色
    public String updateRole(){
    	Set<Manage> manage_set = new HashSet<Manage>();
    	if(Manages_name!=null){
	    	for(int i=0; i<Manages_name.length; i++){
	    		manage = new Manage();
	    		manage.setName(Manages_name[i]);
	    		manage_set.add(manage);
	    	}
	    	role.setManage(manage_set);
    	}
    	base.update(role);
    	return role_manage();
    }
    
   
    //条件查询
    public String queryRole(){
    	role_list = base.query("Role",
			    			   util.getValue(role), 
			    			   page.getPage(),
			    			   5);
    	return "privilege_role.jsp";
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

	
	public Manage getManage() {
		return manage;
	}

	public void setManage(Manage manage) {
		this.manage = manage;
	}

	
	public String[] getManages_name() {
		return Manages_name;
	}

	public void setManages_name(String[] manages_name) {
		Manages_name = manages_name;
	}

	
	@Override
    public void setSession(Map<String, Object> session) {
    	this.session = session;
    }
    
}
