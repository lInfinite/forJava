package web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.dao.UserServiceDao;
import service.dao.impl.UserServiceImpl;
import entity.User;

public class UserAction  {
    
	private User user;
	public ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
	private UserServiceDao user_dao = (UserServiceImpl)context.getBean("UserService");
	
	
	public void logon(){
		System.out.println(user_dao.hasUser(user));
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
