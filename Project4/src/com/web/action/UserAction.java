package com.web.action;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.entity.Manage;
import com.entity.Role;
import com.entity.User;
import com.service.dao.RoleDao;
import com.service.dao.UserDao;
import com.service.dao.impl.RoleImpl;
import com.service.dao.impl.UserImpl;

public class UserAction extends SuperAction{
	/**service**/
	private UserDao user_dao = (UserImpl)context.getBean("UserImpl");
	private RoleDao role_dao = (RoleImpl)context.getBean("RoleImpl");
	/**entity**/
    private User user;
    private Role role;
    private Manage manage;
    /**list**/
    private List<User> user_list = null;
    private List<Role> role_list = null;
    private String[] Manages_name;
    
    
    
    /**初始化action**/
	public UserAction(){
		page.setMax_results(5);
	}    
    

    /**用户登陆**/
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
    
    
    /**初始化用户管理页面**/
    public String user_manage(){
    	String result = super.result(user, "User", "privilege_user.jsp");
    	user_list = super.list;
    	return result;
    }
    
    
    /**初始化 用户添加页面**/
    public String add_user(){
    	role_list = base.query("Role");
    	return "privilege_user_create.jsp";
    }

    
    /**用户注册**/
    public String login(){
    	if(user_dao.user(user, false)!=null){
    		this.addActionError("已有改用户名");
    	    return "privilege_user_create.jsp";
    	}else{
    		user.setPassword(util.eccrypt(user.getPassword()));
    		base.add(user);
        	user=null;
    		return user_manage();
    	}
    } 
    
    
    /**初始化 更新用户页面**/
    public String update_user(){
    	user = user_dao.user(user.getId());
    	role_list = base.query("Role");
    	return "privilege_user_update.jsp";
    }
    
    
    /**编辑用户**/
    public String updateUser(){
    	user.setPassword(util.eccrypt(user.getPassword()));
    	base.update(user);
    	user=null;
    	return user_manage();
    }
    
    
    /**删除用户**/
    public String deleteUser(){
    	base.delete(user);
    	return user_manage();
    }
    
   
    /**
     * 角色
     * */
    
    
    /**初始化 角色页面**/
    public String role_manage(){
    	String result = super.result(role, "Role", "privilege_role.jsp");
    	user_list = super.list;
    	return result;
    }
    
    
    /**初始化 角色添加页面**/
    public String add_role(){
    	return "privilege_role_create.html";
    }
    
    
    /**添加角色**/
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
    	role=null;
    	return role_manage();
    }
    
    
    /**删除角色**/
    public String deleteRole(){
    	role = role_dao.role(role.getId());
    	
    	for(User u:role.getUser()){
    		base.delete(u);
    	}
    	base.delete(role);
    	return role_manage();
    }
    
    
    /**初始化编辑角色页面**/
    public String update_role(){
    	role = role_dao.role(role.getId());
    	return "privilege_role_update.jsp";
    }
    
    
    /**编辑角色**/
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
    	role=null;
    	return role_manage();
    }
    

    
    
    
    
    /**entity getter and setter**/
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

	
	public Manage getManage() {
		return manage;
	}

	public void setManage(Manage manage) {
		this.manage = manage;
	}
	
	
	/**list getter and setter**/
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


}
