package com.web.action;

import java.util.List;
import java.util.Map;

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
    private Page page = (Page)context.getBean("Page");
    private List<Role> role_list;
    
    public String user_manage(){
    	return "init_user";
    }
    
    public String role_manage(){
    	role_list = base.query("Role", page.getPage(), 5);
    	return "init_role";
    }
    
    public String add_use(){
    	return "init_user_add";
    }
    
    public String add_role(){
    	return "init_role_add";
    }
    
    public String addRole(){
    	System.out.println("role.name:"+role.getName());
    	java.util.Iterator t = role.getManage().iterator();
    	while(t.hasNext()){
    		System.out.println(t.next());
    	}
    	base.add(role);
    	return "init_role_add";
    }
    
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
    
    public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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



    
}
