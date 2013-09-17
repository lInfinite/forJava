package domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.dao.UserServiceDao;
import service.dao.impl.UserServiceImpl;
import dao.impl.BaseImpl;
import dao.impl.BaseImpl.Operation;
import entity.User;

public class DoMain {
    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	BaseImpl base = (BaseImpl)context.getBean("BaseImpl");
    	UserServiceDao userdao = (UserServiceImpl)context.getBean("UserService");
	}
}

